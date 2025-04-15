
import java.util.HashMap;

public class maps {
    public static void main(String[] args) {
        HashMap<String, Integer> empIds = new HashMap<>();
        empIds.put("John", 12345);
        empIds.put("Carl", 54321);
        empIds.put("Jerry", 8675309);

        System.out.println(empIds); // prints the entire map

        System.out.println(empIds.get("Carl")); // prints the value associated with the key "Carl"

        System.out.println(empIds.containsKey("Jerry")); // checks if the key "Jerry" exists in the map - returns true
        System.out.println(empIds.containsKey("George")); // checks if the key "George" exists in the map - returns false

        System.out.println(empIds.containsValue(12345)); // checks if the value 12345 exists in the map - returns true
        System.out.println(empIds.containsValue(99999)); // checks if the value 99999 exists in the map - returns false

        empIds.put("John", 98765); // updates the value associated with the key "John"
        System.out.println(empIds);

        empIds.replace("John", 777); // replaces the value associated with the key "John" with 777
        System.out.println(empIds);

        empIds.replace("Kramer", 1924); // tries to replace the value associated with the key "Kramer" with 1924
        System.out.println(empIds); // prints the map - no change since "Kramer" is not a key in the map

        empIds.putIfAbsent("John", 1234); // tries to add the key "John" with value 1234 if it doesn't exist
        System.out.println(empIds); // prints the map - no change since "John" already exists
        empIds.putIfAbsent("Kramer", 1924); // adds the key "Kramer" with value 1924 if it doesn't exist
        System.out.println(empIds);

        empIds.remove("Carl"); // removes the key "Carl" and its associated value from the map
        System.out.println(empIds);
    }
}