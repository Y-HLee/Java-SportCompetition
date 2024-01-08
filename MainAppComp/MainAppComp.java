package MainAppComp;

import ModelComp.Competitor;
import ModelComp.CompetitorList;
import ModelComp.YLCompetitor;
import ViewComp.MainFrameComp;
import ViewComp.MainFrameManager;

import java.util.ArrayList;
import java.util.Scanner;

public class MainAppComp {

    public static void main(String[] args) {

        CompetitorList competitorLists = new CompetitorList();

        YLCompetitor c1 = new YLCompetitor("100", "Yuan", "yuan@gmailcom", 22, "Beginner", "UK");
        YLCompetitor c2 = new YLCompetitor("101", "Yuan", "yuan@gmailcom", 22, "Beginner", "UK");

        competitorLists.addCompetitor(c1);
        competitorLists.addCompetitor(c2);

        System.out.println(competitorLists.listByID());

        competitorLists.removeCompetitor(c1);

        System.out.println(competitorLists.listByID());
        System.out.println(competitorLists.getNumberOfEntries());

        new MainFrameComp();


   }
}
