package ViewComp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;
import ModelComp.*;

public class CompetitorListGUI extends JFrame implements EventListener, ActionListener {
    private CompetitorList competitorList;

    JTextField result;
    JTextField searchField;
    JButton search;
    JScrollPane scrollList;
    JButton showListById, showListByName, close, alterUserButton,
            removeCompetitorButton, showShortDetailsButtton, showLongDetailsButton;
    JTextArea displayList;


    /**
     * Create the frame with its panels.
     * @param list	The staff list to be searched.
     */
    public CompetitorListGUI(CompetitorList list)
    {
        this.competitorList = list;

        //set up window title
        setTitle("Competitor List");
        //disable standard close button
        setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);

        setupSouthPanel();
        setupNorthPanel();
        setupCenterPanel();

        //pack and set visible
        pack();
        setVisible(true);

    }
    private void setupCenterPanel() {
        displayList = new JTextArea(15,25);
        displayList.setFont(new Font(Font.MONOSPACED, Font.PLAIN,14));
        displayList.setEditable(false);
        scrollList = new JScrollPane(displayList);
        this.add(scrollList,BorderLayout.CENTER);
    }
    private void setupSouthPanel() {
        //search panel contains label, text field and button
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new GridLayout(1,3));
        searchPanel.add(new JLabel("Enter ID"));
        searchField = new JTextField(5);
        searchPanel.add(searchField);
        search = new JButton("Search");
        searchPanel.add(search);
        //specify action when button is pressed
        search.addActionListener(this);

        //Set up the area where the results will be displayed.
        result= new JTextField(25);
        result.setEditable(false);

        //set up south panel containing 2 previous areas
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(2,1));
        southPanel.add(searchPanel);
        southPanel.add(result);

        alterUserButton = new JButton("Alter Chosen User");
        searchPanel.add(alterUserButton);
        alterUserButton.addActionListener(this);

        removeCompetitorButton = new JButton("Remove competitor");
        searchPanel.add(removeCompetitorButton);
        removeCompetitorButton.addActionListener(this);

        showShortDetailsButtton = new JButton("Show Short Details");
        searchPanel.add(showShortDetailsButtton);
        showShortDetailsButtton.addActionListener(this);

        showLongDetailsButton = new JButton("Show Long Details");
        searchPanel.add(showLongDetailsButton);
        showLongDetailsButton.addActionListener(this);

        //add south panel to the content pane`
        this.add(southPanel, BorderLayout.SOUTH);
    }
    private void setupNorthPanel() {
        //add north panel containing some buttons
        JPanel northPanel = new JPanel();
        showListById = new JButton("List By ID");
        showListById.addActionListener(this);

        showListByName = new JButton("List By Name");
        showListByName.addActionListener(this);

        close = new JButton("Close");
        close.addActionListener(this);

        northPanel.add (showListById);
        northPanel.add(showListByName);
        northPanel.add(close);
        this.add(northPanel, BorderLayout.NORTH);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == search) {
            search();
        }
        else if (e.getSource() == showListById) {
            displayList.setText(competitorList.listByID());
        }
        else if (e.getSource() == showListByName ) {
            displayList.setText(competitorList.listByName());
        }
        else if(e.getSource() == removeCompetitorButton){
            competitorList.removeCompetitor(competitorList.findById(searchField.getText().trim()));
            displayList.setText(competitorList.listDetails());
            competitorList.saveToFile();
        }
        else if (e.getSource() == showShortDetailsButtton ) {
            displayList.setText(competitorList.findById(searchField.getText().trim()).getShortDetails());
        }
        else if (e.getSource() == showLongDetailsButton) {
            displayList.setText(competitorList.findById(searchField.getText().trim()).getFullDetails());
        }
        else if (e.getSource() == close) {
            JOptionPane.showMessageDialog(this,
                    "Closing down ..");
            System.exit(0);
        }
    }

    private void search() {
        //get search text and search staff list
        //setting result text
        String searchString = searchField.getText().trim();
        if(searchString.length() > 0) {
            Competitor person = competitorList.findById(searchString);
            if (person != null ) {
                result.setText(person.toString());

            }
            else
                result.setText("not found");
        }
        else
            result.setText("no text entered");
    }


}
