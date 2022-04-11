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
    private static JLabel success;
    private static JComboBox combo1;
    private static JComboBox combo2;
    private static JComboBox combo3;
    private static JComboBox combo4;
    private static JComboBox combo5;
    private static JLabel sizeOfFamily;
    private static JLabel choiceOfTrans;
    private static JRadioButton boxYes;
    private static JRadioButton boxNo;
    private static ButtonGroup group1;
    private static JButton generateForm;
    private static JProgressBar progressBar;
    private static final String[] array = {"0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18",
    "19","20","21","22","23","24","25","26","27","28","29","30"};
    private static final String[] choiceHampers = {"Balanced", "Calorie Deficit (low calories)",
            "Muscle Building (high protein)", "Keto (low grains/carbs)"};

    private boolean choice;
    private String familyName;
    private String currDate;
    private int numAdultMales;
    private int numAdultFemales;
    private int numChildUnder8;
    private int numChildOver8;
    private int hamperChoice;

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
        frame.add(panel);

        welcomeLabel = new JLabel("Welcome to the Application Form!");
        welcomeLabel.setFont(fontHeader);
        welcomeLabel.setForeground(textColor);
        welcomeLabel.setBounds(90,10,400,25);
        panel.add(welcomeLabel);

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
        boxNo.setActionCommand("No");
        boxYes.setActionCommand("Yes");
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
        combo1.addActionListener(new ProjectGUI());
        panel.add(combo1);

        combo2 = new JComboBox(array);
        combo2.setBounds(4, 352, 100, 25);
        combo2.addActionListener(new ProjectGUI());
        panel.add(combo2);

        combo3 = new JComboBox(array);
        combo3.setBounds(4, 402, 100, 25);
        combo3.addActionListener(new ProjectGUI());
        panel.add(combo3);

        combo4 = new JComboBox(array);
        combo4.setBounds(4, 452, 100, 25);
        combo4.addActionListener(new ProjectGUI());
        panel.add(combo4);

        choices = new JLabel("Choose a hamper configuration: ");
        choices.setFont(secondHeader);
        choices.setForeground(textColor);
        choices.setBounds(5, 490, 300, 25);
        panel.add(choices);

        combo5 = new JComboBox(choiceHampers);
        combo5.setBounds(4, 515, 300, 25);
        combo5.addActionListener(new ProjectGUI());
        panel.add(combo5);

        generateForm = new JButton("Generate Hamper");
        generateForm.setFont(thirdHeader);
        generateForm.setBounds(130, 560, 200, 30);
        generateForm.setBackground(buttonColor);
        generateForm.setForeground(buttonTextColor);
        generateForm.addActionListener(new ProjectGUI());
        panel.add(generateForm);

        progressBar = new JProgressBar(0);
        progressBar.setBounds(130, 600, 200, 30);
        progressBar.setValue(0);
        progressBar.setBackground(textColor);
        progressBar.setStringPainted(true);

        panel.add(progressBar);

        group1 = new ButtonGroup();
        group1.add(boxNo);
        group1.add(boxYes);
        boxYes.addActionListener(new ProjectGUI());
        boxNo.addActionListener(new ProjectGUI());


        success = new JLabel();
        success.setFont(textFont);
        success.setForeground(textColor);
        success.setBounds(130, 630, 300, 30);
        panel.add(success);


        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(generateForm)){
            if (boxNo.isSelected()){
                this.choice = false;
            }
            if (boxYes.isSelected()){
                this.choice = true;
            }
            this.familyName = orderNameField.getText();
            this.currDate = orderDateField.getText();
            this.numAdultMales = combo1.getSelectedIndex();
            this.numAdultFemales = combo2.getSelectedIndex();
            this.numChildUnder8 = combo3.getSelectedIndex();
            this.numChildOver8 = combo4.getSelectedIndex();
            this.hamperChoice =combo5.getSelectedIndex();
            //Following are index values for hamperChoice
            //0 = Balanced
            //1 = Calorie Deficit (low calories)
            //2 = Muscle Building (high protein)
            //3 = Keto (low grains/carbs)
            if (!(boxYes.isSelected()) && !(boxNo.isSelected())){
                success.setText("Please select a choice of delivery!");
            }
            else if (orderNameField.getText().equals("")){
                success.setText("Please enter an input for family/last name!");
            }
            else if (combo1.getSelectedIndex() == 0 && combo2.getSelectedIndex() == 0 && combo3.getSelectedIndex() == 0
                    && combo4.getSelectedIndex() == 0){
                success.setText("Please enter valid values for family size!");
            }
            else{
                success.setText("Generating hamper and order form!");
            }

            generateApplicationForm();
        }
    }

    public void generateApplicationForm(){
        ApplicationForm form = new ApplicationForm(choice, familyName, currDate, numAdultMales,
                numAdultFemales, numChildUnder8, numChildOver8, hamperChoice);

        System.out.println("Transport Req: " + form.getTransportRequirement());
        System.out.println("Family name: " + form.getOrderName());
        System.out.println("Order date: " + form.getOrderDate());
        System.out.println("Num adult males: " + form.getCountAdultMales());
        System.out.println("Num adult females: " + form.getCountAdultFemales());
        System.out.println("Num child under 8: " + form.getCountChildUnder8());
        System.out.println("Num child over 8: " + form.getCountChildOver8());
        System.out.println("Hamper choice: " + form.getHamperChoice());

    }
}
