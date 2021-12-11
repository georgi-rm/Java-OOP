package spaceStation.models.mission;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.planets.Planet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MissionImpl implements Mission {
    @Override
    public void explore(Planet planet, Collection<Astronaut> astronauts) {
        List<String> itemsCollectedFromPlanet = new ArrayList<>();
        if (!astronauts.isEmpty()) {
            for (Astronaut astronaut : astronauts) {
                if (planet.getItems().isEmpty()) {
                    break;
                }
                for (String item : planet.getItems()) {
                    if (astronaut.canBreath()) {
                        astronaut.breath();
                        astronaut.getBag().getItems().add(item);
                        itemsCollectedFromPlanet.add(item);
                    }
                }
                for (String item : itemsCollectedFromPlanet) {
                    planet.getItems().remove(item);
                }
                itemsCollectedFromPlanet.clear();
            }
        }
    }
}
