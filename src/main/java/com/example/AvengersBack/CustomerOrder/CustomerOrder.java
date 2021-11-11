package com.example.AvengersBack.CustomerOrder;

import com.example.AvengersBack.Onboard.customers;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@Entity
@Table(name = "customerorder")
public class CustomerOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "cus_id", nullable = false, unique = false, length = 11)
    private Integer cusId;

    @Column(name = "act_id", nullable = false, unique = false, length = 3 )
    private Integer actId;

    @Column(name = "total_price", nullable = false, unique = false, length = 3 )
    private float totalPrice;

    @Column(name = "table_num", nullable = false, unique = false, length = 3 )
    private Integer tableNum;

    //@OneToOne(mappedBy = "customerorders")
    //private customers customer;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getCusId() {
        return cusId;
    }

    public void setCusId(Integer cusId) {
        this.cusId = cusId;
    }

    public Integer getActId() {
        return actId;
    }

    public void setActId(Integer actId) {
        this.actId = actId;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getTableNum() {
        return tableNum;
    }

    public void setTableNum(Integer tableNum) {
        this.tableNum = tableNum;
    }

}
