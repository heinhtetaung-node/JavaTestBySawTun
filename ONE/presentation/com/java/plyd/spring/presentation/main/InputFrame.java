package com.java.plyd.spring.presentation.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.DropMode;

public class InputFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtgrade;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InputFrame frame = new InputFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InputFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 358, 260);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterYourGrade = new JLabel("Enter Your Grade:");
		lblEnterYourGrade.setBounds(39, 78, 126, 24);
		contentPane.add(lblEnterYourGrade);
		
		txtgrade = new JTextField();

		txtgrade.setBounds(147, 80, 86, 20);
		contentPane.add(txtgrade);
		txtgrade.setColumns(10);
	}
}
