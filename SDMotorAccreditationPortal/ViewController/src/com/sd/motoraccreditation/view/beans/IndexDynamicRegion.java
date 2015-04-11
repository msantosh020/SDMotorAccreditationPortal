package com.sd.motoraccreditation.view.beans;

import com.sd.motoraccreditation.view.util.MenuBuilderUtil;
import com.sd.motoraccreditation.view.util.SDMotorAccreditationUtil;

import java.io.Serializable;

import java.util.HashMap;

import oracle.adf.controller.TaskFlowId;

public class IndexDynamicRegion implements Serializable {
    @SuppressWarnings("compatibility:7048680811174526905")
    public static final long serialVersionUID = -2968581055157302513L;
    public static final String HOME_TASKFLOW = "/WEB-INF/flows/HomeTF.xml#HomeTF";
    public static final String COMPANIES_LIST_TASKFLOW = "/WEB-INF/flows/CompaniesListTF.xml#CompaniesListTF";
    public static final String COMPANY_MOTORS_LIST_TASKFLOW = "/WEB-INF/flows/CompanyMotorsListTF.xml#CompanyMotorsListTF";
    public static final String COMPANY_REQUEST_LIST_TASKFLOW = "/WEB-INF/flows/CompanyRequestListTF.xml#CompanyRequestListTF";
    public static final String MOTOR_USER_MANUALS_TASKFLOW = "/WEB-INF/flows/MotorUserManualsTF.xml#MotorUserManualsTF";
    public static final String REQUESTS_LIST_TASKFLOW = "/WEB-INF/flows/RequestsListTF.xml#RequestsListTF";
    public static final String CLIENT_USER_LIST_TASKFLOW = "/WEB-INF/flows/ClientUserListTF.xml#ClientUserListTF";
    public static final String OTHER_PRODUCTS_TASKFLOW = "/WEB-INF/flows/OtherProductsTF.xml#OtherProductsTF";
    public static final String INSPECTION_CHECKING_LIST_TASKFLOW = "/WEB-INF/flows/InspectionCheckingListTF.xml#InspectionCheckingListTF";
    private String taskFlowId = HOME_TASKFLOW;
    private HashMap parameters = new HashMap();

    public IndexDynamicRegion() {
    }

    public void setParameters(HashMap parameters) {
        this.parameters = parameters;
    }

    public HashMap getParameters() {
        return parameters;
    }

    public TaskFlowId getDynamicTaskFlowId() {
        return TaskFlowId.parse(taskFlowId);
    }

    public void setDynamicTaskFlowId(String taskFlowId) {
        this.taskFlowId = taskFlowId;
    }

    public String homePage() {
        setDynamicTaskFlowId(HOME_TASKFLOW);
        MenuItemBean selectedMenuItem = MenuBuilderUtil.getMenuItemBean("Home");
        GlobalInfo globalInfo = SDMotorAccreditationUtil.getGlobalInfo();
        globalInfo.setSelectedMenuItem(selectedMenuItem);
        return null;
    }
}

