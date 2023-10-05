package com.justedlev.hub.repository;

import com.justedlev.hub.repository.entity.NotificationType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationTypeRepository extends JpaRepository<NotificationType, Long> {
    boolean existsByLabel(String label);

    default boolean notExistsByLabel(String label) {
        return !existsByLabel(label);
    }
}