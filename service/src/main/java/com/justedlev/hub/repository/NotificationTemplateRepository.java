package com.justedlev.hub.repository;

import com.justedlev.hub.repository.entity.NotificationTemplate;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NotificationTemplateRepository extends JpaRepository<NotificationTemplate, Long> {
    Optional<NotificationTemplate> findByName(String name);

    default NotificationTemplate getByName(String name) {
        return findByName(name)
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format("Template '%s' not exists", name)));
    }
}
