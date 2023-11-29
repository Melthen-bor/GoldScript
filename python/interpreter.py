import datetime
import goldException
import errorHandler
class interpreter:
  custom=[]
  def __init__(self,args):
    custom=args
  def run(self,filename):
    fileName=filename+".gold"
    file=open(fileName)
    contents=file.read()
    file.close()
    contents=contents.split("\n")
    
