package com.trash_sorter.servlet;

import com.google.gson.Gson;
import com.trash_sorter.service.HashSearch;
import com.trash_sorter.service.TrashService;
import com.trash_sorter.service.TrashServiceIMPL;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@WebServlet("/worker")
public class WorkerServlet extends HttpServlet {
    long id = TankServlet.id;
    private Set<String> barCodeList = new HashSet<>();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//        String code = req.getParameter("barCode");
        String code =req.getParameter("txts");
        TrashService trashService = TrashServiceIMPL.getInstance();

        String[] barcode = trashService.getTrashName(code);

        boolean can_drop = HashSearch.search(trashService.getAllTrashById(id), barcode);
        //barCodeList.add(barcode);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String json = new Gson().toJson(barCodeList);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(json);
        resp.setStatus(HttpServletResponse.SC_OK);
    }
}
