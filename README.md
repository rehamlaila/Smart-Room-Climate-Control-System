# Smart-Room-Climate-Control-System
Arduino and Java-based smart room climate monitoring and control system.
Course: EECS 1021 – Object-Oriented Programming from Sensors to Actuators
Institution: York University
Date: August 2026

Overview

A smart room climate control system built with Java and Arduino that monitors room temperature and humidity in real time and makes automatic climate-control decisions based on a user-defined desired temperature.

The system uses serial communication to exchange data between the Arduino hardware and the Java application. LED indicators are used to represent heating and cooling states without requiring a physical HVAC system.

How It Works

The Arduino collects environmental readings from a Seeed Studio Grove Temperature & Humidity Sensor and communicates the sensor data to the Java application.

The user enters a desired room temperature in Java. The application processes the incoming temperature data and compares the current temperature with the desired temperature.

Temperature above desired value – generates FAN_ON
Temperature equal to or below desired value – generates FAN_OFF
Heating/Cooling LEDs – visually represent climate-control states
Q command – safely stops the system and disconnects the Arduino
Features
Real-time temperature and humidity monitoring
User-defined desired temperature
Automatic temperature-based control decisions
Arduino and Java serial communication
Heating and cooling LED indicators
System status updates
Safe system shutdown
Error handling for invalid sensor data and connection failures
Tech Stack
Java
Arduino/C++
Arduino IDE
IntelliJ IDEA
jSerialComm
Seeed Studio Grove Beginner Kit for Arduino
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
Files
File	Description
SmartClimate.ino	Main Arduino program
DHTSensor.h	Sensor class declaration
DHTSensor.cpp	Temperature and humidity sensor implementation
ClimateController.h	Embedded climate controller declaration
ClimateController.cpp	Embedded climate-control implementation
Main.java	Main Java application and system loop
ClimateData.java	Processes and stores incoming temperature data
ClimateController.java	Compares current and desired temperatures and determines the control command
SerialManager.java	Manages communication between Java and Arduino
Results

The completed prototype successfully demonstrated real-time environmental monitoring and hardware-software integration. Temperature data was processed by the Java application, allowing the system to make automatic climate-control decisions and communicate control commands through the serial connection.

The prototype uses LED indicators rather than a physical fan, heater, or HVAC system, allowing the climate-control behaviour to be demonstrated using low-power hardware.

Future Improvements
Add a physical fan or HVAC interface
Add appropriate driver circuitry for higher-power devices
Implement wireless communication
Develop a graphical user interface
Add environmental data logging
Implement more advanced climate-control algorithms
Authors

Reham
Arduino and Embedded System

Sieara
Java Application

Both team members collaborated on system integration, testing, troubleshooting, and overall project development.
