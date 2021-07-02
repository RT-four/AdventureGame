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

        Map<String, Integer> tempExit = new HashMap<>();
        locations.put(0, new Location(0, "U r learning Java", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("W", 2);
        tempExit.put("E", 3);
        tempExit.put("S", 4);
        tempExit.put("N", 5);
        locations.put(1, new Location(1, "U r on the road before building", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("N", 5);
        locations.put(2, new Location(2, "U r at the top of a hill", tempExit));


        tempExit = new HashMap<>();
        tempExit.put("W", 1);
        locations.put(3, new Location(3, "U r inside a building", tempExit));


        tempExit = new HashMap<>();
        tempExit.put("N", 1);
        tempExit.put("W", 2);
        locations.put(4, new Location(4, "U r beside a stream", tempExit));


        tempExit = new HashMap<>();
        tempExit.put("S", 1);
        tempExit.put("W", 2);
        locations.put(5, new Location(5, "U r in the forest", tempExit));


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
