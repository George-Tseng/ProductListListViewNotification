package com.tester.productlistlistview;

public class ProductSet {
    public int img;
    public String name;
    public String price;
    public String intro;
    //自訂4參數


    public ProductSet(int img, String name, String price, String intro) {
        this.img = img;
        this.name = name;
        this.price = price;
        this.intro = intro;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }
}
