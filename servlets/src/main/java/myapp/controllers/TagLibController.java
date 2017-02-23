package myapp.controllers;

import lombok.val;
import myapp.tags.JSPSetBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;

@WebServlet("/TagLibController")
public class TagLibController extends HttpServlet {

    public static final String NAME = "userbean";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        val set = new HashSet<String>();
        set.add("one");
        set.add("two");
        set.add("three");

        val jsp = new JSPSetBean(set);

        request.setAttribute(NAME, jsp);

        request.getRequestDispatcher("/tags/index.jsp").
                forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
