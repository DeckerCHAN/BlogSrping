package com.deckerchan.blog.utils;

import org.apache.commons.codec.digest.DigestUtils;

public class CodeUtils {

    public static String getHash(String sample) {
        return DigestUtils.md5Hex(sample).toUpperCase();
    }
}
