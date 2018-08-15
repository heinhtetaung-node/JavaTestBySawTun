package com.java.plyd.spring.util;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author HWT
 */
public class SimpleHeaderRenderer extends JLabel implements TableCellRenderer {
    /*
	public SimpleHeaderRenderer() {
        setFont(new Font("Zawgyi-One", Font.BOLD, 14));
        setForeground(Color.BLUE);
        setBorder(BorderFactory.createEtchedBorder());
    }
     */
	

	public SimpleHeaderRenderer() {
        setFont(new Font("Myanmar2", Font.BOLD, 14));
        setForeground(Color.BLUE);
        setBorder(BorderFactory.createEtchedBorder());
    }
	
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        setText(value.toString());
        return this;
    }
}
