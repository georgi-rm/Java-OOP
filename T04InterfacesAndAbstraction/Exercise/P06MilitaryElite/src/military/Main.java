package military;

import military.enumerations.Corps;
import military.interfaces.Private;
import military.interfaces.Spy;
import military.soldiers.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Integer, Private> privates = new HashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] commandData = input.split("\\s+");
            String commandName = commandData[0];
            int id = Integer.parseInt(commandData[1]);
            String firstName = commandData[2];
            String lastName = commandData[3];

            switch (commandName) {
                case "Private":
                    double salary = Double.parseDouble(commandData[4]);
                    privates.put(id, new PrivateImpl(id, firstName, lastName, salary));
                    System.out.println(privates.get(id));
                    break;
                case "LieutenantGeneral":
                    double salaryLieutenant = Double.parseDouble(commandData[4]);
                    LieutenantGeneralImpl lieutenantGeneral = new LieutenantGeneralImpl(id, firstName, lastName, salaryLieutenant);
                    for (int i = 5; i < commandData.length; i++) {
                        int privateId = Integer.parseInt(commandData[i]);
                        lieutenantGeneral.addPrivate(privates.get(privateId));
                    }
                    System.out.println(lieutenantGeneral);
                    break;
                case "Engineer":
                    double salaryEngineer = Double.parseDouble(commandData[4]);
                    try {
                        Corps corps = Corps.valueOf(commandData[5].toUpperCase());
                        EngineerImpl engineer = new EngineerImpl(id, firstName, lastName, salaryEngineer, corps);
                        for (int i = 6; i < commandData.length; i += 2) {
                            String repairPartName = commandData[i];
                            int repairHours = Integer.parseInt(commandData[i + 1]);
                            Repair repairPart = new Repair(repairPartName, repairHours);
                            engineer.addRepair(repairPart);
                        }
                        System.out.println(engineer);
                    } catch (IllegalArgumentException ignored) {

                    }
                    break;
                case "Commando":
                    double salaryCommando = Double.parseDouble(commandData[4]);
                    try {
                        Corps corps = Corps.valueOf(commandData[5].toUpperCase());
                        CommandoImpl commando = new CommandoImpl(id, firstName, lastName, salaryCommando, corps);
                        for (int i = 6; i < commandData.length; i += 2) {
                            String missionName = commandData[i];
                            String missionState = commandData[i + 1];
                            if (missionState.equals("inProgress") || missionState.equals("finished")) {
                                Mission mission = new Mission(missionName);
                                if (missionState.equals("finished")) {
                                    mission.completeMission();
                                }
                                commando.addMission(mission);
                            }
                        }
                        System.out.println(commando);
                    } catch (IllegalArgumentException ignored) {

                    }
                    break;
                case "Spy":
                    String spyCode = commandData[4];
                    Spy spy = new SpyImpl(id, firstName, lastName, spyCode);
                    System.out.println(spy);
                    break;
            }

            input = scanner.nextLine();
        }
    }
}
