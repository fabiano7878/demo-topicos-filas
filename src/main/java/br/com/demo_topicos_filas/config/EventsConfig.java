package br.com.demo_topicos_filas.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "events")
public class EventsConfig {
    private String topic;
    private String queue;
}
