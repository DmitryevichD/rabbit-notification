package by.dm13y.example.rabbitnotification.receiver;

import by.dm13y.example.rabbitnotification.dto.Notification;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import static by.dm13y.example.rabbitnotification.config.RabbitConfig.QUERY_NAME;

@Slf4j
@Component
@RequiredArgsConstructor
@RabbitListener(queues = QUERY_NAME)
public class Receiver {
    private final RabbitTemplate template;
    private final Queue queue;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public void send(Notification notification) throws Exception {
        notification.setAttemptNumber(notification.getAttemptNumber() + 1);
        val message = objectMapper.writeValueAsString(notification);
        template.convertAndSend(queue.getName(), message);
        log.info("ResendMsg msg {}", notification);
    }

    @RabbitHandler
    public void receive(String msg, Channel channel, Message message) throws Exception{
//        val notification = objectMapper.readValue(msg, Notification.class);
//        if (notification.getAttemptNumber() < 0) {
//            notification.setAttemptNumber(notification.getAttemptNumber() + 1);
//            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
//            send(notification);
//        } else {
//            log.info("Receive msg {}", msg);
//        long ss = message.getMessageProperties().getDeliveryTag();
//        log.error("TAG {}", ss);
//            channel.basicAck(ss, true);
//        }
        throw new RuntimeException("");
    }
}
