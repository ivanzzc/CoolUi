package com.ivan.jemmy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CoolUi extends JPanel {
    private JTextArea msgTxt=new JTextArea(400,320);
    private JButton coolBtn=new JButton("Cool");

    public CoolUi(){
        this.setLayout(new GridBagLayout());
        this.setMinimumSize(new Dimension(400,350));
        this.setPreferredSize(new Dimension(400,350));

        coolBtn.setMinimumSize(new Dimension(80,21));
        coolBtn.setPreferredSize(new Dimension(80,21));

        JScrollPane scrollPane=new JScrollPane(msgTxt);
        scrollPane.setMinimumSize(new Dimension(400,320));
        scrollPane.setPreferredSize(new Dimension(400,320));

        this.add(scrollPane,new GridBagConstraints(0,0,1,1,0.0,0.0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(5,5,5,5),0,0));
        this.add(coolBtn,new GridBagConstraints(0,1,1,1,0.0,0.0,GridBagConstraints.CENTER,GridBagConstraints.NONE,new Insets(5,5,5,5),0,0));

        coolBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                appendText();
            }
        });
    }

    protected void appendText(){
        msgTxt.append("cool");
    }

    public static void main(String[] args){
        JFrame jFrame=new JFrame("Cool UI");
        jFrame.getContentPane().add(new CoolUi());
        jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }
}
