package com.trash_sorter.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/tank")
public class TankServlet extends HttpServlet {
    public static long id;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String string_id = req.getParameter("id");
        id = Long.parseLong(string_id);
        //получить название бака

//        TankService service = TankServiceIMPL.getInstance();
//        String tankName = service.getTankById(id).getTankName();

        RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
        dispatcher.forward(req,resp);
    }
}
