package com.funck.hrworker.resources;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("workers/configs")
public class ConfigPropertiesResource {

    @Value("${test.config:teste}")
    private String config;

    @GetMapping
    public String test() {
        return config;
    }

}
