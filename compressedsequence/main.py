import sys
import os
import json

loc = os.getcwd()

test_cases = open(sys.argv[1], 'r')
#test_cases = open(loc + "/rawdata.txt", "r")


for row in test_cases:
	data = row.strip()
	if data != None:
		dataVec = data.split()
		saveVec = []
		for val in range(len(dataVec)):

			# single value
			if len(dataVec) == 1:
				saveVec.append(str(1))
				saveVec.append(str(dataVec[0]))

			# multi len
			else:
				if val == 0:
					count = 1
				elif val != 0 and val < len(dataVec) - 1:
					if dataVec[val] == dataVec[val - 1]:
						count += 1
					else:
						saveVec.append(str(count))
						saveVec.append(str(dataVec[val-1]))
						count = 1
				elif val == len(dataVec) -1:
					if dataVec[val] == dataVec[val -1]:
						saveVec.append(str(count+1))
						saveVec.append(str(dataVec[val]))
					else:
						saveVec.append(str(count))
						saveVec.append(str(dataVec[val-1]))
						saveVec.append(str(1))
						saveVec.append(str(dataVec[val]))

		print " ".join(saveVec)

test_cases.close()

#4 40 8 29 2 57 5 92 10 86
##4 73 10 41
#2 1 3 3 4 2 3 14 3 11 1 2
#1 7

