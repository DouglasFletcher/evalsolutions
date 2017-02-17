import sys
import os

loc = os.getcwd()

def armstrong(n):

	num = int(n)

	# initialise sum
	sumVal = 0

	# find the sum of the cube of each digit
	temp = list(n)
	for val in temp:
		#print val
		sqrVal = int(val) ** (len(temp))
		sumVal += sqrVal
	#print num
	#print sumVal

	# display the result
	if num == sumVal:
		return True
	else:
		return False


test_cases = open(sys.argv[1], 'r')
#test_cases = open(loc + "/rawdata.txt", "r")


for test in test_cases:

	test = test.strip()
	if test != None:

		print armstrong(test)


test_cases.close()



