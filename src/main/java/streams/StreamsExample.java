package streams;


import java8.data.Student;
import java8.data.StudentDataBase;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamsExample {

    public static void main(String[] args) {

        Predicate<Student> gradePredicate = student -> student.getGradeLevel()>=3;
        Predicate<Student> gpaPredicate = student -> student.getGradeLevel()>=3.9;

/*
        List<String> names = Arrays.asList("adam","dan","jenny");
        names.stream();
        names.parallelStream();
        StudentDataBase.getAllStudents().stream();
        StudentDataBase.getAllStudents().parallelStream();
*/


        Map<String,List<String>> studentMap = StudentDataBase.getAllStudents().stream(). //.parallelStream dont forger.
                filter(gpaPredicate) // Stream<Student>
                .collect(Collectors.toMap(Student::getName ,Student::getActivities ));

        System.out.println("studentMap  : " + studentMap);

        List<String> studentActivities = StudentDataBase.getAllStudents().
                stream() // Stream<Student>
                .map(Student::getActivities) //<Stream<List<Activites>>
                .flatMap(List::stream) //<Stream<String>
                .distinct() // removes duplicates
                .collect(Collectors.toList()); //collects it to a list.

        List<String> namesList = StudentDataBase.getAllStudents().
                stream() // Stream<Student>
                .peek((student -> {
                    System.out.println(student);
                }))
                .map(Student::getName) //<Stream<List<Activites>>
                .peek(System.out::println)
                .distinct() // removes duplicates
                .collect(Collectors.toList()); //collects it to a list.

        System.out.println("namesList  : " + namesList);


    }

    // public static void main2(String[] args) {
    //     List<String> values = new ArrayList("B","D","A","D","B");
    //     System.out.println(values.stream().collect(Collectors.toMap(i->i ,
    //                                                                 i-> values.stream().filter(i2 -> i2.equals(i)).count(),
    //                                                                 (a,b)->b)));
    // }

//    // Grouping people by gender
//    Map<Gender, List<Person>> peopleByGender = people.stream()
//            .collect(Collectors.groupingBy(
//                    Person::getGender,
//                    Collectors.toList()));
//    // Grouping person names by gender
//    Map<Gender, List<String>> nameByGender = people.stream()
//            .collect(Collectors.groupingBy(
//                    Person::getGender,
//                    Collectors.mapping(Person::getName, Collectors.toList())));
//    // Grouping average age by gender
//    Map<Gender, Double> averageAgeByGender = people.stream()
//            .collect(Collectors.groupingBy(
//                    Person::getGender,
//                    Collectors.averagingInt(Person::getAge)
//            ));



//// calculating sum using reduce terminal operator
//people.stream()
//        .mapToInt(Person::getAge)
//    .reduce(0, (total, currentValue) -> total + currentValue);
//// calculating sum using sum terminal operator
//people.stream()
//        .mapToInt(Person::getAge)
//    .sum();
//// calculating count using count terminal operator
//people.stream()
//        .mapToInt(Person::getAge)
//    .count();
//    // calculating summary
//    IntSummaryStatistics ageStatistics = people.stream()
//            .mapToInt(Person::getAge)
//            .summaryStatistics();
//ageStatistics.getAverage();
//ageStatistics.getCount();
//ageStatistics.getMax();
//ageStatistics.getMin();
//ageStatistics.getSum();

//    List<Person> peopleSortedEldestToYoungest = people.stream()
//            .sorted(Comparator.comparing(Person::getAge).reversed())
//            .collect(Collectors.toList());
//

//    // searching for a element
//    Optional<Person> any = people.stream()
//            .filter(person -> person.getAge() < 20)
//            .findAny();
//
//    // searching for existence
//    boolean isAnyOneInGroupLessThan20Years = people.stream()
//            .anyMatch(person -> person.getAge() < 20);


//    // filtering using Predicate
//    List<Person> listOfPeopleBelow20 = people.stream()
//            .filter(person -> person.getAge() < 20)
//            .collect(Collectors.toList());
//    // count based filtering
//    List<Person> smallerListOfPeople = people.stream()
//            .skip(2)
//            .limit(10)
//            .collect(Collectors.toList());


//    List<String> namesOfPeople = people.stream()
//            .map(Person::getName)
//            .collect(Collectors.toList());
//}


//    List<Person> people = ...
//    // bulding a stream
//    List<String> namesOfPeopleBelow20 = people.stream()
//            // pipelining a computation
//            .filter(person -> person.getAge() < 20)
//            // pipelining another computation
//            .map(Person::getName)
//            // terminating a stream
//            .collect(Collectors.toList());

//    public class Person {
//        private final String name;
//        private final int age;
//        private final Gender gender;
//        public Person(String name, int age, Gender gender) {
//            this.name = name;
//            this.age = age;
//            this.gender = gender;
//        }
//        public String getName() { return name; }
//        public int getAge() { return age; }
//        public Gender getGender() { return gender; }
//    }
//    public enum Gender {
//        MALE, FEMALE, OTHER
//    }


}
