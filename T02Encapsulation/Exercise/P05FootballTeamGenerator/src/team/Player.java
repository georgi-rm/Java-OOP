package team;

public class Player {
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        setName(name);
        setEndurance(endurance);
        setSprint(sprint);
        setDribble(dribble);
        setPassing(passing);
        setShooting(shooting);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    private void setEndurance(int endurance) {
        ensureStatsRange(endurance, "Endurance");
        this.endurance = endurance;
    }

    private void setSprint(int sprint) {
        ensureStatsRange(sprint, "Sprint");
        this.sprint = sprint;
    }

    private void setDribble(int dribble) {
        ensureStatsRange(dribble, "Dribble");
        this.dribble = dribble;
    }

    private void setPassing(int passing) {
        ensureStatsRange(passing, "Passing");
        this.passing = passing;
    }

    private void setShooting(int shooting) {
        ensureStatsRange(shooting, "Shooting");
        this.shooting = shooting;
    }

    public double overallSkillLevel() {
        return (this.endurance + this.sprint + this.dribble + this.passing + this.shooting) / 5.0;
    }

    private void ensureStatsRange(int statValue, String statName) {
        if (statValue < 0 || statValue > 100) {
            String exceptionMessage = String.format("%s should be between 0 and 100.", statName);
            throw new IllegalArgumentException(exceptionMessage);
        }
    }
}
