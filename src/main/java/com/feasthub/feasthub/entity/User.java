package com.feasthub.feasthub.entity;
 
import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

 
@Entity
@Table(name="usertable")
public class User {
    @Id
    @SequenceGenerator(
        name = "usertable_sequence",
        sequenceName = "usertable_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "usertable_sequence"
    )
    private Long id;
    private String email;
    private String password;
    private String firstname;
    private String lastname;
    private Long phonenumber;
    private String address;
    private String usertype;
   
    public User() {
    }
 
    public User(Long id, String email, String password , String  firstname, String  lastname, Long phonenumber, String  address,String  usertype) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phonenumber =phonenumber;
        this.address = address;
        this.usertype = usertype;
       
    }
 
    public User(String email, String password , String  firstname, String  lastname, Long phonenumber, String  address,String  usertype) {
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phonenumber =phonenumber;
        this.address = address;
        this.usertype = usertype;
    }
          public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public String getemail() {
        return email;
    }
 
    public void setemail(String email) {
        this.email = email;
    }
 
    public String getpassword() {
        return password;
    }
 
    public void setpassword(String password) {
        this.password = password;
    }
   public String getfirstname() {
        return firstname;
    }
 
    public void setfirstname(String firstname) {
        this.firstname = firstname;
    }
      public String getlastname() {
        return lastname;
    }
 
    public void setlastname(String lastname) {
        this.lastname = lastname;
    }
      public long getphonenumber() {
        return phonenumber;
    }
 
    public void setphonenumber(long phonenumber) {
        this.phonenumber = phonenumber;
    }
      public String getaddress() {
        return address;
    }
 
    public void setaddress(String address) {
        this.address = address;
    }
     public String getusertype() {
        return usertype;
    }
 
    public void setusertype(String usertype) {
        this.usertype = usertype;}
    @Override
    public String toString() {
        return "User [id=" + id + ", email=" + email + ", password=" + password + ", firstname=" + firstname + ", lastname=" + lastname + ", phonenumber=" + phonenumber +",address="+address+",usertype="+usertype+"]";
    }
 
 
 
}
 
   


 