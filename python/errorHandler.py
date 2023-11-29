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
    
