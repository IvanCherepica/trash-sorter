package com.example;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/rest")
public class RestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        List<Model> list = new ArrayList<>();
//
//        list.add( new Model(1, "door", 100) );
//        list.add( new Model(2, "box", 50) );
//        list.add( new Model(3, "bad", 70) );

        //String json = new Gson().toJson(list);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        //response.getWriter().write(json);
    }

}
