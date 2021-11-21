package military.interfaces;

import military.Repair;

import java.util.Collection;

public interface Engineer extends SpecialisedSoldier{

    Collection<Repair> getRepairs();
}
