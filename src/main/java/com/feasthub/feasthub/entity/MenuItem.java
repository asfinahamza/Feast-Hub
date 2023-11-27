
package com.feasthub.feasthub.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="menu_item")
public class MenuItem {
    @Id
    @SequenceGenerator(
        name = "menu_item_sequence",
        sequenceName = "menu_item_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "menu_item_sequence"
    )
    private Long id;
    private String name;
    private Float price;
    
    public MenuItem() {
    }

    public MenuItem(Long id, String name, Float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public MenuItem(String name, Float price) {
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Customer [id=" + id + ", name=" + name + ", price=" + price + "]";
    }



}
