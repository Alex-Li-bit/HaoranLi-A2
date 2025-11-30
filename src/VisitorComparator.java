import java.util.Comparator;

public class VisitorComparator implements Comparator<Visitor> {

    @Override
    public int compare(Visitor v1, Visitor v2) {
        // First compare by name
        int nameCompare = v1.getName().compareToIgnoreCase(v2.getName());
        if (nameCompare != 0) {
            return nameCompare;
        }

        // If names are equal, compare by age
        return Integer.compare(v1.getAge(), v2.getAge());
    }
}