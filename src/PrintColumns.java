import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintColumns {

    public static List<String> hasOne = new ArrayList<>();
    public static List<String> hasTwo = new ArrayList<>();
    public static List<String> hasThree = new ArrayList<>();
    public static List<String> hasFour = new ArrayList<>();

    public static Integer widthOne;
    public static Integer widthTwo;
    public static Integer widthThree;
    public static Integer widthFour;

    public static void main(String[] args) {
        List<String> numbers = Arrays.asList("111", "222", "33333", "44",
                "111111", "2222", "33", "4444",
                "111111", "222222222", "3", "444444",
                "11111111", "2", "3333", "444");

        splitValuesByColumns(numbers);

        widthOne = maxValueInRow(hasOne);
        widthTwo = maxValueInRow(hasTwo);
        widthThree = maxValueInRow(hasThree);
        widthFour = maxValueInRow(hasFour);

        printColumns(4, numbers);
    }

    public static void splitValuesByColumns(List<String> numbers) {
        for (String number : numbers) {
            if (number.contains("1")) {
                hasOne.add(number);
            }
            if (number.contains("2")) {
                hasTwo.add(number);
            }
            if (number.contains("3")) {
                hasThree.add(number);
            }
            if (number.contains("4")) {
                hasFour.add(number);
            }
        }
    }

    public static Integer maxValueInRow(List<String> values) {
        return values.stream().map(String::length).max(Integer::compareTo).get();
    }

    public static void printColumns(int columns, List<String> numbers) {
        String pattern = "%-<:widthOne:>s %-<:widthTwo:>s %-<:widthThree:>s %-<:widthFour:>s";
        String template = createTemplate(pattern);

        for (int i = 0; i < columns; i++) {
            System.out.printf(template, hasOne.get(i), hasTwo.get(i), hasThree.get(i), hasFour.get(i));
            System.out.println();
        }
    }

    public static String createTemplate(String pattern) {
        return pattern.
                replace("<:widthOne:>", widthOne.toString()).
                replace("<:widthTwo:>", widthTwo.toString()).
                replace("<:widthThree:>", widthThree.toString()).
                replace("<:widthFour:>", widthFour.toString());
    }
}
