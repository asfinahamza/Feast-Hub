package com.feasthub.feasthub.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.feasthub.feasthub.entity.Restaurant;
import com.feasthub.feasthub.repository.RestaurantRepository;
import com.feasthub.feasthub.services.RestaurantService;

@Controller
public class HomeController {
    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/home")
    public String getRestaurants(@RequestParam String name, Model model) {
        // Retrieve all restItems
        //Iterable<Restaurant> restItmes = restaurantService.getRestaurants();
        
        List<Restaurant> restItmes = new ArrayList<Restaurant>();
        restaurantService.getRestaurants().forEach(restItmes::add);
        

          model.addAttribute("username", name);

      //  String welcomeMsg = "Welcome "+name;
      //  model.addAttribute("welcomeMsg", welcomeMsg);

        // Add restItems to the model
        
        model.addAttribute("restItems", restItmes);

        return "home.html";
    }
}
