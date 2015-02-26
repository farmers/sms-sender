package io.farmers.common.sms;

/**
 * Created by amond on 15. 2. 27.
 */
public enum MessageType {

    SMS("sms"), LMS("lms"), MMS("mms");


    private String name;

    private MessageType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
