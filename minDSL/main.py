import sys
import os


loc = os.getcwd()

test_cases = open(sys.argv[1], 'r')
#test_cases = open(loc + "/rawdata.txt", "r")

m0 = [[0 for x in range(256)] for x in range(256)]

for test in test_cases:

	test = test.strip()
	if test != None:
		testLn = test.split(" ")

		querie = testLn[0]

		if querie == "SetCol":
			for row in range(256):
				m0[row][int(testLn[1])] = int(testLn[2])

		if querie == "SetRow":
			for col in range(256):
				m0[int(testLn[1])][col] = int(testLn[2])

		if querie == "QueryCol":
			sumVal = 0
			for row in range(256):
				sumVal += m0[row][int(testLn[1])]
			print sumVal

		if querie == "QueryRow":
			sumVal = 0
			for col in range(256):
				sumVal += m0[int(testLn[1])][col]
			print sumVal

#5118
#34
#1792
#3571


test_cases.close()



