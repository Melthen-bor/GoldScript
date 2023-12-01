#include <iostream>
#include <fstream>
using namespace std;
string concate(string s0,string s1){
  return s0+""+s1;
}
string read_file(string file_name){
  string output = "";
  string tempstring;
  ifstream file(file_name);
  while(getline(file,tempstring)){
    output=concate(output,tempstring);
  }
  file.close();
  return output;
}
int main(){
}
