import goldException
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
      except:
        a=0
