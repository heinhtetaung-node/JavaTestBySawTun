package com.java.plyd.spring.presentation.academicyear;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.ScrollPaneAdjustable;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.ScrollPaneUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.java.plyd.spring.entity.academicyear;
//import com.java.plyd.spring.entity.grade;
//import com.java.plyd.spring.entity.class_;
//import com.java.plyd.spring.entity.grade;
import com.java.plyd.spring.presentation.main.SchoolMainFrame;
import com.java.plyd.spring.service.academicyear.iacademicyear_manager;
//import com.java.plyd.spring.service.grade.igrade_manager;
//import com.java.plyd.spring.service.class_.iclass_manager;
//import com.java.plyd.spring.service.grade.igrade_manager;
import com.java.plyd.spring.util.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.java.plyd.spring.util.BasicBeanFactory;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.java.plyd.spring.comboboxRenderer.*;

public class academicyearSearchFrame extends JFrame 
{

	public static academicyearSearchFrame datashowSearch;
	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private DefaultTableModel dtm;
	private JPanel panel_1;
	private JLabel lblHome;
	private JLabel lblAdd;

	private String flag;
	
	static iacademicyear_manager academicyear_manager;
	private JTextField txttotal;
	private JTextField txtofitem;
	private JTextField txtinvoice;
	private int selectedRowIndex ;
	private JTextField txtid;
		
	/**
	 * Launch the application.
	 */

	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					academicyearSearchFrame frame = new academicyearSearchFrame();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	public static academicyearSearchFrame getInstance() 
	{
		if (datashowSearch == null) 
		{
			datashowSearch = new academicyearSearchFrame();
			datashowSearch.setExtendedState(JFrame.MAXIMIZED_BOTH);
			datashowSearch.setVisible(true);
			datashowSearch.setResizable(false);
			return datashowSearch;
		}
		datashowSearch.setExtendedState(JFrame.MAXIMIZED_BOTH);
		datashowSearch.setVisible(true);
		datashowSearch.setResizable(false);
		return datashowSearch;
	}

	/**
	 * Create the frame.
	 */
	public academicyearSearchFrame() 
	{

		academicyear_manager = (iacademicyear_manager) BasicBeanFactory
				.getBean("academicyear_manager");

		setTitle("Student Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1362, 880);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel.setBounds(30, 11, 1326, 534);
		contentPane.add(panel);
		panel.setLayout(null);

		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager
				.getBorder("TitledBorder.border"), "Result View",
				TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_1.setBounds(21, 164, 1276, 342);
		panel.add(panel_1);
		panel_1.setLayout(null);

		overrideDefaultTableModle();

		JLabel lblLogo = new JLabel("Academic Year Searching");
		lblLogo.setFont(new Font("Castellar", Font.PLAIN, 25));
		lblLogo.setBounds(20, 60, 500, 24);
		panel.add(lblLogo);

		DefaultTableCellRenderer r = new DefaultTableCellRenderer()
		{
			@Override
			public Component getTableCellRendererComponent(JTable table,
					Object value, boolean isSelected, boolean hasFocus,
					int row, int column) 
			{
				super.getTableCellRendererComponent(table, value, isSelected,
						hasFocus, row, column);
				setHorizontalAlignment(JLabel.CENTER);
				return this;
			}
		};

		String[] columnNames = { "invoice ID", "total"," ofitem","invoicename ", "Action" };

		Object[][] data = {};
		dtm.setDataVector(data, columnNames);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 54, 1210, 253);
		panel_1.add(scrollPane);

		table = new JTable();
		Font font = new Font("Zawgyi-One", Font.PLAIN, 16);
		table.setFont(font);
		table.setModel(dtm);
		table.addMouseListener(new CheckBoxHandler());
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

		// align checkbox to center
		table.getColumnModel().getColumn(0).setCellRenderer(r);
		table.getColumnModel().getColumn(1).setCellRenderer(r);
		table.getColumnModel().getColumn(2).setCellRenderer(r);
		table.getColumnModel().getColumn(3).setCellRenderer(r);
		table.getColumnModel().getColumn(4).setCellRenderer(r);
		
		// add button at update column
		table.getColumn("Action").setCellRenderer(new ButtonRenderer());
		table.getColumn("Action").setCellEditor(
				new ButtonDetailStock(new JCheckBox()));
		scrollPane.setViewportView(table);
		table.setRowHeight(30);

		lblHome = new JLabel(new ImageIcon("img/home.png"));
		lblHome.setToolTipText("Go To Home");
		lblHome.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblHome.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				SchoolMainFrame mainFrame = SchoolMainFrame.getInstance();
				datashowSearch.setVisible(false);
				datashowSearch = null;
			}

			@Override
			public void mouseEntered(MouseEvent e)
			{

			}

