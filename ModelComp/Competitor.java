package ModelComp;

import java.io.Serializable;

public class Competitor implements Comparable<Competitor>, Serializable {

    private String id;
    private String name;
    private String email;
    private int age;
    private String level;
    private String country;
    private String category;


    public Competitor(String id,String name, String email, int age, String level, String country){

        if( name == null || id.trim().length() == 0 || email == null)
        {
            throw new IllegalStateException(
                    "Cannot have blank id or name or email");
        }

        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.level = level;
        this.country = country;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void addScore(int score) {};
    public void addScores(int[] scoreArray){};
    public String scoresToString(){
        return null;
    }

    public String getShortDetails(){
        return "CN " + id +
                "(" + getInitials() + ")" ;
    }

    //write a function which check age limit when adding a competitor


    //write a check weight function and write the weight in the derived sub class
    public double checkWeight(){
        if (getLevel().equals("Beginner")){
            return 0.5;
        }
        if (getLevel().equals("Intermediate")){
            return 0.8;
        }
        if (getLevel().equals("Professional")){
            return 1;
        }
        return 0;
    }

    public String getInitials() {
        String[] namesSeparately = name.split(" ");
        StringBuilder initials = new StringBuilder();
        for (String name : namesSeparately) {
            initials.append(name.charAt(0));
        }
        return initials.toString();
    }


    public String getFullDetails() {
        return "Competitor{" +
                "Competitor number " + id +
                ", name " + name +
                ", country " + country +
                ", competitor is a " + level +
                ", age " + age +
                ", category " + category ;
    }

    @Override
    public int compareTo(Competitor c) {
        return id.compareTo(c.getId());
    }

    @Override
    public String toString() {
        return id + "," + name + "," + email + "," + age + "," + category + ',' + level + "," + country;
    }
    public String toStringtoGUI()
    {
        return String.format("%-5s", id ) + String.format("%-20s", name ) + String.format("%-5s", age) + String.format("%-15s", category) + String.format("%-20s", level) + String.format("%-12s", country);
    }
}
