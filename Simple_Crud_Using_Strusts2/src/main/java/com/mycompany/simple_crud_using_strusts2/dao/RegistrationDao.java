/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simple_crud_using_strusts2.dao;

import com.mycompany.simple_crud_using_strusts2.db.DbConnection;
import com.mycompany.simple_crud_using_strusts2.model.Registration;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Ravindu
 */
public class RegistrationDao {

    DbConnection dbConnection = new DbConnection();

    public boolean registerUser(Registration registration) throws ClassNotFoundException, SQLException {
        Connection connection = dbConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("insert into Registration values(?,?,?,?,?,?,?,?)");
        pstm.setObject(1, registration.getUserID());
        pstm.setObject(2, registration.getUserName());
        pstm.setObject(3, registration.getAddress());
        pstm.setObject(4, registration.getEmail());
        pstm.setObject(5, registration.getContact());
        pstm.setObject(6, registration.getPassword());
        pstm.setObject(7, registration.getCreateTime());
        pstm.setObject(8, registration.getLastUpdateTime());
        if (pstm.executeUpdate() > 0) {
            return true;
        } else {
            return false;
        }

    }

    public ArrayList<Registration> report() throws SQLException, ClassNotFoundException {
        Connection connection = dbConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("select * from Registration");
        ResultSet rst = pstm.executeQuery();
        //System.out.println(rst.getObject(1));
        ArrayList<Registration> load = new ArrayList<>();
        while (rst.next()) {
            Registration registration = new Registration(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getString(8)
            );
            load.add(registration);
        }

        return load;
    }

}
