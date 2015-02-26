// Decompiled by DJ v3.6.6.79 Copyright 2004 Atanas Neshkov  Date: 2012-11-11 ¿ÀÈÄ 11:03:08
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   Base64.java

package com.apistore.utils;

import java.io.PrintStream;

public class Base64
{

    public Base64()
    {
    }

    public static byte[] zeroPad(int length, byte bytes[])
    {
        byte padded[] = new byte[length];
        System.arraycopy(bytes, 0, padded, 0, bytes.length);
        return padded;
    }

    public static String encode(String string)
    {
        String encoded = "";
        byte stringArray[];
        try
        {
            stringArray = string.getBytes("UTF-8");
        }
        catch(Exception ignored)
        {
            stringArray = string.getBytes();
        }
        int paddingCount = (3 - stringArray.length % 3) % 3;
        stringArray = zeroPad(stringArray.length + paddingCount, stringArray);
        for(int i = 0; i < stringArray.length; i += 3)
        {
            int j = ((stringArray[i] & 0xff) << 16) + ((stringArray[i + 1] & 0xff) << 8) + (stringArray[i + 2] & 0xff);
            encoded = (new StringBuilder()).append(encoded).append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt(j >> 18 & 0x3f)).append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt(j >> 12 & 0x3f)).append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt(j >> 6 & 0x3f)).append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt(j & 0x3f)).toString();
        }

        return splitLines((new StringBuilder()).append(encoded.substring(0, encoded.length() - paddingCount)).append("==".substring(0, paddingCount)).toString());
    }

    public static String splitLines(String string)
    {
        String lines = "";
        for(int i = 0; i < string.length(); i += 76)
        {
            lines = (new StringBuilder()).append(lines).append(string.substring(i, Math.min(string.length(), i + 76))).toString();
            lines = (new StringBuilder()).append(lines).append("\r\n").toString();
        }

        return lines;
    }

    public static void main(String args[])
    {
        for(int i = 0; i < args.length; i++)
        {
            System.err.println((new StringBuilder()).append("encoding \"").append(args[i]).append("\"").toString());
            System.out.println(encode(args[i]));
        }

    }

    private static final String base64code = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
    private static final int splitLinesAt = 76;
}