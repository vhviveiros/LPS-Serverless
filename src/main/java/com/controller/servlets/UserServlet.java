package com.controller.servlets;

import com.controller.ControllerSingleton;
import com.etc.DataMock;
import com.etc.exception.Exception;
import com.etc.exception.invalid_input_exception.InvalidInputException;
import com.model.Address;
import com.model.Client;
import com.model.Credentials;
import com.validation.UserValidation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Date;

@WebServlet(name = "UserServlet", urlPatterns = ("/UserServlet"))
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("confirm").equals("Confirmar")) {
            String[] userArray = new String[6];
            String[] addressArray = new String[5];

            userArray[0] = request.getParameter("name");
            userArray[1] = request.getParameter("birth");
            userArray[2] = request.getParameter("cpf");
            userArray[3] = request.getParameter("identity");
            userArray[4] = request.getParameter("gender");
            userArray[5] = request.getParameter("user_type");

            addressArray[0] = request.getParameter("address");
            addressArray[1] = request.getParameter("number");
            addressArray[2] = request.getParameter("city");
            addressArray[3] = request.getParameter("state");
            addressArray[4] = request.getParameter("district");

            response.setContentType("text/html;charset=UTF-8");

            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet UserServlet</title>");
                out.println("</head>");
                out.println("<body>");

                try {
                    ControllerSingleton.currentUser = new Client("Cliente", true, new Date(), 00000000000, 00000000, null,
                            null);

                    new UserValidation(userArray).validate(); //Lança exceção em caso de campo inválido

                    ControllerSingleton.ADDRESS_CONTROLLER.insert(addressArray);
                    ControllerSingleton.ADDRESS_CONTROLLER.updateData(addressArray);

                    ControllerSingleton.currentUser.setCredentials(DataMock.mockCredentials());

                    if (userArray[5].equals("Cliente"))
                        ControllerSingleton.CLIENT_CONTROLLER.insert(userArray);
                    else
                        ControllerSingleton.CLEANER_CONTROLLER.insert(userArray);

                    Address address = ControllerSingleton.currentUser.getAddress();
                    ControllerSingleton.CLIENT_CONTROLLER.updateData(new String[]{userArray[2], userArray[3]});
                    ControllerSingleton.currentUser.setAddress(address);

                    out.println("Usuário cadastrado com sucesso!");
                } catch (SQLException | InvalidInputException e) {
                    out.println(e.getMessage());
                } finally {
                    out.println("</body>");
                    out.println("</html>");
                }
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
