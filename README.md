# Temperature of Things

## Synopsis

A project for the Internet of Things class that makes use of multiple sensors and an MQTT broker. This is implemented with Java, Python, and MySQL.

## Pre-requirements

* python v2.7 https://www.python.org/downloads/
	* 3.x does not have support for mysql yet
* pyserial (to import serial) https://pyserial.readthedocs.org/en/latest/pyserial.html
* paho-mqtt (to import paho) https://pypi.python.org/pypi/paho-mqtt/1.1
* mysqldb (to be able to save in the database) https://pypi.python.org/pypi/MySQL-python/1.2.5
* java
* jdbc mysql-java connector
* ini4j to easily parse .ini config files http://ini4j.sourceforge.net/index.html
* mysql server
* mosquitto http://mosquitto.org/download/

## How to Use

* Set up arduino/sensors
* Start the mysql server
* Set up the database
* Start the mqtt broker
* Run the following python scripts
	* temp_pub.py
	* temp_sub1.py
	* temp_sub2.py
* Run the Driver.java
