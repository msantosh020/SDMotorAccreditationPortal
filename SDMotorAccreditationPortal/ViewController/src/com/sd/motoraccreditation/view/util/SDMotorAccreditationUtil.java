package com.sd.motoraccreditation.view.util;

import com.sd.motoraccreditation.view.beans.GlobalInfo;
import com.sd.motoraccreditation.view.beans.IndexDynamicRegion;

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

    public static IndexDynamicRegion getIndexDynamicRegion() {
        IndexDynamicRegion indexDynamicRegion = (IndexDynamicRegion) JSFUtils.resolveExpression("#{IndexDynamicRegion}");
        return indexDynamicRegion;
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
        /*
        for (String role : ADFContext.getCurrent().getSecurityContext().getUserRoles()) {
            if ("admin".equals(role) || "admin1".equals(role)) {
                userRoles[0] = true;
            } else if ("client".equals(role) || "client1".equals(role)) {
                userRoles[1] = true;
            } else if ("salesRep".equals(role) || "salesRep1".equals(role)) {
                userRoles[2] = true;
            } else if ("supervisor".equals(role) || "supervisor1".equals(role)) {
                userRoles[3] = true;
            } else if ("employee".equals(role) || "employee1".equals(role)) {
                userRoles[4] = true;
            }
        }
       */
        Boolean adminRole = (Boolean) JSFUtils.resolveExpression("#{securityContext.userInRole['admin1'] or securityContext.userInRole['admin']}");
        Boolean clientRole = (Boolean) JSFUtils.resolveExpression("#{securityContext.userInRole['client1'] or securityContext.userInRole['client']}");
        Boolean salesRepRole = (Boolean) JSFUtils.resolveExpression("#{securityContext.userInRole['salesRep1'] or securityContext.userInRole['salesRep']}");
        Boolean supervisorRole = (Boolean) JSFUtils.resolveExpression("#{securityContext.userInRole['supervisor1'] or securityContext.userInRole['supervisor']}");
        Boolean employeeRole = (Boolean) JSFUtils.resolveExpression("#{securityContext.userInRole['employee1'] or securityContext.userInRole['employee']}");
        
        if (adminRole) {
            userRoles[0] = true;
        } else if (clientRole) {
            userRoles[1] = true;
        } else if (salesRepRole) {
            userRoles[2] = true;
        } else if (supervisorRole) {
            userRoles[3] = true;
        } else if (employeeRole) {
            userRoles[4] = true;
        }
        
        return userRoles;
    }
}
