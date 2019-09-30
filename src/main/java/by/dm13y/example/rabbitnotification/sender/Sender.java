package by.dm13y.example.rabbitnotification.sender;

import by.dm13y.example.rabbitnotification.dto.Notification;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
@Component
@RequiredArgsConstructor
@EnableScheduling
public class Sender {
    private final RabbitTemplate template;
    private final Queue queue;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send() throws Exception {
        val notification = new Notification(0, String.valueOf(new Date().getTime()));
        val message = objectMapper.writeValueAsString(notification);
        template.convertAndSend(queue.getName(), message);
        log.info("Send msg {}", notification);
    }

}
