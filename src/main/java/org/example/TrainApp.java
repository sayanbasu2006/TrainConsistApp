import java.util.*;
import java.util.stream.*;

public class TrainApp {

    // ✅ Goods Bogie class
    static class GoodsBogie {
        String type;   // Cylindrical, Open, Box
        String cargo;  // Petroleum, Coal, Grain

        public GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }

        @Override
        public String toString() {
            return type + " (" + cargo + ")";
        }
    }

    // ✅ UC12: Safety validation using allMatch()
    public static boolean isTrainSafe(List<GoodsBogie> bogies) {
        return bogies.stream()
                .allMatch(b ->
                        // Rule: Cylindrical → only Petroleum
                        !b.type.equalsIgnoreCase("Cylindrical") ||
                                b.cargo.equalsIgnoreCase("Petroleum")
                );
    }

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // Step 1: Create goods bogies
        List<GoodsBogie> bogies = new ArrayList<>();
        bogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        bogies.add(new GoodsBogie("Open", "Coal"));
        bogies.add(new GoodsBogie("Box", "Grain"));

        // Step 2: Display bogies
        System.out.println("\nGoods Bogies:");
        bogies.forEach(System.out::println);

        // Step 3: Safety validation
        boolean isSafe = isTrainSafe(bogies);

        // Step 4: Result
        System.out.println("\nSafety Compliance Status: "
                + (isSafe ? "SAFE ✅" : "UNSAFE ❌"));
    }
}