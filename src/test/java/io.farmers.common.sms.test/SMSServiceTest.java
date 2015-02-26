package io.farmers.common.sms.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.farmers.common.sms.SMSRequest;
import io.farmers.common.sms.SMSService;
import io.farmers.common.sms.SMSServiceImpl;
import io.farmers.common.sms.ppurio.Response;
import org.junit.Test;

/**
 * Created by amond on 15. 2. 27.
 */
public class SMSServiceTest {

    @Test
    public void testSendSMSTest() throws Exception {

        SMSService service = new SMSServiceImpl();

        SMSRequest request = new SMSRequest.Builder("01083160605", "01066605175").msgBody("test").build();

        System.out.println(new ObjectMapper().writeValueAsString(request));

        Response response = service.sendSMS(request);
        System.out.println(new ObjectMapper().writeValueAsString(response));


    }
}
