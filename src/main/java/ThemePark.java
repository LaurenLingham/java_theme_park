import attractions.Attraction;
import behaviours.IReviewed;
import behaviours.ISecurity;
import people.Visitor;

import java.util.ArrayList;
import java.util.HashMap;

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

    public HashMap<String, Integer> getAllReviews() {
        HashMap<String, Integer> reviews = new HashMap<>();

        for (IReviewed feature : parkFeatures) {
            reviews.put(feature.getName(), feature.getRating());
        }

        return reviews;
    }

    public ArrayList<IReviewed> getAllAllowedFor(Visitor visitor) {
        ArrayList<IReviewed> allowedFeatures = new ArrayList<>();

        for (IReviewed feature : parkFeatures) {
            if (feature instanceof ISecurity) {
                if (((ISecurity) feature).isAllowedTo(visitor)) {
                    allowedFeatures.add(feature);
                }
            }
            else {
                allowedFeatures.add(feature);
            }
        }

        return allowedFeatures;
    }
}
