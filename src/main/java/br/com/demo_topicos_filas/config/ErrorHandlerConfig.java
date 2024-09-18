package br.com.demo_topicos_filas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;

@Configuration
public class ErrorHandlerConfig {

    @Bean
    @ServiceActivator(inputChannel = "errorChannel")
    public MessageHandler errorLogger() {
        return new MessageHandler() {
            @Override
            public void handleMessage(Message<?> message) {
                System.err.println("Erro no processamento da mensagem: " + message.getPayload());
            }
        };
    }
}
