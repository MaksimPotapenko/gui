/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mycomponents;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Deniss
 */
public class EditComponent extends JPanel {
    private JLabel JLabelTitle;
    private JTextField edit;

    public EditComponent(String title, int widthPanel, int heightPanel) {
        initComponent(title, widthPanel, heightPanel);
    }

    private void initComponent(String title, int widthPanel, int heightPanel) {
        setMinimumSize(new Dimension(widthPanel,heightPanel));
        setPreferredSize(getMinimumSize());
        setMaximumSize(getMinimumSize());
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setBorder(BorderFactory.createLineBorder(Color.yellow));
        this.JLabelTitle = new JLabel(title);
        JLabelTitle.setMinimumSize(new Dimension(widthPanel/3,27));
        JLabelTitle.setMaximumSize(JLabelTitle.getMaximumSize());
        JLabelTitle.setPreferredSize(JLabelTitle.getMinimumSize());
        JLabelTitle.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JLabelTitle.setHorizontalAlignment(JLabel.RIGHT);
        this.add(JLabelTitle);
        
        edit = new JTextField();
        edit.setPreferredSize(new Dimension(250,27));
        edit.setMinimumSize(edit.getPreferredSize());
        edit.setMaximumSize(edit.getPreferredSize());
        this.add(edit);
        
    }
    
    
   
}
