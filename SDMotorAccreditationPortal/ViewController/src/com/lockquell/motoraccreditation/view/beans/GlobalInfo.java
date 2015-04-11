package com.lockquell.motoraccreditation.view.beans;

import com.lockquell.motoraccreditation.view.util.MenuBuilderUtil;

import java.util.List;


public class GlobalInfo {
    public GlobalInfo() {
        super();
    }

    private String selectedLocale = null;
    private List<MenuItemBean> menuItems = null;
    private MenuItemBean selectedMenuItem = null;

    public void setSelectedMenuItem(MenuItemBean selectedMenuItem) {
        this.selectedMenuItem = selectedMenuItem;
    }

    public MenuItemBean getSelectedMenuItem() {
        if (selectedMenuItem == null) {
            selectedMenuItem = getMenuItems().get(0);
        }
        return selectedMenuItem;
    }

    public void setMenuItems(List<MenuItemBean> menuItems) {
        this.menuItems = menuItems;
    }

    public List<MenuItemBean> getMenuItems() {
        if (menuItems == null) {
            menuItems = MenuBuilderUtil.getUserMenuList();
        }
        return menuItems;
    }

    public void setSelectedLocale(String selectedLocale) {
        this.selectedLocale = selectedLocale;
    }

    public String getSelectedLocale() {
        if (selectedLocale == null) {
            selectedLocale = "en";
        }
        return selectedLocale;
    }
}
