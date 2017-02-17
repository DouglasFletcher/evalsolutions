import sys
import os

loc = os.getcwd()

test_cases = open(sys.argv[1], 'r')
#test_cases = open(loc + "/rawdata.txt", "r")


for test in test_cases:

	test = test.strip()
	if test != None:
		testList = test.split(",")
		#print testList
		a = int(testList[0])
		b = int(testList[1])
		if a < b:
			print a
		if a > b:
			print a - int(a / b) * b
		if a == b:
			print 0

test_cases.close()



