package com.feasthub.feasthub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;
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
    
    @GetMapping("/menu/{id}")
    public String showMenuItem(@PathVariable Long id, Model model) {
        Optional<MenuItem> menuItem = menuService.getMenuItemById(id);
        model.addAttribute("menuItem", menuItem.orElse(null));
        return "menuItem";
    }

    @PostMapping("/updateMenu/{id}")
    public String updateMenu(@PathVariable Long id, @RequestParam String name, @RequestParam Float price) {
        Optional<MenuItem> optionalMenuItem = menuService.getMenuItemById(id);

        optionalMenuItem.ifPresent(menuItem -> {
            menuItem.setName(name);
            menuItem.setPrice(price);
            menuRepository.save(menuItem);
        });

        return "redirect:/";
    }

    @PostMapping("/deleteMenu/{id}")
    public String deleteMenu(@PathVariable Long id) {
        menuService.deleteMenuItemById(id);
        return "redirect:/";
    }
    
}
