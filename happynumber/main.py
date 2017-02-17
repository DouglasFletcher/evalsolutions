import sys
import os

loc = os.getcwd()

def is_happy_number(n):
	seen = set()
	while True:
		digits = [int(c) for c in str(n)]
		n = sum(digit**2 for digit in digits)
		if n == 1:
			return 1
		elif n in seen:
			return 0
		seen.add(n)



test_cases = open(sys.argv[1], 'r')
#test_cases = open(loc + "/rawdata.txt", "r")


for test in test_cases:

	test = test.strip()
	if test != None:

		print is_happy_number(test)


test_cases.close()



