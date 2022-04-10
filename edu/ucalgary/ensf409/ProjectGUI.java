/*
@Authors: Manraj Singh, Kartik Sharma, Sajan Hayer, Kirtan Kakadiya
@Version: 1.0
@Since: 1.0
 */

package edu.ucalgary.ensf409;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

public class ProjectGUI extends JFrame implements ActionListener {
    private static JFrame frame;
    private static JPanel panel;
    private static JLabel welcomeLabel;
    private static JLabel orderName;
    private static JLabel choices;
    private static JTextField orderNameField;
    private static JLabel orderDate;
    private static JTextField orderDateField;
    private static JLabel family;
    private static JLabel adultMale;
    private static JLabel adultFemale;
    private static JLabel chUnder8;
    private static JLabel chOver8;
    private static JComboBox combo1;
    private static JComboBox combo2;
    private static JComboBox combo3;
    private static JComboBox combo4;
    private static JComboBox combo5;
    private static JLabel sizeOfFamily;
    private static JLabel choiceOfTrans;
    private static JRadioButton boxYes;
    private static JRadioButton boxNo;
    private static JButton generateForm;
    private static JProgressBar progressBar;
    private static final String[] array = {"0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18",
    "19","20","21","22","23","24","25","26","27","28","29","30"};
    private static final String[] choiceHampers = {"Balanced", "Calorie Deficit (low calories)", "Muscle Building (high protein)", "Keto (low grains/carbs)"};

    public static void main(String[] args){
        try{
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        }catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException exception){
            exception.printStackTrace();
        }

        Font fontHeader = new Font(Font.DIALOG, Font.BOLD, 20);
        Font secondHeader = new Font(Font.DIALOG, Font.BOLD, 15);
        Font thirdHeader = new Font(Font.DIALOG, Font.BOLD, 15);
        Font textFont = new Font(Font.DIALOG, Font.PLAIN, 12);
        Color bgColor = new Color(17, 75, 95, 255);
        Color textColor = new Color(198, 218, 191);
        Color buttonColor = new Color(136, 212, 152);
        Color buttonTextColor = new Color(26, 147, 111);

        frame = new JFrame("Order Window");
        frame.setSize(500, 700);
        //frame.setUndecorated(false);
        frame.setLocationRelativeTo(null);
        //frame.setShape(new RoundRectangle2D.Double(0, 0, frame.getWidth(), frame.getHeight(), 20, 20));
        panel = new JPanel();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);


        panel.setBackground(bgColor);
        panel.setLayout(null);
        System.out.println(panel.getSize());
        frame.add(panel);

        welcomeLabel = new JLabel("Welcome to the Application Form!");
        welcomeLabel.setFont(fontHeader);
        welcomeLabel.setForeground(textColor);
        welcomeLabel.setBounds(90,10,400,25);
        panel.add(welcomeLabel);
        frame.setVisible(true);

        choiceOfTrans = new JLabel("Do you require delivery?");
        choiceOfTrans.setFont(secondHeader);
        choiceOfTrans.setForeground(textColor);
        choiceOfTrans.setBounds(5, 50, 300, 25);
        panel.add(choiceOfTrans);

        boxYes = new JRadioButton("Yes");
        boxNo = new JRadioButton("No");
        boxNo.setForeground(textColor);
        boxYes.setForeground(textColor);
        boxYes.setBounds(5, 80, 100, 25);
        boxNo.setBounds(50, 80, 100, 25);
        boxYes.setSelected(false);
        boxNo.setSelected(false);
        panel.add(boxNo);
        panel.add(boxYes);

        orderName = new JLabel("Please enter your family name:");
        orderName.setFont(secondHeader);
        orderName.setForeground(textColor);
        orderName.setBounds(5, 120, 300, 25);
        orderNameField = new JTextField(100);
        orderNameField.setBounds(4, 145, 100, 30);
        panel.add(orderName);
        panel.add(orderNameField);

        orderDate = new JLabel("Please enter the current date (MM/DD/YYYY):");
        orderDate.setForeground(textColor);
        orderDate.setFont(secondHeader);
        orderDate.setBounds(5, 185, 400, 25);
        orderDateField = new JTextField(300);
        orderDateField.setBounds(4, 210, 100, 30);
        panel.add(orderDate);
        panel.add(orderDateField);

        family = new JLabel("Please enter your family size: ");
        family.setFont(secondHeader);
        family.setBounds(5, 250, 300, 25);
        family.setForeground(textColor);
        panel.add(family);

        adultMale = new JLabel("Number of Adult Males: ");
        adultMale.setBounds(5, 280, 300, 25);
        adultMale.setForeground(textColor);
        adultMale.setFont(textFont);
        panel.add(adultMale);

        adultFemale = new JLabel("Number of Adult Females: ");
        adultFemale.setBounds(5, 330, 300, 25);
        adultFemale.setForeground(textColor);
        adultFemale.setFont(textFont);
        panel.add(adultFemale);

        chUnder8 = new JLabel("Number of Children under 8: ");
        chUnder8.setBounds(5, 380, 300, 25);
        chUnder8.setForeground(textColor);
        chUnder8.setFont(textFont);
        panel.add(chUnder8);

        chOver8 = new JLabel("Number of Children over 8: ");
        chOver8.setBounds(5, 430, 300, 25);
        chOver8.setForeground(textColor);
        chOver8.setFont(textFont);
        panel.add(chOver8);

        combo1 = new JComboBox(array);
        combo1.setBounds(4, 302, 100, 25);
        panel.add(combo1);

        combo2 = new JComboBox(array);
        combo2.setBounds(4, 352, 100, 25);
        panel.add(combo2);

        combo3 = new JComboBox(array);
        combo3.setBounds(4, 402, 100, 25);
        panel.add(combo3);

        combo4 = new JComboBox(array);
        combo4.setBounds(4, 452, 100, 25);
        panel.add(combo4);

        choices = new JLabel("Choose a hamper configuration: ");
        choices.setFont(secondHeader);
        choices.setForeground(textColor);
        choices.setBounds(5, 490, 300, 25);
        panel.add(choices);

        combo5 = new JComboBox(choiceHampers);
        combo5.setBounds(4, 515, 300, 25);
        panel.add(combo5);

        generateForm = new JButton("Generate Hamper");
        generateForm.setFont(thirdHeader);
        generateForm.setBounds(130, 560, 200, 30);
        generateForm.setBackground(buttonColor);
        generateForm.setForeground(buttonTextColor);
        panel.add(generateForm);

        progressBar = new JProgressBar(0);
        progressBar.setBounds(130, 600, 200, 30);
        progressBar.setBackground(textColor);
        panel.add(progressBar);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {}
}
