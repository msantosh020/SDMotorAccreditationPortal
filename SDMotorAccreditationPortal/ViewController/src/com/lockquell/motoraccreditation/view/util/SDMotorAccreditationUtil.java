package com.lockquell.motoraccreditation.view.util;

import com.lockquell.motoraccreditation.view.beans.GlobalInfo;

import java.util.Locale;

import javax.faces.context.FacesContext;

import oracle.adf.share.ADFContext;


public class SDMotorAccreditationUtil {
    public SDMotorAccreditationUtil() {
        super();
    }

    public static void changeLocale(String language) {
        Locale newLocale = new Locale(language);
        FacesContext fctx = FacesContext.getCurrentInstance();
        fctx.getViewRoot().setLocale(newLocale);
    }

    public static GlobalInfo getGlobalInfo() {
        GlobalInfo globalInfo = (GlobalInfo) JSFUtils.resolveExpression("#{GlobalInfo}");
        return globalInfo;
    }

    public static boolean isAdminRoleUser() {
        for (String role : ADFContext.getCurrent().getSecurityContext().getUserRoles()) {
            if ("admin".equals(role)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isClientRoleUser() {
        for (String role : ADFContext.getCurrent().getSecurityContext().getUserRoles()) {
            if ("admin".equals(role)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSalesRepRoleUser() {
        for (String role : ADFContext.getCurrent().getSecurityContext().getUserRoles()) {
            if ("admin".equals(role)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isEmployeeRoleUser() {
        for (String role : ADFContext.getCurrent().getSecurityContext().getUserRoles()) {
            if ("admin".equals(role)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSupervisorRoleUser() {
        for (String role : ADFContext.getCurrent().getSecurityContext().getUserRoles()) {
            if ("admin".equals(role)) {
                return true;
            }
        }
        return false;
    }

    public static boolean[] geUserRoles() {
        //Array consist of admin, client, salesRep, supervisor, employee
        boolean[] userRoles = { false, false, false, false, false };
        for (String role : ADFContext.getCurrent().getSecurityContext().getUserRoles()) {
            if ("admin".equals(role)) {
                userRoles[0] = true;
            } else if ("client".equals(role)) {
                userRoles[1] = true;
            } else if ("salesRep".equals(role)) {
                userRoles[2] = true;
            } else if ("supervisor".equals(role)) {
                userRoles[3] = true;
            } else if ("employee".equals(role)) {
                userRoles[4] = true;
            }
        }
        return userRoles;
    }
}
