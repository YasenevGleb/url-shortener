package com.challenge.urlshortener.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.net.URL;

public class ShortenerUrlRequest {
    private URL url;

    @JsonCreator
    public ShortenerUrlRequest(@JsonProperty URL url) {
        this.url = url;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }
}
