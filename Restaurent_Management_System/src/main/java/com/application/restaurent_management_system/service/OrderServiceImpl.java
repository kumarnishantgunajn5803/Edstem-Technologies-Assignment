package com.application.restaurent_management_system.service;

import com.application.restaurent_management_system.dto.OrderMenuInput;
import com.application.restaurent_management_system.entities.MenuItem;
import com.application.restaurent_management_system.entities.Order;
import com.application.restaurent_management_system.dto.OrderInput;
import com.application.restaurent_management_system.entities.OrderItem;
import com.application.restaurent_management_system.entities.Status;
import com.application.restaurent_management_system.repository.MenuItemRepository;
import com.application.restaurent_management_system.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;



@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private MenuItemRepository menuItemRepository;

    @Override
    @Transactional
    public Order createOrder(OrderInput orderInput) {

        Order order = new Order();
        order.setCreatedAt(LocalDateTime.now());
        order.setStatus(Status.RECEIVED);
        order.setCustomerName(orderInput.customerName());
        order.setCustomerPhone(orderInput.customerPhone());

        BigDecimal totalAmount = new BigDecimal(0);

        List<OrderMenuInput> orderMenuInputs =  orderInput.items();
        List<OrderItem> items = new ArrayList<>();
        for(OrderMenuInput orderMenuInput : orderMenuInputs) {
            //Fetch the menu with the menuItem id
            int menuItemId = orderMenuInput.menuItemId();
            int quantity = orderMenuInput.quantity();

            MenuItem menuItem = menuItemRepository.findById(menuItemId).orElseThrow(() -> new IllegalArgumentException("Menu item with id: " + menuItemId+" not found!"));

            //check the quantity
            if(menuItem.getAvailableQuantity() < quantity) {
                throw new IllegalArgumentException("Insufficient quantity for the menu " + menuItem.getName());
            }


            // Find the total price of menu
            BigDecimal menuSubTotal = menuItem.getPrice().multiply(new BigDecimal(quantity));

            //create order item
            OrderItem orderItem = new OrderItem();
            orderItem.setQuantity(quantity);
            orderItem.setSubtotal(menuSubTotal);
            orderItem.setMenuItem(menuItem);
            //update order item
            items.add(orderItem);

            //update the available quantity
            menuItem.setAvailableQuantity(menuItem.getAvailableQuantity() - quantity);
            menuItemRepository.save(menuItem);

            //update the order total price

            totalAmount = totalAmount.add(menuSubTotal);

        }

        //Finally add all the items to the order
        order.setItems(items);

        //update total order amount
        order.setTotalAmount(totalAmount);

        //save the order to the order repo
        orderRepository.save(order);

        return order;
    }

    @Override
    public Order getOrderById(Integer Id) {
        return orderRepository.findById(Id).orElseThrow(() -> new IllegalArgumentException("Order with id: " + Id + " not found!"));
    }
}











