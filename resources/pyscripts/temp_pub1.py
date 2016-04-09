# PUBLISHER

# MQTT Broker
import paho.mqtt.client as mqtt
# Serial communication
import serial
# Constants
import temp_config as config


print("Running PUBLISHER 1...")

# Get string from sensor1
ser = serial.Serial(config.serialport1, config.baudrate)

# Publish
while True:
    # Receive data from the sensor1
    temp = ser.readline()

    mqttc = mqtt.Client("python pub")

    print("Connecting to host1 [" + config.host1 + ":" + config.mqttport + "]")
    mqttc.connect(config.host1, config.mqttport)

    print("Publishing to topic1 [" + config.topic1 + "] the message [" + str(temp).strip() + "]")
    mqttc.publish(config.topic1, str(temp).strip(), int(config.qos))

    print("-----")
