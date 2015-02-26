// Decompiled by DJ v3.6.6.79 Copyright 2004 Atanas Neshkov  Date: 2012-11-11 ¿ÀÈÄ 11:00:31
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   BasicAuthentication.java

package com.apistore.authentication;

import com.apistore.utils.Base64;
public class BasicAuthentication
{
	public static String getBasicAuthenticationHeader(String clientKey, String secret)
    {
        String headerValue = (new StringBuilder()).append(clientKey).append(":").append(secret).toString();
        return (new StringBuilder()).append("Basic ").append(Base64.encode(headerValue).replace("\r\n", "")).toString();
    }
}