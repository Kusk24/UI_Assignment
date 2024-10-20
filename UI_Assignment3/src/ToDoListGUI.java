import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToDoListGUI extends JFrame implements ActionListener {

    private JLabel taskLabel, taskListLabel, taskValueLabelOne, taskValueLabelTwo;
    private JTextField taskTextField;
    private JButton addTaskButton, removeTaskButton, clearAllButton;
    private ButtonGroup actionButtonGroup;
    private String taskOne = "";
    private String taskTwo = "";

    public ToDoListGUI() {
        initializeUIComponent();

        this.add(taskLabel);

        this.add(taskTextField);

        this.add(addTaskButton);

        this.add(taskListLabel);

        this.add(taskValueLabelOne);

        this.add(taskValueLabelTwo);

        this.add(removeTaskButton);

        this.add(clearAllButton);

        this.setVisible(true);

    }

    private void initializeUIComponent() {
        this.setTitle("TO-Do List Manager");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(5,3));
        this.setSize(500,400);
        this.setLocationRelativeTo(null);

        this.taskLabel = new JLabel("Task");

        this.taskListLabel = new JLabel("TaskList");

        this.taskTextField = new JTextField();

        this.taskValueLabelOne = new JLabel("Task 1");
        this.taskValueLabelTwo = new JLabel("Task 2");

        this.addTaskButton = new JButton("Add Task");
        this.removeTaskButton = new JButton("Remove Task");
        this.clearAllButton = new JButton("Clear All");

        this.actionButtonGroup = new ButtonGroup();
        this.actionButtonGroup.add(this.removeTaskButton);
        this.actionButtonGroup.add(this.clearAllButton);

        this.addTaskButton.addActionListener(this);
        this.removeTaskButton.addActionListener(this);
        this.clearAllButton.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.removeTaskButton) {
            removeTaskButtonAction();
        } else if (e.getSource() == this.addTaskButton){
            addTaskButtonAction();
        } else if (e.getSource() == this.clearAllButton) {
            clearAllButtonAction();
        }
    }

    private void clearAllButtonAction() {
        this.taskOne = "";
        this.taskTwo = "";

        this.taskValueLabelOne.setText("");
        this.taskValueLabelTwo.setText("");
    }

    private void addTaskButtonAction() {
        String task = this.taskTextField.getText();
        if (task.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please fill information", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (this.taskOne.isEmpty() && this.taskTwo.isEmpty()){
            this.taskOne = task;
            this.taskValueLabelOne.setText("1 : "+ task);
        } else if (!this.taskOne.isEmpty() && taskTwo.isEmpty()){
            this.taskTwo = task;
            this.taskValueLabelTwo.setText("2 : "+ task);
        } else {
            JOptionPane.showMessageDialog(this, "Please delete some of your task", "Full Task List", JOptionPane.ERROR_MESSAGE);
        }
        this.taskTextField.setText("");
    }

    private void removeTaskButtonAction() {
        if (!this.taskOne.isEmpty() && !this.taskTwo.isEmpty()){
            this.taskTwo = "";
            this.taskValueLabelTwo.setText("");
        } else if (!this.taskOne.isEmpty() && taskTwo.isEmpty()){
            this.taskOne = "";
            this.taskValueLabelOne.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Nothing to remove from the list", "Full Task List", JOptionPane.ERROR_MESSAGE);
        }
    }
}
