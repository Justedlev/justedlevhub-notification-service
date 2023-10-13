package com.justedlev.hub.service.impl;

import com.justedlev.hub.component.TemplateManager;
import com.justedlev.hub.component.NotificationUtilities;
import com.justedlev.hub.component.command.NotificationCommand;
import com.justedlev.hub.model.request.CreateTemplateRequest;
import com.justedlev.hub.model.request.SendNotificationRequest;
import com.justedlev.hub.model.response.SentTemplateResponse;
import com.justedlev.hub.model.response.TemplateResponse;
import com.justedlev.hub.repository.TemplateRepository;
import com.justedlev.hub.repository.NotificationTypeRepository;
import com.justedlev.hub.repository.entity.NotificationTemplate;
import com.justedlev.hub.service.TemplateService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TemplateServiceImpl implements TemplateService {
    private final TemplateRepository templateRepository;
    private final TemplateManager templateManager;
    private final NotificationTypeRepository notificationTypeRepository;
    private final NotificationUtilities notificationUtilities;
    private final ModelMapper mapper;

    @Override
    public Page<TemplateResponse> findPage(Pageable pageable) {
        return templateRepository.findAll(pageable).map(nt -> mapper.map(nt, TemplateResponse.class));
    }

    @Override
    public SentTemplateResponse sendFromTemplate(SendNotificationRequest request) {
        if (notificationTypeRepository.notExistsByLabel(request.getType())) throw new EntityNotFoundException();

        var mailTemplate = templateRepository.getByName(request.getTemplateName());
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
        templateManager.assign(command);

        return SentTemplateResponse.builder()
                .recipient(request.getRecipient())
                .templateName(request.getTemplateName())
                .build();
    }

    @Override
    public TemplateResponse create(CreateTemplateRequest request) {
        var template = mapper.map(request, NotificationTemplate.class);
        templateRepository.save(template);

        return mapper.map(request, TemplateResponse.class);
    }

    @Override
    public void delete(String name) {
        templateRepository.deleteByName(name);
    }

    @Override
    public TemplateResponse getByName(String name) {
        var template = templateRepository.getByName(name);

        return mapper.map(template, TemplateResponse.class);
    }
}
