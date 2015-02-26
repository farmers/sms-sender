package io.farmers.common.sms;

/**
 * Created by amond on 15. 2. 27.
 */
public class SMSRequest {

    private String sendTime;

    private String sendPhone;
    private String destPhone;

    private String sendName;
    private String destName;

    private String subject;
    private String msgBody;

    private SMSRequest(String sendTime, String sendPhone, String destPhone, String sendName, String destName, String subject, String msgBody) {
        this.sendTime = sendTime;
        this.sendPhone = sendPhone;
        this.destPhone = destPhone;
        this.sendName = sendName;
        this.destName = destName;
        this.subject = subject;
        this.msgBody = msgBody;
    }

    public String getSendTime() {
        return sendTime;
    }

    public String getSendPhone() {
        return sendPhone;
    }

    public String getDestPhone() {
        return destPhone;
    }

    public String getSendName() {
        return sendName;
    }

    public String getDestName() {
        return destName;
    }

    public String getSubject() {
        return subject;
    }

    public String getMsgBody() {
        return msgBody;
    }

    public static class Builder {

        private String sendTime = "";

        private String sendPhone = "";
        private String destPhone = "";

        private String sendName = "";
        private String destName = "";

        private String subject = "";
        private String msgBody = "";


        public Builder(final String sendPhone, final String destPhone) {
            this.sendPhone = sendPhone;
            this.destPhone = destPhone;
        }

        public Builder sendName(final String sendName) {
            this.sendName = sendName;
            return this;
        }

        public Builder destName(final String destName) {
            this.destName = destName;
            return this;
        }

        public Builder subject(final String subject) {
            this.subject = subject;
            return this;
        }

        public Builder msgBody(final String msgBody) {
            this.msgBody = msgBody;
            return this;
        }

        public SMSRequest build() {
            return new SMSRequest(sendTime, sendPhone, destPhone, sendName, destName, subject, msgBody);
        }

    }

}
