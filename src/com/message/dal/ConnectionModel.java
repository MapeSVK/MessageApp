/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.message.dal;

import com.message.be.Message;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Pepe15224
 */
public class ConnectionModel {
    
    private ConnectionManager cm = new ConnectionManager();
   
    public Message addMessage(Message message) {

       try (Connection con = cm.getConnection()) {
            String sql
                    = "INSERT INTO Message"
                    + "(text)"
                    + "VALUES(?)";
            PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, message.getText());
  
            pstmt.executeUpdate();            
            ResultSet rs = pstmt.getGeneratedKeys();

        }
        catch (SQLException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
        
       return message;
    }
    
    public List<Message> getMessages() {
        List<Message> allMessages = new ArrayList();
        try (Connection connection = cm.getConnection())
        {
            PreparedStatement pstmt = connection.prepareCall("SELECT * FROM Message");
            ResultSet rs = pstmt.executeQuery();
                while(rs.next())
                {
                    Message message = new Message(rs.getString("text"));
                    allMessages.add(message);
                }
        
        
        
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return allMessages;
    }
   
    
//    public List<Movie> getAllMovies()
//    {
//        List<Movie> allMovies = new ArrayList();
//        try (Connection con = cm.getConnection())
//        {
//         PreparedStatement pstmt = con.prepareCall("SELECT * FROM Movie");
//         ResultSet rs = pstmt.executeQuery();
//            while(rs.next())
//            {
//                Movie m = new Movie(rs.getInt("id"),
//                       rs.getString("name"),
//                        rs.getDouble("rating"),
//                        rs.getDouble("personalrating"),
//                        rs.getString("filelink"), rs.getString("lastview"));
//      
//                allMovies.add(m);
//            }
//         }
//         catch (SQLException ex) {
//            Logger.getLogger(ConnectionModel.class.getName()).log(
//                    Level.SEVERE, null, ex);
//          }
//        return allMovies;
//}
//   

    
}
