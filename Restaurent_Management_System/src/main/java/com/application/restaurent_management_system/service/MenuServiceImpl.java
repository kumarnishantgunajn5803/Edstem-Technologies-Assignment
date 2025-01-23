package com.application.restaurent_management_system.service;

import com.application.restaurent_management_system.entities.Category;
import com.application.restaurent_management_system.dto.MenuInput;
import com.application.restaurent_management_system.entities.MenuItem;
import com.application.restaurent_management_system.repository.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuItemRepository menuItemRepository;

    @Override
    public MenuItem addMenuItem(MenuInput menuItem) {
        MenuItem menuItemEntity = new MenuItem();
            menuItemEntity.setName(menuItem.name());
            menuItemEntity.setPrice(menuItem.price());
            menuItemEntity.setCategory(menuItem.category());
            menuItemEntity.setAvailableQuantity(menuItem.availableQuantity());

        return menuItemRepository.save(menuItemEntity);
    }

    @Override
    public List<MenuItem> getMenuItems(Category category) {
        if(category==null)return menuItemRepository.findAll();
        return menuItemRepository.findByCategory(category);
    }
}


















