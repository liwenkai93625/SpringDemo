package com.lwk.spitter.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.core.type.filter.RegexPatternTypeFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.regex.Pattern;

/**
 * Created by lianjia on 2017-5-18.
 *
 * 配置spring的应用上下文
 */
@Configuration
@ComponentScan(basePackages = {"com.lwk.spitter"},
    excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class)
    })
public class RootConfig {
    public static class WebPackage extends RegexPatternTypeFilter {
        public WebPackage() {
            super(Pattern.compile("com.lwk.spittr\\."));
        }
    }
}
