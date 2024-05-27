package com.challenge.urlshortener.data;

import lombok.Data;

@Data
public class ShortenerUrlResponse {
    private String urlOrigin;
    private String shortUrl;
}
