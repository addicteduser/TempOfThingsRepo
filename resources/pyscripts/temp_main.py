import thread
import test_pub1 as pub1
import test_pub2 as pub2


t1 = pub1.PubThread1()
t2 = pub2.PubThread1()

t1.start()
t2.start()

print ("hi")
