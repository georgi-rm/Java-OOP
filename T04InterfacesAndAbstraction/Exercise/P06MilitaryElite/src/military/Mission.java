package military;

import military.enumerations.State;

public class Mission {
    private final String codeName;
    State state;

    public Mission(String codeName) {
        this.codeName = codeName;
        this.state = State.INPROGRESS;
    }

    public void completeMission() {
        this.state = State.FINISHED;
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s", this.codeName, this.state.toString());
    }
}
