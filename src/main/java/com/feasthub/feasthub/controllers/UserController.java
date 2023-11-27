package com.feasthub.feasthub.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ch.qos.logback.core.model.Model;

import com.feasthub.feasthub.entity.Restaurant;
import com.feasthub.feasthub.entity.User;
import com.feasthub.feasthub.repository.RestaurantRepository;
//import com.feasthub.feasthub.entity.User;
import com.feasthub.feasthub.repository.UserRepository;
import com.feasthub.feasthub.services.RestaurantService;
import com.feasthub.feasthub.services.UserService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private RestaurantService restaurantService;

    @PostMapping("/addUser")
    public String addUser(@RequestParam String email,@RequestParam String password, @RequestParam String firstname,@RequestParam String lastname,@RequestParam Long phonenumber,@RequestParam String address,@RequestParam String usertype, Model model) {
        User usertable = new User();
        usertable.setemail(email);
        usertable.setpassword(password);
        usertable.setfirstname(firstname);
        usertable.setlastname(lastname);
        usertable.setphonenumber(phonenumber);
        usertable.setaddress(address);
        usertable.setusertype(usertype);
        userRepository.save(usertable);

        if(usertype.equals("Restaurant")){
            Restaurant restauranttable = new Restaurant();
                restauranttable.setEmail(email);
                //restauranttable.setpassword(password);
                restauranttable.setFirstname(firstname);
                restauranttable.setLastname(lastname);
                restauranttable.setPhonenumber(phonenumber);
                restauranttable.setAddress(address);
                restauranttable.setuserId(Long.toString(usertable.getId()));
                //restauranttable.setuserId(usertype);
            restaurantRepository.save(restauranttable);
        }
        


        return "redirect:/loginpage?message=User added successfully";
    }

    @GetMapping("/loginpage")
    public ResponseEntity<Resource> loginpage() throws IOException {
        Resource resource = new ClassPathResource("templates/INDEXLOGIN.html");
        return ResponseEntity.ok()
            .contentType(MediaType.TEXT_HTML)
            .body(resource);
}

@GetMapping("/menupage")
    public ResponseEntity<Resource> menupage() throws IOException {
        Resource resource = new ClassPathResource("templates/index-two.html");
        return ResponseEntity.ok()
            .contentType(MediaType.TEXT_HTML)
            .body(resource);
}
@GetMapping("/registration")
    public ResponseEntity<Resource> registration() throws IOException {
        Resource resource = new ClassPathResource("templates/registration.html");
        return ResponseEntity.ok()
            .contentType(MediaType.TEXT_HTML)
            .body(resource);
}

/*@GetMapping("/homepage")
    public ResponseEntity<Resource> homepage() throws IOException {
        Resource resource = new ClassPathResource("templates/home.html");
        return ResponseEntity.ok()
            .contentType(MediaType.TEXT_HTML)
            .body(resource);
}*/

    

@PostMapping("/UserLogin")
public String login(@RequestParam String email, @RequestParam String password, Model model) {
    User user = userService.getUserByEmail(email);
    Boolean validLogin = false;
    String usertype = null;

    if (user != null) {
        String pwd = user.getpassword();
        if (pwd.equalsIgnoreCase(password)) {
            validLogin = true;
            usertype = user.getusertype(); // Assuming the correct method name is getUsertype()
        }
    }

    if ("customer".equalsIgnoreCase(usertype)) {
        return (validLogin) ? "redirect:/home?name=" + user.getfirstname() : "redirect:/loginpage";
    }else if ("restaurant".equalsIgnoreCase(usertype)) {
        return (validLogin) ? "redirect:/?name=" + user.getfirstname() : "redirect:/loginpage";
    }

    // Handle other user types or redirect to a default page
    return "redirect:/loginpage";
    }
}
