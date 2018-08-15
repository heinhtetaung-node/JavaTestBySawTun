package com.java.plyd.spring.comboboxRenderer;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;

import com.java.plyd.spring.entity.academicyear;

public class AYearComboBoxRenderer extends DefaultListCellRenderer
{
	public Component getListCellRendererComponent(JList list,Object value,int index,boolean isSelected,boolean cellHasFocus){
		JLabel label=(JLabel) super.getListCellRendererComponent(list,value,index,isSelected,cellHasFocus);
		academicyear a=(academicyear) value;
	    label.setText(a.getinvoicename());
		return label;
	}
	
	public Object setListCellRendererComponent(JList list,Object value,int index,boolean isSelected,boolean cellHasFocus){
		//JLabel label=(JLabel) super.getListCellRendererComponent(list,value,index,isSelected,cellHasFocus);
		academicyear a=(academicyear) value;
		//label.setText(a.getName());
		return a;
	}
}
