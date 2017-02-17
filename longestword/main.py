import sys
import os

loc = os.getcwd()

test_cases = open(sys.argv[1], 'r')
#test_cases = open(loc + "/rawdata.txt", "r")

for line in test_cases:
	test = line.strip()
	wordlen = 0
	if test != None:
		print max(test.split(), key=len)



test_cases.close()



