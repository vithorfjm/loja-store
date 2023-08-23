package br.com.vithorfjm.lojastore.exceptions;

import java.time.Instant;

public class ExceptionDTO {

    private Integer status;
    private String messsage;

    public ExceptionDTO() {
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMesssage() {
        return messsage;
    }

    public void setMesssage(String messsage) {
        this.messsage = messsage;
    }
}
