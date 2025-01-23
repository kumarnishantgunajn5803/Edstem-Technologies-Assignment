package com.application.restaurent_management_system.controller;


import com.application.restaurent_management_system.dto.OrderInput;
import com.application.restaurent_management_system.entities.Order;
import com.application.restaurent_management_system.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class OrderController {


    @Autowired
    private OrderService orderService;

    //http://localhost:8080/api/orders
    /*
    {

    "items" : [
        {"menuItemId" : 1, "quantity" : 2},

        {"menuItemId" : 2, "quantity" : 2}

     ],
    "customerName" : "",
    "customerPhone" : ""

}
     */
    @PostMapping("/orders")
    public ResponseEntity<Order> createOrderHandler(@Valid @RequestBody OrderInput orderInput) {
        return new ResponseEntity<>( orderService.createOrder(orderInput), HttpStatus.CREATED);
    }


    //http://localhost:8080/api/orders/
    @GetMapping("/orders/{id}")
    public ResponseEntity<Order> getOrderByOrderIdHandler(@PathVariable Integer id) {
        return new ResponseEntity<>(orderService.getOrderById(id), HttpStatus.OK);
    }
}







//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

