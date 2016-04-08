
#include <SoftwareSerial.h>

int analogPIN = 0;
int sensor_value = 0;
int temp = 0;
int buttonState = 0;
int buttonPin = 17;
int ledPin = 8;

void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);
  pinMode(ledPin, OUTPUT);
  pinMode(buttonPin, INPUT);
  digitalWrite(17, HIGH);
}

void loop() {
  // put your main code here, to run repeatedly:

  // GETS TEMP DATA
  sensor_value = analogRead(analogPIN);
  temp = (5 * sensor_value * 100) / 1024;
  Serial.println(temp);

  buttonState = digitalRead(buttonPin);
  if(buttonState == LOW) { // if pressed
    digitalWrite(ledPin, HIGH);
    Serial.println("ON");
  } else {
    digitalWrite(ledPin, LOW);
    Serial.println("OFF");
  }

  delay(1000);

  clearall();
}

void clearall() {
  digitalWrite(12, LOW);
  digitalWrite(13, LOW);
}

