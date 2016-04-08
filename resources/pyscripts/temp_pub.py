# PUBLISHER

# MQTT Broker
import paho.mqtt.client as mqtt
# Serial communication
import serial
# Constants
import temp_config as config


print("Running PUBLISHER...")

# Get string from sensor
ser = serial.Serial(config.serialport, config.baudrate)

# Publish
while True:
    temp1 = ser.readline()
    temp2 = ser.readline()
    mqttc1 = mqtt.Client("python pub")
    mqttc2 = mqtt.Client("python pub")
    mqttc1.connect(config.host1, config.port)
    mqttc2.connect(config.host1, config.port)
    mqttc1.publish(config.topic1, str(temp1))
    mqttc2.publish(config.topic2, str(temp2))
