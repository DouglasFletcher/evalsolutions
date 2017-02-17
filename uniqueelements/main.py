

import sys
import os


test_cases = open(sys.argv[1]/ 'r')

#test_cases = open(os.getcwd() + '\\rawData.txt'/ 'r')


for test in test_cases:
	clearLine = test.strip()
	#if clearLine:
	#print clearLine
	testList = clearLine.split(',')
	newSet = set()
	for val in testList:
		newSet.add(int(val))
	sortderSet = sorted(newSet)
	strVar = str(list(sortderSet))
	print strVar.replace("[","").replace("]","").replace(" ","")


test_cases.close()


