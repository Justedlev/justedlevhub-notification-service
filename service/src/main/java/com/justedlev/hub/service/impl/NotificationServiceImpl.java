package com.justedlev.hub.service.impl;

import com.justedlev.hub.component.NotificationTemplateManager;
import com.justedlev.hub.component.NotificationUtilities;
import com.justedlev.hub.component.command.NotificationCommand;
import com.justedlev.hub.model.request.CreateTemplateRequest;
import com.justedlev.hub.model.request.SendNotificationRequest;
import com.justedlev.hub.model.response.SentTemplateResponse;
import com.justedlev.hub.model.response.TemplateResponse;
import com.justedlev.hub.repository.NotificationTemplateRepository;
import com.justedlev.hub.repository.NotificationTypeRepository;
import com.justedlev.hub.repository.entity.NotificationTemplate;
import com.justedlev.hub.service.NotificationService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {
    private final NotificationTemplateRepository notificationTemplateRepository;
    private final NotificationTemplateManager notificationTemplateManager;
    private final NotificationTypeRepository notificationTypeRepository;
    private final NotificationUtilities notificationUtilities;
    private final ModelMapper mapper;

    @Override
    public List<TemplateResponse> getAll() {
        return notificationTemplateRepository.findAll()
                .stream()
                .map(nt -> mapper.map(nt, TemplateResponse.class))
                .toList();
    }

    @Override
    public SentTemplateResponse sendFromTemplate(SendNotificationRequest request) {
        if (notificationTypeRepository.notExistsByLabel(request.getType())) throw new EntityNotFoundException();

        var mailTemplate = notificationTemplateRepository.getByName(request.getTemplateName());
        var subject = Optional.ofNullable(request.getSubject())
                .filter(StringUtils::isNotBlank)
                .orElseGet(mailTemplate::getSubject);
        var body = notificationUtilities.buildBody(mailTemplate.getTemplate(), request.getContent());
        var command = NotificationCommand.builder()
                .subject(subject)
                .recipient(request.getRecipient())
                .body(body)
                .type(request.getType())
                .build();
        notificationTemplateManager.assign(command);

        return SentTemplateResponse.builder()
                .recipient(request.getRecipient())
                .templateName(request.getTemplateName())
                .build();
    }

    @Override
    public TemplateResponse createTemplate(CreateTemplateRequest request) {
        var template = mapper.map(request, NotificationTemplate.class);
        notificationTemplateRepository.save(template);

        return mapper.map(request, TemplateResponse.class);
    }
}
