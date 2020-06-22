package hu.adatbazisokAlkfejl.servlet;

import hu.adatbazisokAlkfejl.controller.RecordController;
import hu.adatbazisokAlkfejl.util.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/renameColumn")
public class RenameServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /*
        String tableName = parameterMap.get("tableName")[0];


        if(!screen.getText().matches(Utils.SQL.SQL_COLUMN_NAME_REGEX_PATTER)){
            /*Alert errorAlert = new Alert(Alert.AlertType.ERROR);
            errorAlert.setHeaderText(Utils.SQL.COLUMN_NAMING_ERROR);
            errorAlert.showAndWait();
        }else{
            RecordController.getInstance().editColumn(sqlColumns.getSelectionModel().getSelectedItem(),screen.getText());
            Stage stage = (Stage) sqlColumns.getScene().getWindow();
            stage.close();
        }
*/
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        StringBuffer text = new StringBuffer(req.getParameter("textarea1"));
        var tableName = req.getParameterMap().get("tableName")[0];

        if (!text.toString().matches(Utils.SQL.SQL_COLUMN_NAME_REGEX_PATTER)) {
            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();
            out.println(Utils.SQL.COLUMN_NAMING_ERROR);
            out.println("<a href=\"#\" onclick=\"javascript:window.history.back(-1);return false;\">Back</a>");

            out.close();
        } else {
            RecordController.getInstance().editColumn(tableName, text.toString());
        }

        resp.sendRedirect(req.getContextPath() + "/mainWindow");
    }
}