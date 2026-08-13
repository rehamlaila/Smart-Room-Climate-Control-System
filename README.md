# Smart-Room-Climate-Control-System
Arduino and Java-based smart room climate monitoring and control system.
The Smart Room Climate Control System is a hardware-software integrated project that monitors room temperature and humidity and demonstrates automatic climate-control decisions.

The system uses a Seeed Studio Grove Temperature & Humidity Sensor connected to an Arduino-based embedded system. Sensor data is transmitted to a Java application through serial communication. The Java application processes the incoming temperature data, compares it with a user-defined desired temperature, and generates the appropriate climate-control command.

Heating and cooling states are represented using LED indicators rather than a physical fan, heater, or HVAC system.

Hardware

The project uses:

Seeed Studio Grove Beginner Kit for Arduino
Seeed Studio Grove Temperature & Humidity Sensor
Heating and cooling LED indicators
USB cable
Computer running the Java application
Software
Embedded System
Arduino IDE
Arduino/C++ firmware
Java Application
Java
IntelliJ IDEA
jSerialComm library
Project Structure
Smart-Room-Climate-Control/
│
├── Embedded-Firmware/
│   ├── SmartClimate.ino
│   ├── DHTSensor.h
│   ├── DHTSensor.cpp
│   ├── ClimateController.h
│   └── ClimateController.cpp
│
├── Java-Application/
│   ├── Main.java
│   ├── ClimateData.java
│   ├── ClimateController.java
│   └── SerialManager.java
│
└── README.md
Hardware Setup
Connect the Seeed Studio Grove Temperature & Humidity Sensor to the Grove Beginner Kit.
Connect the Arduino to the computer using a USB cable.
Ensure the Arduino is powered and recognized by the computer.
Use the integrated LED indicators to represent heating and cooling states.

The USB connection provides power to the Arduino system and supports serial communication with the Java application.

Running the Embedded Program
Open the embedded firmware in Arduino IDE.
Connect the Arduino to the computer using USB.
Select the correct Arduino board and serial port.
Compile and upload the firmware to the Arduino.
Keep the Arduino connected while running the Java application.
Running the Java Application
Open the Java project in IntelliJ IDEA.
Ensure Java and the jSerialComm library are properly configured.
Connect the Arduino to the computer.
Run Main.java.
Enter the desired room temperature when prompted.
The application establishes a serial connection with the Arduino and begins receiving sensor data.
The current temperature is compared with the desired temperature to determine the climate-control response.
Enter Q and press Enter to safely stop the program.
Climate-Control Logic

The Java application compares the current temperature with the desired temperature entered by the user.

If the current temperature is greater than the desired temperature, the application generates FAN_ON.
If the current temperature is equal to or below the desired temperature, the application generates FAN_OFF.

These commands represent the cooling-control decision used by the prototype. Heating and cooling LED indicators are used to visually demonstrate the system state.

Error Handling

The Java application includes basic error handling for:

Invalid sensor data
Serial connection failures
Missing or unavailable serial connections

Invalid sensor messages are handled without allowing the application to terminate unexpectedly.

Limitations

The current prototype does not operate a physical fan, heater, or HVAC system. Instead, LED indicators and software commands are used to demonstrate climate-control behaviour.

As a result, the system can monitor environmental conditions and demonstrate control decisions, but it cannot physically change the room temperature.

The system also requires a wired USB connection between the Arduino and computer.

Future Improvements

Possible future improvements include:

Adding a physical fan or HVAC interface
Adding appropriate driver circuitry for higher-power devices
Implementing wireless communication
Developing a graphical user interface
Adding environmental data logging
Implementing more advanced temperature-control algorithms
Authors

Reham — Arduino and Embedded System
Sieara — Java Application

Both team members collaborated on system integration, testing, troubleshooting, and overall project development.
