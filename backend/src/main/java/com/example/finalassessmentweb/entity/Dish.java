package com.example.finalassessmentweb.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "dishes")
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "name", nullable = false)
    private String name;

    @Column(name= "price", nullable = false)
    private Long price;

    @Column(name= "ingredients",nullable = false)
    private String ingredients;

    @Column(name= "prep_time",nullable = false)
    private String preparationTime;

    @Column(name= "image_url",nullable = false)
    private String imageUrl;

    private String tag;

    public Dish() {
    }

    public Dish(Long id, String name, Long price, String ingredients, String preparationTime, String imageUrl, String tag) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.ingredients = ingredients;
        this.preparationTime = preparationTime;
        this.imageUrl = imageUrl;
        this.tag = tag;
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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(String preparationTime) {
        this.preparationTime = preparationTime;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", ingredients='" + ingredients + '\'' +
                ", preparationTime='" + preparationTime + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", tag='" + tag + '\'' +
                '}';
    }
}
