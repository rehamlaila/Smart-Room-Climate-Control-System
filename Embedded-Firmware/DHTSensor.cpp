#include "DHTSensor.h" // Givs .cpp file access to class in DHTSensor.h

// This is the constructor
DHTSensor::DHTSensor(uint8_t pin, uint8_t type)
    : dht(pin, type)
{
    temperature = 0.0;
    humidity = 0.0;
}

// Initialize the DHT11 sensor
void DHTSensor::begin()
{
    dht.begin();
}

// Reads the temperature and humidity from the DHT11 sensor
void DHTSensor::readSensor()
{
    temperature = dht.readTemperature();
    humidity = dht.readHumidity();
}

// Returns the current temperature
float DHTSensor::getTemperature()
{
    return temperature;
}

// Return the current humidity
float DHTSensor::getHumidity()
{
    return humidity;
}