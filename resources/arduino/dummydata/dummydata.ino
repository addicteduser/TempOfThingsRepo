float randNum1;
float randNum2;

void setup(){
  Serial.begin(9600);
}

void loop(){
  // Generate random numbers
  randNum1 = random(30);
  
  // Send data
  Serial.println(randNum1); // tempdata1
  
  // Delay
  delay(5000);
}
