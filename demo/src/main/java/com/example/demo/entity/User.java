package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
   @Column(name="name")
    private String name;
   @Column(name = "email")
    private String email;
   @Column(name = "sdt")
    private String sdt;
    @Column(name = "status")
    private int status;
    public User(){}

    public User(String name, String email, String sdt, int status) {
        this.name = name;
        this.email = email;
        this.sdt = sdt;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getSdt() {
        return sdt;
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

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", sdt='" + sdt + '\'' +
                ", status=" + status +
                '}';
    }
}
