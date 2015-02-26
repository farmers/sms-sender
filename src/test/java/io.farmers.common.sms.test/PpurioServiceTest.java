package io.farmers.commons.sms.test;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import io.farmers.common.sms.MessageType;
import io.farmers.common.sms.ResultCode;
import io.farmers.common.sms.SMSRequest;
import io.farmers.common.sms.ppurio.AuthInterceptor;
import io.farmers.common.sms.ppurio.PpurioService;
import io.farmers.common.sms.ppurio.Response;
import org.junit.Test;
import retrofit.RestAdapter;
import retrofit.converter.JacksonConverter;

import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by amond on 15. 2. 27.
 */
public class PpurioServiceTest {

    private static final String TEST_URL = "http://api.openapi.io/ppurio_test/1/message_test";
    private static final String TEST_KEY = "MS0xMzY1NjY2MTAyNDk0LTA2MWE4ZDgyLTZhZmMtNGU5OS05YThkLTgyNmFmYzVlOTkzZQ==";
    private static final String TEST_ID = "io.farmers.common.sms.test";

    @Test
    public void testSendSMS() throws Exception {
        ObjectMapper mapper = new ObjectMapper();


        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(TEST_URL)
                .setConverter(new JacksonConverter(mapper))
                .setRequestInterceptor(new AuthInterceptor(TEST_KEY))
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();

        PpurioService ppurioService = restAdapter.create(PpurioService.class);

        SMSRequest request = new SMSRequest.Builder("0101231234", "0101231234").build();



        Response response = ppurioService.sendSMS(MessageType.SMS.getName(), TEST_ID, mapper.convertValue(request, Map.class));

        assertEquals(ResultCode.OK, response.getResultCode());
    }

}
