#ifndef CLIMATECONTROLLER_H
#define CLIMATECONTROLLER_H

#include <Arduino.h>

class ClimateController
{
private:
    float targetTemperature;
    float currentTemperature;
    float currentHumidity;

    bool coolingOn;
    bool heatingOn;

public:
    // This is the constructor
    ClimateController();

    // Initializes the controller
    void begin();

    // Updates with the current room temperature and humidity
    void update(float temperature, float humidity);

    // Sets room temperature target
    void setTargetTemperature(float target);

    // Gets current target temperature
    float getTargetTemperature();

    // Checks the system's current status
    bool isCoolingOn();

    bool isHeatingOn();
};

#endif