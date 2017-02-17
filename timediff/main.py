import sys
import os
import time

time.strftime('%H:%M:%S', time.gmtime(12345))

loc = os.getcwd()

test_cases = open(sys.argv[1], 'r')
#test_cases = open(loc + "/rawdata.txt", "r")

for row in test_cases:
	data = row.strip()
	if data != None:
		saveVec = data.split(" ")

		start = saveVec[0]
		startVec = start.split(":")
		startsec = int(startVec[2]) + int(startVec[1]) * 60 + int(startVec[0]) * 60 * 60

		finish = saveVec[1]
		finishVec = finish.split(":")
		finishsec = int(finishVec[2]) + int(finishVec[1]) * 60 + int(finishVec[0]) * 60 * 60

		diffsec = abs(startsec - finishsec)
		print time.strftime('%H:%M:%S', time.gmtime(diffsec))




test_cases.close()






