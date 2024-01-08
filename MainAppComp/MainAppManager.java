package MainAppComp;

import ModelComp.*;
import ViewComp.CompetitorListGUI;
import ViewComp.MainFrameComp;
import ViewComp.MainFrameManager;

import java.io.*;
import java.util.ArrayList;

public class MainAppManager {

    //private ArrayList<Competitor> competitorList;
    private CompetitorList entries;

    public MainAppManager() {

        //competitorList = new ArrayList<>();
        entries = new CompetitorList();
        addCompetitors();

    }

    private void addCompetitors() {
        //load staff data from file
        BufferedReader buff = null;
        try {
            buff = new BufferedReader(new FileReader("RunCompetitor.csv"));
            String inputLine = buff.readLine();  //read first line
            while(inputLine != null){
                processLine(inputLine);
                //read next line
                inputLine = buff.readLine();
            }
        }
        catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        finally  {
            try{
                buff.close();
            }
            catch (IOException ioe) {
                //don't do anything
            }
        }
    }

    private void processLine(String inputLine) {
        //split line into parts
        String data [] = inputLine.split(",");
        int[] scores = {Integer.parseInt(data[7]),Integer.parseInt(data[8]), Integer.parseInt(data[9]), Integer.parseInt(data[10]),Integer.parseInt(data[11])};
        //create staff object
        Competitor comp = null;
        if (data[4].trim().equals("Ice Skater"))
            comp = new IceSkater(data[0], data[1], data[2], Integer.parseInt(data[3]), data[5], data[6]);
        if (data[4].trim().equals("YLCompetitor"))
            comp = new YLCompetitor(data[0], data[1], data[2], Integer.parseInt(data[3]), data[5], data[6]);
        comp.addScores(scores);
        //add to list
        entries.addCompetitor(comp);
    }


    public boolean checkField(String name, String age, String country){
        if (name.isEmpty() || age.isEmpty() || country.isEmpty()){
            System.out.println("error");
            return false;
        }
        return true;
    }

    private void showGUI() {
        CompetitorListGUI gui = new CompetitorListGUI(entries);
        gui.setVisible(true);

    }

    public static void main(String[] args) {

        MainAppManager demo = new MainAppManager();
        demo.showGUI();
        new MainFrameManager();


    }


}
