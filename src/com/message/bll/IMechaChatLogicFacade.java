/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.message.bll;

import com.message.be.Message;
import java.util.List;

/**
 *
 * @author Mape
 */
public interface IMechaChatLogicFacade {
    public Message logMessage(String text);
    List<Message> getMessages();
}
