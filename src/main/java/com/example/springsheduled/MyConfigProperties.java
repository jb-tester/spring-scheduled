package com.example.springsheduled;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * *
 * <p>Created by irina on 10/25/2021.</p>
 * <p>Project: spring-sheduled</p>
 * *
 */

@ConfigurationProperties("foo.bar")
public record MyConfigProperties(String p1, String p2, String p3, String p4) {
}
