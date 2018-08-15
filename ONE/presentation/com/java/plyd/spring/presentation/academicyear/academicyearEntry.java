package com.java.plyd.spring.presentation.academicyear;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JSpinner;

import com.java.plyd.spring.comboboxRenderer.AYearComboBoxRenderer;
import com.java.plyd.spring.entity.academicyear;
import com.java.plyd.spring.entity.academicyear;
//import com.java.plyd.spring.entity.grade;
import com.java.plyd.spring.presentation.main.SchoolMainFrame;
import com.java.plyd.spring.service.academicyear.iacademicyear_manager;
//import com.java.plyd.spring.service.grade.igrade_manager;
import com.java.plyd.spring.util.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.java.plyd.spring.util.BasicBeanFactory;
import javax.swing.DefaultComboBoxModel;


public class academicyearEntry extends JFrame 
{

	public static academicyearEntry manageClassEntry;
	private JPanel contentPane;
	private JLabel lblHome;
	private JLabel lblSearch;
		
	private academicyearSearchFrame gradeEnquiry;
	
	static iacademicyear_manager academicyear_manager;
	private  JTextField jtfinvoicename;
	private  JTextField jtfofitem;
	private  JTextField jtfprice;
	private  JTextField jtfitemname;
	private  JTextField jtftotal;
	private   JTextField jtftax;
	private  JTextField jtfsubtotal;
	
	
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
					academicyearEntry frame = new academicyearEntry();
					
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setVisible(true);
					frame.setResizable(true);
					
					
					
					
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	public static academicyearEntry getInstance()
	{
		
		
		if (manageClassEntry == null) 
		{    
			manageClassEntry = new academicyearEntry();
			
			manageClassEntry.setExtendedState(JFrame.MAXIMIZED_BOTH);
			manageClassEntry.setVisible(true);
			manageClassEntry.setResizable(false);
			return manageClassEntry;
		}
		manageClassEntry.setExtendedState(JFrame.MAXIMIZED_BOTH);
		manageClassEntry.setVisible(true);
		manageClassEntry.setResizable(false);
		return manageClassEntry;
	}

