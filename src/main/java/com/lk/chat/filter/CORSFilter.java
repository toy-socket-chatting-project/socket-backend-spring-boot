package com.lk.chat.filter;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CORSFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        var httpServletRequest = (HttpServletRequest) request;
        var httpservletResponse = (HttpServletResponse) response;

        var requestOrigin = httpServletRequest.getHeader(HttpHeaders.ORIGIN);

        httpservletResponse.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, requestOrigin);
        httpservletResponse.setHeader(
                HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS,
                "Origin, X-Requested-With, Content-Type, Accept, Authorization");
        httpservletResponse.setHeader(
                HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS, Boolean.TRUE.toString());
        httpservletResponse.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, "*");
        httpservletResponse.setHeader(HttpHeaders.ALLOW, "GET,POST");

        if (HttpMethod.OPTIONS.name().equalsIgnoreCase(httpServletRequest.getMethod())) {
            httpservletResponse.setStatus(HttpServletResponse.SC_OK);
        } else {
            chain.doFilter(httpServletRequest, httpservletResponse);
        }
    }
}
