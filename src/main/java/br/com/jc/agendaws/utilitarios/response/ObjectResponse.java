package br.com.jc.agendaws.utilitarios.response;

import java.util.List;

public class ObjectResponse<T> {

    private String status;
    private String message;
    private T object;
    private List<T> objectList;

    public ObjectResponse(String status, String message, T object) {
        this.status = status;
        this.message = message;
        this.object = object;
    }
    
    public ObjectResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public ObjectResponse() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<T> getObjectList() {
        return objectList;
    }

    public void setObjectList(List<T> objectList) {
        this.objectList = objectList;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
}
