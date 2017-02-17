import sys
import os
import time

time.strftime('%H:%M:%S', time.gmtime(12345))

loc = os.getcwd()

test_cases = open(sys.argv[1], 'r')
#test_cases = open(loc + "/rawdata.txt", "r")

findpos = 0
for row in test_cases:
	data = row.strip()
	opt = ""
	if data != None:
		saveVec = data.split(" ")
		#print saveVec
		# get spliter
		try:
			findpos = saveVec[1].index("+")
			opt = "+"
		except: 
			findpos = saveVec[1].index("-")
			opt = "-"

		if opt == "+":
			print int(saveVec[0][0:findpos]) + int(saveVec[0][findpos:])
		if opt == "-":
			print int(saveVec[0][0:findpos]) - int(saveVec[0][findpos:])


test_cases.close()






