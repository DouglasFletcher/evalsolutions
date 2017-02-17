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
		dataVec = data.split()
		dataSorted = data.split()
		dataSorted.sort()

		truth = True
		while truth:
			if len(dataSorted)== 0:
				print 0
				break

			minval = min(dataSorted)
			if minval in dataSorted:
				dataSorted.pop(0)
			if minval in dataSorted:
				dataSorted = remove_values_from_list(dataSorted, minval)
			else:
				print dataVec.index(minval) + 1
				truth = False


test_cases.close()



