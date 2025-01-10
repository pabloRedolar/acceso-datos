package org.iesch.ad.Ej2.models.DTOs;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

public class ErrorDTO {
    private int Status;
    private String error;
    private String message;
    private LocalDateTime dateTime;

    public ErrorDTO(int status, String error, String message, LocalDateTime dateTime) {
        this.Status = status;
        this.error = error;
        this.message = message;
        this.dateTime = dateTime;
    }

    public ErrorDTO() {
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
