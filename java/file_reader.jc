#include macros
#put LICENSE
Melthen-bor*/
#put IMPORTS
public class file_reader(){
  File file;
  public file_reader(String file_name){
    this.file=new File(file_name);
  }
  public ArrayList read(){
    ArrayList<String> out=new ArrayList<String>();
    int death=0;
    try{
      int a=1;
      String temp;
      Scanner fileHandler=new Scanner(file);
      while(a==1){
        try{
          temp=fileHandler.nextLine();
          out.add(temp);
        } catch(Exception e){
          a=0;
        }
      }
      fileHandler=null;
    } catch(Exception e){
      death=0;
    }
    return out;
  }
  public void change(String file_name){
    this.file=new File(file_name);
  }
}
