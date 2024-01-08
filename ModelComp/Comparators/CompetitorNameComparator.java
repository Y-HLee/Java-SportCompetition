package ModelComp.Comparators;

import ModelComp.Competitor;

import java.util.Comparator;
public class CompetitorNameComparator implements Comparator<Competitor> {
    public int compare(Competitor c1, Competitor c2) {
        return c1.getName().compareTo(c2.getName());
    }
}
