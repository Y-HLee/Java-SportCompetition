package ViewComp;

import ControllerComp.CompetitorController;
import ModelComp.CompetitorList;

import javax.swing.*;
import java.awt.*;

public class MainFrameManager extends JFrame {

    // Card layout for switching view
    private CardLayout cardLayout;

    public MainFrameManager() {
        super("Competition Manager App ");
        cardLayout = new CardLayout();
        RegistrationForm regForm = new RegistrationForm();
        CompetitorDetails competitorDetails = new CompetitorDetails();
        // sets our layout as a card layout
        setLayout(cardLayout);

        // initialize user controller
        new CompetitorController(regForm, competitorDetails);

        // adds view to card layout with unique constraints
        add(regForm, "form");
        add(competitorDetails, "comp details");

        // switch view according to its constraints on click
        regForm.viewCompetitors(e -> cardLayout.show(MainFrameManager.this.getContentPane(), "comp details"));
        competitorDetails.backButton(e -> cardLayout.show(MainFrameManager.this.getContentPane(), "form"));

        // frame width & height
        int FRAME_WIDTH = 1200;
        int FRAME_HEIGHT = 700;
        // size of our application frame
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}