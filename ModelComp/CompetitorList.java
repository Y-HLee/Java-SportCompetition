package ModelComp;

import ModelComp.Comparators.CompetitorIdComparator;
import ModelComp.Comparators.CompetitorNameComparator;

import java.io.*;
        import java.util.*;

public class CompetitorList {
    private ArrayList<Competitor> competitorList;
    Random random = new Random();

    public CompetitorList() {
        competitorList = new ArrayList<>();
    }

    public Competitor getByIndex(int n) {
        return competitorList.get(n);
    }
    public int getNumberOfEntries()
    {
        return competitorList.size();
    }
    public void removeCompetitor(Competitor competitor){
        competitorList.remove(competitor);
    }
    public ArrayList<Competitor> getCompetitorList(){
        return competitorList;
    }

    public void addCompetitor(Competitor competitor) { //run checks before ADDDING!!!!!!!!!!!!!!!!!!!
        competitorList.add(competitor);
    }

    public String generateId() {
        String newId = null;
        do {
            newId = String.valueOf(random.nextInt(101));
        }
        while (idExists(newId));
        return newId;
    }

    private boolean idExists(String id) {
        for (Competitor c : competitorList) {
            if (c.getId().equals(id))
                return true;
        }
        return false;
    }

    public void saveCompetitor(File file) {
        try {
            Competitor competitor;
            String save_data = "";

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            int i = 0;
            while (i < competitorList.size()) {
                competitor = competitorList.get(i);
                save_data = competitor.getId() + ',' + competitor.getName() + ',' + competitor.getEmail() +
                        ',' + competitor.getAge() + ',' + competitor.getLevel() + ',' + competitor.getCountry() + ',' + competitor.getCategory();
                i++;
            }
            bufferedWriter.write(save_data);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object[] loadCompetitor(File file) {
        Object[] objects;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            // each lines to array
            objects = bufferedReader.lines().toArray();
            bufferedReader.close();
            return objects;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void saveToFile(){
        BufferedWriter buff = null;
        try {
            buff = new BufferedWriter(new FileWriter("RunCompetitor.csv"));
            for (Competitor competitor : competitorList){
                buff.write(competitor.toString());
                buff.newLine();
            }
            buff.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public Competitor findById(String id) {
        for (Competitor competitor : competitorList) {
            if (competitor.getId().equals(id)) {
                return competitor;
            }
        }
        return null;
    }

    public String listDetails() {
        StringBuffer allEntries = new StringBuffer();
        for (Competitor details : competitorList) {
            allEntries.append(details.toStringtoGUI());
            allEntries.append('\n');
        }
        return allEntries.toString();
    }


    public Object[] orderByComparator(Comparator<Competitor> competitorComparator) {
        ArrayList<Competitor> copyOfCompetitors = new ArrayList<>(competitorList);
        copyOfCompetitors.sort(competitorComparator);
        return copyOfCompetitors.toArray(Competitor[]::new);
    }

    public Object[] orderById() {
        CompetitorIdComparator comparator = new CompetitorIdComparator();
        return orderByComparator(comparator);
    }

    public Object[] orderByName() {
        CompetitorNameComparator comparator = new CompetitorNameComparator();
        return orderByComparator(comparator);
    }

    public String listByName() {
        Collections.sort(competitorList, new CompetitorNameComparator());
        return listDetails();
    }

    public String listByID() {
        Collections.sort(competitorList);
        return listDetails();
    }
}



