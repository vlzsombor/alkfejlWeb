package hu.adatbazisokAlkfejl.servlet;

import hu.adatbazisokAlkfejl.controller.RecordController;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

@WebServlet("/mainWindow")
public class MainWindowServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<String> list = RecordController.getInstance().getTables();

        req.setAttribute("tablesNameList", list);
        resp.setContentType("text/html");

        //write.append("Email: " + req.getParameter("email")+"<br>");
        //write.append("Pass: " + req.getParameter("password"));
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/pages/mainWindow.jsp");
        rd.forward(req, resp);

    }

    public void getName() {

        try {

            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/yourdb");
            Connection conn = ds.getConnection();
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery("select * from Person");

            while (rs.next()) {
                String field = rs.getString(2);
            }
            ctx.close();
            conn.close();
            ctx.close();

        } catch (Exception se) {
            se.printStackTrace();
        }
    }

}
