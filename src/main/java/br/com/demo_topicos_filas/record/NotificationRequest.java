package br.com.demo_topicos_filas.record;

public record NotificationRequest(String from, String to, String content) {

    public NotificationMessage toDomain() {
        return new NotificationMessage(this.from, this.to, this.content);
    }
}
