package com.feasthub.feasthub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.feasthub.feasthub.repository.MenuRepository;
import com.feasthub.feasthub.entity.MenuItem;

@Service
public class MenuService {
    private final MenuRepository menuRepository;
    public MenuService(MenuRepository menuRepository){
        this.menuRepository = menuRepository;
    }
    public List<MenuItem> getMenuItems(){
        return menuRepository.findAll();
    }

    public Optional<MenuItem> getMenuItemById(Long id) {
        return menuRepository.findById(id);
    }

    public void saveMenuItem(MenuItem menuItem) {
        menuRepository.save(menuItem);
    }

    public void deleteMenuItemById(Long id) {
        menuRepository.deleteById(id);
    }
}
