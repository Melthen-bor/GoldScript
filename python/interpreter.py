import datetime
class goldException():
  message=""
  type=""
  def _init_(self,error,type):
    self.message="\033[31m"+error+"\033[0m"
    self.type=type
  def geterror(self):
    return self.message
  def gettype(self):
    return self.type
class errorHandler:
  errors=[]
  nexterror=0
  created="no"
  def _init_(self):
    created="yes"
  def adderror(self,error):
    errors+=[error]
    nexterror+=1
  def removeerror(self,error):
    errors-=[error]
    nexterror-=1
  def rethrow(self):
    a=1
    b=""
    c=0
    while a==1:
      try:
        d=errors[c]
        b=d.getmessage()
        b+=","
        b+=d.gettype()
        print(b)
        c+=1
      except:
        a=0
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
    templist=["a"]
    lastgolderror=""
    tempinter=""
    vars=[]
    c=250
    while c>=1:
      vars+=[0]
      c-=1
    while a==1:
      try:
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
            Ehandler.adderror(lastgolderror)
        elif tempstring=="go":
          try:
            tempint=int(command[1])
            b=tempint
          except:
            lastgolderror=goldException(self.concate(inloc,":Error[1]:Failed to parse command <go>"),"Command_error")
            Ehandler.adderror(lastgolderror)
        elif tempstring=="throw":
          try:
            tempstring=command[1]
            try:
              temptype=command[2]
              if temptype=="Command_error":
                temptype="Thrown_error"
            except:
              temptype="Thrown_error"
          except:
            tempstring="Error[?]:Undefined"
            temptype="Thrown_error"
          lastgolderror=goldException(self.concate(inloc,self.concate(":",tempstring)),temptype)
          Ehandler.adderror(lastgolderror)
          elif tempstring=="import":
            try:
              tempstring=command[1]
              tempint=int(command[2])
              templist[0]=command[3]
              tempinter=inerpreter(templist)
              vars[tempint]=tempinter.run(tempstring)
            except:
              lastgolderror=goldException(self.concate(inloc,":Error[3]:Failed to parse command <import>"),"Command_error")
              Ehandler.adderror(lastgolderror)
          elif tempstring=="return":
            try:
              tempstring=command[1]
              if tempstring=="custom":
                tempstring=command[2]
                ret=tempstring
              elif tempstring=="variable":
                tempint=int(command[2])
                tempstring=vars[tempint]
                ret=tempstring
              else:
                lastgolderror=goldException(self.concate(inloc,":Error[4]:Failed to parse command <return>"),"Command_error")
                Ehandler.adderror(lastgolderror)
            except:
              lastgolderror=goldException(self.concate(inloc,":Error[4]:Failed to parse command <return>"),"Command_error")
              Ehandler.adderror(lastgolderror)
          elif tempstring=="assign":
            try:
              tempint=int(command[1])
              tempstring=command[2]
              vars[tempint]=tempstring
            except:
              lastgolderror=goldException(self.concate(inloc,":Error[5]:Failed to parse command <assign>"),"Command_error")
              Ehandler.adderror(lastgolderror)
          elif tempstring=="time":
            try:
              tempint=int(command[1])
              time=datetime.datetime.now()
              vars[tempint]=Str(time)
            except:
              lastgolderror=goldException(self.concate(inloc,":Error[6]:Failed to parse command <time>"),"Command_error")
              Ehandler.adderror(lastgolderror)
          elif tempstring=="format":
            try:
              tempstring=command[1]
              tempint=int(command[2])
              if tempstring=="time":
                tempstring=command[3]
                timestring=time.strftime(tempstring)
                vars[tempint]=tempstring
              else:
                lastgolderror=goldException(self.concate(inloc,":Error[7]:Failed to parse command <format>"),"Command_error")
                Ehandler.adderror(lastgolderror)
            except:
              lastgolderror=goldException(self.concate(inloc,":Error[7]:Failed to parse command <format>"),"Command_error")
              Ehandler.adderror(lastgolderror)
        elif tempstring=="out":
          try:
            tempstring=command[1]
            if tempstring=="variable":
              tempint=int(command[2])
              tempstring=vars[tempint]
              print(tempstring)
            elif tempstring=="custom":
              tempstring=command[2]
              print(tempstring)
            else:
              lastgolderror=goldException(self.concate(inloc,":Error[8]:Failed to parse command <out>"),"Command_error")
              Ehandler.adderror(lastgolderror)
          except:
            lastgolderror=goldException(self.concate(inloc,":Error[8]:Failed to parse command <out>"),"Command_error")
            Ehandler.adderror(lastgolderror)
        else:
          lastgolderror=goldException(self.concate(inloc,":Error[0]:Unknown command"),"Command_error")
          Ehandler.adderror(lastgolderror)
        b+=1
      except:
        a=0
        Ehandler.rethrow()
        return ret
if __name__=="__main__":
  file=input()
  inter=interpreter()
  inter.run(file)
