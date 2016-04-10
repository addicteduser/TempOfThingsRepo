# Temperature of Things

## Synopsis
A project for the Internet of Things class (CSC700M AY 15-16) that makes use of multiple sensors and an MQTT broker. This is implemented with Java (user interface), Python (serial communication with sensor; MQTT broker publisher and subscriber), and MySQL (database).

## Pre-requirements
* Python v2.7
	* 3.x does not have support for `MySQLdb` yet
	* https://www.python.org/downloads/
* `PySerial`
	* for serial comminication with the Arduino
	* `import serial`
	* https://pyserial.readthedocs.org/en/latest/pyserial.html
* Eclipse Paho MQTT Python client library
	* for MQTT functions
	* `import paho.mqtt.client`
	* https://pypi.python.org/pypi/paho-mqtt/1.1
* `MySQLdb`
	* Python interface to MySQL
	* `import mysqldb`
	* https://pypi.python.org/pypi/MySQL-python/1.2.5
* Java
	* https://java.com/en/download/
* Java Database Connectivity (JDBC) *(included in /lib/)*
	* http://dev.mysql.com/downloads/connector/j 
* ini4j *(included in /lib/)*
	* Java API for handling configuration files in Windows .ini format
	* http://ini4j.sourceforge.net/index.html
* MyySQL server
	* for database
	* https://www.mysql.com/downloads/
* Mosquitto
	* to enable the machine with MQTT function
	* http://mosquitto.org/download/

## How to Use
* Set up arduino/sensors *(see /resources/arduino/)*
* Start the mysql server
* Set up the database *(see /resources/sqlscripts/)*
* Start the mqtt broker
* Run the `temp_main.py` to invoke the Publisher and Subscriber *(see /resources/pyscripts/)*
	* Choose which Publisher you'd like to try: test_pub or temp_pub
* Run the `Driver.java` *(see /src/)*
	* Opens the user interface
