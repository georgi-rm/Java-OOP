package spaceStation.core;

import spaceStation.common.ConstantMessages;
import spaceStation.common.ExceptionMessages;
import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.astronauts.Biologist;
import spaceStation.models.astronauts.Geodesist;
import spaceStation.models.astronauts.Meteorologist;
import spaceStation.models.mission.Mission;
import spaceStation.models.mission.MissionImpl;
import spaceStation.models.planets.Planet;
import spaceStation.models.planets.PlanetImpl;
import spaceStation.repositories.AstronautRepository;
import spaceStation.repositories.PlanetRepository;
import spaceStation.repositories.Repository;

import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private Repository<Astronaut> astronautRepository;
    private Repository<Planet> planetRepository;
    private int exploredPlanetsCount;

    public ControllerImpl() {
        this.astronautRepository = new AstronautRepository();
        this.planetRepository = new PlanetRepository();
        exploredPlanetsCount = 0;
    }

    @Override
    public String addAstronaut(String type, String astronautName) {
        Astronaut astronaut;
        switch (type) {
            case "Biologist":
                astronaut = new Biologist(astronautName);
                break;
            case "Geodesist":
                astronaut = new Geodesist(astronautName);
                break;
            case "Meteorologist":
                astronaut = new Meteorologist(astronautName);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.ASTRONAUT_INVALID_TYPE);
        }
        astronautRepository.add(astronaut);
        return String.format(ConstantMessages.ASTRONAUT_ADDED, type, astronautName);
    }

    @Override
    public String addPlanet(String planetName, String... items) {
        Planet planet = new PlanetImpl(planetName);
        for (String item : items) {
            planet.getItems().add(item);
        }
        this.planetRepository.add(planet);
        return String.format(ConstantMessages.PLANET_ADDED, planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {
        boolean isRemoved = this.astronautRepository.remove(this.astronautRepository.findByName(astronautName));
        if (!isRemoved) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.ASTRONAUT_DOES_NOT_EXIST, astronautName));
        }
        return String.format(ConstantMessages.ASTRONAUT_RETIRED, astronautName);
    }

    @Override
    public String explorePlanet(String planetName) {
        double oxygenNeededToGoOnMission = 60.0;
        Planet planet = planetRepository.findByName(planetName);
        List<Astronaut> suitableAstronauts = this.astronautRepository.getModels().stream()
                .filter(a -> a.getOxygen() > oxygenNeededToGoOnMission)
                .collect(Collectors.toList());

        if (suitableAstronauts.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.PLANET_ASTRONAUTS_DOES_NOT_EXISTS);
        }

        Mission mission = new MissionImpl();
        mission.explore(planet, suitableAstronauts);
        long countOfDeadAstronauts = suitableAstronauts.stream()
                .filter(a -> a.getOxygen() == 0.0)
                .count();
        this.exploredPlanetsCount++;
        return String.format(ConstantMessages.PLANET_EXPLORED, planetName, countOfDeadAstronauts);
    }

    @Override
    public String report() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format(ConstantMessages.REPORT_PLANET_EXPLORED, this.exploredPlanetsCount)).append(System.lineSeparator())
                .append(ConstantMessages.REPORT_ASTRONAUT_INFO).append(System.lineSeparator());

        for (Astronaut astronaut : this.astronautRepository.getModels()) {
            String bagItems = "none";
            if (!astronaut.getBag().getItems().isEmpty()) {
                bagItems = String.join(ConstantMessages.REPORT_ASTRONAUT_BAG_ITEMS_DELIMITER, astronaut.getBag().getItems());
            }

            stringBuilder.append(String.format(ConstantMessages.REPORT_ASTRONAUT_NAME, astronaut.getName())).append(System.lineSeparator())
                    .append(String.format(ConstantMessages.REPORT_ASTRONAUT_OXYGEN, astronaut.getOxygen())).append(System.lineSeparator())
                    .append(String.format(ConstantMessages.REPORT_ASTRONAUT_BAG_ITEMS, bagItems)).append(System.lineSeparator());
        }


        return stringBuilder.toString().trim();
    }
}
