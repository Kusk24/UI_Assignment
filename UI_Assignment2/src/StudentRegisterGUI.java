import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentRegisterGUI extends JFrame implements ActionListener {

    private JLabel nameLabel;
    private JTextField nameTextField;
    private JLabel emailLabel;
    private JTextField emailTextField;
    private JLabel phoneLabel;
    private JTextField phoneTextField;
    private JRadioButton maleRadio, femaleRadio;
    private ButtonGroup genderGroup;
    private JPanel genderPanel;
    private JCheckBox termsCheckBox;
    private JComboBox courseBox;
    private JLabel genderLabel;
    private JLabel courseLabel;
    private Button submitButton;


    public StudentRegisterGUI(){
        initializeUIComponent();

        this.add(nameLabel);
        this.add(nameTextField);

        this.add(emailLabel);
        this.add(emailTextField);

        this.add(phoneLabel);
        this.add(phoneTextField);

        this.add(genderLabel);
        this.genderPanel.add(this.maleRadio);
        this.genderPanel.add(this.femaleRadio);
        this.add(this.genderPanel);

        this.add(courseLabel);
        this.add(courseBox);

        this.add(termsCheckBox);
        this.add(new JLabel());

        this.add(submitButton);
        this.setVisible(true);
    }

    private void initializeUIComponent(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(7, 2, 5, 5));
        this.setSize(400, 300);  // Set a preferred size
        this.setLocationRelativeTo(null);

        this.nameLabel = new JLabel("Name");
        this.nameTextField = new JTextField();

        this.emailLabel = new JLabel("Email");
        this.emailTextField = new JTextField();

        this.phoneLabel = new JLabel("Phone Number");
        this.phoneTextField = new JTextField();

        this.genderPanel = new JPanel();
        this.genderLabel = new JLabel("Gender:");
        this.maleRadio = new JRadioButton("Male");
        this.femaleRadio = new JRadioButton("Female");

        this.genderGroup = new ButtonGroup();
        this.genderGroup.add(this.maleRadio);
        this.genderGroup.add(this.femaleRadio);

        this.courseLabel = new JLabel("Course: ");
        String[] course = {"java", "python", "C++"};
        this.courseBox = new JComboBox<>(course);

        termsCheckBox = new JCheckBox(("Accept Terms and Conditions"));

        this.submitButton = new Button("Submit");
        this.submitButton.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.submitButton){
            submitButtonAction();
        }
    }

    private void submitButtonAction(){
        String name = this.nameTextField.getText();
        String email = this.emailTextField.getText();
        String phone = this.phoneTextField.getText();
        String gender = this.maleRadio.isSelected() ? "Mail" : this.femaleRadio.isSelected() ? "Female" : "";
        String course = (String) courseBox.getSelectedItem();
        boolean termAccepted = this.termsCheckBox.isSelected();

        if (name.isEmpty() || email.isEmpty() || gender.isEmpty() || !termAccepted) {
            JOptionPane.showMessageDialog(this, "Please fill all fields and accept the term and conditions.", "Error", JOptionPane.ERROR_MESSAGE);

        } else {
            String message = String.format("Name %s \nEmail %s \nPhone %s \nGender %s \n", name,email,phone,gender,course);
            JOptionPane.showMessageDialog(this,message, "Registeration Successful", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
