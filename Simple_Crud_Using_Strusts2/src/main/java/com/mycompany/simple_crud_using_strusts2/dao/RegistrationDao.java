/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simple_crud_using_strusts2.dao;

import com.mycompany.simple_crud_using_strusts2.db.DbConnection;
import com.mycompany.simple_crud_using_strusts2.model.Registration;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author atlas
 */
public class RegistrationDao {
    public boolean registerUser(Registration registration) throws ClassNotFoundException, SQLException{
        DbConnection dbConnection = new DbConnection();
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
        return pstm.executeUpdate()>0;
    }
    
    
}
