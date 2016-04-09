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


class PubThread1(threading.Thread):
    def run(self):
        print("Running TEST PUBLISHER 2...")
        start_publisher()


# Publish
def start_publisher():
    while True:
        # Generate random numbers
        temp = random.uniform(1.0,30.0)

        mqttc = mqtt.Client("python pub")

        print("Connecting to host2 [" + config.host2 + ":" + config.mqttport + "]")
        mqttc.connect(config.host2, config.mqttport)

        print("Publishing to topic2 [" + config.topic2 + "] the message [" + str(temp).strip() + "]")
        mqttc.publish(config.topic2, str(temp).strip(), int(config.qos))

        # Delay for 5 seconds. For the actual publisher, the delay is handled by the sensor's program.
        time.sleep(5)

        print("-----")
