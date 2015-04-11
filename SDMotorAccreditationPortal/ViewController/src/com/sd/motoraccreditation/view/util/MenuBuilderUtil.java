package com.sd.motoraccreditation.view.util;

import com.sd.motoraccreditation.view.beans.IndexDynamicRegion;
import com.sd.motoraccreditation.view.beans.MenuItemBean;

import java.util.ArrayList;
import java.util.List;

public class MenuBuilderUtil {
    public MenuBuilderUtil() {
        super();
    }

    private static MenuItemBean userMgmtMenu = new MenuItemBean("Home", "/images/xxx.png", IndexDynamicRegion.HOME_TASKFLOW);
    private static MenuItemBean companiesListMenu = new MenuItemBean("Companies List", "/images/xxx.png", IndexDynamicRegion.COMPANIES_LIST_TASKFLOW);
    private static MenuItemBean companyMotorsListMenu = new MenuItemBean("Company’s motors list", "/images/xxx.png", IndexDynamicRegion.COMPANY_MOTORS_LIST_TASKFLOW);
    private static MenuItemBean CompanyRequestListMenu = new MenuItemBean("Company‘s Request List", "/images/xxx.png", IndexDynamicRegion.COMPANY_REQUEST_LIST_TASKFLOW);
    private static MenuItemBean MotorUserManualsMenu = new MenuItemBean("Motors’ user manuals", "/images/xxx.png", IndexDynamicRegion.MOTOR_USER_MANUALS_TASKFLOW);
    private static MenuItemBean requestsListMenu = new MenuItemBean("Requests lists", "/images/xxx.png", IndexDynamicRegion.REQUESTS_LIST_TASKFLOW);
    private static MenuItemBean ClientUserListMenu = new MenuItemBean("Client’s user list", "/images/xxx.png", IndexDynamicRegion.CLIENT_USER_LIST_TASKFLOW);
    private static MenuItemBean otherProductsMenu = new MenuItemBean("Other Products", "/images/xxx.png", IndexDynamicRegion.OTHER_PRODUCTS_TASKFLOW);
    private static MenuItemBean inspectionCheckingListMenu = new MenuItemBean("Inspection’s checking lists", "/images/xxx.png", IndexDynamicRegion.INSPECTION_CHECKING_LIST_TASKFLOW);

    public static List<MenuItemBean> getUserMenuList() {
        //Array consist of admin, client, salesRep, supervisor, employee
        boolean[] userRoles = SDMotorAccreditationUtil.geUserRoles();
        List<MenuItemBean> userMenuList = new ArrayList<MenuItemBean>();
        //Only admin pages - User management pages
        if (userRoles[0]) {
            userMenuList.add(userMgmtMenu);
        }
        //Common pages for all roles except admin
        if (userRoles[1] || userRoles[2] || userRoles[3] || userRoles[4]) {
            userMenuList.add(companiesListMenu);
            userMenuList.add(companyMotorsListMenu);
        }

        //Common pages for salesRep, supervisor
        if (userRoles[2] || userRoles[3]) {
            userMenuList.add(requestsListMenu);
            userMenuList.add(ClientUserListMenu);
            userMenuList.add(otherProductsMenu);
        }

        // Only client pages
        if (userRoles[1]) {
            userMenuList.add(CompanyRequestListMenu);
            userMenuList.add(MotorUserManualsMenu);
        }

        // Only Supervisor pages
        if (userRoles[3]) {
            userMenuList.add(inspectionCheckingListMenu);
        }

        return userMenuList;
    }

    public static MenuItemBean getMenuItemBean(String menuName) {
        MenuItemBean menuItem = null;
        for (MenuItemBean menu : getUserMenuList()) {
            if (menuName.equals(menu.getMenuName())) {
                menuItem = menu;
                break;
            }
        }
        return menuItem;
    }
}
