package br.com.demo_topicos_filas.consumer;

import br.com.demo_topicos_filas.record.NotificationMessage;
import io.awspring.cloud.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Component;


/*
@Component
public class SqsConsumer {

    @SqsListener("NOTIFICATION-DEMOFILAS-QUEUE")
    public void receiveMessage(NotificationMessage message) {
        System.out.println("Recebendo msg da fila: " + message);
        // Processar a mensagem
    }
}
*/
