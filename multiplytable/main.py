import sys
import os

loc = os.getcwd()

#test_cases = open(sys.argv[1], 'r')
#test_cases = open(loc + "/rawdata.txt", "r")


for j in range(12):
	
	jply = j + 1
	row = ""

	for i in range(12):
	

		multi = str(jply * (i + 1))

		if len(multi) == 1:
			row += "   " + multi
		if len(multi) == 2:
			row += "  " + multi
		if len(multi) == 3:
			row += " " + multi

	print row



#test_cases.close()






