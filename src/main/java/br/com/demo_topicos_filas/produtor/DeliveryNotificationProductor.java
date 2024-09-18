package br.com.demo_topicos_filas.produtor;

import io.awspring.cloud.messaging.listener.SqsMessageDeletionPolicy;
import io.awspring.cloud.messaging.listener.annotation.SqsListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DeliveryNotificationProductor {

    @SqsListener(value = "${events.queue}", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void consume(Message<String> message) {
        log.info("Recebendo uma nova mensagem da fila...");

        try {
            // Log completo da mensagem recebida
            log.info("Payload da mensagem recebida: {}", message.getPayload());

            // Log das headers, caso necessário
            log.info("Headers da mensagem: {}", message.getHeaders());

            // Verifique se a mensagem está no formato esperado (opcional)
            if (message.getPayload() == null || message.getPayload().isEmpty()) {
                log.warn("Mensagem recebida está vazia ou nula!");
            } else {
                // Processar a mensagem normalmente
                log.info("Mensagem processada com sucesso: {}", message.getPayload());
            }
        } catch (Exception e) {
            // Captura e log detalhado de exceções
            log.error("Erro ao processar a mensagem da fila: {}", message.getPayload(), e);
        }
    }
}
