package hu.adatbazisokAlkfejl.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.nio.file.Paths;

@WebServlet("/upload")
@MultipartConfig
public class UploadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Part filePart = null; // Retrieves <input type="file" name="file">
        try {
            filePart = req.getPart("file");
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
            InputStream fileContent = filePart.getInputStream();

            byte[] buffer = new byte[fileContent.available()];
            File targetFile = new File(".."+File.separator + "sample.db");
            OutputStream outStream = new FileOutputStream(targetFile);
            fileContent.transferTo(outStream);
            outStream.close();
            fileContent.close();
        } catch (Exception e) {
            resp.sendRedirect("/adatbazisokAlkFejlWeb_war");
            e.printStackTrace();
        }

        resp.sendRedirect("/adatbazisokAlkFejlWeb_war/mainWindow");
    }
}
