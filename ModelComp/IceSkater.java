package ModelComp;

import java.io.Serializable;
import java.util.Arrays;

public class IceSkater extends Competitor{

    private int[] scoreArray;

    private int counter;
    public IceSkater(String id, String name, String email, int age, String level, String country) {
        super(id, name, email, age, level, country);
        this.scoreArray = new int[5];
        counter = 0;
        super.setCategory("Ice Skater");
    }
    public int[] getScoreArray() {
        return scoreArray;
    }

    @Override
    public void addScore(int score) {
        if (counter < 5) {
            scoreArray[counter] = score;
            counter++;
        }
        else System.out.println("Limit reached");
    }
    public void addScores(int[] scoreArr) {
        for (int i = 0; i < scoreArr.length; i++) {
            scoreArray[counter] = scoreArr[i];
            counter++;
        }
    }
    public String scoresToString(){
        return Arrays.toString(getScoreArray());
    }

    public double getOverallScore(){
        double result = 0;
        for (int score : scoreArray){
            result += score;
        }
        return (result * checkWeight()) / scoreArray.length;
    }

    @Override
    public String getShortDetails() {
        return  super.getShortDetails() +
                " overall score is " + getOverallScore();
    }


    @Override
    public String getFullDetails() {
        return super.getFullDetails() +
                ", scoreList=" + Arrays.toString(scoreArray) +
                ", this gives an overall score of " + getOverallScore() +
                '}';
    }

    @Override
    public String toString() {
        return super.toString() + "," + scoreArray[0] + "," + scoreArray[1]
                                + "," + scoreArray[2] + "," + scoreArray[3]
                                + "," + scoreArray[4];
    }

    @Override
    public String toStringtoGUI()
    {
        return super.toStringtoGUI() + String.format("%-20s", scoresToString()) + String.format("%15s  %-5.2f", "OverScore:", getOverallScore());
    }

}
