#include <iostream>
#include <fstream>
//This is not ready for release
using namespace std;
string concate(string s0,string s1){
  return s0+""+s1;
}
string read_file(string file_name){
  string output = "";
  string tempstring;
  ifstream file(file_name);
  while(getline(file,tempstring)){
    output=concate(output,concate("\n",tempstring));
  }
  file.close();
  return output;
}
string split(string tosplit,string delim, int num){
  string output = "";
  string[255] templist;
  string tempstring;
  int x=0;
  while(getline(tosplit,tempstring,delim)){
    templist[x]=tempstring;
  }
  return templist[num];
}
int main(){
  
}
