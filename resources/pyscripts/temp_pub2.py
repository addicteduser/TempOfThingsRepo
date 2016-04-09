# PUBLISHER

# MQTT Broker
import paho.mqtt.client as mqtt
# Serial communication
import serial
# Constants
import temp_config as config


print("Running PUBLISHER 2...")

# Get string from sensor2
ser = serial.Serial(config.serialport2, config.baudrate)

# Publish
while True:
    # Receive data from the sensor2
    temp = ser.readline()

    mqttc = mqtt.Client("python pub")

    print("Connecting to host2 [" + config.host2 + ":" + config.mqttport + "]")
    mqttc.connect(config.host2, config.mqttport)

    print("Publishing to topic2 [" + config.topic2 + "] the message [" + str(temp).strip() + "]")
    mqttc.publish(config.topic2, str(temp).strip(), int(config.qos))

    print("-----")
