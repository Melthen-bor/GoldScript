/*This file is licensed under the OPLL*/
#include <iostream>
#include <thread>
#include <string>
#include <list>
#define TYPE_INFO unsigned char
using namespace std;
struct goldObject{
  void* value;
  TYPE_INFO value_type;
};
class interpreter{
  int line;
  
  public interpreter(){
    line = 0;
  }
}
