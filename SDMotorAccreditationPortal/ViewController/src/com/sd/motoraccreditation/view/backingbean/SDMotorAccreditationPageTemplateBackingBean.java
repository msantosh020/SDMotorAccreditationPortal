package com.sd.motoraccreditation.view.backingbean;

import com.sd.motoraccreditation.view.beans.GlobalInfo;
import com.sd.motoraccreditation.view.beans.IndexDynamicRegion;
import com.sd.motoraccreditation.view.beans.MenuItemBean;
import com.sd.motoraccreditation.view.util.MenuBuilderUtil;
import com.sd.motoraccreditation.view.util.SDMotorAccreditationUtil;

import java.io.IOException;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import javax.servlet.http.HttpSession;

public class SDMotorAccreditationPageTemplateBackingBean {
    public SDMotorAccreditationPageTemplateBackingBean() {
        super();
    }

    public void onLocaleSelectionAction(ActionEvent actionEvent) {
        // Add event code here...
        GlobalInfo globalInfo = SDMotorAccreditationUtil.getGlobalInfo();
        System.out.println("SDMotorAccreditationPageTemplateBackingBean.onLocaleSelectionAction() old Locale =" + globalInfo.getSelectedLocale());
        String newlySelectedLocale = "en".equalsIgnoreCase(globalInfo.getSelectedLocale()) ? "fr" : "en";
        System.out.println("SDMotorAccreditationPageTemplateBackingBean.onLocaleSelectionAction() newlySelectedLocale =" + newlySelectedLocale);
        SDMotorAccreditationUtil.changeLocale(newlySelectedLocale);
        globalInfo.setSelectedLocale(newlySelectedLocale);
    }

    public void onLogoutAction(ActionEvent actionEvent) {
        // Add event code here...
        try {
            FacesContext fc = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
            session.invalidate();
            String contextPath = FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath();
            System.out.println("contextPath=" + contextPath);
            FacesContext.getCurrentInstance().getExternalContext().redirect(contextPath + "/faces/index.jsf");
        } catch (IOException e) {
        }
    }

    public void onMenuSelectionAction(ActionEvent actionEvent) {
        String menuName = (String) actionEvent.getComponent().getAttributes().get("MenuName");
        MenuItemBean selectedMenuItem = MenuBuilderUtil.getMenuItemBean(menuName);
        GlobalInfo globalInfo = SDMotorAccreditationUtil.getGlobalInfo();
        globalInfo.setSelectedMenuItem(selectedMenuItem);
        IndexDynamicRegion indexDynamicRegion = SDMotorAccreditationUtil.getIndexDynamicRegion();
        indexDynamicRegion.setDynamicTaskFlowId(selectedMenuItem.getPageUrl());
    }    
}
