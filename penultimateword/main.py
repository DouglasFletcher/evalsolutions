import sys
import os

loc = os.getcwd()

#test_cases = open(sys.argv[1], 'r')
test_cases = open(loc + "/rawdata.txt", "r")


for test in test_cases:

	test = test.strip()
	if test != None:
		testList = test.split(";")
		print testList


test_cases.close()



