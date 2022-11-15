/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simple_crud_using_strusts2.action;

import com.mycompany.simple_crud_using_strusts2.dao.RegistrationDao;
import com.mycompany.simple_crud_using_strusts2.model.Registration;
import com.opensymphony.xwork2.ActionSupport;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author Ravindu
 */
public class RegisterAction extends ActionSupport {

    Map<String, String> result = new HashMap<>();

    public Map<String, String> getResult() {
        return result;
    }

    public void setResult(Map<String, String> result) {
        this.result = result;
    }
    RegistrationDao registrationDao = new RegistrationDao();

    @Override
    public String execute() throws IOException, ClassNotFoundException, SQLException {
        HttpServletResponse response = ServletActionContext.getResponse();
        HttpServletRequest request = ServletActionContext.getRequest();
        PrintWriter writer = response.getWriter();
        boolean register = false;
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formatDateTime = time.format(format);
        String s = "sa";
        Registration registration = new Registration(
                request.getParameter("userID"),
                request.getParameter("userName"),
                request.getParameter("address"),
                request.getParameter("email"),
                request.getParameter("contact"),
                request.getParameter("password"),
                formatDateTime,
                s
        );
        register = registrationDao.registerUser(registration);

        if (register) {

            result.put("status", "200");
            return SUCCESS;
        } else {
            result.put("status", "400");
            return SUCCESS;
        }

    }

    public String getAllUser() throws SQLException, ClassNotFoundException, IOException {
        ArrayList<Registration> details = registrationDao.report();
        HttpServletResponse response = ServletActionContext.getResponse();
        HttpServletRequest request = ServletActionContext.getRequest();
        PrintWriter writer = response.getWriter();
        writer.print(details);
        if (details == null) {
            result.put("status", "400");
            return SUCCESS;
        } else {
            result.put("data", "200");
            return SUCCESS;
        }

    }
}
