package com.frm;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by chenfengfu on 2018/2/26.
 * 自定义异常处理
 */

@Component
public class MyExceptionHandler implements HandlerExceptionResolver {

    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object object, Exception exception) {
        if (exception instanceof IOException) {
            return new ModelAndView("ioexp");
        } else if (exception instanceof SQLException) {
            return new ModelAndView("sqlexp");
        }
        return null;
    }
}