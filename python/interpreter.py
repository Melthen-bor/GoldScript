import datetime
import random
import js2py
class goldException():
    def __init__(self,error,error_type):
        self.message="\033[31m"+error+"\033[0m"
        self.error_type=error_type
    def geterror(self):
        return self.message
    def gettype(self):
        return self.error_type
class errorHandler():
    def __init__(self):
        self.errors=[]
        self.nexterror=0
    def adderror(self,error):
        self.errors+=[error]
        self.nexterror+=1
    def rethrow(self):
        a=1
        b=""
        c=0
        while a==1:
            try:
                d=self.errors[c]
                b=d.getmessage()
                b+=","
                b+=d.gettype()
                print(b)
                c+=1
            except:
                a=0
class d3_vector():
    def __init__(self,a=0,b=0,c=0):
        self.a=a
        self.b=b
        self.c=c
    def from_list(self,a):
        self.a=int(a[0])
        self.a=int(a[1])
        self.a=int(a[2])
    def cross(self,a,b):
        self.a=a[1]*b[2]-a[2]*b[1]
        self.b=a[2]*b[0]-a[0]*b[2]
        self.c=a[0]*b[1]-a[1]*b[0]
    def to_list(self):
        a=[self.a,self.b,self.c]
        return a
def concate(s0,s1):
  return s0+""+s1
def parse_list(a):
    d=1
    b=1
    c=str(a[0])
    while b==1:
        try:
            c=concate(c,concate("#",a[d]))
            d+=1
        except:
            b=0
    return c
