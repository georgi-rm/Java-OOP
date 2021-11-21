package military.soldiers;

import military.Repair;
import military.enumerations.Corps;
import military.interfaces.Engineer;
import military.interfaces.Private;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer {
    List<Repair> repairs;

    public EngineerImpl(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = new ArrayList<>();
    }

    public void addRepair(Repair repair) {
        this.repairs.add(repair);
    }

    @Override
    public Collection<Repair> getRepairs() {

        return this.repairs;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString()).append(System.lineSeparator())
                .append("Repairs:").append(System.lineSeparator());
        this.repairs.forEach(r -> stringBuilder.append("  ")
                .append(r.toString()).append(System.lineSeparator()));
        return stringBuilder.toString().trim();
    }
}
