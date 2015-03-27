package com.lockquell.motoraccreditation.view.beans;


public class GlobalInfo {
    public GlobalInfo() {
        super();
    }

    private String selectedLocale;

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
