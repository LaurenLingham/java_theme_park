import attractions.Attraction;
import behaviours.IReviewed;
import people.Visitor;

import java.util.ArrayList;

public class ThemePark {

    private ArrayList<IReviewed> parkFeatures;

    public ThemePark() {
        this.parkFeatures = new ArrayList<>();
    }

    public ArrayList<IReviewed> getAllReviewed() {
        return this.parkFeatures;
    }

    public void visit(Visitor visitor, Attraction attraction) {
        visitor.addAttraction(attraction);
        attraction.increaseVisits(visitor);
    }
}
