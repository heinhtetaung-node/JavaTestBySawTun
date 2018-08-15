package com.java.plyd.spring.presentation.academicyear;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.apache.commons.lang.StringUtils;

import com.java.plyd.spring.service.academicyear.iacademicyear_manager;
//import com.java.plyd.spring.service.grade.igrade_manager;
import com.java.plyd.spring.util.BasicBeanFactory;
import com.java.plyd.spring.util.Conversation;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.List;

import com.java.plyd.spring.comboboxRenderer.AYearComboBoxRenderer;
import com.java.plyd.spring.entity.academicyear;
//import com.java.plyd.spring.entity.grade;
import com.java.plyd.spring.presentation.main.*;
import javax.swing.JComboBox;

public class academicyearDetailFrame extends JFrame {

	private JPanel contentPane;
	public static academicyearDetailFrame acDetailFrame;
	private iacademicyear_manager ac_manager;
	private JTextField jtfID;
	private JLabel lblHome;
	private JLabel lblSearch;
	private JButton btnDelete, btnEdit;
	
	private String id;
	private JTextField jtfinvoicename;
	private JTextField jtfitemname;
	private JTextField jtfofitem;
	private JTextField jtfprice;
	private JTextField jtftotal;
	private JTextField jtfsubtotal;
	private JTextField jtftax;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					academicyearDetailFrame frame = new academicyearDetailFrame();
					frame.setVisible(true);
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static academicyearDetailFrame getInstance() 
	{
		if (acDetailFrame == null) 
		{
			acDetailFrame = new academicyearDetailFrame();
			acDetailFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
			acDetailFrame.setVisible(true);
			acDetailFrame.setResizable(false);
			
			return acDetailFrame;
		}
		acDetailFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		acDetailFrame.setVisible(true);
		acDetailFrame.setResizable(false);
		return acDetailFrame;
	}

