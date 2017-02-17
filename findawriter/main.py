import sys
import os

loc = os.getcwd()

test_cases = open(sys.argv[1], 'r')
#test_cases = open(loc + "/rawdata.txt", "r")

for row in test_cases:
	data = row.strip()
	dataVec = []
	if data != None:
		dataVec = data.split("|")
		if len(dataVec) == 2:
			letters = list(dataVec[0].strip())
			numbers = dataVec[1].strip().split(" ")
			writer = ""
			for val in numbers:
				writer += letters[int(val) -1]
			print writer

test_cases.close()






