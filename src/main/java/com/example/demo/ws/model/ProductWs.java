package com.example.demo.ws.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "product", namespace = "http://example.com/demo/ws/products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductWs {

    private static final String NAMESPACE = "http://example.com/demo/ws/products";

    @XmlElement(namespace = NAMESPACE)
    private Long id;

    @XmlElement(namespace = NAMESPACE)
    private String name;

    // use Double to allow null mapping from DB (primitive double defaults to 0.0)
    @XmlElement(namespace = NAMESPACE)
    private Double price;

    @XmlElement(namespace = NAMESPACE)
    private String description;

    public ProductWs() {
    }

    public ProductWs(Long id, String name, Double price, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
