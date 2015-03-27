package com.lockquell.motoraccreditation.view.util;

import com.lockquell.motoraccreditation.view.beans.GlobalInfo;

import java.util.Locale;

import javax.faces.context.FacesContext;


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
}
