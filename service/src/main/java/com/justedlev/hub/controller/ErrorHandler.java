package com.justedlev.hub.controller;

import com.justedlev.hub.model.response.ErrorDetailsResponse;
import com.justedlev.hub.model.response.ValidationErrorResponse;
import com.justedlev.hub.model.response.ViolationResponse;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {
            IllegalArgumentException.class,
            EntityExistsException.class,
            IllegalStateException.class
    })
    public ResponseEntity<ErrorDetailsResponse> handleConflictException(Exception ex, WebRequest request) {
        log.error(ex.getMessage(), ex);
        var errorDetails = ErrorDetailsResponse.builder()
                .details(request.getDescription(false))
                .message(ex.getMessage())
                .build();

        return new ResponseEntity<>(errorDetails, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = EntityNotFoundException.class)
    public ResponseEntity<ErrorDetailsResponse> handleEntityNotFoundException(EntityNotFoundException ex,
                                                                              WebRequest request) {
        log.error(ex.getMessage(), ex);
        var errorDetails = ErrorDetailsResponse.builder()
                .details(request.getDescription(false))
                .message(ex.getMessage())
                .build();

        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseEntity<ValidationErrorResponse> handleFeignException(ConstraintViolationException ex,
                                                                        WebRequest request) {
        log.error(ex.getMessage(), ex);
        var violations = ex.getConstraintViolations()
                .stream()
                .map(current -> ViolationResponse.builder()
                        .fieldName(current.getPropertyPath().toString())
                        .message(current.getMessage())
                        .build())
                .toList();
        var response = ValidationErrorResponse.builder()
                .details(request.getDescription(false))
                .violations(violations)
                .build();

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @NonNull
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(@NonNull MethodArgumentNotValidException ex,
                                                                  @NonNull HttpHeaders headers,
                                                                  @NonNull HttpStatusCode status,
                                                                  @NonNull WebRequest request) {
        log.error(ex.getMessage(), ex);
        var violations = ex.getBindingResult().getFieldErrors()
                .stream()
                .map(current -> ViolationResponse.builder()
                        .fieldName(current.getField())
                        .message(current.getDefaultMessage())
                        .build())
                .toList();
        var error = ValidationErrorResponse.builder()
                .details(request.getDescription(false))
                .violations(violations)
                .build();

        return new ResponseEntity<>(error, status);
    }
}
