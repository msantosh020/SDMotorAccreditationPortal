package com.sd.motoraccreditation.view.backingbean;

import com.sd.motoraccreditation.view.util.EmailSenderUtil;

import javax.faces.event.ActionEvent;

import org.apache.log4j.Logger;


public class LoginBackingBean {
    public LoginBackingBean() {
        super();
    }
    static Logger log = Logger.getLogger(LoginBackingBean.class);

    public void setLostPasswordRequestEmailId(String lostPasswordRequestEmailId) {
        this.lostPasswordRequestEmailId = lostPasswordRequestEmailId;
    }

    public String getLostPasswordRequestEmailId() {
        return lostPasswordRequestEmailId;
    }

    private String lostPasswordRequestEmailId;

    public void onSendRequestAction(ActionEvent actionEvent) {
        // Add event code here...
        log.info("Start of onSendRequestAction() lostPasswordRequestEmailId=" + getLostPasswordRequestEmailId() + ";;");
        EmailSenderUtil.sendLostPasswordRequestEmail(getLostPasswordRequestEmailId());

        log.info("end of onSendRequestAction()");
    }
}
