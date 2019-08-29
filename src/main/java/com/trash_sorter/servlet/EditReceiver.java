package com.trash_sorter.servlet;

import com.google.gson.Gson;
import com.trash_sorter.service.ManyToManyService;
import com.trash_sorter.service.ManyToManyServiceIMPL;
import com.trash_sorter.service.TankService;
import com.trash_sorter.service.TankServiceIMPL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/admin/receiver")
public class EditReceiver extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson = new Gson();
        String jsonOutput = req.getParameter("ids");
        Long tank_id = Long.parseLong(req.getParameter("tankId"));
        int[] posts = gson.fromJson(jsonOutput, int[].class);

        ManyToManyService service = ManyToManyServiceIMPL.getInstance();
        for (int i = 0; i < posts.length; i++){
            long cat_id = (long) posts[i];
            service.makeDependency(tank_id, cat_id);
        }
    }
}
