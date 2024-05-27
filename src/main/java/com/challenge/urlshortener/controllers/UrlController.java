package com.challenge.urlshortener.controllers;

import com.challenge.urlshortener.common.UrlMapper;
import com.challenge.urlshortener.common.UrlValidator;
import com.challenge.urlshortener.data.ShortenerUrlRequest;
import com.challenge.urlshortener.data.UrlModel;
import com.challenge.urlshortener.exception.InvalidUrlException;
import com.challenge.urlshortener.service.UrlShortenerService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import java.net.URL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;


@RestController
public class UrlController {
    private final UrlShortenerService urlService;
    private final UrlMapper urlMapper;

    public UrlController(UrlShortenerService urlService, UrlMapper urlMapper) {
        this.urlService = urlService;
        this.urlMapper = urlMapper;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(UrlController.class);

    @PostMapping(value = "/shortener", consumes = "application/json")
    public ResponseEntity<UrlModel> createShortenerUrl(@RequestBody @Valid ShortenerUrlRequest shortenerUrlRequest,
                                                       HttpServletRequest request) {
        LOGGER.info("Received request to create url shortener");
        URL url = shortenerUrlRequest.getUrl();
        if (UrlValidator.INSTANCE.validateUrl(url)) {
            return new ResponseEntity(
                urlMapper.mapEntityToResponse(urlService.createShortenerUrl(url, request)),
                HttpStatus.CREATED);
        }
        throw new InvalidUrlException("please enter valid url");
    }

    @GetMapping(value = "/{id}")
    public RedirectView createShortenerUrl(@PathVariable String id) {
        LOGGER.info("Received request with shor id request {}", id);
        LOGGER.info("Redirect to url with id {}", id);
        var originUrl = urlService.getOriginUrlFormUuid(id).getOriginUrl();
        LOGGER.info("Origin url {}", originUrl);
        return new RedirectView() {{
            setUrl(originUrl);
        }};
    }
}
