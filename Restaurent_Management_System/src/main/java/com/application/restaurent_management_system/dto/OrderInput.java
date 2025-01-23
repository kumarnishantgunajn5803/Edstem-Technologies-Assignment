package com.application.restaurent_management_system.dto;



import java.util.List;

public record OrderInput(List<OrderMenuInput> items, String customerName, String customerPhone) {
}
