package com.java.plyd.spring.presentation.main;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JLabel;
import com.java.plyd.spring.util.BasicBeanFactory;
import javax.swing.JMenuBar;
import javax.swing.JMenu;

import jxl.common.Logger;
/*
 import org.amaris.util.BasicBeanFactory;
 import org.amaris.util.Conversation;
 import org.apache.log4j.Logger;
 */

import com.java.plyd.spring.util.*;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

import com.java.plyd.spring.entity.academicyear;
//import com.java.plyd.spring.entity.user;
import com.java.plyd.spring.presentation.academicyear.academicyearSearchFrame;
//import com.java.plyd.spring.presentation.cla_ss.cla_ssSearchFrame;
//import com.java.plyd.spring.presentation.grade.gradeSearchFrame;
//import com.java.plyd.spring.presentation.attendence.attendenceSearchFrame;
//import com.java.plyd.spring.presentation.attendence.attendence_entry;
//import com.java.plyd.spring.presentation.award.awardSearchFrame;
//import com.java.plyd.spring.presentation.class_.classSearchFrame;
//import com.java.plyd.spring.presentation.department.departmentSearchFrame;
//import com.java.plyd.spring.presentation.exam_title.exam_detailSearchFrame;
//import com.java.plyd.spring.presentation.exam_title.exam_titleSearchFrame;
//import com.java.plyd.spring.presentation.grade.gradeSearchFrame;
//import com.java.plyd.spring.presentation.punishment.punishmentSearchFrame;
//import com.java.plyd.spring.presentation.rank.rankSearchFrame;
//import com.java.plyd.spring.presentation.staff.staffSearchFrame;
//import com.java.plyd.spring.presentation.staff_rank.staff_rankSearchFrame;
//import com.java.plyd.spring.presentation.staff_reports.all_staffReportFrame;
//import com.java.plyd.spring.presentation.staff_reports.staffReportFrame;
//import com.java.plyd.spring.presentation.student.studentEntry;
//import com.java.plyd.spring.presentation.student.studentSearchFrame;
//import com.java.plyd.spring.presentation.student_exam.student_examSearchFrame;
//import com.java.plyd.spring.presentation.student_exam.student_examEntry;
//import com.java.plyd.spring.presentation.student_reports.student_by_age_reportFrame;
//import com.java.plyd.spring.presentation.student_reports.student_exam_reportFrame;
//import com.java.plyd.spring.presentation.student_reports.student_reportFrameForIV_VIII;
//import com.java.plyd.spring.presentation.student_reports.student_reportFrameForX;
//import com.java.plyd.spring.presentation.studentclass.studentclassFrame;
//import com.java.plyd.spring.presentation.subject.subjectSearchFrame;
//import com.java.plyd.spring.presentation.teacher_class_subject.teacher_class_subjectEntry;
//import com.java.plyd.spring.presentation.teacher_class_subject.teacher_class_subjectSearchFrame;
//import com.java.plyd.spring.presentation.user.userEntryFrame;
//import com.java.plyd.spring.service.academicyear.*;

public class SchoolMainFrame extends JFrame {

	/**
	 * 
	 */
	public static String academicYear;
	public static HashMap<String, Object> conversation = new HashMap<String, Object>();
	public static int initalizedFilter = 0;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static SchoolMainFrame mainFrame;

	private JMenuBar menuBar;
	private JMenu mnReport;
	private JMenu mnUserRegistration;
	private JMenu mnAccounting;
	private JMenu mnLogOut;
	private JMenu mnClose;

	private JMenuItem mntmUserRegistration;
	private JMenuItem mntmAccounting;

	private JMenuItem mntmLogOut;
	private JMenuItem mntmClose;

	Conversation cov = new Conversation();
	private static Logger logger = Logger.getLogger(SchoolMainFrame.class);

	private JMenu mnMain;
	private JMenuItem mntminvoice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainFrame = new SchoolMainFrame();
					mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					mainFrame.setVisible(true);
					mainFrame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static SchoolMainFrame getInstance() {
		if (mainFrame == null) {
			mainFrame = new SchoolMainFrame();
			mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
			mainFrame.setVisible(true);
			mainFrame.setResizable(false);
		}
		mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		mainFrame.setVisible(true);
		mainFrame.setResizable(false);
		return mainFrame;
	}

	/**
	 * Create the frame.
	 */
	public SchoolMainFrame() {
		setTitle("School Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1366, 740);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1350, 31);
		contentPane.add(menuBar);

		mnMain = new JMenu("Main");
		mnMain.setFont(new Font("Zawgyi-One", Font.PLAIN, 20));
		menuBar.add(mnMain);

		mntminvoice = new JMenuItem("Invoice");
		mntminvoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				academicyearSearchFrame aSearchFrame = academicyearSearchFrame
						.getInstance();
				mainFrame.setVisible(false);
				mainFrame = null;
			}
		});
		mntminvoice.setFont(new Font("Zawgyi-One", Font.PLAIN, 20));
		mnMain.add(mntminvoice);
		
		/*JMenuItem mntmGrade = new JMenuItem("Grade");
		mntmGrade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gradeSearchFrame aSearchFrame = gradeSearchFrame
						.getInstance();
				mainFrame.setVisible(false);
				mainFrame = null;
			}
			
		});
		mntmGrade.setFont(new Font("Zawgyi-One", Font.PLAIN, 20));
		mnMain.add(mntmGrade);
		
		/*JMenuItem mntmClass = new JMenuItem("Class");
		mntmClass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cla_ssSearchFrame aSearchFrame = cla_ssSearchFrame
						.getInstance();
				mainFrame.setVisible(false);
				mainFrame = null;
			}
			
		});
		mntmClass.setFont(new Font("Zawgyi-One", Font.PLAIN, 20));
		mnMain.add(mntmClass);
		*/ 
		
		initalizedBean();
	}
	public void initalizedBean() 
	{
		try 
		{
			BasicBeanFactory bf = new BasicBeanFactory();
			logger.info("All Spring bean are successfully loaded.");
		} catch (Exception ex) 
		{
			logger.error("Erro when loading spring bean.", ex);
		}

	}
}
