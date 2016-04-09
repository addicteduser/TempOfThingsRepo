import ConfigParser


filepath = "../config.ini"
parser = ConfigParser.ConfigParser()
parser.readfp(open(name=filepath, mode='r'))

serialport1 = parser.get('SERIAL', 'serialport1')
serialport2 = parser.get('SERIAL', 'serialport2')
baudrate = parser.get('SERIAL', 'baudrate')

host1 = parser.get('MQTT', 'host1')
host2 = parser.get('MQTT', 'host2')
topic1 = parser.get('MQTT', 'topic1')
topic2 = parser.get('MQTT', 'topic2')
mqttport = parser.get('MQTT', 'mqttport')
qos = parser.get('MQTT', 'qos')

dbhost = parser.get('DATABASE', 'dbhost')
dbuser = parser.get('DATABASE', 'dbuser')
dbpass = parser.get('DATABASE', 'dbpass')
dbname = parser.get('DATABASE', 'dbname')
