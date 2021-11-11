package com.example.AvengersBack.Food;

import javax.persistence.*;

@Entity
@Table(name="food")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "food_id")
    private Integer food_id;

    @Column(name ="cat_id", nullable = false, unique = false)
    private Integer catId;

    @Column(nullable = false, unique = false, length = 25)
    private String name;

    @Column(nullable = false, unique = false, length = 250)
    private String image;

    @Column(nullable = false, unique = false, length = 11)
    private float preptime;

    @Column(nullable = false, unique = false, length = 11)
    private float price;


    public Integer getFood_id() {
        return food_id;
    }

    public void setFood_id(Integer food_id) {
        this.food_id = food_id;
    }

    public Integer getCat_id() {
        return catId;
    }

    public void setCat_id(Integer cat_id) {
        this.catId = cat_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public float getPreptime() {
        return preptime;
    }

    public void setPreptime(float preptime) {
        this.preptime = preptime;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

}
