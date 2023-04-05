package com.amarin.urlshortenerapi.service;

public class BaseConversion {

    public static String encode(long input){
        return Long.toString(input, 36);
    }

    public static long decode(String input) {
        return Long.parseLong(input, 36);
    }
}
