import test_pub1 as pub1	# Synthetic data
#import temp_pub1 as pub1	# From sensor

import test_pub2 as pub2	# Synthetic data
#import temp_pub2 as pub2	# From sensor

import temp_sub1 as sub1
import temp_sub2 as sub2


# Create threads
s1 = sub1.SubThread()
s2 = sub2.SubThread()
p1 = pub1.PubThread()
p2 = pub2.PubThread()


# Start threads
s1.start()
s2.start()
p1.start()
p2.start()
