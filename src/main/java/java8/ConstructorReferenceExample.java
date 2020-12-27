package java8;


import java8.data.Student;

import java.util.function.Function;
import java.util.function.Supplier;

public class ConstructorReferenceExample {

    public static void main(String[] args) {
        System.out.println(studentSupplier.get());
        System.out.println(studentFunction.apply("Client123"));
    }

    static Supplier<Student> studentSupplier = Student::new;
    static Function<String, Student> studentFunction = Student::new;

}
