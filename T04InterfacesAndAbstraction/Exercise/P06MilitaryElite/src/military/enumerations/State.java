package military.enumerations;

public enum State {
    INPROGRESS("inProgress"),
    FINISHED("finished");

    private final String text;

    State(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return this.text;
    }
}
