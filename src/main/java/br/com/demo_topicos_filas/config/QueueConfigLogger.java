package br.com.demo_topicos_filas.config;


import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class QueueConfigLogger {

    @Value("${events.queue}")
    private String queueUrl;

    @PostConstruct
    public void logQueueConfig() {
        log.info("Aplicação está configurada para escutar a fila: {}", queueUrl);
    }
}
