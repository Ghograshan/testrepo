import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalClass {
    public static void main(String[] args) {
        Integer numara = null;

        Optional<Integer> opt = Optional.ofNullable(numara);

        opt.ifPresent(num -> {
            double karesi = Math.pow(num , 2);
            System.out.println("Sonuc: " + karesi);
        });

        opt.map( num -> Math.pow(num, 2)).ifPresent(System.out::println);

        String message = "Test Message";

        Optional<String> opt2 = Optional.ofNullable(message);
        opt2.filter(m -> m.length() >= 10).ifPresent(System.out::println);




        List<String> names = Arrays.asList("Ali","Veli","Selami");

        Optional<List<String>> opt3 = Optional.ofNullable(names);

        names = opt3.orElseGet(ArrayList::new);
        System.out.println(names);

        String name = null;
        String test = Optional.ofNullable(name).orElse("Test");
        System.out.println(test);




    }
}
