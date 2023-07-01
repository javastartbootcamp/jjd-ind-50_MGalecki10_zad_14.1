import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    final static String FILE_NAME = "liczby.txt";
    public static void main(String[] args) {

        try {
            List<Integer> numbersList = readFile(FILE_NAME);
            Map<Integer, Integer> numbersAndQuantity = countNumbers(numbersList);
            printInfo(numbersAndQuantity);
        } catch (FileNotFoundException e) {
            System.out.println("Nie odnaleziono pliku");
        }
    }

    private static List<Integer> readFile(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        List<Integer> numbers = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            numbers.add(Integer.valueOf(line));
        }
        return numbers;
    }

    private static Map<Integer, Integer> countNumbers(List<Integer> numbers) {
        Map<Integer, Integer> numbersAndCounts = new TreeMap<>();
        for (int i = 0; i < numbers.size(); i++) {
            int count = 0;
            for (Integer number : numbers) {
                if (numbers.get(i).equals(number)) {
                    count++;
                }
            }
            numbersAndCounts.put(numbers.get(i), count);
        }
        return numbersAndCounts;
    }

    private static void printInfo(Map<Integer, Integer> numbersMap) {
        for (Map.Entry<Integer, Integer> numbersAndQuantity : numbersMap.entrySet()) {
            System.out.println(numbersAndQuantity.getKey() + " - liczba wystapień " + numbersAndQuantity.getValue());

        }
    }
}
