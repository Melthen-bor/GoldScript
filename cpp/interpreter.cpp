/*This file is licensed under the OPLL*/
#include <iostream>
#include <thread>
#include <string>
#include <list>
using namespace std;
class goldObject{
  String val;
  public goldObject(String value){
    this.val = value;
  }
  public getValue(){
    return this.val;
  }
  public setValue(String value){
    this.val = value;
  }
}
class goldString: private goldObject{
  public goldString(String value){
  }
}
class interpreter{
  int line;
  
  public interpreter(){
    line = 0;
  }
}
