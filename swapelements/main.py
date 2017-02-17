import sys
import os
import json

loc = os.getcwd()

test_cases = open(sys.argv[1], 'r')
#test_cases = open(loc + "/rawdata.txt", "r")

def remove_values_from_list(the_list, val):
	return [value for value in the_list if value != val]


for row in test_cases:
	data = row.strip()
	if data != None:
		rawVec = data.split(":")

		dataVec = rawVec[0].split(" ")
		splitVec = rawVec[1].split(",")

		for val in splitVec:
			first = int(val.split("-")[0].strip())
			second = int(val.split("-")[1].strip())

			listVal1 = dataVec[first]
			listVal2 = dataVec[second]

			dataVec[first] = listVal2
			dataVec[second] = listVal1

		print " ".join(dataVec).strip()

test_cases.close()



