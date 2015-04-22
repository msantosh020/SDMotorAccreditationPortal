package com.sd.motoraccreditation.view.backingbean;

import com.sd.motoraccreditation.view.util.ADFUtils;

import javax.faces.event.ActionEvent;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.RichPopup;

import oracle.jbo.Row;

public class UserManagementBackingBean {
    private RichPopup userFormPopup;

    public UserManagementBackingBean() {
        super();
    }

    public void onUserCreateAction(ActionEvent actionEvent) {
        // Add event code here...
        Object binding = ADFUtils.invokeOperationBinding("CreateInsert", null);
        ADFUtils.showPopup(getUserFormPopup());
    }

    public void setUserFormPopup(RichPopup userFormPopup) {
        this.userFormPopup = userFormPopup;
    }

    public RichPopup getUserFormPopup() {
        return userFormPopup;
    }
    
    public void onUserRoleAddAction(ActionEvent actionEvent) {
        // Add event code here...
        ADFUtils.invokeOperationBinding("CreateInsert1", null);
        DCIteratorBinding dciter = ADFUtils.findIterator("UsersIterator");
        Row userRow = dciter.getCurrentRow();
        userRow.setAttribute("EPassword", "Welcome1");
        userRow.setAttribute("Password", "Welcome1");
    }

    public void onUserFormCancelAction(ActionEvent actionEvent) {
        // Add event code here...
        ADFUtils.invokeOperationBinding("Commit", null);
        ADFUtils.hidePopup(getUserFormPopup());
    }
    
    public void onUserFormSaveAction(ActionEvent actionEvent) {
        // Add event code here...
        ADFUtils.invokeOperationBinding("Rollback", null);
        ADFUtils.hidePopup(getUserFormPopup());
    }
}
