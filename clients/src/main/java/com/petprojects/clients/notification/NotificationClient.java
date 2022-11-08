package com.petprojects.clients.notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("notification")
public interface NotificationClient {

    @PostMapping (path = "api/v1/notification")
    NotificationResponse sendNotification(NotificationRequest notificationRequest);
}