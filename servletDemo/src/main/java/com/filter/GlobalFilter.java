package com.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by chenfengfu on 2018/2/5.
 */
public class GlobalFilter implements Filter{


    public void init(FilterConfig filterConfig) throws ServletException {
        String name = filterConfig.getInitParameter("name"); // 过滤器的初始化参数
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(request, response); // 过滤器通过
    }

    public void destroy() {

    }
}
