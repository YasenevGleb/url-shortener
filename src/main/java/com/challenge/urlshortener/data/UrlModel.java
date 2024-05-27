package com.challenge.urlshortener.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "urlModel")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UrlModel {
    private String shortUrl;
    private String originUrl;
    @Id
    @Indexed(unique=true)
    private String id;
}
