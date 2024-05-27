

package com.challenge.urlshortener.common;

import com.challenge.urlshortener.data.ShortenerUrlResponse;
import com.challenge.urlshortener.data.UrlModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UrlMapper {
    @Value("${urlShortener.domain}")
    private String host;
    public ShortenerUrlResponse mapEntityToResponse(UrlModel model) {
        ShortenerUrlResponse response = new ShortenerUrlResponse();
        response.setShortUrl(host + model.getShortUrl());
        response.setUrlOrigin(model.getOriginUrl());
        return response;
    }
}

