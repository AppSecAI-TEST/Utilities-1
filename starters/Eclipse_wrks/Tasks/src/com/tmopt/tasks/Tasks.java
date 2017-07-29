package com.tmopt.tasks;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.ObjectInputStream.GetField;

import javax.swing.*;

public class Tasks
{
    public static void main(String[] args)
    {
        try {
            UIManager.setLookAndFeel(
                UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {}
 
        JFrame tasksFrame = new JFrame("Calculator");
        
        TasksModel model = new TasksModel();        
        TasksPanel tasksPanel = new TasksPanel(model);
        tasksPanel.init();
                
        tasksFrame.setContentPane(tasksPanel);
        tasksFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tasksFrame.pack();
        
        tasksFrame.setIconImage(new ImageIcon
        		(Tasks.class.getResource("icon.bmp")).getImage()); 
        
        tasksFrame.setVisible(true);
    }
}

 
