package com.amitu.springboot.controller;

import com.amitu.springboot.dto.Product;
import com.amitu.springboot.publisher.RabbitMQJsonProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product/")
public class ProductController {

    private RabbitMQJsonProducer rabbitMQJsonProducer;

    public ProductController(RabbitMQJsonProducer rabbitMQJsonProducer) {
        this.rabbitMQJsonProducer = rabbitMQJsonProducer;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createProduct(@RequestBody Product product){
        rabbitMQJsonProducer.sendJsonMessage(product);
        return ResponseEntity.ok("Product Created : "+product.toString());
    }
}
