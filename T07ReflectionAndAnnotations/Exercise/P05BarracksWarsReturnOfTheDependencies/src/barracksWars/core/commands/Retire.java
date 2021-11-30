package barracksWars.core.commands;

import barracksWars.interfaces.Inject;
import barracksWars.interfaces.Repository;
import barracksWars.interfaces.Unit;
import barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

public class Retire extends Command {
    @Inject
    private Repository repository;
    @Inject
    private UnitFactory unitFactory;

    public Retire(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        String unitType = super.getData()[1];
        Unit unitToRetire = this.unitFactory.createUnit(unitType);
        this.repository.removeUnit(super.getData()[1]);
        return unitType + " retired!";
    }
}
