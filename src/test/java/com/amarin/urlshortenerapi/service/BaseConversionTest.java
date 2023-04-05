package com.amarin.urlshortenerapi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BaseConversionTest {

    @Test
    public void encode_lessThan62() {
        assertEquals("a", BaseConversion.encode(10));
    }

    @Test
    public void encode_moreThan62() {
        assertEquals("26", BaseConversion.encode(78));
    }

    @Test
    public void decode_singleCharacter() {
        assertEquals(21, BaseConversion.decode("l"));
    }
}
