package com.petprojects.notification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {
        "com.petprojects.notification",
        "com.petprojects.amqp"
})
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.petprojects.clients")
public class NotificationApplication {
//public class NotificationApplication implements CommandLineRunner {

//    @Autowired
//    private ApplicationContext applicationContext;

    public static void main(String[] args) {
        SpringApplication.run(NotificationApplication.class, args);
    }

//    @Override
//    public void run(String... args) throws Exception {
//        String[] beans = applicationContext.getBeanDefinitionNames();
//        Arrays.sort(beans);
//        for (String bean : beans) {
//            System.out.println(bean);
//        }
//    }

//    @Bean
//    CommandLineRunner commandLineRunner(RabbitMQMessageProducer producer, NotificationConfig notificationConfig) {
//        return args -> {
//            producer.publish("foo", notificationConfig.getInternalExchange(),
//                    notificationConfig.getInternalNotificationRoutingKey());
//        };
//    }
}