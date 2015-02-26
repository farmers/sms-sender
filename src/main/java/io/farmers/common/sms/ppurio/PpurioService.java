package io.farmers.common.sms.ppurio;

import io.farmers.common.sms.MessageType;
import retrofit.http.*;

import java.util.Map;

/**
 * Created by amond on 15. 2. 27.
 */
public interface PpurioService {

    @FormUrlEncoded
    @POST("/{message_type}/{client_id}")
    Response sendSMS(@Path("message_type") String messageType, @Path("client_id") String clientId, @FieldMap Map<String, String> options);


}
