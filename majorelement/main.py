import sys
import os

from collections import Counter

loc = os.getcwd()

test_cases = open(sys.argv[1], 'r')
#test_cases = open(loc + "/rawdata.txt", "r")

for row in test_cases:
	data = row.strip()
	if data != None:
		datavec = data.split(",")
		veclen = len(datavec) / 2
		lookup = Counter(datavec)
		MaxVal = None


		for key, value in lookup.iteritems():
			if value > veclen:
				MaxVal = key

		print MaxVal


test_cases.close()


