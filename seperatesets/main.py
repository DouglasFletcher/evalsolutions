import sys
import os

loc = os.getcwd()

#test_cases = open(sys.argv[1], 'r')
test_cases = open(loc + "/rawdata.txt", "r")


for test in test_cases:

	test = test.strip()
	if test != None:
		testList = test.split(";")
		set1 = set(testList[0].split(','))
		set2 = set(testList[1].split(','))

		x = set.intersection(*[set1, set2])

		a = list(x)
		a.sort()

		w = str()
		i = 0
		for val in a:
			if i == 0:
				w = str(val)
			else:
				w += ',' + str(val)
			i+= 1

		print w


test_cases.close()



