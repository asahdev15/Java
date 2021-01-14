package java8.streams;

import java.io.File;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {

    public static void main(String[] args) {

        sequentialParallelStream();

    }

    private static void basic() {
        List<String> list = Arrays.asList("1", "2", "3");
        Stream<String> stream = list.stream();

        String[] strs = {"1", "2", "3"};
        Stream<String> stream2 = Arrays.stream(strs);

        int[] ints = {1, 2, 3};
        IntStream stream3 = Arrays.stream(ints);
    }

    private static void listFiles() {
        File fileDir = new File("/Users/asahdev/Work/Test/Java/src/main/java/java8/streams");
        List<String> allDirNames = new ArrayList<>();
        for (File file : fileDir.listFiles()) {
            if(file.isDirectory()){
                allDirNames.add(file.getName());
            }
        }
        System.out.println(allDirNames);
        List<String> allDirNames2 =
                Arrays.stream(fileDir.listFiles())
                        .filter(File::isDirectory)
                        .map(File::getName)
                        .collect(Collectors.toList());
        System.out.println(allDirNames2);
    }

    private static void sequentialParallelStream() {
        String[] strings = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        System.out.println("-------\nRunning sequential\n-------");
        run(Arrays.stream(strings).sequential());

        System.out.println("-------\nRunning parallel\n-------");
        run(Arrays.stream(strings).parallel());
    }

    private static void run (Stream<String> stream) {
        long startTime = System.currentTimeMillis();
        stream.forEach(s -> {
            System.out.println(LocalTime.now() + " - value: " + s + " - thread: " + Thread.currentThread().getName());
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("TimeTaken : "+ (System.currentTimeMillis() - startTime));
    }

    private static void allIntegersLessThan10() {
        List<Integer> list = Arrays.asList(3, 2, 12, 5, 6, 11, 13);
        boolean b = true;
        for (Integer i : list) {
            if (i >= 10) {
                b = false;
                break;
            }
        }
        System.out.println(b);
        System.out.println("-------------------");
        b = list.stream()
                .allMatch(i -> i < 10);
        System.out.println(b);
    }

    private static void sumAllEvenNumbers() {
        List<Integer> list = Arrays.asList(3, 2, 12, 5, 6, 11, 13);
        int sum = 0;
        for (Integer i : list) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        System.out.println(sum);
        System.out.println("-------------------");
        sum = list.stream()
                .filter(i -> i % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(sum);
        System.out.println("-------------------");
        sum = list.stream()
                .filter(i -> i % 2 == 0)
                .reduce(0, (i, c) -> i + c);
        System.out.println(sum);
    }

    private static void printEvenNumbers() {
        List<Integer> list = Arrays.asList(3, 2, 12, 5, 6, 11, 13);
        List<Integer> evenList = new ArrayList<>();
        for (Integer i : list) {
            if (i % 2 == 0) {
                evenList.add(i);
            }
        }
        System.out.println(evenList);

        System.out.println("-------------------");
        evenList = list.stream()
                        .filter(i -> i % 2 == 0)
                        .collect(Collectors.toList());
        System.out.println(evenList);
        System.out.println("-------------------");
        list.stream()
                .filter(i -> i % 2 == 0)
                .forEach(System.out::println);
    }

    private static void countEvenNumbers() {
        List<Integer> list = Arrays.asList(3, 2, 12, 5, 6, 11, 13);
        long count = 0;
        for (Integer i : list) {
            if (i % 2 == 0) {
                count++;
            }
        }
        System.out.println(count);
        System.out.println("-------------------");
        count = list.stream()
                .filter(i -> i % 2 == 0)
                .count();
        System.out.println(count);
    }

    private static void iterationSimple() {
        List<String> list = Arrays.asList("Apple", "Orange", "Banana");
        System.out.println("-------------------");
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println("-------------------");
        //using lambda expression
        list.forEach(s -> System.out.println(s));
        System.out.println("-------------------");
        //or using method reference on System.out instance
        list.forEach(System.out::println);
    }


    // Topics

    private List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("1", "Topic 1", "Topic 1 Desc"),
            new Topic("2", "Topic 2", "Topic 2 Desc"),
            new Topic("3", "Topic 3", "Topic 3 Desc")));

    public void addTopic(Topic topic) {
        topics.add(topic);
    }

    public Topic getTopic(String id) {
        return topics.stream().filter(topic -> topic.getId().equals(id)).findFirst().get();
    }

    public void updateTopic(String id, Topic topic) {
        for (int i = 0; i < topics.size(); i++) {
            if (topics.get(i).getId().equals(id)) {
                topics.set(i, topic);
            }
        }
    }

    public void deleteTopic(String id) {
        topics.removeIf(topic -> topic.getId().equals(id));
    }

    private class Topic {

        public String id;
        public String name;
        public String description;

        public Topic() {
        }

        public Topic(String id, String name, String description) {
            this.id = id;
            this.name = name;
            this.description = description;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

    }
}
