package com.amitu.springboot.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Product {
    private String title;
    private BigDecimal price;
    private Long quantity;

}
