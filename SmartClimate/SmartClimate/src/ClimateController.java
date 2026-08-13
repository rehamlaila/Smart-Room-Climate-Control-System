public class ClimateController {

    private double desiredTemperature;

    // Constructor
    public ClimateController(double desiredTemperature) {
        this.desiredTemperature = desiredTemperature;
    }

    // Decide whether the fan should be ON or OFF
    public String getFanCommand(double currentTemperature) {

        if (currentTemperature > desiredTemperature) {
            return "FAN_ON";
        } else {
            return "FAN_OFF";
        }
    }

    // Change the desired temperature
    public void setDesiredTemperature(double desiredTemperature) {
        this.desiredTemperature = desiredTemperature;
    }

    // Return the desired temperature
    public double getDesiredTemperature() {
        return desiredTemperature;
    }
}