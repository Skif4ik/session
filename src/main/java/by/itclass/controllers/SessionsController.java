package by.itclass.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@WebServlet(name ="sessionsController", urlPatterns = "/handler")
public class SessionsController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       HttpSession session = req.getSession();
       session.setAttribute("sessionMessage", "I am session attribute");
       req.setAttribute("requestMessage", "I am request attribute");

       req.getRequestDispatcher("/message").forward(req, resp);

//       resp.getWriter()
//               .append("Creation time: " + new Date(session.getCreationTime()));
    }
}