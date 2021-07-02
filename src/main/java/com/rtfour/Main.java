package com.rtfour;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Map<Integer, Location> locations = new HashMap<>();
    private static final Map<String, String> keyWords = new HashMap<>();

    public static void main(String[] args) {
        keyWords.put("WEST", "W");
        keyWords.put("EAST", "E");
        keyWords.put("SOUTH", "S");
        keyWords.put("NORTH", "N");

        Scanner scanner = new Scanner(System.in);

        locations.put(0, new Location(0, "U r learning Java"));
        locations.put(1, new Location(1, "U r on the road before building"));
        locations.put(2, new Location(2, "U r at the top of a hill"));
        locations.put(3, new Location(3, "U r inside a building"));
        locations.put(4, new Location(4, "U r beside a stream"));
        locations.put(5, new Location(5, "U r in the forest"));

        locations.get(1).addExit("W", 2);
        locations.get(1).addExit("E", 3);
        locations.get(1).addExit("S", 4);
        locations.get(1).addExit("N", 5);

        locations.get(2).addExit("N", 5);

        locations.get(3).addExit("W", 1);

        locations.get(4).addExit("N", 1);
        locations.get(4).addExit("W", 2);

        locations.get(5).addExit("S", 1);
        locations.get(5).addExit("W", 2);

        int loc = 1;
        boolean success = false;
        while (true) {

            System.out.println(locations.get(loc).getDescription());

            if (loc == 0) {
                break;
            }

            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.println("Available exits are: ");
            for (String exit : exits.keySet()) {
                System.out.print(exit + ", ");
            }
            System.out.println();

            String direction = scanner.nextLine().toUpperCase();

            if (exits.containsKey(direction)) {
                loc = exits.get(direction);
                success = true;
            } else {
                for (String word : direction.split(" ")) {
                    String key = keyWords.get(word.toUpperCase());
                    if (exits.containsKey(key)) {
                        loc = exits.get(key);
                        success = true;
                        break;
                    }
                }
            }

            if (success == false) {
                System.out.println("U cannot go to this direction");
            }
        }
    }
}
