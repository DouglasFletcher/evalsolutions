import sys
import os
import json

loc = os.getcwd()

test_cases = open(sys.argv[1], 'r')
#test_cases = open(loc + "/rawdata.txt", "r")

for row in test_cases:
	data = row.strip()
	vec3 = []
	if data != None:
		dataVec = data.split("|")
		vec1 = dataVec[0].strip().split(" ")
		vec2 = dataVec[1].strip().split(" ")

		for val in range(len(vec1)):
			vec3.append(str(int(vec1[val]) * int(vec2[val])))

		print " ".join(vec3)

test_cases.close()


