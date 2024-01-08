package ModelComp.Comparators;

import ModelComp.Competitor;

import java.util.Comparator;
import java.util.Objects;

public class CompetitorIdComparator implements Comparator<Competitor> {

    @Override
    public int compare(Competitor c1, Competitor c2) {
        Integer comp1 = Integer.parseInt(c1.getId());
        Integer comp2 = Integer.parseInt(c2.getId());
        return comp1.compareTo(comp2);
    }
}