	/**
	 * Create the frame.
	 */
	public academicyearEntry() 
	{
		

		BasicBeanFactory bf = new BasicBeanFactory();
		setTitle("Invoice Entry");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1366, 740);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		academicyear_manager=(iacademicyear_manager) BasicBeanFactory.getBean("academicyear_manager");

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Invoice Entry",
				TitledBorder.LEADING, TitledBorder.TOP,null, null));
		/* public TitledBorder(Border border, String title,int titleJustification,int titlePosition,Font titleFont,Color titleColor)*/
		panel.setBounds(14, 57, 1336, 680);
		contentPane.add(panel);
		panel.setLayout(null);
		contentPane.setLayout(null);
		

		DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer()//iiiiiiiiiiii
		{
			@Override
			public Component getTableCellRendererComponent(JTable table,
					Object value, boolean isSelected, boolean hasFocus,
					int row, int column) {
				super.getTableCellRendererComponent(table, value, isSelected,
						hasFocus, row, column);
				setHorizontalAlignment(JLabel.CENTER);
				return this;
			}
		};

		Font font = new Font("Zawgyi-One", Font.PLAIN, 16);

		lblHome = new JLabel(new ImageIcon("img/home.png"));
		lblHome.setToolTipText("Go To Home");
		lblHome.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblHome.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e) 
			{

				SchoolMainFrame mainFrame = SchoolMainFrame.getInstance();
				manageClassEntry.setVisible(false);
				manageClassEntry = null;

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

		lblSearch = new JLabel(new ImageIcon("img/search.png"));
		lblSearch.setToolTipText("Search Item");
		lblSearch.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				gradeEnquiry = academicyearSearchFrame.getInstance();
				manageClassEntry.setVisible(false);
				manageClassEntry = null;

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
		lblSearch.setBounds(1176, 11, 150, 150);
		panel.add(lblSearch);
		
		JLabel label = new JLabel("New Invoice");
		label.setFont(new Font("Dialog", Font.PLAIN, 25));
		label.setBounds(10, 11, 500, 24);
		panel.add(label);
		
		JLabel lblInvoiceName = new JLabel("Invoice Name");
		lblInvoiceName.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		lblInvoiceName.setBounds(36, 111, 202, 50);
		panel.add(lblInvoiceName);
		
		jtfinvoicename = new JTextField();
		jtfinvoicename.setFont(new Font("Tahoma", Font.PLAIN, 27));
		jtfinvoicename.setColumns(10);
		jtfinvoicename.setBounds(238, 100, 271, 50);
		panel.add(jtfinvoicename);
		
		JLabel label_3 = new JLabel("#Of Item");
		label_3.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		label_3.setBounds(36, 255, 202, 50);
		panel.add(label_3);
		
		jtfofitem = new JTextField();
		jtfofitem.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		jtfofitem.setColumns(10);
		jtfofitem.setBounds(239, 255, 271, 50);
		panel.add(jtfofitem);
		
		JLabel label_4 = new JLabel("Price");
		label_4.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		label_4.setBounds(36, 332, 202, 50);
		panel.add(label_4);
		
		jtfprice = new JTextField();
		jtfprice.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		jtfprice.setColumns(10);
		jtfprice.setBounds(239, 332, 271, 50);
		panel.add(jtfprice);
		
		JLabel label_5 = new JLabel("Item Name");
		label_5.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		label_5.setBounds(36, 172, 202, 50);
		panel.add(label_5);
		
		jtfitemname = new JTextField();
		jtfitemname.setFont(new Font("Tahoma", Font.PLAIN, 27));
		jtfitemname.setColumns(10);
		jtfitemname.setBounds(239, 171, 271, 50);
		panel.add(jtfitemname);
		
		JButton button = new JButton("Create");
		button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				calculate();
				academicyear a=new academicyear();
				
				a.settotal(Integer.parseInt(jtftotal.getText()));
				a.setofitem(Integer.parseInt(jtfofitem.getText()));
				a.setinvoicename(jtfinvoicename.getText());
				try {

					academicyear_manager.insert(a);
					JOptionPane.showMessageDialog(null,
							"Successfully Insert Invoice.", "Success Info",
							JOptionPane.INFORMATION_MESSAGE);

					clear();
					
					
				} catch (Exception ex) 
				{
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null,
							"Fail to Insert Invoice.", "Error Info",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		button.setFont(new Font("Zawgyi-One", Font.PLAIN, 25));
		button.setBounds(36, 589, 165, 45);
		panel.add(button);
		
		JButton button_1 = new JButton("Clear");
		button_1.setFont(new Font("Zawgyi-One", Font.PLAIN, 25));
		button_1.setBounds(345, 589, 165, 45);
		panel.add(button_1);
		
		JLabel lbltotal = new JLabel("Total.....");
		lbltotal.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		lbltotal.setBounds(238, 501, 97, 32);
		panel.add(lbltotal);
		
		jtftotal = new JTextField();
		jtftotal.setFont(new Font("Tahoma", Font.PLAIN, 27));
		jtftotal.setColumns(10);
		jtftotal.setBounds(368, 491, 143, 39);
		panel.add(jtftotal);
		
		JLabel lbltax = new JLabel("Tax.....");
		lbltax.setEnabled(false);
		lbltax.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		lbltax.setBounds(238, 398, 72, 32);
		panel.add(lbltax);
		
		jtftax = new JTextField();
		jtftax.setFont(new Font("Tahoma", Font.PLAIN, 27));
		jtftax.setColumns(10);
		jtftax.setBounds(368, 393, 142, 39);
		panel.add(jtftax);
		
		JLabel lblsubtotal = new JLabel("Sub Total.....");
		lblsubtotal.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		lblsubtotal.setEnabled(false);
		lblsubtotal.setBounds(238, 441, 122, 45);
		panel.add(lblsubtotal);
		
		jtfsubtotal = new JTextField();
		jtfsubtotal.setFont(new Font("Tahoma", Font.PLAIN, 27));
		jtfsubtotal.setColumns(10);
		jtfsubtotal.setBounds(367, 441, 143, 39);
		panel.add(jtfsubtotal);
		
	}

	private void clear() 
	{
		jtfofitem.setText("");
		jtfitemname.setText("");
		jtfinvoicename.setText("");
		jtfprice.setText("");
		jtftotal.setText("");
		jtftax.setText("");
		jtfsubtotal.setText("");
	}
	public  void calculate() 
	{
		int ofitem;
		int price;
		int subtotal;
		int tax;
		int total;
		ofitem=Integer.parseInt(jtfofitem.getText());
		price =Integer.parseInt(jtfprice.getText());
		subtotal=(ofitem*price);
		tax=Integer.parseInt(jtftax.getText());
		total=(subtotal+tax);
		jtfsubtotal.setText(String.valueOf(subtotal));
		jtftotal.setText(String.valueOf(total));
		
		
	}
}
