# TEST PUBLISHER

# MQTT Broker
import paho.mqtt.client as mqtt
# Constants
import temp_config as config
# Random number generator
import random
# Delay
import time
import threading

class PubThread(threading.Thread):
    def run(self):
        print("Running TEST PUBLISHER 1...")
        start_publisher()


# Publish
def start_publisher():
    while True:
        # Generate random numbers
        temp = random.uniform(1.0,30.0)

        mqttc = mqtt.Client("python pub")

        print("Connecting to host1 [" + config.host1 + ":" + config.mqttport + "]")
        mqttc.connect(config.host1, config.mqttport)

        print("Publishing to topic1 [" + config.topic1 + "] the message [" + str(temp).strip() + "]")
        mqttc.publish(config.topic1, str(temp).strip(), int(config.qos))

        # Delay for 5 seconds. For the actual publisher, the delay is handled by the sensor's program.
        time.sleep(5)

        print("-----")
