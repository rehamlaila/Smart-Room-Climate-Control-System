#include "ClimateController.h"

// This is the constructor
ClimateController::ClimateController()
{
    targetTemperature = 22.0;      // Default target temperature
    currentTemperature = 0.0;
    currentHumidity = 0.0;

    coolingOn = false;
    heatingOn = false;
}

// Initializes the controller
void ClimateController::begin()
{
   
}

// Updates with current room conditions
void ClimateController::update(float temperature, float humidity)
{
    currentTemperature = temperature;
    currentHumidity = humidity;

    // Climate control logic
    if (currentTemperature > targetTemperature + 1)
    {
        coolingOn = true;
        heatingOn = false;
    }
    else if (currentTemperature < targetTemperature - 1)
    {
        heatingOn = true;
        coolingOn = false;
    }
    else
    {
        heatingOn = false;
        coolingOn = false;
    }
}

// Sets desired room temperature
void ClimateController::setTargetTemperature(float target)
{
    targetTemperature = target;
}

// Returns target temperature
float ClimateController::getTargetTemperature()
{
    return targetTemperature;
}

// Checks if cooling is already on
bool ClimateController::isCoolingOn()
{
    return coolingOn;
}

// Checks if heating is already on
bool ClimateController::isHeatingOn()
{
    return heatingOn;
}