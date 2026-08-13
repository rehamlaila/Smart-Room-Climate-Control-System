import java.util.Scanner;

public class Main {

    private static boolean running = true;

    public static void main(String[] args) {

        // Create Scanner for user input
        Scanner scanner = new Scanner(System.in);

        System.out.println();
        System.out.println("========================================");
        System.out.println("       SMART ROOM CLIMATE SYSTEM");
        System.out.println("========================================");
        System.out.println();

        // Ask user for desired room temperature
        System.out.print("Enter desired temperature: ");
        double desiredTemperature = scanner.nextDouble();
        scanner.nextLine();

        // Create climate controller
        ClimateController controller =
                new ClimateController(desiredTemperature);

        // Create serial connection to Arduino
        SerialManager serialManager = new SerialManager();

        System.out.println();
        System.out.println("Connecting to Arduino...");

        // Connect to Arduino
        if (!serialManager.connect()) {
            System.out.println();
            System.out.println("ERROR: Could not connect to Arduino.");
            System.out.println("Please check the USB connection and try again.");
            return;
        }

        System.out.println("Arduino connected successfully!");

        System.out.println();
        System.out.println("----------------------------------------");
        System.out.println("Climate control system started.");
        System.out.println("Desired Temperature: "
                + desiredTemperature + " C");
        System.out.println("Type Q and press Enter to stop the system.");
        System.out.println("----------------------------------------");
        System.out.println();

        // Allows user to stop the system
        Thread stopThread = new Thread(() -> {

            while (running) {

                String userInput = scanner.nextLine();

                if (userInput.equalsIgnoreCase("Q")) {
                    running = false;
                    break;
                }
            }
        });

        stopThread.setDaemon(true);
        stopThread.start();

        // Stores information about the current system state
        double currentTemperature = Double.NaN;
        String previousCommand = "";

        long lastStatusTime = System.currentTimeMillis();

        // Continuously read Arduino sensor data
        while (running) {

            String sensorData = serialManager.readData();

            if (sensorData != null) {

                ClimateData data =
                        ClimateData.fromSerial(sensorData);

                if (data != null) {

                    currentTemperature = data.getTemperature();

                    // Decide if fan should be ON or OFF
                    String command =
                            controller.getFanCommand(
                                    currentTemperature
                            );

                    // Send command to Arduino
                    serialManager.sendCommand(command);

                    // Displays when fan status changes
                    if (!command.equals(previousCommand)) {

                        System.out.println();
                        System.out.println("Temperature: "
                                + currentTemperature + " C");

                        if (command.equals("FAN_ON")) {

                            System.out.println(
                                    "Fan Status: ON"
                            );

                            System.out.println(
                                    "Room is above the desired temperature."
                            );

                            System.out.println(
                                    "Cooling has been activated."
                            );

                        } else {

                            System.out.println(
                                    "Fan Status: OFF"
                            );

                            System.out.println(
                                    "Room temperature is within the desired range."
                            );
                        }

                        System.out.println();

                        previousCommand = command;
                    }
                }
            }

            // Displays system status every 30 seconds
            if (System.currentTimeMillis() - lastStatusTime >= 30000) {

                System.out.println();
                System.out.println("========== SYSTEM STATUS ==========");

                if (Double.isNaN(currentTemperature)) {

                    System.out.println(
                            "Current Temperature: Waiting for sensor..."
                    );

                } else {

                    System.out.println(
                            "Current Temperature: "
                                    + currentTemperature + " C"
                    );
                }

                System.out.println(
                        "Desired Temperature: "
                                + controller.getDesiredTemperature()
                                + " C"
                );

                if (previousCommand.equals("FAN_ON")) {

                    System.out.println("Fan Status: ON");

                } else if (previousCommand.equals("FAN_OFF")) {

                    System.out.println("Fan Status: OFF");

                } else {

                    System.out.println("Fan Status: Waiting for sensor...");
                }

                System.out.println("System Status: RUNNING");
                System.out.println("===================================");

                System.out.println();
                System.out.println(
                        "Type Q and press Enter to stop the system."
                );

                lastStatusTime = System.currentTimeMillis();
            }
        }

        // Safely shut down system
        System.out.println();
        System.out.println("----------------------------------------");
        System.out.println("Stopping climate control system...");

        serialManager.sendCommand("FAN_OFF");
        serialManager.disconnect();

        System.out.println("Fan turned OFF.");
        System.out.println("Arduino disconnected.");
        System.out.println();
        System.out.println("Smart Climate System stopped safely.");
        System.out.println("----------------------------------------");
    }
}
