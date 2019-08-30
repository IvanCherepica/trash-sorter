package com.trash_sorter.servlet;

import com.google.gson.Gson;
import com.trash_sorter.model.Result;
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
import java.util.List;
import java.util.Set;

@WebServlet("/worker")
public class WorkerServlet extends HttpServlet {
    long id = TankServlet.id;
    private Set<String> barCodeList = new HashSet<>();


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        boolean isvalidate;
        String code = req.getParameter("barCode");
//        String code =req.getParameter("txts");
        TrashService trashService = TrashServiceIMPL.getInstance();

        String[] barcode = trashService.getTrashName(code);

        List<String> list = trashService.getAllTrashById(1);

        String result = HashSearch.search(trashService.getAllTrashById(1), barcode);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        if (result !=null) {
            isvalidate = true;
            Result trueResult = new Result(code,result, isvalidate);
            resp.getWriter().write(new Gson().toJson(trueResult)); }
        else {
            isvalidate = false;
            Result falseResult = new Result(code,"Данный товар не найден в базе", isvalidate);
            resp.getWriter().write(new Gson().toJson(falseResult));
        }
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
