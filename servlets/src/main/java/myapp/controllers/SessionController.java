package myapp.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;

@WebServlet("/SessionController")
public class SessionController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        HttpSession session = request.getSession();

        session.setAttribute(
                request.getParameter("paramName"),
                request.getParameter("paramValue"));

        try (PrintWriter out = response.getWriter()) {
            out.printf("%s<br/>", session.getId());
            Collections.list(session.getAttributeNames())
                    .forEach(paramName -> out.printf(
                            "%s - %s<br/>", paramName, session.getAttribute(paramName)));

            request.getRequestDispatcher("/index.jsp")
                    .include(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
