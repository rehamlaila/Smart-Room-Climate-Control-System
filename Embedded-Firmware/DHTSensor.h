#ifndef DHTSENSOR_H
#define DHTSENSOR_H

#include <Arduino.h>
#include <DHT.h>

class DHTSensor
{
private:
    DHT dht;
    float temperature;
    float humidity;

public:
    // Constructor
    DHTSensor(uint8_t pin, uint8_t type);

    // Initialize the sensor
    void begin();

    // Read the sensor
    void readSensor();

    // Return the latest readings
    float getTemperature();

    float getHumidity();
};

#endif