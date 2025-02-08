package com.APIGateway.filter;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class LoggingFilter implements GlobalFilter 
{
    private Logger logger=LoggerFactory.getLogger(LoggingFilter.class);
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) 
    {
        ServerHttpRequest request=exchange.getRequest();
        logger.info("Incoming Request:{}",request.getURI());
        logger.info("Method:",request.getMethod());
        logger.info("Headers",request.getHeaders());
        return chain.filter(exchange);
    }
    
}
