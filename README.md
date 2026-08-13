Smart Room Climate Control System

Course: EECS 1021 – Object-Oriented Programming from Sensors to Actuators
Institution: York University
Date: August 2026

Overview

The Smart Room Climate Control System monitors room temperature and humidity in real time using a Raspberry Pi Pico and a Java application.

The user enters a desired temperature in the Java application. The system compares the current temperature with the desired temperature and automatically determines whether cooling should be turned on or off.

LED indicators are used to represent the heating and cooling states without requiring a physical HVAC system.

Features
Real-time temperature and humidity monitoring
User-defined desired temperature
Automatic climate-control decisions
Serial communication between Java and the Raspberry Pi Pico
Heating and cooling LED indicators
System status updates
Safe shutdown using the Q command
Error handling for invalid sensor data and connection problems
Project Structure
Embedded Firmware

Embedded-Firmware

SmartClimatePico.ino
ClimateController.cpp
ClimateController.h
DHTSensor.cpp
DHTSensor.h
Java Application

Java-Application/src

Main.java
ClimateController.java
ClimateData.java
SerialManager.java
Hardware Setup

The system uses:

Raspberry Pi Pico
Seeed Studio Grove Temperature and Humidity Sensor
LED indicators
USB cable
Computer

Connect the temperature and humidity sensor and LEDs according to the pin assignments used in the embedded firmware.

Connect the Raspberry Pi Pico to the computer using a USB cable for power and serial communication.

Dependencies and Libraries
Embedded Firmware
Arduino IDE
Raspberry Pi Pico board support
C/C++
Java Application
Java JDK
IntelliJ IDEA
jSerialComm library
Build and Run Instructions
Embedded Firmware
Open SmartClimatePico.ino in Arduino IDE.
Select the Raspberry Pi Pico board.
Select the correct serial port.
Compile the program.
Upload the firmware to the Raspberry Pi Pico.
Java Application
Open the Java application in IntelliJ IDEA.
Make sure the Java JDK is configured.
Add the jSerialComm library to the project.
Connect the Raspberry Pi Pico to the computer.
Run Main.java.
Enter the desired temperature when prompted.
Enter Q to safely stop the program.
How It Works

The Raspberry Pi Pico reads temperature and humidity data from the sensor and sends the readings to the Java application through serial communication.

If the current temperature is above the desired temperature, the system generates FAN_ON.

If the current temperature is equal to or below the desired temperature, the system generates FAN_OFF.

The LEDs visually indicate the current climate-control state.

Results

The completed prototype successfully demonstrated real-time environmental monitoring and communication between the embedded system and Java application.

The system was able to process sensor data, compare the current temperature with the desired temperature, and automatically determine the correct climate-control state.

Authors

Reham
Embedded Firmware

Sieara
Java Application

Both team members contributed to system integration, testing, troubleshooting, and overall project development.
