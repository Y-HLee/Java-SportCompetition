package ModelComp;

public class Category {
    private String name;
    private String level;

    private int ageLimit;

    public Category(String name, String level, int ageLimit ) {
        this.name = name;
        this.level = level;
        this.ageLimit = ageLimit;
    }

    //implement set age limit to a category
    public boolean checkAge(Competitor competitor){
        return competitor.getAge() ==  ageLimit;
    }

    public boolean hasAccess(Competitor competitor){
        return competitor.getLevel().equals(level);
    }

}
