#include "DHTSensor.h"
#include "ClimateController.h"


// Pin initialization
#define DHT_PIN 15
#define DHT_TYPE DHT11

#define COOLING_LED 16
#define HEATING_LED 17

// Objects
DHTSensor sensor(DHT_PIN, DHT_TYPE);
ClimateController climate;

// Variables
float temperature;
float humidity;

// Setup
void setup()
{
    Serial.begin(115200);

    pinMode(COOLING_LED, OUTPUT);
    pinMode(HEATING_LED, OUTPUT);

    sensor.begin();
    climate.begin();

    Serial.println("Smart Climate Control Started");
}

// Main Loop
void loop()
{
    // Read sensor values
    sensor.readSensor();

    temperature = sensor.getTemperature();
    humidity = sensor.getHumidity();

    // Update climate controller
    climate.update(temperature, humidity);

    // Control LEDs
    digitalWrite(COOLING_LED, climate.isCoolingOn());

    digitalWrite(HEATING_LED, climate.isHeatingOn());

    // Send data to Java
    Serial.print("TEMP:");
    Serial.println(temperature);

    Serial.print("HUM:");
    Serial.println(humidity);

    Serial.print("TARGET:");
    Serial.println(climate.getTargetTemperature());

    Serial.print("COOLING:");
    Serial.println(climate.isCoolingOn());

    Serial.print("HEATING:");
    Serial.println(climate.isHeatingOn());

    Serial.println("------------------");

    delay(2000);
}
