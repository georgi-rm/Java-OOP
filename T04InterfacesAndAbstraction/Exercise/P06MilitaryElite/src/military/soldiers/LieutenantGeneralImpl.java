package military.soldiers;

import military.interfaces.LieutenantGeneral;
import military.interfaces.Private;

import java.util.ArrayList;
import java.util.List;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral {
    private final List<Private> privates;

    public LieutenantGeneralImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.privates = new ArrayList<>();
    }

    public void addPrivate(Private priv) {
        this.privates.add(priv);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString()).append(System.lineSeparator())
                .append("Privates:").append(System.lineSeparator());
        privates.stream()
                .sorted((p1, p2) -> Integer.compare(p2.getId(), p1.getId()))
                .forEach(p -> stringBuilder.append("  ")
                        .append(p).append(System.lineSeparator()));
        return stringBuilder.toString().trim();
    }

    @Override
    public List<Private> getPrivates() {
        return privates;
    }
}
