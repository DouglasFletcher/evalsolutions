import sys
import os
import json

loc = os.getcwd()

test_cases = open(sys.argv[1], 'r')
#test_cases = open(loc + "/rawdaata.txt", "r")

def remove_values_from_list(the_list, val):
	return [value for value in the_list if value != val]


for row in test_cases:
	data = row.strip()
	if data != None:
		dataVec = data.split(";")
		numVec = []

		for val in dataVec:
			if val == "zero":
				numVec.append("0")
			if val == "one":
				numVec.append("1")
			if val == "two":
				numVec.append("2")
			if val == "three":
				numVec.append("3")
			if val == "four":
				numVec.append("4")
			if val == "five":
				numVec.append("5")
			if val == "six":
				numVec.append("6")
			if val == "seven":
				numVec.append("7")
			if val == "eight":
				numVec.append("8")
			if val == "nine":
				numVec.append("9")

		print "".join(numVec)


test_cases.close()



