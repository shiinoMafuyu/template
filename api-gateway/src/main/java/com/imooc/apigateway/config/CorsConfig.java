package com.imooc.apigateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

/**
 * Cors:跨域资源共享
 * C - Cross   O - Origin   R - Resource S - Sharing
 *
 */
@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter(){
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        source.registerCorsConfiguration("/**",config);
        config.setAllowCredentials(true);
        config.setAllowedOrigins(Arrays.asList("*"));//http:www.a.com ....允许的地址
        config.setAllowedHeaders(Arrays.asList("*"));
        config.setAllowedMethods(Arrays.asList("*"));//GET POST ...
        config.setMaxAge(300L);//相同的请求在这段时间之内就不进行检查了

        return new CorsFilter(source);
    }

}
