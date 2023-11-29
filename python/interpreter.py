import datetime
import goldException
import errorHandler
class interpreter:
  custom=[]
  def __init__(self,args=["Gold_Program"]):
    custom=args
  def run(self,filename):
    ret=""
    Ehandler=errorHandler();
    fileName=filename+".gold"
    file=open(fileName)
    contents=file.read()
    file.close()
    contents=contents.split("\n")
    a=1
    b=0
    tempint=0
    tempint2=0
    tempint3=0
    tempstring=""
    inloc=custom[0]
    lastgolderror=""
    tempinter=""
    while a==1:
      unparse=contents[b]
      command=unparse.split(" ")
      tempstring=command[0]
      if command=="goif":
        tempstring=command[1]
        tempint=int(command[2])
        
