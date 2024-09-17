package br.com.demo_topicos_filas.services;

import br.com.demo_topicos_filas.config.EventsConfig;
import br.com.demo_topicos_filas.record.NotificationMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;

@Slf4j
@RequiredArgsConstructor
@Service
public class DeliveryNotificationService {

    private final EventsConfig config;
    private final SnsClient snsClient;
    private final SqsClient sqsClient;
    public ResponseEntity<String> notifyTopic(NotificationMessage message) {
        log.info("Notificando o topic, path completo {}", config.getPath());
        snsClient.publish(publishRequest -> publishRequest
                .topicArn(config.getPath())
                .message(message.content()));
        return ResponseEntity.ok().body("Tópico notificado com sucesso!");
    }

    public ResponseEntity<String> notifyQueue(NotificationMessage message) {
        log.info("Notificando a fila {}", config.getQueue());

        SendMessageRequest sendMessageRequest = SendMessageRequest.builder()
                .queueUrl(config.getQueue()) // URL da fila SQS
                .messageBody(message.content()) // Corpo da mensagem
                .build();

        sqsClient.sendMessage(sendMessageRequest);

        return ResponseEntity.ok().body("Fila notificada com sucesso!");
    }
}