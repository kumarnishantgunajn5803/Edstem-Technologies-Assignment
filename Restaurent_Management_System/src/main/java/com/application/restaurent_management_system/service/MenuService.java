package com.application.restaurent_management_system.service;

import com.application.restaurent_management_system.entities.Category;
import com.application.restaurent_management_system.dto.MenuInput;
import com.application.restaurent_management_system.entities.MenuItem;

import java.util.List;

public interface MenuService {

   public MenuItem addMenuItem(MenuInput menuItem);

   public List<MenuItem> getMenuItems(Category category);
}
