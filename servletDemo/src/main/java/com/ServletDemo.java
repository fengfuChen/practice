package com;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by chenfengfu on 2018/2/5.
 */
public class ServletDemo extends HttpServlet {


    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        out.write("hello world");
        out.close();
    }

}
