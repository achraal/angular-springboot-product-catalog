package com.achraf.productbackend.dtos;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class ProductRequestDTO {
    private String name;
    private double price;
    private boolean selected;
}