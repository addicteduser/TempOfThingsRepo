# For database manipulation
import MySQLdb
# Constants
import temp_config as config


# Inserts data to sensor1
def addDataToSensor(topic,tempdata):
    global db, cursor

    open_connection()

    # Prepare SQL query to INSERT a record into the database
    if topic == 1:
        tablename = "sensor1"
    else:
        tablename = "sensor2"

    sql = "INSERT INTO %s (temperature) VALUES (%f)" % (tablename, tempdata)

    try:
        # Execute the SQL command
        print("Executing SQL statement: "+sql)
        cursor.execute(sql)
        # Commit your changes in the database
        print("Committing changes to database...")
        db.commit()
    except:
        # Rollback in case there is any error
        print("Database insert error...")
        db.rollback()
    finally:
        close_connection()

# Opens a connection to the database
def open_connection():
    global db, cursor
    db = MySQLdb.connect(config.dbhost, config.dbuser, config.dbpass, config.dbname)
    cursor = db.cursor()
    print("Open connection...")


# Closes the connection to the database
def close_connection():
    global db
    db.close();
    print("Close connection...")


# Initialization
db = ""
cursor = ""
