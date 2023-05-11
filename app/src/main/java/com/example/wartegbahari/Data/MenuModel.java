package com.example.wartegbahari.Data;

public class MenuModel {
  private int image;
  private String title;
  private String desc;
  private Double price;

  public MenuModel(int image, String title, String desc, Double price) {
    this.image = image;
    this.title = title;
    this.desc = desc;
    this.price = price;
  }

  public Integer getImage() {
    return image;
  }

  public void setImage(Integer image) {
    this.image = image;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }
}
