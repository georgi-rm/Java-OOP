package military.soldiers;

import military.enumerations.Corps;
import military.interfaces.Private;
import military.interfaces.SpecialisedSoldier;

public class SpecialisedSoldierImpl extends PrivateImpl implements SpecialisedSoldier {
    private Corps corps;

    public SpecialisedSoldierImpl(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary);
        this.corps = corps;
    }

    @Override
    public String toString() {
        return String.format("%s%nCorps: %s", super.toString(), corps.toString());
    }

    @Override
    public Corps getCorps() {
        return this.corps;
    }
}
