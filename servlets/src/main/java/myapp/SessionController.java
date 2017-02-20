package myapp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

@WebServlet("/SessionController")
public class SessionController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();

        String name = request.getParameter("paramname");
        String value = request.getParameter("paramvalue");

        session.setAttribute(name, value);

        try (PrintWriter out = response.getWriter()) {

            out.println(session.getId() + "<br/>");

            ArrayList<String> list = Collections.list(session.getAttributeNames());
            for(String paramValue: list) {
                value = (String) session.getAttribute(paramValue);
                out.println(paramValue + " - " + value + "<br/>");
            }

            request.getRequestDispatcher("/index.jsp").
                    include(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
