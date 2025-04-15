
import java.util.HashMap;

public class maps {
    public static void main(String[] args) {
        HashMap<String, Integer> empIds = new HashMap<>();
        empIds.put("John", 12345);
        empIds.put("Carl", 54321);
        empIds.put("Jerry", 8675309);

        System.out.println("Printing the map: ");
        System.out.println(empIds + "\n");

        System.out.println("Getting the value associated with the key 'Carl': ");
        System.out.println(empIds.get("Carl") + "\n"); // prints the value associated with the key "Carl"

        System.out.println("Checking if a key exists in the map: ");
        System.out.println("Jerry: " + empIds.containsKey("Jerry")); // checks if the key "Jerry" exists in the map - returns true
        System.out.println("George: " + empIds.containsKey("George") + "\n"); // checks if the key "George" exists in the map - returns false

        System.out.println("Checking if a value exists in the map: ");
        System.out.println("12345" + empIds.containsValue(12345)); // checks if the value 12345 exists in the map - returns true
        System.out.println("99999" + empIds.containsValue(99999) + "\n"); // checks if the value 99999 exists in the map - returns false

        System.out.println("Putting a new key-value pair in the map, overriding John: ");
        empIds.put("John", 98765); // updates the value associated with the key "John"
        System.out.println(empIds + "\n");

        System.out.println("Replacing the value associated with a key: ");
        System.out.println("John, 777");
        empIds.replace("John", 777); // replaces the value associated with the key "John" with 777
        System.out.println(empIds);

        System.out.println("Kramer, 1924 : This will not change the map since Kramer is not a key in the map");
        empIds.replace("Kramer", 1924); // tries to replace the value associated with the key "Kramer" with 1924
        System.out.println(empIds + "\n"); // prints the map - no change since "Kramer" is not a key in the map

        System.out.println("Putting a new key-value pair in the map, if the key does not exist: ");
        System.out.println("tries to add the key 'John' with value 1234 if it doesn't exist : it will not change the map since John already exists");
        empIds.putIfAbsent("John", 1234); // tries to add the key "John" with value 1234 if it doesn't exist
        System.out.println(empIds); // prints the map - no change since "John" already exists
        System.out.println("tries to add the key 'Kramer' with value 1924 if it doesn't exist : it will change the map since Kramer does not exist");
        empIds.putIfAbsent("Kramer", 1924); // adds the key "Kramer" with value 1924 if it doesn't exist
        System.out.println(empIds + "\n");

        System.out.println("Removing a key-value pair from the map: ");
        empIds.remove("Carl"); // removes the key "Carl" and its associated value from the map
        System.out.println(empIds);
    }
}