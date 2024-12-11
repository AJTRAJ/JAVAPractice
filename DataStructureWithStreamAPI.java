package org.example;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Stream;

public class DataStructureWithStreamAPI {
    public static void main(String[] args){
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(10, 20, 30, 40, 50));
        findMiddleElement(list);
        mergeTwoList();
    }
    private static void findMiddleElement(List list){
        int middleElement = (int) list.stream().skip((list.size()-1)/2).findFirst().orElseThrow();
        System.out.println(middleElement);
    }
    private static void mergeTwoList(){
        List<Integer> list1 = Arrays.asList(1,3,5);
        List<Integer> list2 = Arrays.asList(5,4,3);
        List<Integer> list3 = Stream.concat(list1.stream(),list2.stream()).sorted().toList();
        System.out.println(list3);
    }
    private static void balancedParenthesis(){
        String input = "(()[{}])";

        boolean isBalanced = input.chars()
                .filter(ch -> "()[]{}".indexOf(ch) != -1)
                .mapToObj(ch -> (char) ch)
                .reduce(new Stack<Character>(), (stack, ch) -> {
                    if ("({[".indexOf(ch) >= 0) stack.push(ch);
                    else if (!stack.isEmpty() && "([{".indexOf(stack.peek()) == ")]}".indexOf(ch)) stack.pop();
                    else stack.push(ch);
                    return stack;
                }, (s1, s2) -> s1)
                .isEmpty();

        System.out.println(isBalanced); // Output: true
    }

    
}
