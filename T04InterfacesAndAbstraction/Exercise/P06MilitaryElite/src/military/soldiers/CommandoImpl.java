package military.soldiers;

import military.Mission;
import military.enumerations.Corps;
import military.interfaces.Commando;
import military.interfaces.Private;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando {
    List<Mission> missions;

    public CommandoImpl(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary, corps);
        this.missions = new ArrayList<>();
    }


    public void addMission(Mission mission) {
        missions.add(mission);
    }

    @Override
    public Collection<Mission> getMissions() {
        return this.missions;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString()).append(System.lineSeparator())
                .append("Missions:").append(System.lineSeparator());
        missions.forEach(m -> stringBuilder.append("  ")
                .append(m.toString()).append(System.lineSeparator()));
        return stringBuilder.toString().trim();
    }
}
