package com.example.wartegbahari.Data;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class ArrayMenuModel extends ViewModel {
  private static ArrayList<MenuModel> menu;

  public static ArrayList<MenuModel> getInstance() {
    if (menu == null) {
      menu = new ArrayList<MenuModel>();
    }
    return menu;
  }

  public static ArrayList<MenuModel> getMenu() {
    return menu;
  }

  public static void addMenu(MenuModel menuModel) {
    menu.add(menuModel);
  }

  public void setMenuList(ArrayList<MenuModel> menuList) {
    this.menu = menuList;
  }
}
