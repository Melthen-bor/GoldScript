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
def concate(s0,s1):
  return s0+""+s1
class interpreter():
  def __init__(self,args):
    
