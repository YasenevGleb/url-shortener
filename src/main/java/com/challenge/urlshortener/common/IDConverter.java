package com.challenge.urlshortener.common;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class IDConverter {
    public static final IDConverter INSTANCE = new IDConverter();

    public String createUUID(URL localUrl) {
        var toEncode = localUrl.getFile();
        var uuid = UUID.nameUUIDFromBytes(toEncode.getBytes()).toString();
        return uuid;
    }
}
