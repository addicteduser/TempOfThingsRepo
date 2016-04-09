# TEST PUBLISHER

# MQTT Broker
import paho.mqtt.client as mqtt
# Constants
import temp_config as config
# Random number generator
import random
# Delay
import time


# Publish
print("Running TEST PUBLISHER...")
while True:
    # Generate random numbers
    temp1 = random.uniform(1.0,30.0)
    temp2 = random.uniform(1.0,30.0)

    mqttc1 = mqtt.Client("python pub")
    mqttc2 = mqtt.Client("python pub")

    mqttc1.connect(config.host1, config.port)
    mqttc2.connect(config.host1, config.port)

    mqttc1.publish(config.topic1, str(temp1))
    mqttc2.publish(config.topic2, str(temp2))

    # Delay for 5 seconds
    time.sleep(5)
