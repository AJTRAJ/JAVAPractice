package org.example;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamAPI {
    public static void main(String[] args){
        wordStartWith();
        secondLargest();
        CountWordOccurance();
        findDuplicate();
        findLongestString();
        partitionOddEven();
        CheckListSorted();
        firstNonRepeated();

    }
    private static void secondLargest()
    {
        int[] numbers = {5, 1, 4, 2, 9, 9, 7};

        // Find the second largest element
        Optional<Integer> secondLargest = Arrays.stream(numbers)
                .boxed()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();

        secondLargest.ifPresent(System.out::println); // Output: 7
    }
    private static void CountWordOccurance() {
        List<String> names = List.of(new String[]{"abc", "bwe","gsgs","sadgsag"});
        Map<String,Long> wordCount = names.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(wordCount);
    }
    private static void wordStartWith() {
        List<String> names = List.of(new String[]{"abc", "bwe","gsgs","sadgsag"});
        // Filtering Here we will filter the name which start with a
        List<String> filternames = names.stream().filter(name->name.startsWith("a")).collect(Collectors.toUnmodifiableList());
        System.out.println(filternames);
    }
    private static void findDuplicate() {
        List<Integer> values = Arrays.asList(1,3,5,6,8,4,5,2,3,1);
        Set<Integer> duplicate =values.stream().filter(n->Collections.frequency(values,n) >1).collect(Collectors.toSet());
        System.out.println(duplicate);
    }
    private static void findLongestString() {
        List<String> names = List.of(new String[]{"abc", "bwe","gsgs","sadgsag"});
        String longest =names.stream().max(Comparator.comparingInt(String::length)).orElse("");
        System.out.println(longest);
    }
    private static void partitionOddEven() {
        List<Integer> values = Arrays.asList(1,3,5,6,8,4,5,2,3,1);
        Map<Boolean,List<Integer>> part =values.stream().collect(Collectors.partitioningBy(i->i%2==0));
        System.out.println(part);
    }
    private static void CheckListSorted() {
        List<Integer> values = Arrays.asList(1,3,5,6,8,4,5,2,3,1);
        boolean allmatch = IntStream.range(0,values.size()-1).allMatch(i->values.get(i) <= values.get(i+1));
        System.out.println(allmatch);
    }
    private static void firstNonRepeated() {
        String str = "swiss";
        Optional<Character> value = str.chars().mapToObj(c-> (char) c).filter(ch->str.chars().filter(c->c==ch).count() ==1).findFirst();
        System.out.println(value);
    }
    private static void fibSeries() {
        Stream.iterate(new int[]{0, 1}, fib -> new int[]{fib[1], fib[0] + fib[1]})
                .limit(10)
                .map(fib -> fib[0])
                .forEach(System.out::print);
    }
    private static void mostFrequentElement() {
        List<String> items = Arrays.asList("a", "b", "c", "a", "b", "a");

        String mostFrequent = items.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("");

        System.out.println(mostFrequent); // Output: a
    }
    private static void reverseString(){
        String input = "streamapi";
        String reversed = new StringBuilder(input)
                .reverse()
                .chars()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());

        System.out.println(reversed); // Output: ipamraets
    }
    private static void LongestPlaindrom(){
        List<String> words = Arrays.asList("madam", "level", "world", "civic", "stream");

        String longestPalindrome = words.stream()
                .filter(word -> word.equals(new StringBuilder(word).reverse().toString()))
                .max(Comparator.comparingInt(String::length))
                .orElse("");

        System.out.println(longestPalindrome); // Output: madam
    }
    private static void findKthSmallest(){
        int[] arr = {3, 1, 4, 1, 5, 9, 2};
        int k = 3; // Find 3rd smallest

        OptionalInt kthSmallest = Arrays.stream(arr).sorted().distinct().skip(k - 1).findFirst();

        kthSmallest.ifPresent(System.out::println); // Output: 3
    }
    private static void removeDuplicate(){
        String input = "programming";
        String uniqueChars = input.chars()
                .distinct()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());

        System.out.println(uniqueChars); // Output: progamin
    }
    private static void mergeTwoList(){
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(3, 4, 5);

        List<Integer> mergedList = Stream.concat(list1.stream(), list2.stream())
                .distinct()
                .collect(Collectors.toList());

        System.out.println(mergedList); // Output: [1, 2, 3, 4, 5]
    }
    private static void convertMapToList(){
        Map<Integer, String> map = Map.of(1, "One", 2, "Two", 3, "Three");

        List<String> mapAsList = map.entrySet().stream()
                .map(entry -> entry.getKey() + "->" + entry.getValue())
                .collect(Collectors.toList());

        System.out.println(mapAsList);
// Output: [1->One, 2->Two, 3->Three]
    }
    private static void topNHighestNnumber(){
        int[] numbers = {10, 20, 30, 40, 50};
        int n = 3;

        List<Integer> topN = Arrays.stream(numbers)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .limit(n)
                .collect(Collectors.toList());

        System.out.println(topN); // Output: [50, 40, 30]
    }
    private static void commonElemnetinLists(){
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> list2 = Arrays.asList(3, 4, 5, 6);

        List<Integer> commonElements = list1.stream()
                .filter(list2::contains)
                .collect(Collectors.toList());

        System.out.println(commonElements); // Output: [3, 4]
    }
    private static void FindFactorial(){
        int number = 5;

        int factorial = IntStream.rangeClosed(1, number)
                .reduce(1, (a, b) -> a * b);

        System.out.println(factorial); // Output: 120
    }
    private static void FindrepeatingElement(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 2, 5);

        Optional<Integer> firstRepeating = numbers.stream()
                .filter(n -> Collections.frequency(numbers, n) > 1)
                .findFirst();

        firstRepeating.ifPresent(System.out::println); // Output: 2
    }
}
