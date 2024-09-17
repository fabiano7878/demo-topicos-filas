package br.com.demo_topicos_filas.config;

import lombok.Builder;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "events")
public class EventsConfig {
    private String topic;
    private String queue;
    private String origen;
    private String brand;
    private String type;
    private String hash;
    private String region;
    private String path;


    public String getPath(){
        return this.origen + this.brand + this.type + this.region + this.hash+  this.topic;
    }

}
