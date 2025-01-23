package com.application.restaurent_management_system.dto;

import com.application.restaurent_management_system.entities.Category;

import java.math.BigDecimal;

public record MenuInput(String name, BigDecimal price, Integer availableQuantity, Category category) {
}
