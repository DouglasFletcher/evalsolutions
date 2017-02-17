import sys
import os
import math

loc = os.getcwd()

with open(sys.argv[1], 'r') as input:
#with open(loc + "/rawdata.txt", "r") as input:

	test_cases = input.read().strip().splitlines()


for line in test_cases:
	num = [int(i) for i in line.replace(',','').replace('(','').replace(')','').split()]
	print int(math.sqrt((num[0] - num[2]) ** 2 + (num[1] - num[3]) ** 2))

input.close()