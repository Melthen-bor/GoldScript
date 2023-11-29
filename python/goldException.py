#import
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
