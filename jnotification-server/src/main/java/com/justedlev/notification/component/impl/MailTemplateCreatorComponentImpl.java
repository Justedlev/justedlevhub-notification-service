package com.justedlev.notification.component.impl;

import com.justedlev.notification.component.MailTemplateCreatorComponent;
import com.justedlev.notification.model.request.CreateMailTemplateRequest;
import com.justedlev.notification.model.response.MailTemplateResponse;
import com.justedlev.notification.repository.MailTemplateRepository;
import com.justedlev.notification.repository.entity.MailTemplate;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import javax.persistence.EntityExistsException;

@Component
@RequiredArgsConstructor
public class MailTemplateCreatorComponentImpl implements MailTemplateCreatorComponent {
    private final MailTemplateRepository mailTemplateRepository;
    private final ModelMapper defaultMapper;

    @Override
    public MailTemplateResponse create(CreateMailTemplateRequest request) {
        var mailTemplate = mailTemplateRepository.findByName(request.getName());

        if (mailTemplate.isPresent()) {
            throw new EntityExistsException("Template already exists by name " + request.getName());
        }

        var entity = defaultMapper.map(request, MailTemplate.class);

        return defaultMapper.map(mailTemplateRepository.save(entity), MailTemplateResponse.class);
    }
}
