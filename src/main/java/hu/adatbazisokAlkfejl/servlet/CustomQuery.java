package hu.adatbazisokAlkfejl.servlet;

import hu.adatbazisokAlkfejl.controller.RecordController;
import hu.adatbazisokAlkfejl.model.SqlRow2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/customQuery")
public class CustomQuery extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuffer text = new StringBuffer(req.getParameter("textarea1"));

        var list = RecordController.getInstance().executeQuery(text.toString());

        List<String> columnNameList = SqlRow2.getColumnsName();

        req.setAttribute("columnNameList", columnNameList);
        req.setAttribute("recordList", list);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/pages/table.jsp");
        rd.forward(req, resp);

    }
}
