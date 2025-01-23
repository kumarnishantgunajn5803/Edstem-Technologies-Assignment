package com.application.restaurent_management_system.controller;



import com.application.restaurent_management_system.dto.MenuInput;
import com.application.restaurent_management_system.entities.Category;
import com.application.restaurent_management_system.entities.MenuItem;
import com.application.restaurent_management_system.service.MenuService;
import com.application.restaurent_management_system.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MenuItemController {

    @Autowired
    private MenuService menuService;

    //http://localhost:8080/api/menu-items
    /*
    {

    "name" : "Ice Cream",
    "price" : 50.0,
    "availableQuantity" : 2,
    "category" : "DESSERT"
}
     */
    @PostMapping("/menu-items")
    public ResponseEntity<MenuItem> addMenuItemHandler(@Valid @RequestBody MenuInput menuInput) {
        return new ResponseEntity<>(menuService.addMenuItem(menuInput), HttpStatus.CREATED);
    }

    //http://localhost:8080/api/menu-items?category=
    @GetMapping("/menu-items")
    public ResponseEntity<List<MenuItem>> getMenuItemsHandler(@RequestParam(required = false) Category category) {
        return new ResponseEntity<>(menuService.getMenuItems(category), HttpStatus.OK);
    }

}















