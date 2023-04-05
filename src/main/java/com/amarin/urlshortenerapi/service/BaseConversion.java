package com.amarin.urlshortenerapi.service;

import org.springframework.stereotype.Service;

@Service
public class BaseConversion {

    public String encode(long input){
        return Long.toString(input, 36);
    }

    public long decode(String input) {
        return Long.parseLong(input, 36);
    }
}
