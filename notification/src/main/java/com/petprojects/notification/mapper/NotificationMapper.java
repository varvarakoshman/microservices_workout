package com.petprojects.notification.mapper;

import com.petprojects.clients.notification.NotificationRequest;
import com.petprojects.clients.notification.NotificationResponse;
import com.petprojects.notification.Notification;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface NotificationMapper {
    Notification toEntity(NotificationRequest notificationRequest);
    NotificationResponse toDto(Notification notification);
}
