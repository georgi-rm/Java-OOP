package military.interfaces;

import military.Mission;

import java.util.Collection;

public interface Commando extends SpecialisedSoldier{

    Collection<Mission> getMissions();
}
