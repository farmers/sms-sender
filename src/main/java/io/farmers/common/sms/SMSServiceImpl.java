package io.farmers.common.sms;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.OkHttpClient;
import io.farmers.common.sms.ppurio.AuthInterceptor;
import io.farmers.common.sms.ppurio.PpurioService;
import io.farmers.common.sms.ppurio.Response;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;
import retrofit.converter.JacksonConverter;
import retrofit.http.Path;

import java.util.Map;

/**
 * Created by amond on 15. 2. 26.
 */
public class SMSServiceImpl implements SMSService {

    private final String BASE_URL = "http://api.openapi.io/ppurio/1/message";
    private final String API_KEY = "MjI2MC0xNDIzODA2NDQzNDAxLTg0NWY1MjliLTA2NWYtNGE4Zi05ZjUyLTliMDY1ZjdhOGY4Mg==";
    private final String CLIENT_ID = "farmers";


    private static OkHttpClient okHttpClient = new OkHttpClient();

    ObjectMapper mapper = new ObjectMapper();

    private PpurioService ppurioService;


    public SMSServiceImpl() {

        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(BASE_URL)
                .setConverter(new JacksonConverter(mapper))
                .setRequestInterceptor(new AuthInterceptor(API_KEY))
                //.setLogLevel(RestAdapter.LogLevel.FULL)
                .build();

        ppurioService = restAdapter.create(PpurioService.class);
    }

    @Override
    public Response sendSMS(SMSRequest smsRequest) {
        return ppurioService.sendSMS(MessageType.SMS.getName(), CLIENT_ID, (Map<String, String>) mapper.convertValue(smsRequest, Map.class));
    }

    @Override
    public Response sendLMS(SMSRequest smsRequest) {
        throw new UnsupportedOperationException();
//TODO
    }

    @Override
    public Response sendMMS(SMSRequest smsRequest) {
        throw new UnsupportedOperationException();

//TODO
    }


}
