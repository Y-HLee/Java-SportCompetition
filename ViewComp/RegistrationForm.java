package ViewComp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class RegistrationForm extends JPanel {
    private JTextField nameField;
    private JTextField emailField;
    private JTextField ageField;
    private JComboBox levelField;
    private String[] levelChoices = {"Beginner", "Intermediate", "Professional"};
    private JTextField countryField;
    private JComboBox categoryField;
    private String[] categoryChoices = {"Ice Skater", "YLCompetitor"};

    private JButton addButton;
    private JButton viewButton;

    public RegistrationForm(){
        JLabel nameLabel = new JLabel("Name: ");
        JLabel emailLabel = new JLabel("Email: ");
        JLabel ageLabel = new JLabel("Age: ");
        JLabel levelLabel = new JLabel("Level: ");
        JLabel countryLabel = new JLabel("Country: ");
        JLabel categoryLabel = new JLabel("Category: ");

        nameField = new JTextField(25);
        emailField = new JTextField(25);
        ageField = new JTextField(25);
        levelField = new JComboBox<String>(levelChoices);
        countryField = new JTextField(25);
        categoryField = new JComboBox<String>(categoryChoices);

        addButton = new JButton("Add Competitor");
        addButton.setPreferredSize(new Dimension(278, 40));
        viewButton = new JButton("View All Competitors");
        viewButton.setPreferredSize(new Dimension(278, 40));

        // space between fields
        Insets fieldsInset = new Insets(0, 0, 10, 0);
        // space between buttons
        Insets buttonInset = new Insets(20,0,0,0);

        setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.insets = fieldsInset;
        gridBagConstraints.fill = GridBagConstraints.NONE;

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.WEST;

        add(nameLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;

        add(nameField, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = buttonInset;

        add(emailLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;

        add(emailField, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = buttonInset;

        add(ageLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;

        add(ageField, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = GridBagConstraints.WEST;

        add(levelLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;

        add(levelField, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = GridBagConstraints.WEST;

        add(countryLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;

        add(countryField, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = GridBagConstraints.WEST;

        add(categoryLabel, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;

        add(categoryField, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = GridBagConstraints.WEST;

        add(addButton, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.insets = buttonInset;

        add(viewButton, gridBagConstraints);
    }

    public String getName() {
        return nameField.getText();
    }
    public String getEmail() {
        return emailField.getText();
    }
    public String getAge() {
        return ageField.getText();
    }
    public String getLevel() {
        return (String) levelField.getSelectedItem();
    }
    public String getCountry() {
        return countryField.getText();
    }
    public String getCategory() {
        return (String) categoryField.getSelectedItem();
    }



    public void submitCompetitor(ActionListener actionListener) {
        addButton.addActionListener(actionListener);
    }

    public void viewCompetitors(ActionListener actionListener) {
        viewButton.addActionListener(actionListener);
    }

    // reset fields
    public void reset(boolean bln) {
        if(bln) {
            nameField.setText("");
            emailField.setText("");
            ageField.setText("");
            levelField.setSelectedItem("Beginner");
            countryField.setText("");
            categoryField.setSelectedItem("Ice Skater");
        }
    }

}
