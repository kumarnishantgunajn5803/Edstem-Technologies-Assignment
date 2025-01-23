package com.application.restaurent_management_system.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MenuItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @DecimalMin(value = "0.1", message = "Price must be greate than zero")
    private BigDecimal price;

    @Min(value = 0, message = "Available quantity can't be negative")
    private Integer availableQuantity;

    @Enumerated(EnumType.STRING)
    private Category category;


}














