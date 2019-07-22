package practicecourt.java8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Learn1 {
    public static void main(String[] args) {
        Food food1 = new Food(111, "aaaa", "001");
        Food food2 = new Food(22, "bb", "004");
        Food food3 = new Food(113, "ccc", "002");
        Food food4 = new Food(178, "dddddddd", "004");
        Food food5 = new Food(100, "e", "003");
        List<Food> list = new ArrayList<Food>();
        list.add(food1);
        list.add(food2);
        list.add(food3);
        list.add(food4);
        list.add(food5);

        List<String> filterAndSortedList = list.parallelStream().filter(item -> item.getCalories() > 50)
            .sorted(Comparator.comparing(Food::getCalories).reversed()).map(item -> item.getName())
            .collect(Collectors.toList());

        System.out.println(filterAndSortedList);

        Map<String, List<Food>> groupByFoodGroupCode = list.stream().collect(Collectors.groupingBy(Food::getGroupCode));
        System.out.println(groupByFoodGroupCode);

        Stream<Food> stream = list.stream();
        stream.map(item -> item.getName()).forEach(item -> System.out.println(item));
        // stream 只能消费一次，必须重新获取流
        // stream.map(item -> item.getName()).forEach(System.out::println);

        Stream<Food> stream1 = list.stream();
        List<Integer> lengthList = stream1.map(item -> item.getName()).map(String::length).collect(Collectors.toList());
        System.out.println(lengthList);

        List<String> strs = new ArrayList();
        strs.add("Hello");
        strs.add("World");
        List<String> wordList =
            strs.stream().map(item -> item.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList());
        System.out.println(wordList);

        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(3);
        integerList.add(4);
        integerList.add(10);
        integerList.add(11);

        List<Integer> squareList = integerList.stream().map(item -> item * item).collect(Collectors.toList());
        System.out.println(squareList);

    }
}

class Food {
    private Integer Calories;
    private String name;
    private String groupCode;

    public Food(Integer calories, String name, String groupCode) {
        Calories = calories;
        this.name = name;
        this.groupCode = groupCode;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCalories() {
        return Calories;
    }

    public void setCalories(Integer calories) {
        Calories = calories;
    }

    @Override
    public String toString() {
        return "Food{" + "Calories=" + Calories + ", name='" + name + '\'' + ", groupCode='" + groupCode + '\'' + '}';
    }
}
