package br.com.demo_topicos_filas.controller;

import br.com.demo_topicos_filas.record.NotificationRequest;
import br.com.demo_topicos_filas.services.DeliveryNotificationService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DemoFilaController {

private static final Logger log = LoggerFactory.getLogger(DemoFilaController.class);

    @Autowired
    private final DeliveryNotificationService service;

    @GetMapping("/list")
    public ResponseEntity<String> consulta(){
    log.info("Primeiro get!!!!");
    return ResponseEntity.ok().body("Deu bom");
    }

    @PostMapping("/topic")
    public ResponseEntity<String> topic(@RequestBody NotificationRequest request) {
        log.info("sending message toward SNS...");
        return service.notifyTopic(request.toDomain());
    }

    @PostMapping("/queue")
    public ResponseEntity<String> queue(@RequestBody NotificationRequest request) {
        log.info("sending message toward SQS...");
        return service.notifyQueue(request.toDomain());
    }
}
