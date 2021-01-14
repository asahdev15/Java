package xdatastructures.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KeyPhraseProblem {
    public static void main(String[] args) {
        String text = "In prior versions of Java, " +
                "we have been inlining custom code or custom functionality by wrapping it inside an anonymous class. " +
                "Java 8 Lambda expression is a way to inline that functionality without creating anonymous class. " +
                "Now we are able to pass plain method/functionality as arguments. " +
                "In last topic, we saw how to write Lambda Lambda expressions. " +
                "Here we are going discuss what they are compiled to and how they get executed during runtime";
        List<String> conjuctionList = Arrays.asList(new String[]{"a","in","of",",","we","have","been","or","by", "it", "an", ".", "is", "are", "to", "to", "as" });
        Map<String, Integer> wordsFrequency = new HashMap<String, Integer>();
        Arrays.stream(text.replace("/"," ").split(" "))
                .filter(item->{
                    String key = item.trim().toLowerCase().replace(",","").replace(".","");
                    return !conjuctionList.contains(key);
                })
                .forEach(item->{
                    String key = item.trim().toLowerCase().replace(",","").replace(".","");
                    if(wordsFrequency.containsKey(key)){
                        wordsFrequency.put(key,1+wordsFrequency.get(key));
                    }else{
                        wordsFrequency.put(key,1);
                    }
                });

        int maxFrequency = wordsFrequency.values().stream().max((o1, o2)->o1.compareTo(o2)).get();
        System.out.println(maxFrequency);
        wordsFrequency.forEach((key,value)->{
            if(value==maxFrequency){
                System.out.println(key+"-"+value);
            }
        });




    }
}
