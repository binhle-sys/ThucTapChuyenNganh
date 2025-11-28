package com.example.demo.entity;


import jakarta.persistence.*;
@Entity
@Table(name = "product")
public class product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "image")
    private String image;
    @Column(name = "price")
    private float price;
    @Column(name = "id_cate")
    private String cate;
    @Column(name = "status")
    private int status;

    public product() {}

    public product(String name, String image, float price, String cate, int status) {
        this.name = name;
        this.image = image;
        this.price = price;
        this.cate = cate;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public float getPrice() {
        return price;
    }

    public String getCate() {
        return cate;
    }

    public int getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setCate(String cate) {
        this.cate = cate;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", price=" + price +
                ", cate='" + cate + '\'' +
                ", status=" + status +
                '}';
    }
}
