import sys
import os

loc = os.getcwd()

test_cases = open(sys.argv[1], 'r')
#test_cases = open(loc + "/rawdata.txt", "r")

for row in test_cases:
	data = row.strip()
	dataVec = []
	if data != None:
		dataVec = data.split(";")
		days = int(dataVec[0])
		returns = dataVec[1].split(" ")
		base = 0
		for start in range(len(returns) - days + 1):
			sumTot = 0
			for val in range(days):
				sumTot += int(returns[start + val])
			if sumTot > base:
				base = sumTot
			else:
				pass

		print base

test_cases.close()






