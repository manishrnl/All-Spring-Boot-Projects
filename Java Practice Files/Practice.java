import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Practice {
    public static void main(String[] args) {
        System.out.println("Radhe Radhe");
        List<String> fruits = List.of("Mango", "Apple", "Banana", "Kiwi", "Orange", "Pine Apple",
                "Litchi");
        Map<String,Integer> streamedFruits = fruits.stream()
                .sorted()
                .collect(Collectors.toMap(
                        value->value,
                        key->key.length()
                ));

        System.out.println(streamedFruits);

    }
}