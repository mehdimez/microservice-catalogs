package tn.rnu.isetch.mcatalogs.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private String name ;
    private String gender ;
    private int age ;
    private String color ;
    private String size ;

    private double vat ;
    private double priceExclTax ;

    public Product(String name, String gender, int age, String color, String size, double vat, double priceExclTax) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.color = color;
        this.size = size;
        this.vat = vat;
        this.priceExclTax = priceExclTax;
    }

    public Product() {
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getVat() {
        return vat;
    }

    public void setVat(double vat) {
        this.vat = vat;
    }

    public double getPriceExclTax() {
        return priceExclTax;
    }

    public void setPriceExclTax(double priceExclTax) {
        this.priceExclTax = priceExclTax;
    }
}