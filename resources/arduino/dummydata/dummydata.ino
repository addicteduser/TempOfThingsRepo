int i = 1;

void setup(){
  Serial.begin(9600);
}

void loop(){
  Serial.println(i); // tempdata1
  Serial.println(i+10); // tempdata2
  delay(5000);
  i++;
}
