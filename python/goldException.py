#import
class goldException():
  message=""
  type=""
  def _init_(self,error,type):
    self.message=error
    self.type=type
  def geterror(self):
    return self.message
  def gettype(self):
    return self.type
