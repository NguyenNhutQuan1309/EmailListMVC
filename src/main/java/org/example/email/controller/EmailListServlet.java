
package org.example.email.controller;

import org.example.email.model.User;
import org.example.email.model.UserDB;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class EmailListServlet extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        // Doc du lieu theo UTF-8
        request.setCharacterEncoding("UTF-8");

        // Lay action tu form
        String action = request.getParameter("action");

        if (action == null) {
            action = "join";
        }

        // Trang mac dinh
        String url = "/index.html";

        // Xu ly khi mo trang dang ky
        if (action.equals("join")) {

            url = "/index.html";

        }
        // Xu ly khi nguoi dung dang ky
        else if (action.equals("add")) {

            // Lay thong tin tu form
            String firstName =
                    request.getParameter("firstName");

            String lastName =
                    request.getParameter("lastName");

            String email =
                    request.getParameter("email");

            // Tao doi tuong User
            User user = new User(
                    firstName,
                    lastName,
                    email
            );

            // Luu thong tin
            UserDB.insert(user);

            // Gui User sang JSP
            request.setAttribute("user", user);

            // Chuyen sang trang cam on
            url = "/thanks.jsp";
        }

        // Chuyen tiep request va response
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        // Xu ly GET bang logic cua POST
        doPost(request, response);
    }
}
