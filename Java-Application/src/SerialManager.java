import com.fazecast.jSerialComm.SerialPort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class SerialManager {

    private SerialPort serialPort;
    private BufferedReader input;
    private PrintWriter output;

    // Connects to the Arduino board
    public boolean connect() {

        SerialPort[] ports = SerialPort.getCommPorts();

        if (ports.length == 0) {
            System.out.println("No serial ports found.");
            return false;
        }

        // Finds the Arduino USB serial port
        for (SerialPort port : ports) {

            if (port.getSystemPortName().contains("cu.usbserial")) {
                serialPort = port;
                break;
            }
        }

        // Checks if Arduino port was found
        if (serialPort == null) {
            System.out.println("Arduino serial port not found.");
            return false;
        }

        // Sets baud rate to match Arduino
        serialPort.setBaudRate(9600);

        // Sets serial communication parameters
        serialPort.setNumDataBits(8);
        serialPort.setNumStopBits(SerialPort.ONE_STOP_BIT);
        serialPort.setParity(SerialPort.NO_PARITY);

        // Sets timeout for reading Arduino data
        serialPort.setComPortTimeouts(
                SerialPort.TIMEOUT_READ_SEMI_BLOCKING,
                2000,
                0
        );

        // Opens serial port
        if (!serialPort.openPort()) {
            System.out.println("Failed to open Arduino serial port.");
            return false;
        }

        try {

            // Gives Arduino time to restart after connection
            Thread.sleep(2000);

        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();
        }

        // Sets up communication
        input = new BufferedReader(
                new InputStreamReader(serialPort.getInputStream())
        );

        output = new PrintWriter(
                serialPort.getOutputStream(),
                true
        );

        return true;
    }

    // Reads data sent from Arduino
    public String readData() {

        try {

            if (input != null) {

                String data = input.readLine();

                if (data != null && !data.isEmpty()) {
                    return data.trim();
                }
            }

        } catch (Exception e) {

            System.out.println(
                    "Error reading temperature from Arduino."
            );
        }

        return null;
    }

    // Sends commands to Arduino
    public void sendCommand(String command) {

        if (output != null) {
            output.println(command);
            output.flush();
        }
    }

    // Closes connection
    public void disconnect() {

        if (serialPort != null && serialPort.isOpen()) {
            serialPort.closePort();
        }
    }
}