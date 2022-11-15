/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simple_crud_using_strusts2.dao;

import com.mycompany.simple_crud_using_strusts2.db.DbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Ravindu
 */
public class LoginDao {

    public boolean checkEqualityUser(String userName, String password) throws ClassNotFoundException, SQLException {
        DbConnection dbConnection = new DbConnection();
        Connection connection = dbConnection.getConnection();
        PreparedStatement pstm = connection.prepareStatement("select * from Registration where userName=? && password=?");
        pstm.setObject(1, userName);
        pstm.setObject(2, password);
        ResultSet rst = pstm.executeQuery();
        if (rst.next()) {
            return true;
        } else {
            return false;
        }
    }
}
