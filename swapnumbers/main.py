import sys
import os

projloc = os.getcwd()
print projloc
#test_cases = open(sys.argv[1], 'r')
test_cases = open(projloc + "/rawdata.txt")

for test in test_cases:
	teststr = str(test.strip())
	if teststr != None:
		words = teststr.split(" ")

		sentence =""
		for word in words:
			sentence += str(word[-1:])
			sentence += str(word[1:-1])
			sentence += str(word[0:1])
			sentence += " "

		if sentence.strip() != "<tmp>":
			print sentence.strip()

test_cases.close()
