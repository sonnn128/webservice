package com.example.demo.ws.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "getAllProductsResponse", namespace = "http://example.com/demo/ws/products")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetAllProductsResponse {

    @XmlElementWrapper(name = "products")
    @XmlElement(name = "product")
    private List<ProductWs> products;

    public List<ProductWs> getProducts() {
        return products;
    }

    public void setProducts(List<ProductWs> products) {
        this.products = products;
    }
}
