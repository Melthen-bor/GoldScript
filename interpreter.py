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
    def __init__(self,a,b,c):
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
def parse_list(a):
    d=1
    b=1
    c=str(a[0])
    while b==1:
        try:
            c+="split_here"
            c+=str(a[d])
            d+=1
        except:
            b=0
    return c
class interpreter():
    def concate(self,s1,s2):
        return s1+""+s2
    def __init__(self,args=["Gold_Program"]):
        self.custom=args
    def run(self,filename,prevars):
        ret=""
        Ehandler=errorHandler()
        file=open(self.concate(filename,".gold"))
        contents=file.read()
        file.close()
        contents=contents.split("\n")
        inloc=self.custom[0]
        varslist=["","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","",""]
        a=1
        b=0
        while a==1:
            try:
                command=content[b].split(" ")
                tempstring=command[0]
                if tempstring=="goif":
                    try:
                        tempint=int(command[1])
                        tempstring=command[2]
                        tempint2=float(varslist[int(command[3])])
                        tempint3=float(varslist[int(command[4])])
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
                        elif tempsting=="!=":
                            if tempint2!=tempint3:
                                b=tempint
                        else:
                            Ehandler.adderror(goldException(self.concate(inloc,":Error[2]:Failed to parse command <goif>"),"Command_error"))
                    except:
                        Ehandler.adderror(goldException(self.concate(inloc,":Error[2]:Failed to parse command <goif>"),"Command_error"))
                elif tempstring=="go":
                    try:
                        tempint=int(command[1])
                        b=tempint
                    except:
                        Ehandler.adderror(goldException(self.concate(inloc,":Error[1]:Failed to parse command <go>"),"Command_error"))
                elif tempstring=="throw":
                    try:
                        tempstring=command[1]
                        try:
                            temptype=command[2]
                            if temptype=="Command_error":
                                temptype="Thrown_error"
                            elif temptype=="System_error":
                                temptype="Thrown_error"
                        except:
                            temptype="Thrown_error"
                    except:
                        tempstring="Error[?]:undefined"
                        temptype="Thrown_error"
                    Ehandler.adderror(goldException(self.concate(inloc,self.concate(":",tempstring)),temptype))
                elif tempstring=="import":
                    try:
                        tempstring=command[1]
                        tempint=int(command[2])
                        templist=[command[3],""]
                        tempinter=Interpreter(templist)
                        templist=varslist[int(command[4])].split("split_here")
                        varslist[tempint]=tempinter.run(tempstring,templist)
                    except:
                        Ehandler.adderror(goldException(self.concate(inloc,":Error[3]:Failed to parse command <import>"),"Command_error"))
                elif tempstring=="return":
                    try:
                        tempstring=command[1]
                        if tempstring=="custom":
                            ret=command[2]
                        elif tempstring=="variable":
                            ret=varslist[int(command[2])]
                        else:
                            Ehandler.adderror(goldException(self.concate(inloc,":Error[4]:Failed to parse command <return>"),"Command_error"))
                    except:
                        Ehandler.adderror(goldException(self.concate(inloc,":Error[4]:Failed to parse command <return>"),"Command_error"))
                elif tempstring=="assign":
                    try:
                        tempstring=command[1]
                        if tempstring=="string":
                            tempint=int(command[2])
                            tempstring=command[3]
                            varslist[tempint]=tempstring
                        elif tempstring=="prevar":
                            tempint=int(command[2])
                            tempstring=prevars[int(command[3])]
                            varslist[tempint]=tempstring
                        else:
                            Ehandler.adderror(goldException(self.concate(inloc,":Error[5]:Failed to parse command <assign>"),"Command_error"))
                    except:
                        Ehandler.adderror(goldException(self.concate(inloc,":Error[5]:Failed to parse command <assign>"),"Command_error"))
                elif tempstring=="time":
                    try:
                        time=datetime.datetime.now()
                        tempstring=time.strftime("%c")
                        varslist[command[1]]=tempstring
                    except:
                        Ehandler.adderror(goldException(self.concate(inloc,":Error[6]:Failed to parse command <time>"),"Command_error"))
                elif tempstring=="format":
                    try:
                        tempstring=command[1]
                        tempint=int(command[2])
                        if tempstring=="time":
                            tempstring=time.strftime(command[3])
                            varslist[tempint]=tempstring
                        else:
                            Ehandler.adderror(goldException(self.concate(inloc,":Error[7]:Failed to parse command <format>"),"Command_error"))
                    except:
                        Ehandler.adderror(goldException(self.concate(inloc,":Error[7]:Failed to parse command <format>"),"Command_error"))
                elif tempstring=="out":
                    try:
                        tempstring=command[1]
                        if tempstring=="variable":
                            print(varslist[int(command[2])],end="")
                        elif tempstring=="string":
                            print(command[2],end="")
                        elif tempstring=="return":
                            print("\r",end="")
                        elif tempstring=="new":
                            print()
                        else:
                            Ehandler.adderror(goldException(self.concate(inloc,":Error[8]:Failed to parse command <out>"),"Command_error"))
                    except:
                        Ehandler.adderror(goldException(self.concate(inloc,":Error[8]:Failed to parse command <out>"),"Command_error"))
                elif tempstring=="implement":
                    try:
                        varslist[int(command[1])]="1"
                    except:
                        Ehandler.adderror(goldException(self.concate(inloc,":Error[9]:Failed to parse command <implement>"),"Command_error"))
                elif tempstring=="input":
                    try:
                        varslist[int(command[1])]=input()
                    except:
                        Ehandler.adderror(goldException(self.concate(inloc,":Error[10]:Failed to parse command <input>"),"Command_error"))
                elif tempstring=="operation":
                    try:
                        tempstring=command[1]
                        tempint=int(command[2])
                        if tempstring=="+":
                            tempint2=float(varslist[int(command[3])])
                            tempint3=float(varslist[int(command[4])])
                            varslist[tempint]=str(tempint2+tempint3)
                        elif tempstring=="-":
                            tempint2=float(varslist[int(command[3])])
                            tempint3=float(varslist[int(command[4])])
                            varslist[tempint]=str(tempint2-tempint3)
                        elif tempstring=="*":
                            tempint2=float(varslist[int(command[3])])
                            tempint3=float(varslist[int(command[4])])
                            varslist[tempint]=str(tempint2*tempint3)
                        elif tempstring==":":
                            tempint2=float(varslist[int(command[3])])
                            tempint3=float(varslist[int(command[4])])
                            varslist[tempint]=str(tempint2/tempint3)
                        elif tempstring=="**":
                            tempint2=float(varslist[int(command[3])])
                            tempint3=float(varslist[int(command[4])])
                            varslist[tempint]=str(tempint2**tempint3)
                        elif tempsting=="::":
                            tempint2=float(varslist[int(command[3])])
                            tempint3=1/float(varslist[int(command[4])])
                            varslist[tempint]=str(tempint2**tempint3)
                        elif tempstring=="%":
                            tempint2=float(varslist[int(command[3])])
                            tempint3=float(varslist[int(command[4])])
                            varslist[tempint]=str(tempint2%tempint3)
                        elif tempstring=="&&":
                            varslist[tempint]=self.concate(varslist[int(command[3])],varslist[int(command[4])])
                        elif tempstring==">>":
                            tempint2=float(varslist[int(command[3])])
                            tempint3=float(varslist[int(command[4])])
                            varslist[tempint]=str(tempint2>>tempint3)
                        elif tempstring==">>>":
                            tempint2=float(varslist[int(command[3])])
                            tempint3=float(varslist[int(command[4])])
                            varslist[tempint]=str(tempint2>>tempint3)
                        elif tempstring=="<<":
                            tempint2=float(varslist[int(command[3])])
                            tempint3=float(varslist[int(command[4])])
                            varslist[tempint]=str(tempint2<<tempint3)
                        elif tempstring=="|":
                            tempint2=float(varslist[int(command[3])])
                            tempint3=float(varslist[int(command[4])])
                            varslist[tempint]=str(tempint2|tempint3)
                        elif tempstring=="&":
                            tempint2=float(varslist[int(command[3])])
                            tempint3=float(varslist[int(command[4])])
                            varslist[tempint]=str(tempint2&tempint3)
                        elif tempstring=="^":
                            tempint2=float(varslist[int(command[3])])
                            tempint3=float(varslist[int(command[4])])
                            varslist[tempint]=str(tempint2^tempint3)
                        elif tempstring=="~":
                            tempint2=float(varslist[int(command[3])])
                            varslist[tempint]=str(~tempint2)
                        elif tempstring=="$":
                            tempint2=float(varslist[int(command[3])])
                            if tempint2<0:
                                varslist[tempint]="1"
                            else:
                                varslist[tempint]="0"
                        elif tempstring=="E":
                            tempstring=varslist[int(command[3])]
                            #tempstring=self.concate("function(x){",self.concate(tempstring,"}"))
                            funct=js2py.eval_js(tempstring)
                            varslist[tempint]=str(funct())
                        elif tempstring=="X":
                            tempvec=d3_vector(0,0,0)
                            tempvec2=d3_vector(0,0,0)
                            tempvec.from_list(command[3].split("split_here"))
                            tempvec2.from_list(command[4].split("split_here"))
                            tempvec.cross(tempvec,tempvec2)
                            varslist[tempint]=parselist(tempvec.to_list())
                        else:
                            Ehandler.adderror(goldException(self.concate(inloc,":Error[11]:Failed to parse command <operation>"),"Command_error"))
                    except:
                        Ehandler.adderror(goldException(self.concate(inloc,":Error[11]:Failed to parse command <operation>"),"Command_error"))
                elif tempstring=="comment":
                    try:
                        print("",end="")
                    except:
                        Ehandler.adderror(goldException("Gold_interpreter:Error[1]:Failed on comment please report","System_error"))
                else:
                    Ehandler.adderror(goldException(self.concate(":Error[0]:Unknown command"),"Command_error"))
                b+=1
            except:
                a=0
                #Ehandler.adderror(goldException("Gold_interpreter:Error[0]:critical failure","System_error"))
        Ehandler.rethrow()
        return ret
if __name__=="__main__":
    a=interpreter()
    a.run(input(),[])
