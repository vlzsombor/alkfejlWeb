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
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet("/table")
public class TableServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (SqlRow2.getColumnsName() != null) {
            SqlRow2.getColumnsName().clear();
        }


        PrintWriter write = resp.getWriter();

        Map<String, String[]> parameterMap = req.getParameterMap();

        if (!parameterMap.containsKey("tableName")) {
            write.append("A táblát nem található vissza <br>");
            write.append("<a href=\"#\" onclick=\"javascript:window.history.back(-1);return false;\">Back</a>");
            return;
        }

        String tableName = parameterMap.get("tableName")[0];


        var abba = openRecords(tableName);

        req.setAttribute("tableName", tableName);

        req.setAttribute("recordList", abba);
        List<String> columnNameList = SqlRow2.getColumnsName();

        if (SqlRow2.getColumnsName() == null) {

            write.append("<a href=\"#\" onclick=\"javascript:window.history.back(-1);return false;\">Back</a>");
            return;
        }


        if (SqlRow2.getColumnsName().isEmpty()) {
            write.append("A táblát nem található vissza <br>");
            write.append("<a href=\"#\" onclick=\"javascript:window.history.back(-1);return false;\">Back</a>");
            return;
        }

        req.setAttribute("columnNameList", columnNameList);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/pages/table.jsp");
        rd.forward(req, resp);
    }

    private List<SqlRow2> openRecords(String tableName) {
        List<SqlRow2> list = RecordController.getInstance().getRecord(tableName);

        ArrayList<String> strList = new ArrayList<>();
        for (var a : list) {
            strList.addAll(a.getValues());
        }
        return list;
    }


}
