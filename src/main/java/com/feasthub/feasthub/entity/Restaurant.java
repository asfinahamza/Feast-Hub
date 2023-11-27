package com.feasthub.feasthub.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
@Table(name = "restauranttable")
public class Restaurant {
    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String restaurantName;
    private String location;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;*/

    // ... other fields, constructors, getters, setters, and methods ...



     @Id
    @SequenceGenerator(
        name = "restauranttable_sequence",
        sequenceName = "restauranttable_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "restauranttable_sequence"
    )
    private Long id;
    private String email;
    //private String password;
    private String firstname;
    
    


    private String lastname;
    private Long phonenumber;
    private String address;
    private String userId;
   
    public Restaurant() {
    }
 
    public Restaurant(Long id, String email, String password , String  firstname, String  lastname, Long phonenumber, String  address,String  userId) {
        this.id = id;
        this.email = email;
        //this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phonenumber =phonenumber;
        this.address = address;
       this.userId = userId;
       
    }
 
    public Restaurant(String email, String password , String  firstname, String  lastname, Long phonenumber, String  address,String  userId) {
        this.email = email;
        //this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phonenumber =phonenumber;
        this.address = address;
        this.userId = userId;
    }
    
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    /*public String getpassword() {
        return password;
    }
 
    public void setpassword(String password) {
        this.password = password;
    }*/

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Long getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(Long phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

   
    public String getuserId() {
        return userId;
    }
 
    public void setuserId(String userId) {
        this.userId = userId;
    }
    @Override
    public String toString() {
        return "User [id=" + id + ", email=" + email + ", password=" + firstname + ", lastname=" + lastname + ", phonenumber=" + phonenumber +",address="+address+",userId="+userId+"]";
    }
 
 
 
}
 
   

