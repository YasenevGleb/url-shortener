package com.challenge.urlshortener.repo;

import com.challenge.urlshortener.data.UrlModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlModelRepo extends MongoRepository<UrlModel, String> {
    UrlModel findByShortUrl(String shortUrl);
}
