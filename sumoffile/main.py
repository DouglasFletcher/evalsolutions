import sys
import os

loc = os.getcwd()

test_cases = open(sys.argv[1], 'r')
#test_cases = open(loc + "/rawdata.txt", "r")

sumvar = 0
for test in test_cases:

	test = test.strip()
	if test != None:
		sumvar += int(test)

print sumvar


test_cases.close()



