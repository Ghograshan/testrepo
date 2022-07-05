import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortWithLambda {
    public static void main(String[] args) {

        List<Developer> listDevs = getDevelopers();

        System.out.println("Before Sort");
        for (Developer developer : listDevs)
            System.out.println(developer);

        //Sort by age
        listDevs.sort(new Comparator<Developer>() {
            @Override
            public int compare(Developer o1, Developer o2) {
                return o1.getAge() - o2.getAge();
            }
        });

        System.out.println("After Sort");
        for (Developer developer : listDevs)
            System.out.println(developer);

        //age
        listDevs.sort((Developer o1, Developer o2) -> o1.getAge()-o2.getAge());

        //name
        listDevs.sort(new Comparator<Developer>() {
            @Override
            public int compare(Developer o1, Developer o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        listDevs.sort((Developer o1, Developer o2) -> o1.getName().compareTo(o2.getName()));

        //salary
        listDevs.sort(new Comparator<Developer>() {
            @Override
            public int compare(Developer o1, Developer o2) {
                return o1.getSalary().compareTo(o2.getSalary());
            }
        });
        listDevs.sort((Developer o1, Developer o2) -> o1.getSalary().compareTo(o2.getSalary()));

        //reverse sort
        Comparator<Developer> salaryComparator = (Developer o1, Developer o2) -> o1.getSalary().compareTo(o2.getSalary());
        listDevs.sort(salaryComparator.reversed());

    }

    private static List<Developer> getDevelopers() {

        List<Developer> result = new ArrayList<Developer>();

        result.add(new Developer("mkyong", new BigDecimal("70000"), 33));
        result.add(new Developer("alvin", new BigDecimal("80000"), 20));
        result.add(new Developer("jason", new BigDecimal("100000"), 10));
        result.add(new Developer("iris", new BigDecimal("170000"), 55));

        return result;

    }

}
