package com.feasthub.feasthub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.feasthub.feasthub.entity.MenuItem;
import com.feasthub.feasthub.repository.MenuRepository;
import com.feasthub.feasthub.services.MenuService;

@Controller
public class MenuController {
    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private MenuService menuService;

    @PostMapping("/addMenu")
    public String addMenu(@RequestParam String name, @RequestParam Float price, Model model) {
        MenuItem menuItem = new MenuItem();
        menuItem.setName(name);
        menuItem.setPrice(price);
        menuRepository.save(menuItem);

        return "redirect:/?message=menu_item added successfully";
    }

    @GetMapping("/")
    public String showMenuItems(Model model) {
        // Retrieve all MenuItems
        Iterable<MenuItem> menuItems = menuService.getMenuItems();
        
        // Add menuItems to the model
        model.addAttribute("menuItems", menuItems);

        return "index";
    }
}
