package com.challenge.urlshortener.service;

import com.challenge.urlshortener.common.IDConverter;
import com.challenge.urlshortener.data.UrlModel;
import com.challenge.urlshortener.repo.UrlModelRepo;
import jakarta.servlet.http.HttpServletRequest;
import java.net.URL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UrlShortenerService {
    private final UrlModelRepo urlRepo;
    private final Logger logger = LoggerFactory.getLogger(UrlShortenerService.class);

    @Autowired
    public UrlShortenerService(UrlModelRepo repo) {
        this.urlRepo = repo;
    }

    public UrlModel createShortenerUrl(URL url, HttpServletRequest request) {
        var uuid = IDConverter.INSTANCE.createUUID(url);
        logger.info("Generated uuid {} from original url {} ", uuid, url);
        return urlRepo.save(UrlModel.builder().originUrl(url.toString()).shortUrl(uuid).build());
    }

    public UrlModel getOriginUrlFormUuid(String id) {
        return urlRepo.findByShortUrl(id);
    }
}
