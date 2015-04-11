package com.lockquell.motoraccreditation.view.beans;

import java.io.Serializable;

import oracle.adf.controller.TaskFlowId;

public class IndexDynamicRegion implements Serializable {
    @SuppressWarnings("compatibility:7048680811174526905")
    private static final long serialVersionUID = -2968581055157302513L;
    private static final String DASHBOARD_TASKFLOW = "/WEB-INF/view/dashboard/dashboard.xml#dashboard";
    private static final String ORGANIZATION_TASKFLOW = "/WEB-INF/view/organizations/organizations.xml#organizations";
    private static final String PEOPLE_TASKFLOW = "/WEB-INF/view/people/people.xml#people";
    private String taskFlowId = DASHBOARD_TASKFLOW;

    public IndexDynamicRegion() {
    }

    public TaskFlowId getDynamicTaskFlowId() {
        return TaskFlowId.parse(taskFlowId);
    }

    public void setDynamicTaskFlowId(String taskFlowId) {
        this.taskFlowId = taskFlowId;
    }

    public String dashboard() {
        setDynamicTaskFlowId(DASHBOARD_TASKFLOW);
        return null;
    }

    public String organizations() {
        setDynamicTaskFlowId(ORGANIZATION_TASKFLOW);
        return null;
    }

    public String people() {
        setDynamicTaskFlowId(PEOPLE_TASKFLOW);
        return null;
    }
}

