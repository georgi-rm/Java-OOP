public class Rhombus {
    private final int size;

    public Rhombus(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return generateUpperPart() +
                generateMiddlePart() +
                generateLowerPart();
    }

    private String generateUpperPart() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int line = 1; line < this.size; line++) {
            stringBuilder.append(generateLine(line)).append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }

    private String generateMiddlePart() {
        return String.format("%s%n", generateLine(this.size));
    }

    private String generateLowerPart() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int line = this.size - 1; line > 0; line--) {
            stringBuilder.append(generateLine(line)).append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }

    private String generateLine(int line) {
        String lineOutput = repeatSequenceNTimes(this.size - line, " " );
        lineOutput += repeatSequenceNTimes(line, "* ");
        return lineOutput;
    }

    private String repeatSequenceNTimes(int n, String element) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            stringBuilder.append(element);
        }
        return stringBuilder.toString();
    }
}
