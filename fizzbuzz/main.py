import sys
import os

loc = os.getcwd()

test_cases = open(sys.argv[1], 'r')
#test_cases = open(loc + "/rawdata.txt", "r")


for test in test_cases:

	test = test.strip()
	if test != None:
		testList = test.split(" ")
		#print testList
		resultList = []
		for val in range(1, int(testList[2]) + 1):
			
			if val % int(testList[0]) == 0 and val % int(testList[1]) == 0:
				resultList.append("FB")

			elif val % int(testList[0]) == 0:
				resultList.append("F")

			elif val % int(testList[1]) == 0:
				resultList.append("B")

			else:
				resultList.append(str(val))
		
		print " ".join(resultList)

test_cases.close()



