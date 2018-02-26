package com.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.sql.SQLException;

/**
 * Created by chenfengfu on 2018/2/23.
 */
//@RequestMapping("/demo")
//@Controller
public class ControllerDemo implements Controller {


    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView modelAndView = new ModelAndView("hello");
        return modelAndView;
    }

    @ExceptionHandler
//    @ExceptionHandler(value={IOException.class,SQLException.class})
    public String execute(HttpServletRequest request, Exception ex) {
        request.setAttribute("ex", ex);
        if (ex instanceof IOException) {
            return "ioexp";
        } else if (ex instanceof SQLException) {
            return "sqlexp";
        }
        return "error";
    }

}
