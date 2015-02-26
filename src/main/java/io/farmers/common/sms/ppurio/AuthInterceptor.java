package io.farmers.common.sms.ppurio;

import retrofit.RequestInterceptor;

/**
 * Created by amond on 15. 2. 27.
 */
public class AuthInterceptor implements RequestInterceptor {

    private static final String AUTH_HEADER = "x-waple-authorization";
    private final String apiKey;

    public AuthInterceptor(final String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public void intercept(RequestFacade request) {
        request.addHeader(AUTH_HEADER, apiKey);
    }
}
