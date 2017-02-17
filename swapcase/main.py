import sys
import os

loc = os.getcwd()

test_cases = open(sys.argv[1], 'r')
#test_cases = open(loc + "/rawdata.txt", "r")

for row in test_cases:
	data = row.strip()
	if data != None:
		print data.swapcase()

test_cases.close()






