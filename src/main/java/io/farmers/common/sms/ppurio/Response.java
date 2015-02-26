package io.farmers.common.sms.ppurio;

/**
 * Created by amond on 15. 2. 27.
 */
public class Response {
    private int resultCode;
    private String cmid;
    private String description;

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getCmid() {
        return cmid;
    }

    public void setCmid(String cmid) {
        this.cmid = cmid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
