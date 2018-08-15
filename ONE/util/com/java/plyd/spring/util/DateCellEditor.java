package com.java.plyd.spring.util;
import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
 
import javax.swing.AbstractCellEditor;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerModel;
import javax.swing.table.TableCellEditor;

import org.jdesktop.swingx.JXDatePicker;
 
public class DateCellEditor extends AbstractCellEditor implements
		TableCellEditor {
 
	Date currentDate;
	private JXDatePicker datepicker;

 
	protected static final String EDIT = "edit";
 
	public DateCellEditor() {
       
		 datepicker=new JXDatePicker();
		 datepicker.setFormats("dd-MM-yyyy");

	}
 
	// Implement the one CellEditor method that AbstractCellEditor doesn't.
	public Object getCellEditorValue() {
//		currentDate = ((SpinnerDateModel)spinner.getModel()).getDate();
//		return ((SpinnerDateModel)spinner.getModel()).getDate();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//		Date d=SimpleDateFormat.
		return formatter.format(datepicker.getDate());
	}
 
	// Implement the one method defined by TableCellEditor.
	public Component getTableCellEditorComponent(JTable table, Object value,
			boolean isSelected, int row, int column) {
//		currentDate = (Date)value;
//		spinner.setValue(value);
//		return spinner;
		return datepicker;
	}
}