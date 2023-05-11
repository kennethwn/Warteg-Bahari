package com.example.wartegbahari.Data;

import androidx.lifecycle.ViewModel;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class ArrayOrderModel extends ViewModel {
  private static String name;
  private static Integer table;
  private static LocalDateTime orderAt;
  private static ArrayList<OrderModel> order;

  public static ArrayList<OrderModel> getInstance() {
    if (order == null) {
      order = new ArrayList<OrderModel>();
    }
    return order;
  }

  public static ArrayList<OrderModel> getOrder() {
    return order;
  }

  public static void addOrder(OrderModel orderModel) {
    order.add(orderModel);
  }

  public static String getName() {
    return name;
  }

  public static void setName(String name) {
    ArrayOrderModel.name = name;
  }

  public static Integer getTable() {
    return table;
  }

  public static void setTable(Integer table) {
    ArrayOrderModel.table = table;
  }

  public static LocalDateTime getOrderAt() {
    return orderAt;
  }

  public static void setOrderAt(LocalDateTime orderAt) {
    ArrayOrderModel.orderAt = orderAt;
  }

  public void setOrderList(ArrayList<OrderModel> orderList) {
    this.order = orderList;
  }
}
