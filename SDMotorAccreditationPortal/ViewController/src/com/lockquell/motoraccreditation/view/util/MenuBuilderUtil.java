package com.lockquell.motoraccreditation.view.util;

import com.lockquell.motoraccreditation.view.beans.MenuItemBean;

import java.util.ArrayList;
import java.util.List;

public class MenuBuilderUtil {
    public MenuBuilderUtil() {
        super();
    }

    private static MenuItemBean userMgmtMenu = new MenuItemBean("Home", "/images/xxx.png", "/home.jspx");
    private static MenuItemBean companiesListMenu = new MenuItemBean("Companies List", "/images/xxx.png", "/pages/secure/employee/WeeklyTimeSheet.jspx");
    private static MenuItemBean companyMotorsListMenu = new MenuItemBean("Company’s motors list", "/images/xxx.png", "/pages/secure/employee/WeeklyTimeSheet.jspx");
    private static MenuItemBean CompanyRequestListMenu = new MenuItemBean("Company‘s Request List", "/images/xxx.png", "/pages/secure/employee/WeeklyTimeSheet.jspx");
    private static MenuItemBean MotorUserManualsMenu = new MenuItemBean("Motors’ user manuals", "/images/xxx.png", "/pages/secure/employee/WeeklyTimeSheet.jspx");
    private static MenuItemBean requestsListMenu = new MenuItemBean("Requests lists", "/images/xxx.png", "/pages/secure/employee/WeeklyTimeSheet.jspx");
    private static MenuItemBean ClientUserListMenu = new MenuItemBean("Client’s user list", "/images/xxx.png", "/pages/secure/employee/WeeklyTimeSheet.jspx");
    private static MenuItemBean otherProductsMenu = new MenuItemBean("Other Products", "/images/xxx.png", "/pages/secure/employee/WeeklyTimeSheet.jspx");
    private static MenuItemBean inspectionCheckingListMenu = new MenuItemBean("Inspection’s checking lists", "/images/xxx.png", "/pages/secure/employee/WeeklyTimeSheet.jspx");

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
}
