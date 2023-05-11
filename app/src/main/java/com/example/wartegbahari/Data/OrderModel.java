package com.example.wartegbahari.Data;

import java.io.Serializable;

public class OrderModel implements Serializable {
  private String menu;
  private String spicyLevel;
  private String orderType;
  private Double total;

  public OrderModel(String menu, String spicyLevel, String orderType, Double total) {
    this.menu = menu;
    this.spicyLevel = spicyLevel;
    this.orderType = orderType;
    this.total = total;
  }

  public String getSpicyLevel() {
    return spicyLevel;
  }

  public void setSpicyLevel(String spicyLevel) {
    this.spicyLevel = spicyLevel;
  }

  public Double getTotal() {
    return total;
  }

  public void setTotal(Double total) {
    this.total = total;
  }

  public String getMenu() {
    return menu;
  }

  public void setMenu(String menu) {
    this.menu = menu;
  }

  public String getOrderType() {
    return orderType;
  }

  public void setOrderType(String orderType) {
    this.orderType = orderType;
  }
}
