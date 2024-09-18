package br.com.demo_topicos_filas.config;

import br.com.demo_topicos_filas.produtor.DeliveryNotificationProductor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.messaging.MessageChannel;

@Configuration
public class QueueIntegrationConfig {

    // Definindo o canal que será usado para processar as mensagens da fila
    @Bean
    public MessageChannel inputChannel() {
        return new DirectChannel();
    }

    // Definindo o fluxo de integração que escutará o canal e invocará o handler de mensagens
    /**
    @Bean
    public IntegrationFlow sqsListenerFlow(DeliveryNotificationProductor deliveryNotificationProductor) {
        return IntegrationFlow.from("inputChannel")
                .handle(deliveryNotificationProductor::handleMessage)
                .get();
    }
    */
}

