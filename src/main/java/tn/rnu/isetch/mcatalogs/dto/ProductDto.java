package tn.rnu.isetch.mcatalogs.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import tn.rnu.isetch.mcatalogs.entity.Product;

import java.io.Serializable;
import java.util.List;

public class ProductDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id ;
    private String name ;
    private String gender ;
    private int age ;
    private String color ;
    private String size ;
    private String picture;
    private double vat ;
    private double priceExclTax ;
    private double priceInclTax;
    @JsonIgnoreProperties("look")
    private List<ProductDto> productList ;

    private   ProductDto look ;


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

    public double getPriceInclTax() {
        this.priceInclTax = this.priceExclTax* (1+this.vat/100);
        return priceInclTax;
    }

    public void setPriceInclTax(double priceInclTax) {
        this.priceInclTax = priceInclTax;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }


    public List<ProductDto> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductDto> productList) {
        this.productList = productList;
    }

    public ProductDto getLook() {
        return look;
    }

    public void setLook(ProductDto look) {
        this.look = look;
    }
}
