package br.com.demo_topicos_filas.listener;

import io.awspring.cloud.messaging.listener.annotation.SqsListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
@Slf4j
@Component
public class SqsMessageListener {
    @SqsListener("${sqsQueueName}")
    public void queueListener(String message){
        try{
            log.info("Listener recebendo msg: {}", message);
        } catch (Exception ex){
            log.error(ex.getMessage(), ex);
        }
    }
}
 */
