//package gold;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class Gold{
  public String concate(Object o0,Object o1){
    return o0+""+o1;
  }
  public void main(String[] args){
    String file = args[0];
    String[] intargs = args[1].split("[split]");
    interpreter inter = new interpreter(intargs);
    inter.run(args[2]);
  }
}
