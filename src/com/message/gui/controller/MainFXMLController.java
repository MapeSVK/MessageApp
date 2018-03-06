/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.message.gui.controller;

import com.message.be.Message;
import com.message.bll.BLLManager;
import com.message.gui.model.MessageModel;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author Mape
 */
public class MainFXMLController implements Initializable {
    
   
    @FXML
    private ListView<Message> messageListView;
    @FXML
    private TextArea messageTextArea;
    
    MessageModel model = new MessageModel();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        messageListView.setItems(model.getAllMessages());
    }    

    @FXML
    private void sendButtonClick(ActionEvent event) {
        sendMessage();
    }

    KeyCombination combo = new KeyCodeCombination(KeyCode.ENTER, KeyCombination.SHIFT_DOWN);
    
    @FXML
    private void onKeyPressedSend(KeyEvent event) {
        if(combo.match(event)) {
            sendMessage();
        }
    }
    
     
    private void sendMessage() {
        Message message = model.sendMessage(messageTextArea.getText());
        messageTextArea.clear();
    }
    
}
