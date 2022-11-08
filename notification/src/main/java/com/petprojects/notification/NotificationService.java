package com.petprojects.notification;

import com.petprojects.clients.notification.NotificationRequest;
import com.petprojects.clients.notification.NotificationResponse;
import com.petprojects.notification.mapper.NotificationMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    private final NotificationMapper notificationMapper;

    public NotificationResponse sendNotification(NotificationRequest notificationRequest) {
        Notification notification = notificationMapper.toEntity(notificationRequest);
        notification.setSentAt(LocalDateTime.now());
        Notification entity = notificationRepository.saveAndFlush(notification);
        log.info("Saved notification to customer {}", notificationRequest.getToCustomerId());
        return notificationMapper.toDto(entity);
    }
}
