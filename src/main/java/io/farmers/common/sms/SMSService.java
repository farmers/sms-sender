package io.farmers.common.sms;

import io.farmers.common.sms.ppurio.Response;

/**
 * Created by amond on 15. 2. 27.
 */
public interface SMSService {
    Response sendSMS(SMSRequest request);

    Response sendLMS(SMSRequest request);

    Response sendMMS(SMSRequest request);


}
