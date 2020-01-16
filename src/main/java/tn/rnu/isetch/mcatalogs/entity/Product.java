package tn.rnu.isetch.mcatalogs.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String gender;
    private int age;
    private String color;
    private String size;
    private String picture;
    private double vat;
    private double priceExclTax;

    @OneToMany(mappedBy = "look")
   private List<Product> productList ;

    @ManyToOne
            @JoinColumn(name = "look_id")
  private   Product look ;


    public Product() {
    }




    public Product(String name, String gender, int age, String color, String size, String picture, double vat, double priceExclTax, List<Product> productList, Product look) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.color = color;
        this.size = size;
        this.picture = picture;
        this.vat = vat;
        this.priceExclTax = priceExclTax;
        this.productList = productList;
        this.look = look;
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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public double getPriceExclTax() {
        return priceExclTax;
    }

    public void setPriceExclTax(double priceExclTax) {
        this.priceExclTax = priceExclTax;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Product getLook() {
        return look;
    }

    public void setLook(Product look) {
        this.look = look;
    }
}
