package com.ivan.jemmy;

import junit.framework.TestCase;
import org.junit.Test;
import org.netbeans.jemmy.operators.JButtonOperator;
import org.netbeans.jemmy.operators.JFrameOperator;
import org.netbeans.jemmy.operators.JTextAreaOperator;

import javax.swing.*;
import java.awt.*;

public class CoolUiTest extends TestCase {
    private JFrame frm;

    private JFrameOperator frmOpr;

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        frm=new JFrame("Cool UI Test");
        frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frm.setSize(new Dimension(400,320));
        frm.getContentPane().add(new CoolUi());
        frm.pack();
        frm.setVisible(true);

        frmOpr=new JFrameOperator("Cool UI Test");
    }

    @Override
    protected void tearDown() throws Exception {
        frm.dispose();

        super.tearDown();
    }

    @Test
    public void testUi(){
        JTextAreaOperator txtOpr=new JTextAreaOperator(frmOpr,0);
        assertEquals("",txtOpr.getText());
        txtOpr.append("abcde");
        assertEquals("abcde",txtOpr.getText());
        txtOpr.clearText();
        assertEquals("",txtOpr.getText());

        JButtonOperator btnOpr=new JButtonOperator(frmOpr,"Cool");
        btnOpr.doClick();
        assertEquals("cool",txtOpr.getText());
        txtOpr.append("cool");
        assertEquals("coolcool",txtOpr.getText());
    }
}
