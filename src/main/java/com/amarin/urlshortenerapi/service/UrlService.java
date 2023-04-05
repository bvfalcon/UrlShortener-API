package com.amarin.urlshortenerapi.service;

import com.amarin.urlshortenerapi.entity.Url;
import com.amarin.urlshortenerapi.repository.UrlRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Date;

@Service
public class UrlService {

    private final UrlRepository urlRepository;

    public UrlService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public String convertToShortUrl(String longUrl) {
        var url = new Url();
        url.setLongUrl(longUrl);
        url.setCreatedDate(new Date());
        var entity = urlRepository.save(url);

        return BaseConversion.encode(entity.getId());
    }

    public String getOriginalUrl(String shortUrl) {
        var id = BaseConversion.decode(shortUrl);
        var entity = urlRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("There is no entity with " + shortUrl));

        return entity.getLongUrl();
    }
}