	/**
	 * Create the frame.
	 */
	public academicyearDetailFrame() 
	{

		id = (String) Conversation.getConversationValue("editAcademicYear");
		setTitle("School System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1366, 740);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		ac_manager = (iacademicyear_manager) BasicBeanFactory
				.getBean("academicyear_manager");
		lblHome = new JLabel(new ImageIcon("img/home.png"));
		lblHome.setToolTipText("Go To Home");
		lblHome.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblHome.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				SchoolMainFrame mainFrame = SchoolMainFrame.getInstance();
				acDetailFrame.setVisible(false);
				acDetailFrame = null;
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
		lblHome.setBounds(700, 45, 150, 150);
		contentPane.add(lblHome);

		lblSearch = new JLabel(new ImageIcon("img/search.png"));
		lblSearch.setToolTipText("Search Item");
		lblSearch.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblSearch.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				academicyearSearchFrame gSearchFrame = academicyearSearchFrame.getInstance();
				
				acDetailFrame.setVisible(false);
				acDetailFrame = null;

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
		lblSearch.setBounds(830, 30, 150, 150);
		contentPane.add(lblSearch);

		btnEdit = new JButton("Update");
		btnEdit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				edit();
			}
		});
		btnEdit.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnEdit.setBounds(82, 647, 150, 45);
		contentPane.add(btnEdit);

		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				delete();

			}
		});
		btnDelete.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnDelete.setBounds(341, 647, 112, 45);
		contentPane.add(btnDelete);
		
		JLabel label = new JLabel("Update Invoice");
		label.setFont(new Font("Dialog", Font.PLAIN, 25));
		label.setBounds(36, 11, 357, 24);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Invoice Name");
		label_1.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		label_1.setBounds(36, 83, 191, 45);
		contentPane.add(label_1);
		
		jtfinvoicename = new JTextField();
		jtfinvoicename.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		jtfinvoicename.setColumns(10);
		jtfinvoicename.setBounds(228, 79, 273, 51);
		contentPane.add(jtfinvoicename);
		
		JLabel label_2 = new JLabel("ItemName");
		label_2.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		label_2.setBounds(36, 169, 171, 36);
		contentPane.add(label_2);
		
		jtfitemname = new JTextField();
		jtfitemname.setText((String) null);
		jtfitemname.setFont(new Font("Zawgyi-One", Font.PLAIN, 27));
		jtfitemname.setColumns(10);
		jtfitemname.setBounds(228, 169, 273, 34);
		contentPane.add(jtfitemname);
		
		JLabel label_3 = new JLabel("#Of Items");
		label_3.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		label_3.setBounds(36, 243, 171, 45);
		contentPane.add(label_3);
		
		jtfofitem = new JTextField();
		jtfofitem.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		jtfofitem.setColumns(10);
		jtfofitem.setBounds(228, 243, 273, 34);
		contentPane.add(jtfofitem);
		
		JLabel label_4 = new JLabel("Price");
		label_4.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		label_4.setBounds(36, 325, 171, 36);
		contentPane.add(label_4);
		
		jtfprice = new JTextField();
		jtfprice.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		jtfprice.setColumns(10);
		jtfprice.setBounds(228, 312, 273, 34);
		contentPane.add(jtfprice);
		
		jtftotal = new JTextField();
		jtftotal.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		jtftotal.setColumns(10);
		jtftotal.setBounds(362, 517, 139, 34);
		contentPane.add(jtftotal);
		
		JLabel lbltotal = new JLabel("Total");
		lbltotal.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		lbltotal.setBounds(228, 516, 98, 36);
		contentPane.add(lbltotal);
		
		JLabel lblsubtotal = new JLabel("Subtotal");
		lblsubtotal.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		lblsubtotal.setBounds(228, 397, 124, 36);
		contentPane.add(lblsubtotal);
		
		JLabel lbltax = new JLabel("Tax");
		lbltax.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		lbltax.setBounds(228, 455, 98, 36);
		contentPane.add(lbltax);
		
		jtfsubtotal = new JTextField();
		jtfsubtotal.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		jtfsubtotal.setColumns(10);
		jtfsubtotal.setBounds(362, 398, 139, 34);
		contentPane.add(jtfsubtotal);
		
		jtftax = new JTextField();
		jtftax.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		jtftax.setColumns(10);
		jtftax.setBounds(362, 456, 139, 34);
		contentPane.add(jtftax);

		initializeData();
	}

	private void initializeData() 
	{

		int gid = Integer.parseInt(id);
		try
		{
			academicyear a = ac_manager.selectByID(gid);
			
		} catch (Exception ex) 
		{
			ex.printStackTrace();
		}
	}

	private void edit()
	{
		
		academicyear a =new academicyear();
		//jtfsubtotal.setText(String.valueOf(a.getprice()));
		//jtftotal.setText(String.valueOf(a.gettotal()));
		//jtfofitem.setText(String.valueOf(a.getofitem()));
		//jtfinvoicename.setText(a.getinvoicename());
		
		a.setid(Integer.parseInt(id));
		a.settotal(Integer.parseInt(jtftotal.getText()));
		a.setofitem(Integer.parseInt(jtfofitem.getText()));
		a.setinvoicename(jtfinvoicename.getText());
		

		try 
		{
			ac_manager.update(a);
			JOptionPane.showMessageDialog(null, "Successfully Updated",
					"Error Info", JOptionPane.ERROR_MESSAGE);
		} catch (Exception ex)
		{
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Update Failed", "Error Info",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	private void delete()
	{
		try 
		{
			ac_manager.delete(Integer.parseInt(id));
			
			jtftotal.setText("");
			jtfofitem.setText("");
			jtftax.setText("");
			jtfitemname.setText("");
			jtfinvoicename.setText("");
			
			JOptionPane.showMessageDialog(null, "Successfully Removed",
					"Error Info", JOptionPane.ERROR_MESSAGE);
		} catch (Exception ex)
		{
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Remove Failed", "Error Info",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
