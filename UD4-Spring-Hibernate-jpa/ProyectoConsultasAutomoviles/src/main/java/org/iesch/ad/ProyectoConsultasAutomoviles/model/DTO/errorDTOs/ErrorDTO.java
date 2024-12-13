package org.iesch.ad.ProyectoConsultasAutomoviles.model.DTO.errorDTOs;

import java.time.LocalDateTime;

public class ErrorDTO {
    private int status;
    private String message;
    private String error;
    private LocalDateTime date;

    public ErrorDTO(int status, String message, String error, LocalDateTime date) {
        this.status = status;
        this.message = message;
        this.error = error;
        this.date = date;
    }

    public ErrorDTO() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
