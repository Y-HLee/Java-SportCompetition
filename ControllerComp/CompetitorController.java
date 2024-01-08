package ControllerComp;

import ModelComp.Competitor;
import ModelComp.CompetitorList;
import ModelComp.IceSkater;
import ModelComp.YLCompetitor;
import ViewComp.CompetitorDetails;
import ViewComp.RegistrationForm;

import javax.swing.*;
import java.io.File;

public class CompetitorController {
    private String databaseFile = "competitorsDatabase.txt";
    private File file = new File(databaseFile);
    private CompetitorList database;
    private RegistrationForm registrationForm;
    private CompetitorDetails competitorDetails;

    public CompetitorController(RegistrationForm registrationForm, CompetitorDetails competitorDetails){
        this.database = new CompetitorList();
        this.registrationForm = registrationForm;
        this.competitorDetails = competitorDetails;

        this.registrationForm.submitCompetitor(e ->{
            String name = this.registrationForm.getName().trim();
            String email = this.registrationForm.getEmail().trim();
            String age = this.registrationForm.getAge().trim();
            String level = this.registrationForm.getLevel().trim();
            String country = this.registrationForm.getCountry().trim();
            String category = this.registrationForm.getCategory().trim();

            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(this.registrationForm, "Name Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else if(email.isEmpty()) {
                JOptionPane.showMessageDialog(this.registrationForm, "Email Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else if(age.isEmpty()) {
                JOptionPane.showMessageDialog(this.registrationForm, "Age Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else if(level.isEmpty()) {
                JOptionPane.showMessageDialog(this.registrationForm, "Level Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else if(country.isEmpty()) {
                JOptionPane.showMessageDialog(this.registrationForm, "Country Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else if(category.isEmpty()) {
                JOptionPane.showMessageDialog(this.registrationForm, "Category Required.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (category.equals("Ice Skater")){
                this.database.addCompetitor(new IceSkater(database.generateId(), name, email, Integer.parseInt(age), level, country));

            } else if (category.equals("YLCompetitor")){
                this.database.addCompetitor(new YLCompetitor(database.generateId(), name, email, Integer.parseInt(age), level, country));
            }
            this.database.saveCompetitor(new File(databaseFile));
            this.registrationForm.reset(true);
        });

        this.registrationForm.viewCompetitors(e -> {
            this.competitorDetails.getCompetitors(this.database.loadCompetitor(file));
        });

        this.competitorDetails.orderByIDButton(e -> {
            this.competitorDetails.getCompetitors(this.database.orderById());
        });

        this.competitorDetails.orderByNameButton(e -> {
            this.competitorDetails.getCompetitors(this.database.orderByName());
        });
    }
}
