package org.iesch.ad.ProyectoRepasoFinal.model.DTOs;

import lombok.Data;

import java.util.Date;

public class ErrorDTO {
    private String error;
    private String message;
    private Date date;
    private Integer status;

    public ErrorDTO(String error, String message, Date date, Integer status) {
        this.error = error;
        this.message = message;
        this.date = date;
        this.status = status;
    }

    public ErrorDTO() {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
