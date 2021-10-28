import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] coordinatesOfRectangle = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int bottomLeftX = coordinatesOfRectangle[0];
        int bottomLeftY = coordinatesOfRectangle[1];
        int topRightX = coordinatesOfRectangle[2];
        int topRightY = coordinatesOfRectangle[3];

        Rectangle rectangle = new Rectangle(bottomLeftX, bottomLeftY, topRightX, topRightY);

        int numberOfPointsToCheck = Integer.parseInt(scanner.nextLine());

        while (numberOfPointsToCheck-- > 0) {
            int[] coordinatesOfPoint = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            Point pointToCheck = new Point(coordinatesOfPoint[0], coordinatesOfPoint[1]);

            System.out.println(rectangle.contains(pointToCheck));
        }
    }
}
