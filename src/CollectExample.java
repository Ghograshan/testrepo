import java.util.*;
import java.util.stream.Collectors;

class Person {
    private String firstname;
    private String lastname;
    private String gender;
    private Integer age;
    private Long birthday;

    public Person(String firstname, String lastname, String gender, Integer age, Long birthday) {
        super();
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.age = age;
        this.birthday = birthday;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getBirthday() {
        return birthday;
    }

    public void setBirthday(Long birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Person [firstname=" + firstname + ", lastname=" + lastname + ", gender=" + gender + ", age=" + age + ", birthday=" + birthday + "]";
    }

}

public class CollectExample {
    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
                new Person("alican", "akkuş", "male", 23, new Date().getTime() + new Random().nextInt()),
                new Person("mustafa", "demir", "male", 22, new Date().getTime() + new Random().nextInt()),
                new Person("enes", "açıkoğlu", "male", 25, new Date().getTime() + new Random().nextInt()),
                new Person("ilkay", "günel", "male", 23, new Date().getTime() + new Random().nextInt()),
                new Person("hatun", "hatun", "female", 29, new Date().getTime() + new Random().nextInt()));
        // streaming and pipeling sorting and then system out consuming
        // sorted by birthday, result will be different when different time
        // limit with 3
        // and collect (result of processing on the elements of a stream. )
//        List<Person> sortedAndLimitedPersons = persons.stream().sorted((p1, p2) -> p1.getBirthday().compareTo(p2.getBirthday())).limit(3)
//                .collect(Collectors.toList());
//        System.err.println("0. Print sorted and limited persons: ");
//        sortedAndLimitedPersons.forEach(System.out::println);
//
//        Map<String, List<Person>> groupByGenderList = persons.stream().collect(Collectors.groupingBy(Person::getGender));
//        // Group by gender List : Female-> Persons and Male -> Persons
//        System.err.println("1. Group persons by gender - get result in List: ");
//        System.out.println(groupByGenderList.toString());
//
//        Map<String, Optional<Person>> personByMaxAgeForEachGender = persons.stream().collect(
//                Collectors.groupingBy(Person::getGender, Collectors.maxBy(Comparator.comparing(Person::getAge))));
//        System.err.println("2. Group person objects by gender and get person with max age: ");
//        System.out.println(personByMaxAgeForEachGender.toString());

        // streaming and pipeling and then system out consuming
        // pring all person begingging with 'a'
//        persons.stream().filter(p -> p.getFirstname().startsWith("m")).forEach(System.out::println);
//
//        // streaming and pipeling and then system err consuming
//        // pring all person begingging with 'a'
//        // hatunları err'de yazdiralim :)
//        persons.stream().filter(p -> p.getGender().equalsIgnoreCase("female")).forEach(System.err::println);

        Map<String, IntSummaryStatistics> groupPersonsByAge = persons.stream().collect(
                Collectors.groupingBy(Person::getGender, Collectors.summarizingInt(Person::getAge)));
        System.err.println("0. Group person objects by gender and get age statistics: ");
        System.out.println(groupPersonsByAge.toString());
        IntSummaryStatistics malesAge = groupPersonsByAge.get("male");
        System.out.println("Avgerage male age:" + malesAge.getAverage());
        System.out.println("Max male age:" + malesAge.getMax());
        System.out.println("Min male age:" + malesAge.getMin());
    }
}
