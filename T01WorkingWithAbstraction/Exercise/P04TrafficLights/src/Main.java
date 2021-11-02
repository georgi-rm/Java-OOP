import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<TrafficLight> allTrafficLights = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(LightSignal::valueOf)
                .map(TrafficLight::new)
                .collect(Collectors.toList());

        int numberOfSignalChanges = Integer.parseInt(scanner.nextLine());

        while (numberOfSignalChanges-- > 0) {
            for (TrafficLight trafficLight : allTrafficLights) {
                trafficLight.changeSignal();
                System.out.printf("%s ", trafficLight);
            }
            System.out.println();
        }
    }
}
