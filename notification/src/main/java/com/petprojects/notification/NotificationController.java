package com.petprojects.notification;

import com.petprojects.clients.notification.NotificationRequest;
import com.petprojects.clients.notification.NotificationResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/notification")
@Slf4j
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping
    public NotificationResponse sendNotification(@RequestBody NotificationRequest notificationRequest) {
        return notificationService.sendNotification(notificationRequest);
    }
}