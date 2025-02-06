package se.lexicon.g52todoapi.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatusCode;

import java.time.LocalDateTime;

public record ErrorDto(
        HttpStatusCode status,
        String description,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        String path,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
        LocalDateTime timestamp

) {
    public ErrorDto(HttpStatusCode status, String description, String path, LocalDateTime timestamp) {
        this.status = status;
        this.description = description;
        this.path = path;
        this.timestamp = timestamp;
    }

    public ErrorDto(HttpStatusCode status, String description, String path) {
        this(status, description, path, LocalDateTime.now());
    }

    public ErrorDto(HttpStatusCode status, String description) {
        this(status, description, null, LocalDateTime.now());
    }
}
