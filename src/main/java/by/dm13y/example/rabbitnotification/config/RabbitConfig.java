package by.dm13y.example.rabbitnotification.config;

import org.springframework.amqp.core.AnonymousQueue;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    public static final String QUERY_NAME = "notificationQuery";
    private static final boolean DURABLE = true;

    @Bean
    public Queue notificationQueue() {
        return new Queue(QUERY_NAME, DURABLE);
    }

}
