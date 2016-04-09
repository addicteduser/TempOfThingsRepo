long randNum;

void setup(){
  Serial.begin(9600);
}

void loop(){ 
  // Generate random numbers
  randNum = random(30.00);
  
  // Send data
  Serial.println(randNum);
  
  // Delay
  delay(5000);
}
