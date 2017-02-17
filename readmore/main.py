import sys
import os

loc = os.getcwd()

test_cases = open(sys.argv[1], 'r')
#test_cases = open(loc + "/rawdata.txt", "r")

for row in test_cases:
	data = row.strip()
	saveVec = []
	text = None
	if data != None:

		if len(data) <= 55:
			print data

		if len(data) > 55:
			dataVec = data.split(" ")
			sentence = ""
			sentlen = 0
			for word in dataVec:
				sentlen += len(word) + 1
				if sentlen <= 40:
					sentence += word + " "
				else:
					pass
		

			if sentence.strip() != None:
				print sentence.strip() + "... <Read More>"



test_cases.close()

#Tom exhibited.
#Amy Lawrence was proud and glad, and... <Read More>
#Tom was tugging at a button-hole and looking sheepish.
#Two thousand verses is a great many -... <Read More>
#Tom's mouth watered for the apple, but... <Read More>





