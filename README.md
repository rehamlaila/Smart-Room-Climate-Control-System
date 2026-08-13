Smart Room Climate Control System

Course: EECS 1021 – Object-Oriented Programming from Sensors to Actuators
Institution: York University
Date: August 2026

Overview

The Smart Room Climate Control System is a hardware-software project built using Java and a Raspberry Pi Pico programmed through the Arduino IDE. The system monitors room temperature and humidity in real time and makes automatic climate-control decisions based on a user-defined desired temperature.

Serial communication is used to exchange data between the embedded system and the Java application. LED indicators represent heating and cooling states without requiring a physical HVAC system.

How It Works

The Raspberry Pi Pico collects environmental readings from the Seeed Studio Grove Temperature & Humidity Sensor and sends the sensor data to the Java application through a serial connection.

The user enters a desired room temperature in the Java application. The program compares the current temperature with the desired temperature and determines the appropriate climate-control command.

Temperature above desired value → FAN_ON
Temperature equal to or below desired value → FAN_OFF
Heating/cooling LEDs visually represent the current system state
Q safely stops the Java application and disconnects the serial connection
Features
Real-time temperature and humidity monitoring
User-defined desired temperature
Automatic temperature-based control decisions
Serial communication between Java and the Raspberry Pi Pico
Heating and cooling LED indicators
System status updates
Safe system shutdown
Error handling for invalid sensor data and connection failures
Modular object-oriented program structure
Project Structure
Embedded Firmware

Embedded-Firmware/

SmartClimatePico.ino – Main embedded program
DHTSensor.h – Temperature and humidity sensor class declaration
DHTSensor.cpp – Temperature and humidity sensor implementation
ClimateController.h – Embedded climate controller class declaration
ClimateController.cpp – Embedded climate-control implementation
Java Application

Java-Application/src/

Main.java – Main Java application and system loop
ClimateData.java – Processes and stores incoming temperature and humidity data
ClimateController.java – Compares the current and desired temperatures and determines the control command
SerialManager.java – Manages serial communication between Java and the Raspberry Pi Pico
Hardware Setup
Required Hardware
Raspberry Pi Pico
Seeed Studio Grove Beginner Kit
Seeed Studio Grove Temperature & Humidity Sensor
LED indicators
USB cable for serial communication and power
Computer running the Java application
Setup
Connect the temperature and humidity sensor to the Raspberry Pi Pico/Grove hardware according to the pin configuration used in the embedded firmware.
Connect the heating and cooling LED indicators according to the output pins defined in the firmware.
Connect the Raspberry Pi Pico to the computer using a USB cable.
Upload the embedded firmware to the Pico using the Arduino IDE.
Keep the Pico connected to the computer so the Java application can communicate with it through the serial port.
Dependencies and Libraries
Embedded Firmware
Arduino IDE
Raspberry Pi Pico Arduino board support
Standard Arduino/C++ libraries
Seeed Studio Grove Temperature & Humidity Sensor hardware

The temperature and humidity sensor functionality is implemented through the DHTSensor class included in the project.

Java Application
Java JDK
IntelliJ IDEA or another Java IDE
jSerialComm library for serial communication

The jSerialComm library must be added to the Java project before running the application.

Build and Run Instructions
1. Embedded Firmware
Open the Embedded-Firmware folder.
Open SmartClimatePico.ino in the Arduino IDE.
Make sure all .cpp and .h files remain in the same project folder.
Select the correct Raspberry Pi Pico board configuration.
Connect the Pico to the computer.
Select the correct port in the Arduino IDE.
Compile and upload the firmware.
2. Java Application
Open the Java-Application project or source folder in IntelliJ IDEA.
Ensure the Java JDK is configured.
Add the jSerialComm library to the project dependencies.
Ensure the Raspberry Pi Pico is connected to the computer.
Run Main.java.
Follow the console prompts to connect to the appropriate serial port.
Enter the desired room temperature when prompted.
The application will continuously display temperature and humidity readings and automatically determine the appropriate climate-control state.
Enter Q when prompted to safely stop the system and close the serial connection.
Tech Stack
Java
C/C++
Raspberry Pi Pico
Arduino IDE
IntelliJ IDEA
jSerialComm
Seeed Studio Grove Beginner Kit
Seeed Studio Grove Temperature & Humidity Sensor
Key Concepts Demonstrated
Object-oriented programming
Hardware-software integration
Real-time sensor data acquisition
Serial communication
Sensor-to-actuator system design
Automated decision-making
Modular software design
Error handling
Results

The completed prototype successfully demonstrated real-time environmental monitoring and hardware-software integration.

Temperature and humidity data were collected by the embedded system and transmitted to the Java application. The Java application processed the incoming temperature data, compared it with the user-defined desired temperature, and generated the appropriate climate-control command.

LED indicators were used instead of a physical fan, heater, or HVAC system, allowing the climate-control behaviour to be demonstrated safely using low-power hardware.

Future Improvements
Add a physical fan or HVAC interface
Add appropriate driver circuitry for higher-power devices
Implement wireless communication
Develop a graphical user interface
Add environmental data logging
Implement more advanced climate-control algorithms
Authors

Reham – Arduino/Pico and Embedded System
Sieara – Java Application

Both team members collaborated on system integration, testing, troubleshooting, and overall project development.
