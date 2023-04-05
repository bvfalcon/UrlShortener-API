package com.amarin.urlshortenerapi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.amarin.urlshortenerapi.entity.Url;
import com.amarin.urlshortenerapi.repository.UrlRepository;

@ExtendWith(MockitoExtension.class)
public class UrlServiceTest {

    @Mock
    UrlRepository mockUrlRepository;

    @InjectMocks
    UrlService urlService;

    @Test
    public void convertToShortUrlTest() {
        var url = new Url();
        url.setLongUrl("https://github.com/AnteMarin/UrlShortener-API");
        url.setCreatedDate(new Date());
        url.setId(5);

        when(mockUrlRepository.save(any(Url.class))).thenReturn(url);

        var urlRequest = "https://github.com/AnteMarin/UrlShortener-API";

        assertEquals("5", urlService.convertToShortUrl(urlRequest));
    }

    @Test
    public void getOriginalUrlTest() {
        var url = new Url();
        url.setLongUrl("https://github.com/AnteMarin/UrlShortener-API");
        url.setCreatedDate(new Date());
        url.setId(7);

        when(mockUrlRepository.findById(7L)).thenReturn(java.util.Optional.of(url));
        assertEquals("https://github.com/AnteMarin/UrlShortener-API", urlService.getOriginalUrl("7"));

    }
}
