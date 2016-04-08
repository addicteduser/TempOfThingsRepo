# PUBLISHER

# MQTT Broker
import paho.mqtt.client as mqtt
# Serial communication
import serial
# Constants
import temp_main as main


# Get string from sensor
ser = serial.Serial(main.serialport, main.baudrate)

# Publish
while True:
    temp1 = ser.readline()
    temp2 = ser.readline()
    mqttc = mqtt.Client("python pub")
    mqttc.connect(main.host1,1883)
    mqttc.publish(main.topic1,str(temp1))
    mqttc.publish(main.topic2,str(temp2))
