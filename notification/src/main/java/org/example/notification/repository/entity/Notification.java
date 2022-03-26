package org.example.notification.repository.entity;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Value
@Builder
@Entity
public class Notification {
    @Id
    @SequenceGenerator(
            name = "notification_id_sequence",
            sequenceName = "notification_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "notification_id_sequence"
    )
    Integer notificationId;
    Integer toCustomerId;
    String toCustomerEmail;
    String sender;
    String message;
    LocalDateTime sentAt;
}
