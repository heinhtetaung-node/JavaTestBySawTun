package com.java.plyd.spring.util;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class MonthPicker {
 // int month = java.util.Calendar.getInstance().get(java.util.Calendar.MONTH);
  int year = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);;
  JLabel l = new JLabel("", JLabel.CENTER);
  String month = "";
  JDialog d;
  JButton[] button = new JButton[12];
  private JTextField jtfyear;
 
  public MonthPicker(JFrame parent) {
    d = new JDialog();
    d.setModal(true);
   
    JPanel p1 = new JPanel(new GridLayout(4, 3));
    p1.setPreferredSize(new Dimension(430, 120));
 
    for (int x = 0; x < button.length; x++) {
      final int selection = x;
      button[x] = new JButton();
      button[x].setFocusPainted(false);
      button[x].setBackground(Color.white);
    //  if (x > 6) {
        button[x].addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent ae) {
            month = button[selection].getActionCommand();
            d.dispose();
          }
        });
   //   }
      p1.add(button[x]);
    }
    JPanel p2 = new JPanel(new FlowLayout());
     
    // Previous month button
    /*
    JButton previousmonth = new JButton("<< PreviousMonth");
    previousmonth.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        month--;
        displayDate();
      }
    });
    */
    jtfyear = new JTextField(20);
    jtfyear.setText(year+"");
    JButton previousyear = new JButton("<< PreviousYear");
    previousyear.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        year--;
        jtfyear.setText(year+"");
        displayMonth();
      }
    });
   
    //p2.add(previousmonth);
    p2.add(previousyear);
     
    // Current month label between the previous and next buttons
    p2.add(l);
     
    // Next month button
    
    
    p2.add(jtfyear);
     
    JButton nextyear = new JButton("NextYear >>");
    nextyear.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        year++;
        jtfyear.setText(year+"");
        displayMonth();
      }
    });
    p2.add(nextyear);
    
    d.add(p1, BorderLayout.CENTER);
    d.add(p2, BorderLayout.SOUTH);
    d.pack();
    d.setLocationRelativeTo(parent);
    displayMonth();
    d.setVisible(true);
  }
 /*
  public void displayDate() {
    for (int x = 7; x < button.length; x++) {
      button[x].setText("");
    }
     
    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("MMMM yyyy");
    java.util.Calendar cal = java.util.Calendar.getInstance();
    cal.set(year, month, 1);
    int monthOfWeek = cal.get(java.util.Calendar.month_OF_WEEK);
    int monthsInMonth = cal.getActualMaximum(java.util.Calendar.month_OF_MONTH);
 
    for (int x = 6 + monthOfWeek, month = 1; month <= monthsInMonth; x++, month++) {
      button[x].setText("" + month);
    }
   
    l.setText(sdf.format(cal.getTime()));
    d.setTitle("Date Picker");
  }
  */
 public void displayMonth(){
	 //
	 button[0].setText("Jan");
	 button[1].setText("Feb");
	 button[2].setText("March");
	 button[3].setText("April");
	 button[4].setText("May");
	 button[5].setText("Jun");
	 button[6].setText("Jul");
	 button[7].setText("Aug");
	 button[8].setText("Sept");
	 button[9].setText("Oct");
	 button[10].setText("Nov");
	 button[11].setText("Dec");
	 
 }
 
  public String setPickedDate() {
 //   if (month.equals("")) {
      return month;
 //   }
 /*  
    // Set the return date format
    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd-MM-yyyy");
         
    java.util.Calendar cal = java.util.Calendar.getInstance();
    cal.set(year, month, Integer.parseInt(month));
    return sdf.format(cal.getTime());
    */
  }
}

 