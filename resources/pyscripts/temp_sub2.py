# MQTT Broker
import paho.mqtt.client as mqtt
# Database connection
import temp_dbconnector as db
# Constants
import temp_main as main

# The callback for when the client receives a CONNACK response from the server.
def on_connect(client, userdata, rc):
    print("Connected with result code"+ str(rc))
    client.subscribe(main.topic2)
# Subscribing in on_connect() means that if we lose the connection and
# reconnect then subscriptions will be renewed.

# The callback for when a PUBLISH message is received from the server.
def on_message(client, userdata, msg):
    print("Topic: "+msg.topic)
    print("Message: "+str(msg.payload))
    db.addDataToSensor(2, float(msg.payload))


# Create broker
client = mqtt.Client()

# Define callbacks
client.on_connect = on_connect
client.on_message = on_message

# Define host/ip address where sensor is connected
client.connect(main.host2, 1883, 60)

# Run subscriber indefinitely
client.loop_forever()
