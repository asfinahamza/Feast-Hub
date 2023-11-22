package com.feasthub.feasthub.services;

import java.util.List;
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
}
