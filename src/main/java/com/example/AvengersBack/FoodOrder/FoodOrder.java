package com.example.AvengersBack.FoodOrder;

import javax.persistence.*;



@Entity
@Table(name = "foodorder")
public class FoodOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "foodorder_id", nullable = false, unique = true)
    private Integer foodorderId;

    @Column(name = "food_id", nullable = false, unique = false, length = 3)
    private int foodie;

    @Column(name = "quantity",  nullable = false, unique = false, length = 3)
    private int quantity;

    @Column(name = "order_id",  nullable = false, unique = false, length = 3)
    private int orderid;

    public Integer getFoodorderId() {
        return foodorderId;
    }

    public void setFoodorderId(int foodorderId) {
        this.foodorderId = foodorderId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public int getFoodie() {
        return foodie;
    }

    public void setFoodie(int foodie) {
        this.foodie = foodie;
    }
}
