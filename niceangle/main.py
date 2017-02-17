import sys
import os

def decdeg2dms(dd):
	mnt,sec = divmod(dd*3600,60)
	deg,mnt = divmod(mnt,60)
	if len(str(int(mnt))) == 1 and len(str(int(sec))) == 1:
		return str(int(deg))+".0"+str(int(mnt))+"'0"+str(int(sec))+'"'
	elif len(str(int(mnt))) == 1:
		return str(int(deg))+".0"+str(int(mnt))+"'"+str(int(sec))+'"'
	elif len(str(int(sec))) == 1:
		return str(int(deg))+"."+str(int(mnt))+"'0"+str(int(sec))+'"'
	else:
		return str(int(deg))+"."+str(int(mnt))+"'"+str(int(sec))+'"'


loc = os.getcwd()

#test_cases = open(sys.argv[1], 'r')
test_cases = open(loc + "/rawdata.txt", "r")

findpos = 0
for row in test_cases:
	data = row.strip()
	opt = ""
	if data != None:
		saveVec = float(data)
		print decdeg2dms(saveVec)

test_cases.close()






