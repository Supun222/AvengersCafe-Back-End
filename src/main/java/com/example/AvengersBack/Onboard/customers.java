package com.example.AvengersBack.Onboard;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class customers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cus_id;

    @Column(nullable = false, unique = false, length = 50)
    private String name;

    @Column(nullable = false, unique = false, length = 12)
    private String nic;

    @Column(nullable = false, unique = false, length = 10)
    private String phone;

    @Column(nullable = false, unique = false)
    private String address;

    @Column(nullable = false, unique = false)
    private String date;


    public Integer getCus_id() {
        return cus_id;
    }

    public void setCus_id(int cus_id) {
        this.cus_id = cus_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "customers{" +
                "cus_id=" + cus_id +
                ", name='" + name + '\'' +
                ", nic='" + nic + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
