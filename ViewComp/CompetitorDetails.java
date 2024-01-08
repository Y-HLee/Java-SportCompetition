package ViewComp;

import ModelComp.Competitor;
import ModelComp.CompetitorList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class CompetitorDetails  extends JPanel {

    // Table for user data
    private JTable userTable;
    private DefaultTableModel defaultTableModel;
    // table column
    private String[] userTableColumn = {"ID", "NAME", "EMAIL ADDRESS", "AGE", "LEVEL", "COUNTRY", "CATEGORY"};

    // back button
    private JButton backButton;
    private JButton orderByIDButton;
    private JButton orderByNameButton;
    private JButton filterByCategory;
    private JButton filter;


    public CompetitorDetails() {
        // uses box layout
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        // toolbar for buttons
        JToolBar toolBar = new JToolBar();
        userTable = new JTable();
        // scroll bar for table
        JScrollPane userTableScroll = new JScrollPane(userTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        backButton = new JButton("Go Back");
        orderByIDButton = new JButton("Order By Id");
        orderByNameButton = new JButton("Order By Name");
        toolBar.setLayout(new GridLayout(1, 3));
        add(toolBar);
        toolBar.add(backButton);
        toolBar.add(orderByIDButton);
        toolBar.add(orderByNameButton);
        toolBar.setMaximumSize(new Dimension(Integer.MAX_VALUE, toolBar.getMinimumSize().height));
        add(userTableScroll);

    }

    // gets users from database and loads to table
    public void getCompetitors(Object[] objects) {
        defaultTableModel = (DefaultTableModel) userTable.getModel();
        defaultTableModel.getDataVector().removeAllElements();
        defaultTableModel.setColumnIdentifiers(userTableColumn);
        int i = 0;
        while(i < objects.length) {
            String row = objects[i].toString().trim();
            String[] rows = row.split(",");
            defaultTableModel.addRow(rows);
            i++;
        }
    }

    // event listener for back button
    public void backButton(ActionListener actionListener) {
        backButton.addActionListener(actionListener);
    }

    public void orderByIDButton(ActionListener actionListener) {
        orderByIDButton.addActionListener(actionListener);
    }

    public void orderByNameButton(ActionListener actionListener) {
        orderByNameButton.addActionListener(actionListener);
    }

//    public void actionPerformed(ActionEvent e)
//    {
//        if (e.getSource() == orderByIDButton) {
//
//        }
//        else if (e.getSource() == orderByNameButton ) {
//            displayList.setText(staffList.listByName());
//        }
//        else {};
//    }
}