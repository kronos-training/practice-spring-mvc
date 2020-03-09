package com.vanessapr.practica03.springmvc.beans;

public class Client {
    private int id;
    private String name;
    private String lastName;
    private String email;
    private String numberPhone;

    public Client() {

    }

    public Client(String name, String lastName, String email, String numberPhone) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.numberPhone = numberPhone;
    }

    public Client(int id, String name, String lastName, String email, String numberPhone) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.numberPhone = numberPhone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    @Override
    public String toString() {
        return "Client: " + this.name + " " + this.lastName + " with email: " + this.email;
    }
}

