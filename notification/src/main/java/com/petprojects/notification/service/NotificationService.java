package com.petprojects.notification.service;

import com.petprojects.clients.notification.NotificationRequest;
import com.petprojects.clients.notification.NotificationResponse;

public interface NotificationService {

    NotificationResponse sendNotification(NotificationRequest notificationRequest);
}
