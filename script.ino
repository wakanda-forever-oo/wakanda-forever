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
}

void loop()
{
  int value = analogRead(waterRead);
  int sensorValue = analogRead(soilRead);
  int fireValue = analogRead(fireValue);
  double moisture_percentage = ( 100 - ( (sensorValue/1023.00) * 100 ) );
  DHT.read11(dht11Read);

  digitalWrite(pinOut, HIGH);


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

  digitalWrite(pinOut, LOW);

  delay(5000);

  
}
