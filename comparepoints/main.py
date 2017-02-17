import sys
import os

loc = os.getcwd()

#with open(sys.argv[1], 'r') as input:
with open(loc + "/rawdata.txt", "r") as input:
	test_cases = input.read().strip().splitlines()

for line in test_cases:

	lineval = line.split(" ")
	o = lineval[0]
	p = lineval[1]
	q = lineval[2]
	r = lineval[3]

	dirn = ""
	if (p < r):
		dirn += 'N'
	elif (p > r):
		dirn += 'S'

	if (o < q):
		dirn += 'E'
	elif (o > q):
		dirn += 'W'

	if (dirn == ""):
		dirn = "here"

	print dirn

input.close()