class interpreter():
    def __init__(self,args):
        self.line=0
        self.inloc=args[0]
        self.vars=[]
        self.ret=""
        self.prevars=[]
        self.vars=[]
        self.Ehandler=errorHandler()
    def gocmd(self,args):
        try:
            self.line=int(args[0])
        except:
            self.Ehandler.adderror(goldException(concate(self.inloc,":Error[1]:Failed to parse command <go>"),"Command_error"))
    def goifcmd(self,args):
        try:
            if args[1]=="==":
                if self.vars[int(args[2])]==self.vars[int(args[3])]:
                    self.line=int(args[0])
            elif args[1]==">":
                if self.vars[int(args[2])]>self.vars[int(args[3])]:
                    self.line=int(args[0])
            elif args[1]=="<":
                if self.vars[int(args[2])]<self.vars[int(args[3])]:
                    self.line=int(args[0])
            elif args[1]==">=":
                if self.vars[int(args[2])]>=self.vars[int(args[3])]:
                    self.line=int(args[0])
            elif args[1]=="<=":
                if self.vars[int(args[2])]<=self.vars[int(args[3])]:
                    self.line=int(args[0])
            elif args[1]=="!=":
                if self.vars[int(args[2])]!=self.vars[int(args[3])]:
                    self.line=int(args[0])
            else:
                self.Ehandler.adderror(goldException(concate(self.inloc,":Error[2]:Failed to parse command <goif>"),"Command_error"))
        except:
            self.Ehandler.adderror(goldException(concate(self.inloc,":Error[2]:Failed to parse command <goif>"),"Command_error"))
    def throwcmd(self,args):
        try:
            self.Ehandler.adderror(goldException(concate(self.inloc,concate(":",args[0])),(args[1] if (args[1]=="Command_error" or args[1]=="System_error") else "Thrown_error")))
        except:
            self.Ehandler.adderror(goldException(concate(self.inloc,":Error[?]:Undefined"),"Thrown_error"))
    def importcmd(self,args):
        try:
            self.vars[int(args[1])]=(Interpreter(args[2].split("#"))).run(args[0],(self.vars[int(args[3])]).split("#"))
        except:
            self.Ehandler.adderror(goldException(concate(self.inloc,":Error[3]:Failed to parse command <import>"),"Command_error"))
    def returncmd(self,args):
        try:
            if args[0]=="String":
                self.ret=args[1]
            elif args[0]=="Variable":
                self.ret=str(self.vars[int(args[1])])
            else:
                self.Ehandler.adderror(goldException(concate(self.inloc,":Error[4]:Failed to parse command <return>"),"Command_error"))
        except:
            self.Ehandler.adderror(goldException(concate(self.inloc,":Error[4]:Failed to parse command <return>"),"Command_error"))
    def assigncmd(self,args):
        try:
            if args[0]=="String":
                self.vars[int(args[1])]=args[2]
            elif args[0]=="Prevar":
                if args[1]=="String":
                    self.vars[int(args[2])]=self.prevars[int(args[3])]
                elif args[1]=="Number":
                    self.vars[int(args[2])]=float(self.prevars[int(args[3])])
            elif args[0]=="Number":
                self.vars[int(args[1])]=float(args[2])
            else:
                self.Ehandler.adderror(goldException(concate(self.inloc,":Error[5]:Failed to parse command <assign>"),"Command_error"))
        except:
            self.Ehandler.adderror(goldException(concate(self.inloc,":Error[5]:Failed to parse command <assign>"),"Command_error"))
    def timecmd(self,args):
        try:
            self.vars[int(args[0])]=(datetime.datetime.now()).strftime(args[1])
        except:
            self.Ehandler.adderror(goldException(concate(self.inloc,":Error[6]:Failed to parse command <time>"),"Command_error"))
    def outcmd(self,args):
        try:
            if args[0]=="String":
                print(args[1],end="")
            elif args[0]=="Variable":
                print(self.vars[int(args[1])],end="")
            elif args[0]=="New":
                print()
            elif args[0]=="Return":
                print("\r",end="")
            else:
                self.Ehandler.adderror(goldException(concate(self.inloc,":Error[7]:Failed to parse command <out>"),"Command_error"))
        except:
            self.Ehandler.adderror(goldException(concate(self.inloc,":Error[7]:Failed to parse command <out>"),"Command_error"))
    def implementcmd(self,args):
        try:
            self.vars[int(args[0])]="1"
        except:
            self.Ehandler.adderror(goldException(concate(self.inloc,":Error[8]:Failed to parse command <implement>"),"Command_error"))
    def inputcmd(self,args):
        try:
            self.vars[int(args[0])]=input()
        except:
            self.Ehandler.adderror(goldException(concate(self.inloc,":Error[9]:Failed to parse command <input>"),"Command_error"))
    def operationcmd(self,args):
        try:
            if args[0]=="+":
                self.vars[int(args[1])]=self.vars[int(args[2])]+self.vars[int(args[3])]
            elif args[0]=="-":
                self.vars[int(args[1])]=self.vars[int(args[2])]-self.vars[int(args[3])]
            elif args[0]=="*":
                self.vars[int(args[1])]=self.vars[int(args[2])]*self.vars[int(args[3])]
            elif args[0]==":":
                self.vars[int(args[1])]=self.vars[int(args[2])]/self.vars[int(args[3])]
            elif args[0]=="**":
                self.vars[int(args[1])]=self.vars[int(args[2])]**self.vars[int(args[3])]
            elif args[0]=="::":
                self.vars[int(args[1])]=self.vars[int(args[2])]**(1/self.vars[int(args[3])])
            elif args[0]=="%":
                self.vars[int(args[1])]=self.vars[int(args[2])]%self.vars[int(args[3])]
            elif args[0]=="$":
                self.vars[int(args[1])]=(1 if (self.vars[int(args[2])]%2) else 0)
            elif args[0]=="&&":
                self.vars[int(args[1])]=concate(self.vars[int(args[2])],self.vars[int(args[3])])
            elif args[0]=="&":
                self.vars[int(args[1])]=self.vars[int(args[2])]&self.vars[int(args[3])]
            elif args[0]=="|":
                self.vars[int(args[1])]=self.vars[int(args[2])]|self.vars[int(args[3])]
            elif args[0]=="^":
                self.vars[int(args[1])]=self.vars[int(args[2])]^self.vars[int(args[3])]
            elif args[0]==">>":
                self.vars[int(args[1])]=self.vars[int(args[2])]>>self.vars[int(args[3])]
            elif args[0]==">>>":
                self.vars[int(args[1])]=self.vars[int(args[2])]>>self.vars[int(args[3])]
            elif args[0]=="<<":
                self.vars[int(args[1])]=self.vars[int(args[2])]<<self.vars[int(args[3])]
            elif args[0]=="~":
                self.vars[int(args[1])]=~(self.vars[int(args[2])])
            elif args[0]=="X":
                self.vars[int(args[1])]=d3vector().cross((d3vector().from_list((self.vars[int(args[2])]).split("#"))),(d3vector().from_list((self.vars[int(args[3])]).split("#"))))
            elif args[0]=="N":
                self.vars[int(args[1])]=float(self.vars[int(args[2])])
            elif args[0]=="E":
                funct=j2py.eval_js(self.vars[int(args[2])])
                self.vars[int(args[1])]=funct()
            else:
                self.Ehandler.adderror(goldException(concate(self.inloc,":Error[10]:Failed to parse command <operation>"),"Command_error"))
        except:
            self.Ehandler.adderror(goldException(concate(self.inloc,":Error[10]:Failed to parse command <operation>"),"Command_error"))
    def run(self,filename,prevars):
        try:
            a=1
            self.prevars=prevars
            fileHandler=open(concate(file_name,".gold"))
            contents=(fileHandler.read()).split("\n")
            b=0
            c=0
            while c<250:
                self.vars+=[""]
                c+=1
            while a==1:
                try:
                    command=contents[b]
                    d=command[0]
                    del command[0]
                    if d=="go":
                        self.gocmd(command)
                    elif d=="goif":
                        self.goifcmd(command)
                    elif d=="throw":
                        self.throwcmd(command)
                    elif d=="import":
                        self.importcmd(command)
                    elif d=="return":
                        self.returncmd(command)
                    elif d=="assign":
                        self.assigncmd(command)
                    elif d=="time":
                        self.timecmd(command)
                    elif d=="out":
                        self.outcmd(command)
                    elif d=="implement":
                        self.implementcmd(command)
                    elif d=="input":
                        self.inputcmd(command)
                    elif d=="operation":
                        self.operationcmd(command)
                    elif d=="comment":
                        print("",end="")
                    else:
                        self.Ehandler.adderror(goldException(concate(self.inloc,":Error[0]:Unknown command"),"Command_error"))
                    b+=1
                except:
                    a=0
        except:
            self.Ehandler.adderror(goldException("Gold_Interpreter:Error[0]:Critical failure","System_error"))
