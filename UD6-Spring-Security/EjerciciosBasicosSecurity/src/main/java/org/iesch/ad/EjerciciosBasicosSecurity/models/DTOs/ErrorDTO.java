package org.iesch.ad.EjerciciosBasicosSecurity.models.DTOs;

import java.time.LocalDateTime;

public class ErrorDTO {
    private String message;
    private String error;
    private int Status;
    private LocalDateTime timestamp;

    public ErrorDTO() {
    }

    public ErrorDTO(String message, String error, int status) {
        this.message = message;
        this.error = error;
        Status = status;
        this.timestamp = LocalDateTime.now();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
