package com.example.demo.ws;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.ws.model.CreateProductRequest;
import com.example.demo.ws.model.CreateProductResponse;
import com.example.demo.ws.model.GetAllProductsRequest;
import com.example.demo.ws.model.GetAllProductsResponse;
import com.example.demo.ws.model.ProductWs;
import com.example.demo.ws.model.UpdateProductRequest;
import com.example.demo.ws.model.UpdateProductResponse;
import com.example.demo.ws.model.DeleteProductRequest;
import com.example.demo.ws.model.DeleteProductResponse;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ProductEndpoint {

    private static final String NAMESPACE_URI = "http://example.com/demo/ws/products";

    private final ProductRepository productRepository;

    @Autowired
    public ProductEndpoint(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createProductRequest")
    @ResponsePayload
    public CreateProductResponse createProduct(@RequestPayload CreateProductRequest request) {
        CreateProductResponse response = new CreateProductResponse();
        try {
            Product product = new Product();
            product.setName(request.getName());
            product.setPrice(request.getPrice());
            product.setDescription(request.getDescription());

            Product saved = productRepository.save(product);

            response.setId(saved.getId());
            response.setSuccess(true);
            response.setMessage("Product created successfully");
        } catch (Exception ex) {
            response.setSuccess(false);
            response.setMessage("Error creating product: " + ex.getMessage());
        }
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllProductsRequest")
    @ResponsePayload
    public GetAllProductsResponse getAllProducts(@RequestPayload GetAllProductsRequest request) {
        GetAllProductsResponse response = new GetAllProductsResponse();
        List<ProductWs> list = productRepository.findAll().stream()
                .map(p -> new ProductWs(p.getId(), p.getName(), p.getPrice(), p.getDescription()))
                .collect(Collectors.toList());
        response.setProducts(list);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateProductRequest")
    @ResponsePayload
    @Transactional
    public UpdateProductResponse updateProduct(@RequestPayload UpdateProductRequest request) {
        UpdateProductResponse response = new UpdateProductResponse();
        try {
            Long id = request.getId();
            Product existing = productRepository.findById(id).orElse(null);
            if (existing == null) {
                response.setSuccess(false);
                response.setMessage("Product not found with id: " + id);
                return response;
            }
            if (request.getName() != null) existing.setName(request.getName());
            if (request.getPrice() != null) existing.setPrice(request.getPrice());
            if (request.getDescription() != null) existing.setDescription(request.getDescription());
            productRepository.save(existing);
            response.setSuccess(true);
            response.setMessage("Product updated successfully");
        } catch (Exception ex) {
            response.setSuccess(false);
            response.setMessage("Error updating product: " + ex.getMessage());
        }
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteProductRequest")
    @ResponsePayload
    @Transactional
    public DeleteProductResponse deleteProduct(@RequestPayload DeleteProductRequest request) {
        DeleteProductResponse response = new DeleteProductResponse();
        try {
            Long id = request.getId();
            if (!productRepository.existsById(id)) {
                response.setSuccess(false);
                response.setMessage("Product not found with id: " + id);
                return response;
            }
            productRepository.deleteById(id);
            response.setSuccess(true);
            response.setMessage("Product deleted successfully");
        } catch (Exception ex) {
            response.setSuccess(false);
            response.setMessage("Error deleting product: " + ex.getMessage());
        }
        return response;
    }

}
