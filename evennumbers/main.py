import sys
import os
from ast import literal_eval

loc = os.getcwd()

test_cases = open(sys.argv[1], 'r')
#test_cases = open(loc + "/rawdata.txt", "r")

for line in test_cases:
	test = line.strip()
	if test != None:
		if int(test) % 2 == 0:
			print 0
		else:
			print 1



test_cases.close()



