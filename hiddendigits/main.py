import sys
import os
import string

#di=dict(zip(string.letters.lower(),[ord(c)%32 for c in string.letters]))

di=dict({'a':0,'b':1,'c':2,'d':3,'e':4,'f':5,'g':6,'h':7,'i':8,'j':9})
ni=dict({'0':0,'1':1,'2':2,'3':3,'4':4,'5':5,'6':6,'7':7,'8':8,'9':9})

loc = os.getcwd()

test_cases = open(sys.argv[1], 'r')
#test_cases = open(loc + "/rawdata.txt", "r")

for row in test_cases:
	data = row.strip()
	saveVec = []
	text = None
	if data != None:
		datavec = list(data)

		for val in datavec:
			try:
				saveVec.append(str(int(di[val])))
			except:
				pass

			try:
				saveVec.append(str(int(ni[val])))
			except:
				pass


		if len(saveVec) > 0:
			print "".join(saveVec)
		else:
			print 'NONE'

test_cases.close()


