package edu.nucky.fruitmarket.web.bean;

public class Fruit {
    private  String number;
    private  String name;
    private  Double price;
    private  String unit;
    private String imgUrl;
    public Fruit(){
    }

    public Fruit(String number, String name, Double price, String unit) {
        this.number = number;
        this.name = name;
        this.price = price;
        this.unit = unit;
    }

    public Fruit(String number, String name, Double price, String unit, String imgUrl) {
        this.number = number;
        this.name = name;
        this.price = price;
        this.unit = unit;
        this.imgUrl = imgUrl;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", unit='" + unit + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}
