package com.justedlev.hub.repository;

import com.justedlev.hub.repository.entity.NotificationTemplate;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TemplateRepository extends JpaRepository<NotificationTemplate, Long> {
    @Modifying
    void deleteByName(@Nullable String name);

    Optional<NotificationTemplate> findByName(@Nullable String name);

    default NotificationTemplate getByName(String name) {
        return findByName(name)
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format("Template '%s' not exists", name)));
    }
}
