import java.math.BigDecimal;
import java.util.Comparator;

public class CompareWithLambda {

    public static void main(String[] args) {
        Developer o1 = (new Developer("mkyong", new BigDecimal("70000"), 33));
        Developer o2 = (new Developer("alvin", new BigDecimal("60000"), 22));

        Comparator<Developer> byName = new Comparator<Developer>() {
            @Override
            public int compare(Developer o1, Developer o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };

        Comparator<Developer> byName1 = (Developer d1, Developer d2) -> d1.getName().compareTo(d2.getName());
    }
}
