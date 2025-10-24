package com.example.demo.ws.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "getAllProductsRequest", namespace = "http://example.com/demo/ws/products")
@XmlAccessorType(XmlAccessType.FIELD)
public class GetAllProductsRequest {
}
