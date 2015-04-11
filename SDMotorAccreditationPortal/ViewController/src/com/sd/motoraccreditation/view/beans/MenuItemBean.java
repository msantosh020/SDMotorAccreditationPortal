package com.sd.motoraccreditation.view.beans;


public class MenuItemBean {
    public MenuItemBean() {
        super();
    }

    private String menuKey;
    private String menuName;
    private String icon;
    private String pageUrl;

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }

    public void setMenuKey(String menuKey) {
        this.menuKey = menuKey;
    }

    public String getMenuKey() {
        return menuKey;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public MenuItemBean(String menuName, String icon, String pageUrl) {
        super();
        this.menuKey = menuName;
        this.menuName = menuName;
        this.icon = icon;
        this.pageUrl = pageUrl;
    }
}
