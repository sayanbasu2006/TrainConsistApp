import java.util.*;
import java.util.stream.Collectors;

public class TrainApp {

    // Bogie class
    static class Bogie {
        String name;
        int capacity;

        public Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return name + " (" + capacity + ")";
        }
    }

    // ✅ Reusable method (VERY IMPORTANT)
    public static Map<String, List<Bogie>> groupBogies(List<Bogie> bogies) {
        return bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));
    }

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("Sleeper", 70));
        bogies.add(new Bogie("First Class", 40));

        // ✅ Use method
        Map<String, List<Bogie>> groupedBogies = groupBogies(bogies);

        System.out.println("\nGrouped Bogies:");
        groupedBogies.forEach((key, value) ->
                System.out.println(key + " -> " + value));
    }
}