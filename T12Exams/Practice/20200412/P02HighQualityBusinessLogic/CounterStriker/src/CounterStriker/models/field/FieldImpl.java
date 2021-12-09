package CounterStriker.models.field;

import CounterStriker.common.OutputMessages;
import CounterStriker.models.players.CounterTerrorist;
import CounterStriker.models.players.Player;
import CounterStriker.models.players.Terrorist;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class FieldImpl implements Field {
    @Override
    public String start(Collection<Player> players) {
        List<Terrorist> terrorists = players.stream()
                .filter(p -> p instanceof Terrorist)
                .map(e-> (Terrorist) e)
                .collect(Collectors.toList());

        List<CounterTerrorist> counterTerrorists = players.stream()
                .filter(p -> p instanceof CounterTerrorist)
                .map(e-> (CounterTerrorist) e)
                .collect(Collectors.toList());

        while (true) {
            for (Terrorist terrorist : terrorists) {
                if (terrorist.isAlive()) {
                    boolean isCounterTerroristsTeamAlive = false;
                    for (CounterTerrorist counterTerrorist : counterTerrorists) {
                        if (counterTerrorist.isAlive()) {
                            counterTerrorist.takeDamage(terrorist.getGun().fire());
                            if (counterTerrorist.isAlive()) {
                                isCounterTerroristsTeamAlive = true;
                            }
                        }
                    }
                    if (!isCounterTerroristsTeamAlive) {
                        return OutputMessages.TERRORIST_WINS;
                    }
                }
            }

            for (CounterTerrorist counterTerrorist : counterTerrorists) {
                if (counterTerrorist.isAlive()) {
                    boolean isTerroristsTeamAlive = false;
                    for (Terrorist terrorist : terrorists) {
                        if (terrorist.isAlive()) {
                            terrorist.takeDamage(counterTerrorist.getGun().fire());
                            if (terrorist.isAlive()) {
                                isTerroristsTeamAlive = true;
                            }
                        }
                    }
                    if (!isTerroristsTeamAlive) {
                        return OutputMessages.COUNTER_TERRORIST_WINS;
                    }
                }
            }
        }
    }
}
