public class ClimateData {

    // Stores the temperature reading from the Arduino
    private double temperature;

    // This is the constructor
    public ClimateData(double temperature) {
        this.temperature = temperature;
    }

    // Returns the temperature
    public double getTemperature() {
        return temperature;
    }

    // Converts Arduino serial data into ClimateData
    public static ClimateData fromSerial(String sensorData) {

        try {

            double temperature =
                    Double.parseDouble(sensorData.split(":")[1]);

            return new ClimateData(temperature);

        } catch (Exception e) {

            System.out.println(
                    "Invalid sensor data: " + sensorData
            );

            return null;
        }// Error handling to avoid program crashing
    }
}