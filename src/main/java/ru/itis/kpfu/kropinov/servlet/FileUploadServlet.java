package ru.itis.kpfu.kropinov.servlet;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import ru.itis.kpfu.kropinov.util.CloudinaryUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/upload")
@MultipartConfig(maxFileSize = 5 * 1024 * 1024, maxRequestSize = 10*1024*1024)
public class FileUploadServlet extends HttpServlet {

    public static final String FILE_PREFIX = "/tmp";
    public static final int DIRECTORIES_COUNT = 100;
    public static final Cloudinary cloudinary = CloudinaryUtil.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part part = req.getPart("file");
        String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();

        // better to do in service
        File file = new File(FILE_PREFIX + File.separator + filename.hashCode()%DIRECTORIES_COUNT + File.separator + filename);

        InputStream content = part.getInputStream();
        file.getParentFile().mkdirs();
        file.createNewFile();

        FileOutputStream outputStream = new FileOutputStream(file);
        byte[] buffer = new byte[content.available()];
        content.read(buffer);

        outputStream.write(buffer);
        outputStream.close();

        // cloudinary upload
        cloudinary.uploader().upload(file, ObjectUtils.emptyMap());

        resp.sendRedirect("main");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("upload.ftl").forward(req, resp);
    }
}
