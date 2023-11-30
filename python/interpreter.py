import datetime
import goldException
import errorHandler
class interpreter:
  custom=[]
  def concate(self,s1,s2):
    return s1+""+s2
  def __init__(self,args=["Gold_Program"]):
    custom=args
  def run(self,filename):
    ret=""
    Ehandler=errorHandler()
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
    vars=[]
    while a==1:
      unparse=contents[b]
      command=unparse.split(" ")
      tempstring=command[0]
      if command=="goif":
        try:
          tempstring=command[1]
          tempint=int(tempstring)
          tempstring=command[2]
          tempint2=int(vars[int(command[3])])
          tempint3=int(vars[int(command[4])])
          if tempstring=="==":
            if tempint2==tempint3:
              b=tempint
          elif tempstring==">":
            if tempint2>tempint3:
              b=tempint
          elif tempstring=="<":
            if tempint2<tempint3:
              b=tempint
          elif tempstring==">=":
            if tempint2>=tempint3:
              b=tempint
          elif tempstring=="<=":
            if tempint2<=tempint3:
              b=tempint
          elif tempstring=="!=":
            if tempint2!=tempint3:
              b=tempint
          else:
            lastgolderror=goldException(self.concate(inloc,":Error[2]:Failed to parse command <goif>"),"Command_error")
            Ehandler.adderror(lastgolderror)
        except:
          lastgolderror=goldException(self.concate(inloc,":Error[2]:Failed to parse command <goif>"),"Command_error")
      elif
