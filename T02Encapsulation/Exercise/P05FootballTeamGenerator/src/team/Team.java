package team;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        setName(name);
        this.players = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void removePlayer(String player) {
        for (Player currentPlayer : players) {
            if (currentPlayer.getName().equals(player) ) {
                players.remove(currentPlayer);
                return;
            }
        }
        String exceptionMessage = String.format("Player %s is not in %s team.", player, this.name);
        throw new IllegalArgumentException(exceptionMessage);
    }

    public double getRating() {
        return players.stream()
                .mapToDouble(Player::overallSkillLevel)
                .average().orElse(0.0);
    }
}
