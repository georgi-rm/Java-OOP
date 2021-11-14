package team;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Team> allTeams = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] commandData = input.split(";");
            String commandName = commandData[0];
            String teamName = commandData[1];
            switch (commandName) {
                case "Team":
                    try {
                        allTeams.put(teamName, new Team(teamName));
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "Add":
                    if (!allTeams.containsKey(teamName)) {
                        System.out.printf("Team %s does not exist.%n", teamName);
                        break;
                    }
                    String playerName = commandData[2];
                    int endurance = Integer.parseInt(commandData[3]);
                    int sprint = Integer.parseInt(commandData[4]);
                    int dribble = Integer.parseInt(commandData[5]);
                    int passing = Integer.parseInt(commandData[6]);
                    int shooting = Integer.parseInt(commandData[7]);

                    try {
                        Player newPlayer = new Player(playerName, endurance, sprint, dribble, passing, shooting);
                        allTeams.get(teamName).addPlayer(newPlayer);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "Remove":
                    if (!allTeams.containsKey(teamName)) {
                        System.out.printf("Team %s does not exist.%n", teamName);
                        break;
                    }
                    String playerToRemove = commandData[2];

                    try {
                        allTeams.get(teamName).removePlayer(playerToRemove);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "Rating":
                    if (!allTeams.containsKey(teamName)) {
                        System.out.printf("Team %s does not exist.%n", teamName);
                        break;
                    }

                    try {
                        System.out.printf("%s - %.0f%n", teamName, allTeams.get(teamName).getRating());
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }

            input = scanner.nextLine();
        }
    }
}
