package CounterStriker.core;

import CounterStriker.common.ExceptionMessages;
import CounterStriker.common.OutputMessages;
import CounterStriker.models.field.Field;
import CounterStriker.models.field.FieldImpl;
import CounterStriker.models.guns.Gun;
import CounterStriker.models.guns.Pistol;
import CounterStriker.models.guns.Rifle;
import CounterStriker.models.players.CounterTerrorist;
import CounterStriker.models.players.Player;
import CounterStriker.models.players.Terrorist;
import CounterStriker.repositories.GunRepository;
import CounterStriker.repositories.PlayerRepository;

import java.util.Comparator;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private final GunRepository guns;
    private final PlayerRepository players;
    private final Field field;

    public ControllerImpl() {
        this.guns = new GunRepository();
        this.players = new PlayerRepository();
        this.field = new FieldImpl();
    }

    @Override
    public String addGun(String type, String name, int bulletsCount) {
        Gun gun = null;
        switch (type) {
            case "Pistol":
                gun = new Pistol(name, bulletsCount);
                break;
            case "Rifle":
                gun = new Rifle(name, bulletsCount);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_GUN_TYPE);
        }
        this.guns.add(gun);
        return String.format(OutputMessages.SUCCESSFULLY_ADDED_GUN, name);
    }

    @Override
    public String addPlayer(String type, String username, int health, int armor, String gunName) {
        Gun gun = guns.findByName(gunName);

        if (gun == null) {
            throw new NullPointerException(ExceptionMessages.GUN_CANNOT_BE_FOUND);
        }

        Player player = null;
        switch (type) {
            case "Terrorist":
                player = new Terrorist(username, health, armor, gun);
                break;
            case "CounterTerrorist":
                player = new CounterTerrorist(username, health, armor, gun);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_PLAYER_TYPE);
        }

        this.players.add(player);
        return String.format(OutputMessages.SUCCESSFULLY_ADDED_PLAYER, username);
    }

    @Override
    public String startGame() {
        return field.start(players.getModels());
    }

    @Override
    public String report() {

        Comparator<Player> compareByType = Comparator.comparing( Player::toString );
//        Comparator<Player> compareByType = (e1, e2) -> {
//                if(e1 instanceof CounterTerrorist) {
//                    return -1;
//                } else if ( e2 instanceof CounterTerrorist)  {
//                    return 1;
//                } else {
//                    return 0;
//                }
//        };

        Comparator<Player> compareByHealth = Comparator.comparing( Player::getHealth ).reversed();

        Comparator<Player> compareByUsername = Comparator.comparing( Player::getUsername );

        return players.getModels().stream()
                .sorted(compareByType
                        .thenComparing(compareByHealth)
                        .thenComparing(compareByUsername))
                .map(Player::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
