package com.justedlev.hub.repository.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;

@SuperBuilder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@DynamicUpdate
@Table(name = "notification_templates")
@NamedEntityGraph(
        name = "eg-notification-template",
        attributeNodes = {
                @NamedAttributeNode("type"),
        }
)
public class NotificationTemplate extends Versionable<Long> implements Serializable {
    @NotBlank
    @NotEmpty
    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "subject")
    private String subject;

    @NotBlank
    @NotEmpty
    @Column(name = "template", nullable = false)
    private String template;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn()
    @Cascade({
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    private NotificationType type;
}
