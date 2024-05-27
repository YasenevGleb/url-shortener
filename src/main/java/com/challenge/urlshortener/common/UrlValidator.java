package com.challenge.urlshortener.common;

import java.net.URL;
import java.util.regex.Pattern;

public class UrlValidator {
    public static final UrlValidator INSTANCE = new UrlValidator();
    private static final Pattern REGEX_URL = Pattern.compile(
        "^((http|https)://)" +                      // protocol
        "((([a-zA-Z0-9$_.+!*'(),;?&=-]|%[0-9a-fA-F]{2})+(:([a-zA-Z0-9$_.+!*'(),;?&=-]|%[0-9a-fA-F]{2})+)?@)?)?" + // user:password@
        "((\\d{1,3}\\.){3}\\d{1,3}|" +              // IP address
        "([a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}))" +        // domain name
        "(:\\d{1,5})?" +                            // port
        "(/([a-zA-Z0-9$_.+!*'(),;:@&=-]|%[0-9a-fA-F]{2})*)*" + // path
        "(\\?([a-zA-Z0-9$_.+!*'(),;:@&=-]|%[0-9a-fA-F]{2})*)?" + // query
        "(#([a-zA-Z0-9$_.+!*'(),;:@&=-]|%[0-9a-fA-F]{2})*)?$"  // fragment
    );

    private UrlValidator() {
    }

    public boolean validateUrl(URL url) {
        return REGEX_URL.matcher(url.toString()).matches();
    }
}
