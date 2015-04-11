package com.sd.motoraccreditation.view.backingbean;

import com.sd.motoraccreditation.view.util.ADFUtils;

import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;

import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.DialogEvent;


public class ClientUserRequestBackingBean {
    private RichPopup sendRequestSuccessPopup;

    public ClientUserRequestBackingBean() {
        super();
    }

    public void setNewCleintUserRequestInitiated(boolean newCleintUserRequestInitiated) {
        this.newCleintUserRequestInitiated = newCleintUserRequestInitiated;
    }

    public boolean isNewCleintUserRequestInitiated() {
        return newCleintUserRequestInitiated;
    }

    private boolean newCleintUserRequestInitiated = false;

    public void formNewCleintUserRequest(PhaseEvent phaseEvent) {
        // Add event code here...
        if (phaseEvent.getPhaseId() == PhaseId.RENDER_RESPONSE) {
            if (!newCleintUserRequestInitiated && !AdfFacesContext.getCurrentInstance().isPostback()) {
                executeCreateCleintUserRequestRow();
                newCleintUserRequestInitiated = true;
            }
        }
    }

    private void executeCreateCleintUserRequestRow() {
        //        DCBindingContainer bindings = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
        //        OperationBinding operationBinding = (OperationBinding) bindings.getOperationBinding("CreateInsert");
        //        Object result = operationBinding.execute();
        Object binding = ADFUtils.invokeOperationBinding("CreateInsert", null);
    }

    public void sendRequestAction(ActionEvent actionEvent) {
        // Add event code here...
        Object binding = ADFUtils.invokeOperationBinding("Commit", null);
        ADFUtils.showPopup(getSendRequestSuccessPopup());
    }

    public void setSendRequestSuccessPopup(RichPopup sendRequestSuccessPopup) {
        this.sendRequestSuccessPopup = sendRequestSuccessPopup;
    }

    public RichPopup getSendRequestSuccessPopup() {
        return sendRequestSuccessPopup;
    }

    public void userRequestSuccessDialogListener(DialogEvent dialogEvent) {
        // Add event code here...
        ADFUtils.navigateToControlFlowCase("login");
    }
}
