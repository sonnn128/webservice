package com.example.demo.ws.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "createProductResponse", namespace = "http://example.com/demo/ws/products")
@XmlAccessorType(XmlAccessType.FIELD)
public class CreateProductResponse {

    @XmlElement(required = true)
    private Long id;

    @XmlElement(required = true)
    private boolean success;

    private String message;

    public CreateProductResponse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
