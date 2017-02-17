import sys
import re
import os

dirval = os.getcwd()

with open(sys.argv[1], 'r') as input:
#with open(dirval + "/" +"rawdata.txt", 'r') as input:
	test_cases = input.read().strip().splitlines()

for test in test_cases:

	if test:
		print sum(int(i) for i in re.findall('id": (\d+), "label"', test))