			@Override
			public void mouseExited(MouseEvent e) 
			{

			}
		});
		lblHome.setBounds(1046, 26, 150, 150);
		panel.add(lblHome);

		lblAdd = new JLabel(new ImageIcon("img/add.png"));
		lblAdd.setToolTipText("Search Item");
		lblAdd.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblAdd.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				academicyearEntry gradeEntryFrame = academicyearEntry.getInstance();
				datashowSearch.setVisible(false);
				datashowSearch = null;
			}

			@Override
			public void mouseEntered(MouseEvent e)
			{

			}

			@Override
			public void mouseExited(MouseEvent e)
			{

			}
		});
		lblAdd.setBounds(1176, 20, 150, 150);
		panel.add(lblAdd);
		
		txttotal = new JTextField();
		txttotal.setFont(new Font("Zawgyi-One", Font.PLAIN, 19));
		txttotal.setBounds(292, 585, 141, 32);
		contentPane.add(txttotal);
		txttotal.setColumns(10);
		
		txtofitem = new JTextField();
		txtofitem.setFont(new Font("Zawgyi-One", Font.PLAIN, 20));
		txtofitem.setBounds(478, 585, 141, 32);
		contentPane.add(txtofitem);
		txtofitem.setColumns(10);
		
		txtinvoice = new JTextField();
		txtinvoice.setFont(new Font("Zawgyi-One", Font.PLAIN, 19));
		txtinvoice.setBounds(671, 585, 141, 32);
		contentPane.add(txtinvoice);
		txtinvoice.setColumns(10);
		
		JButton btnchoose = new JButton("Choose");
		
		
		btnchoose.addActionListener(new ActionListener() 
		{
			
			public void actionPerformed(ActionEvent e)
			{
				
				
				dtm=(DefaultTableModel) table.getModel();
				int selectRowIndex =table.getSelectedRow();
				txtid.setText(dtm.getValueAt(selectRowIndex,0)+"");
				txttotal.setText(dtm.getValueAt(selectRowIndex,1)+"");
				txtofitem.setText(dtm.getValueAt(selectRowIndex,2)+"");
				txtinvoice.setText(dtm.getValueAt(selectRowIndex,3)+"");
				table.setVisible(false);
				
			
				
			}

			
		});
		btnchoose.setBounds(891, 583, 115, 37);
		contentPane.add(btnchoose);
		
		txtid = new JTextField();
		txtid.setFont(new Font("Zawgyi-One", Font.PLAIN, 19));
		txtid.setBounds(30, 585, 141, 32);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		JButton btndelete = new JButton("Delete");
		btndelete.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				int id=Integer.parseInt(txtid.getText());
				
				try 
				{
					academicyear_manager.delete(id);
					JOptionPane.showMessageDialog(null, "Successfully Delete",
							"Error Info", JOptionPane.ERROR_MESSAGE);
				} catch (Exception ex)
				{
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "delete Failed", "Error Info",
							JOptionPane.ERROR_MESSAGE);
				}
				txtid.setText("");
				txttotal.setText("");
				txtofitem.setText("");
				txtinvoice.setText("");
				table.setVisible(false);
				
			}
		});
		btndelete.setBounds(1069, 585, 115, 35);
		contentPane.add(btndelete);
		
		initialized();
	}

	class CheckBoxHandler implements MouseListener 
	{

		public void mouseClicked(MouseEvent e) 
		{
			int selectedRow = table.getSelectedRow();
			int selectedCol = table.getSelectedColumn();
			if (selectedCol == 3) 
			{
				System.out.println("Selected Student id"
						+ dtm.getValueAt(selectedRow, 0).toString());
				Conversation.addConversation("editAcademicYear",
						dtm.getValueAt(selectedRow, 0).toString());
				//academicyear_manager.delete(Integer.parseInt(txtid.getText()));
				//academicyear_manager.delete(Integer.parseInt(txtid.getText()));
				//academicyear_manager.delete(Integer.parseInt(txtid.getText()));
				
				
				academicyearDetailFrame gDetailFrame = academicyearDetailFrame.getInstance();

				datashowSearch.setVisible(false);
				datashowSearch = null;
			}
		}

		@Override
		public void mousePressed(MouseEvent e) 
		{
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e)
		{
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) 
		{
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) 
		{
			// TODO Auto-generated method stub

		}
	}

	public void mousePressed(MouseEvent e)
	{
		// TODO Auto-generated method stub
	}

	private void overrideDefaultTableModle()
	{
		dtm = new DefaultTableModel() 
		{

			public boolean isCellEditable(int row, int col) 
			{
				// Note that the data/cell address is constant,
				// no matter where the cell appears onscreen.
				if (col >= 0 && col <= 4) 
				{
					return false;
				} else {
					return true;
				}
			}
		};
	}

	private void removeRow() 
	{
		int rowCount = dtm.getRowCount();
		if (dtm.getRowCount() != 0)
		{
			for (int i = dtm.getRowCount() - 1; i >= 0; i--)
			{
				dtm.removeRow(i);
			}
		}
	}

	private void initialized() 
	{

//		List<academicyear> academicyearList=academicyear_manager.selectAll();

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:spring-beans.xml");
		BeanFactory factory = context;

		iacademicyear_manager manager = (iacademicyear_manager) factory.getBean("academicyear_manager");
		List<academicyear> list=manager.selectAll();
		
		
		if (list.size() > 0)
		{
			for (academicyear a : list) 
			{
				dtm.addRow(new Object[] { a.getid(), a.gettotal(),a.getofitem(),a.getinvoicename(),
						"Detail", });

			}
		}
	}
}
