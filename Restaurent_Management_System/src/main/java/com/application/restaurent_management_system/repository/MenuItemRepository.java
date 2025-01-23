package com.application.restaurent_management_system.repository;

import com.application.restaurent_management_system.entities.Category;
import com.application.restaurent_management_system.entities.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Integer> {
     List<MenuItem> findByCategory(Category category);
}
