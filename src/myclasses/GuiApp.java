/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myclasses;

import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import mycomponents.CaptionComponent;
import mycomponents.EditComponent;

/**
 *
 * @author Deniss
 */
public class GuiApp extends JFrame {
    private CaptionComponent captionComponent;
    private EditComponent editComponent;
    
    public GuiApp(){
        initComponents();
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setLocationRelativeTo(null);
    }
    
    private void initComponents() {
        this.setMinimumSize(new Dimension(600,400));
        this.setPreferredSize(this.getMaximumSize());
        this.setMaximumSize(this.getMaximumSize());
        this.getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
        captionComponent = new CaptionComponent("Добавление новый книги", this.getWidth(), 50);
        this.getContentPane().add(captionComponent);
        editComponent= new EditComponent("Название книги",this.getWidth(), 30);
        this.getContentPane().add(editComponent);
    }
    public static void main(String[] args){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run(){
                    new GuiApp().setVisible(true);
                }
    });
    
    }

}
