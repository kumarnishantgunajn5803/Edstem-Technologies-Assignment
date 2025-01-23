package com.application.restaurent_management_system.service;

import com.application.restaurent_management_system.entities.Order;
import com.application.restaurent_management_system.dto.OrderInput;

public interface OrderService {

    public Order createOrder(OrderInput orderInput);

    public Order getOrderById(Integer Id);

}
