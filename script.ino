#include "dht.h"


const int soilRead = A0;
const int dht11Read = A1;
const int waterRead = A2; 
const int fireRead = A3;
const int pinOut = 8;

dht DHT;

void setup()
{
  Serial.begin(9600);
  delay(1000);
  pinMode(pinOut, OUTPUT);
  digitalWrite(pinOut, LOW);
}

void loop()
{
  int value = analogRead(waterRead);
  int sensorValue = analogRead(soilRead);
  int fireValue = analogRead(fireValue);
  float moisture_percentage = map(sensorValue, 0, 1023, 100, 0);
  DHT.read11(dht11Read);

  
  if(moisture_percentage < 50 && value < 480)
  {
    digitalWrite(pinOut, HIGH);
  }
  else if(moisture_percentage >= 60 || value >=480)
  {
    digitalWrite(pinOut, LOW);
  }

  delay(10000);

  Serial.print("waterLevel=");
  Serial.print(value);
  Serial.print("\n");
  Serial.print("soilMoisture=");
  Serial.print(moisture_percentage);
  Serial.print("\n");
  Serial.print("humidity=");
  Serial.print(DHT.humidity);
  Serial.print("\n");
  Serial.print("temperature=");
  Serial.print(DHT.temperature); 
  Serial.print("\n");
  Serial.print("fire=");
  Serial.print(fireValue);
  Serial.print("\n");

  
  delay(1000);
}
