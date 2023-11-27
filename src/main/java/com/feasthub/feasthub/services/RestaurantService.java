package com.feasthub.feasthub.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.feasthub.feasthub.entity.Restaurant;
import com.feasthub.feasthub.repository.RestaurantRepository;

@Service
public class RestaurantService {

  

    private final RestaurantRepository restaurantRepository;
    public RestaurantService(RestaurantRepository restaurantRepository){
        this.restaurantRepository = restaurantRepository;
    }

    public List<Restaurant> getRestaurants(){
        return restaurantRepository.findAll();
    }

    /*
    public List<Restaurant> getAllUsers() {
        return restaurantRepository.findAll();
    }

    public Restaurant getUserByEmail(String email){
       List<Restaurant> userlist = getAllUsers();
       List<Restaurant> userWanted = userlist.stream()
       .filter(usr -> usr.getemail().equalsIgnoreCase(email))
       .collect(Collectors.toList());
       return (userWanted.size()>0)?userWanted.get(0): null;
    }*/
}
