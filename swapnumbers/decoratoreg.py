

class pushit:

	def __init__(self, f):
		print("inside function.__init__()")
		f()

	def __call__(self):
		print("inside decorator.__call__")

@pushit
def aFunction(inOne):
	print("inside aFunction")



aFunction()

