package com.lockquell.motoraccreditation.view.backingbean;

import com.lockquell.motoraccreditation.view.beans.GlobalInfo;
import com.lockquell.motoraccreditation.view.util.SDMotorAccreditationUtil;

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
            FacesContext.getCurrentInstance().getExternalContext().redirect(contextPath + "/faces/home.jsf");
        } catch (IOException e) {
        }
    }
}