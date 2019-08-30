package com.trash_sorter.servlet;

import com.trash_sorter.model.Category;
import com.trash_sorter.model.Tank;
import com.trash_sorter.model.Trash;
import com.trash_sorter.service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/add")
public class AddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String itemType = req.getParameter("itemType");
        String itemName = req.getParameter("itemName");

        switch (itemType){
            case "tank_add":
                TankService tank_service = TankServiceIMPL.getInstance();
                //здесь генерится qr
                String qr = "abcd";
                tank_service.addNewTank(new Tank(itemName,qr));
                break;
            case "category_add":
                CategoryService category_service = CategoryServiceImpl.getInstance();
                category_service.addNewCategory(new Category(itemName));
                break;
            case "trash_add":
                TrashService trash_service = TrashServiceIMPL.getInstance();
                trash_service.addNewTrash(new Trash(itemName));
                break;
        }
        resp.setContentType("text/html");
        resp.sendRedirect("/admin");
    }
}
