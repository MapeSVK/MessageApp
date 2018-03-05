/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.message.gui.controller;

import com.message.be.Message;
import com.message.bll.BLLManager;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

/**
 *
 * @author Mape
 */
public class MainFXMLController implements Initializable {
    
    private Label label;
    @FXML
    private ListView<Message> messageListView;
    @FXML
    private TextArea messageTextArea;
    
    BLLManager bllmanager = new BLLManager();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void sendButtonClick(ActionEvent event) {
         Message message = bllmanager.logMessage(messageTextArea.getText());
        
        
                
    }
    
}
