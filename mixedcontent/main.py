import sys
import os
import json

loc = os.getcwd()

test_cases = open(sys.argv[1], 'r')
#test_cases = open(loc + "/rawdata.txt", "r")

for row in test_cases:
	data = row.strip()
	if data != None:
		dataVec = data.split(",")
		strVec = []
		intVec = []
		for val in dataVec:
			try:
				valnew = int(val)
			except:
				valnew = val

			if isinstance(valnew, str):
				strVec.append(valnew)
			if isinstance(valnew, int):
				intVec.append(str(valnew))

		if len(intVec) > 0 and len(strVec) > 0:
			print ",".join(strVec) + "|" + ",".join(intVec)
		if len(intVec) == 0:
			print ",".join(strVec)
		if len(strVec) == 0:
			print ",".join(intVec)



test_cases.close()


