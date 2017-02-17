


import sys
import os


test_cases = open(sys.argv[1], 'r')

#test_cases = open(os.getcwd() + '\\rawData.txt', 'r')


for test in test_cases:
	clearLine = test.strip()
	if clearLine:
		testList = list(clearLine)
		num = 0
		for val in testList:
			num += int(val)
		print num


test_cases.close()
