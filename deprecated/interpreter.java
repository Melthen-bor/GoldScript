//package gold;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import java.lang.Math;
import javax.vecmath.Vector3d;
public class interpreter{
  ArrayList<String> custom = new ArrayList<>();
  public String concate(Object o0,Object o1){
    return o0+""+o1;
  }
  public interpreter(String[] args){
    custom.addAll(Arrays.asList(args));
  }
  public String run(String file_name, String[] prevars){
    String ret = "";
    errorHandler Ehandler = new errorHandler();
    try{
      String fileName = concate(file_name,".gold");
      file_reader fileHandler = new file_reader(fileName);
      ArrayList<String> contents = new ArrayList<String>();
      contents.addAll(fileHandler.read());
      Scanner inputHandler = new Scanner(System.in);
      LocalDateTime time = LocalDateTime.now();
      DateTimeFormatter timeformat;
      int a = 1;
      int b = 0;
      ArrayList<String> command = new ArrayList<String>();
      String unparse;
      String inloc;
      try{
        inloc = custom.get(0);
      } catch(Exception e){
        inloc = "Gold_Program";
      }
      String tempstring;
      int tempint;
      Float tempintii;
      Float tempintiii;
      Float tempintiv;
      String temptype;
      Object result;
      String[] templist={"","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","","",""}
      goldException lastgolderror;
      interpreter tempinter;
      ScriptEngineManager mgr = new ScriptEngineManager();
      ScriptEngine js = mgr.getEngineByName("JavaScript");
      //ArrayList<goldObject> vars = new ArrayList<goldObject>();
      ArrayList<String> vars = new ArrayList<String>();
      vars.addAll(Arrays.asList(templist));
      Vector3d tempvec;
      Vector3d tempvecii;
      Vector3d tempveciii;
      while(a==1){
        try{
          //This is where the included functions are defined and parsed
          unparse = contents.get(b);
          command.addAll(Arrays.asList(unparse.split(" ")));
          tempstring = command.get(0);
          if(tempstring.equals("goif")){
            try{
              tempstring = command.get(1);
              tempint = Integer.parseInt(tempstring);
              tempstring = command.get(2);
              /*tempintii = vars.get(Integer.parseInt(command.get(3))).getValue();
              tempintiii = vars.get(Integer.parseInt(command.get(4))).getValue();*/
              tempintii = Float.valueOf(vars.get(Integer.parseInt(command.get(3))));
              tempintiii = Float.valueOf(vars.get(Integer.parseInt(command.get(4))));
              //these are the possible operations
              if(tempstring.equals("==")){
                if(tempintii==tempintiii){
                  b = tempint;
                }
              } else if(tempstring.equals(">")){
                if(tempintii>tempintiii){
                  b = tempint;
                }
              } else if(tempstring.equals("<")){
                if(tempintii<tempintiii){
                  b = tempint;
                }
              } else if(tempstring.equals(">=")){
                if(tempintii>=tempintiii){
                  b = tempint;
                }
              } else if(tempstring.equals("<=")){
                if(tempintii<=tempintiii){
                  b = tempint;
                }
              } else if(tempstring.equals("!=")){
                if(tempintii!=tempintiii){
                  b = tempint;
                }
              //throws goldException if something is wrong
              } else{
                lastgolderror = new goldException(concate(inloc,":Error[2]:Failed to parse command <goif>"),"Command_error");
                Ehandler.adderror(lastgolderror);
              }
            } catch(Exception e){
              lastgolderror = new goldException(concate(inloc,concate(":","Error[2]:Failed to parse command <goif>")),"Command_error");
              Ehandler.adderror(lastgolderror);
            }
          } else if(tempstring.equals("go")){
            try{
              tempstring = command.get(1);
              tempint = Integer.parseInt(tempstring);
              b = tempint;
            } catch(Exception e){
              lastgolderror = new goldException(concate(inloc,concate(":","Error[1]:Failed to parse command <go>")),"Command_error");
              Ehandler.adderror(lastgolderror);
            }
          } else if(tempstring.equals("throw")){
            try{
              tempstring = command.get(1);
              try{
                temptype = command.get(2);
                if(temptype.equals("Command_error")||temptype.equals("System_error")){
                  temptype = "Thrown_error";
                }
              } catch(Exception e){
                temptype = "Thrown_error";
              }
            } catch(Exception e){
              tempstring = "Error[?]:undefined";
              temptype = "Thrown_error";
            }
            lastgolderror = new goldException(concate(inloc,concate(":",tempstring)),temptype);
            Ehandler.adderror(lastgolderror);
          } else if(tempstring.equals("import")){
            try{
              tempstring = command.get(1);
              tempint = Integer.parseInt(command.get(2));
              templist[0] = command.get(3);
              tempinter = new interpreter(templist);
              templist = vars.get(Integer.parseInt(command.get(4))).split("split_here");
              //vars.set(tempint,new goldString(tempinter.run(tempstring,templist)));
              vars.set(tempint,tempinter.run(tempstring,templist));
            } catch(Exception e){
              lastgolderror = new goldException(concate(inloc,":Error[3]:Failed to parse command <import>"),"Command_error");
              Ehandler.adderror(lastgolderror);
            }
          } else if(tempstring.equals("return")){
            try{
              tempstring = command.get(1);
              if(tempstring.equals("string")){
                ret = command.get(2);
              } else if(tempstring.equals("variable")){
                //ret = vars.get(Integer.parseInt(command.get(2))).getValue();
                ret = vars.get(Integer.parseInt(command.get(2)));
              } else{
                lastgolderror = new goldException(concate(inloc,":Error[4]:Failed to parse command <return>"),"Command_error");
                Ehandler.adderror(lastgolderror);
              }
            } catch(Exception e){
              lastgolderror = new goldException(concate(inloc,":Error[4]:Failed to parse command <return>"),"Command_error");
              Ehandler.adderror(lastgolderror);
            }
          } else if(tempstring.equals("assign")){
            try{
              tempstring = command.get(1);
              if(tempstring.equals("string")){
                //vars.set(Integer.parseInt(command.get(2)),new goldString(command.get(3)));
                vars.set(Integer.parseInt(command.get(2)),command.get(3));
              } else if(tempstring.equals("prevar")){
                vars.set(Integer.parseInt(command.get(2)),prevars[Integer.parseInt(command.get(3))]);
              } else{
                lastgolderror = new goldException(concate(inloc,":Error[5]:Failed to parse command <assign>","Command_error");
                Ehandler.adderror(lastgolderror);
              }
            } catch(Exception e){
              lastgolderror = new goldException(concate(inloc,":Error[5]:Failed to parse command <assign>"),"Command_error");
              Ehandler.adderror(lastgolderror);
            }
          } else if(tempstring.equals("time")){
            try{
              tempint = Integer.parseInt(command.get(1));
              time = LocalDateTime.now();
              vars.setInteger.parseInt(command.get(1)),time.toString());
            } catch(Exception e){
              lastgolderror = new goldException(concate(inloc,":Error[6]:Failed to parse command <time>"),"Command_error");
              Ehandler.adderror(lastgolderror);
            }
          } else if(tempstring.equals("format")){
            try{
              if(tempstring.equals("time")){
                tempstring = command.get(3);
                timeformat = DateTimeFormatter.ofPattern(command.get(1));
                vars.set(Integer.parseInt(command.get(2)),time.format(timeformat));
              } else{
                lastgolderror = new goldException(concate(inloc,":Error[7]:Failed to parse command <format>"),"Command_error");
                Ehandler.adderror(lastgolderror);
              }
            } catch(Exception e){
              lastgolderror = new goldException(concate(inloc,":Error[7]:Failed to parse command <format>"),"Command_error");
              Ehandler.adderror(lastgolderror);
            }
          } else if(tempstring.equals("out")){
            try{
              tempstring = command.get(1);
              if(tempstring.equals("variable")){
                tempint = Integer.parseInt(command.get(2));
                tempstring = vars.get(tempint);
                System.out.print(tempstring);
              } else if(tempstring.equals("string")){
                tempstring = command.get(2);
                System.out.print(tempstring);
              } else if(tempstring.equals("return")){
                System.out.print("\r");
              } else if(tempstring.equals("new")){
                System.out.print("\n");
              } else{
                lastgolderror = new goldException(concate(inloc,":Error[8]:Failed to parse command <out>"),"Command_error");
                Ehandler.adderror(lastgolderror);
              }
            } catch(Exception e){
              lastgolderror = new goldException(concate(inloc,":Error[8]:Failed to parse command <out>"),"Command_error");
              Ehandler.adderror(lastgolderror);
            }
          } else if(tempstring.equals("implement")){
            try{
              tempint = Integer.parseInt(command.get(1));
              vars.set(tempint,"0");
            } catch(Exception e){
              lastgolderror = new goldException(concate(inloc,":Error[9]:Failed to parse command <implement>"),"Command_error");
              Ehandler.adderror(lastgolderror);
            }
          } else if(tempstring.equals("input")){
            try{
              tempint = Integer.parseInt(command.get(1));
              tempstring = inputHandler.nextLine();
              vars.set(tempint,tempstring);
            } catch(Exception e){
              lastgolderror = new goldException(concate(inloc,":Error[10]:Failed to parse command <input>"),"Command_error");
              Ehandler.adderror(lastgolderror);
            }
          } else if(tempstring.equals("operation")){
            try{
              tempstring = commnad.get(1);
              if(tempstring.equals("+"){
                tempint = Integer.parseInt(command.get(2));
                tempintii = Float.valueFloat(vars.get(Integer.parseInt(command.get(3))));
                tempintiii = Float.valueFloat(vars.get(Integer.parseInt(command.get(4))));
                tempintiv = tempintii+tempintiii;
                vars.set(tempint,Float.toString(tempintiv));
              } else if(tempstring.equals("*")){
                tempint = Integer.parseInt(command.get(1));
                tempintii = Float.valueFloat(vars.get(Integer.parseInt(command.get(2))));
                tempintiii = Float.valueFloat(vars.get(Integer.parseInt(command.get(3))));
                tempintiv = tempintii*tempintiii;
                vars.set(tempint,Float.toString(tempintiv));
              } else if(tempstring.equals("**")){
                tempint = Integer.parseInt(command.get(1));
                tempintii = Float.valueFloat(vars.get(Integer.parseInt(command.get(2))));
                tempintiii = Float.valueFloat(vars.get(Integer.parseInt(command.get(3))));
                tempintiv = Math.pow(tempintii,tempintiii);
                vars.set(tempint,Float.toString(tempintiv));
              } else if(tempstring.equals(":")){
                tempint = Integer.parseInt(command.get(1));
                tempintii = Float.valueFloat(vars.get(Integer.parseInt(command.get(2))));
                tempintiii = Float.valueFloat(vars.get(Integer.parseInt(command.get(3))));
                tempintiv = tempintii/tempintiii;
                vars.set(tempint,Float.toString(tempintiv));
              } else if(tempstring.equals("-")){
                tempint = Integer.parseInt(command.get(1));
                tempintii = Float.valueFloat(vars.get(Integer.parseInt(command.get(2))));
                tempintiii = Float.valueFloat(vars.get(Integer.parseInt(command.get(3))));
                tempintiv = tempintii-tempintiii;
                vars.set(tempint,Float.toString(tempintiv));
              } else if(tempstring.equals("&&")){
                tempint = Integer.parseInt(command.get(1));
                tempstring = concate(vars.get(Integer.parseInt(command.get(2))),vars.get(Integer.parseInt(command.get(3))));
                vars.set(tempint,tempstring);
              } else if(tempstring.equals("&")){
                tempint = Integer.parseInt(command.get(1));
                tempintii = Float.valueFloat(vars.get(Integer.parseInt(command.get(2))));
                tempintiii = Float.valueFloat(vars.get(Integer.parseInt(command.get(3))));
                tempintiv = tempintii&tempintiii;
                vars.set(tempint,Float.toString(tempintiv));
              } else if(tempstring.equals("|")){
                tempint = Integer.parseInt(command.get(1));
                tempintii = Float.valueFloat(vars.get(Integer.parseInt(command.get(2))));
                tempintiii = Float.valueFloat(vars.get(Integer.parseInt(command.get(3))));
                tempintiv = tempintii|tempintiii;
                vars.set(tempint,Float.toString(tempintiv));
              } else if(tempstring.equals("^")){
                tempint = Integer.parseInt(command.get(1));
                tempintii = Float.valueFloat(vars.get(Integer.parseInt(command.get(2))));
                tempintiii = Float.valueFloat(vars.get(Integer.parseInt(command.get(3))));
                tempintiv = tempintii^tempintiii;
                vars.set(tempint,Float.toString(tempintiv));
              } else if(tempstring.equals("~")){
                tempint = Integer.parseInt(command.get(1));
                tempintii = Float.valueFloat(vars.get(Integer.parseInt(command.get(2))));
                tempintiii = ~tempintii;
                vars.set(tempint,Float.toString(tempintiii));
              } else if(tempstring.equals("::")){
                tempint = Integer.parseInt(command.get(1));
                tempintii = Float.valueFloat(vars.get(Integer.parseInt(command.get(2))));
                tempintiii = Float.valueFloat(vars.get(Integer.parseInt(command.get(3))));
                tempintiii = 1/tempintiii;
                tempintiv = Math.pow(tempintii,tempintiii);
                vars.set(tempint,Float.toString(tempintiv));
              } else if(tempstring.equals("%")){
                tempint = Integer.parseInt(command.get(1));
                tempintii = Float.valueFloat(vars.get(Integer.parseInt(command.get(2))));
                tempintiii = Float.valueFloat(vars.get(Integer.parseInt(command.get(3))));
                tempintiv = tempintiii%2;
                if(tempintiv=0){
                  tempintiv = tempintii&(tempintiii-1);
                } else{
                  tempintiv = tempintii%tempintiii;
                }
                vars.set(tempint,Float.toString(tempintiv));
              } else if(tempstring.equals(">>")){
                tempint = Integer.parseInt(command.get(1));
                tempintii = Float.valueFloat(vars.get(Integer.parseInt(command.get(2))));
                tempintiii = Float.valueFloat(vars.get(Integer.parseInt(command.get(3))));
                tempintiv = tempintii>>tempintiii;
                vars.set(tempint,Float.toString(tempintiv));
              } else if(tempstring.equals("<<")){
                tempint = Integer.parseInt(command.get(1));
                tempintii = Float.valueFloat(vars.get(Integer.parseInt(command.get(2))));
                tempintiii = Float.valueFloat(vars.get(Integer.parseInt(command.get(3))));
                tempintiv = tempintii<<tempintiii;
                vars.set(tempint,Float.toString(tempintiv));
              } else if(tempstring.equals(">>>")){
                tempint = Integer.parseInt(command.get(1));
                tempintii = Float.valueFloat(vars.get(Integer.parseInt(command.get(2))));
                tempintiii = Float.valueFloat(vars.get(Integer.parseInt(command.get(3))));
                tempintiv = tempintii>>>tempintiii;
                vars.set(tempint,Float.toString(tempintiv));
              } else if(tempstring.equals("$")){
                tempint = Integer.parseInt(command.get(1));
                tempintii = Float.valueFloat(vars.get(Integer.parseInt(command.get(2))));
                if(tempintii<0){
                  vars.set(tempint,1);
                } else{
                  vars.set(tempint,0);
                }
              } else if(tempstring.equals("E")){
                tempint = Integer.parseInt(command.get(1));
                tempstring = js.eval(vars.get(Integer.parseInt(command.get(2))));
                vars.set(tempint,tempstring);
              } else if(tempstring.equals("X")){
                templist = vars.get(Integer.parseInt(command.get(1))).split("split_here");
                tempvec = new Vector3d(templist);
                templist = vars.get(Integer.parseInt(command.get(1))).split("split_here");
                tempvecii = new Vector3d(templist);
                tempvec.cross(tempvec,tempvecii);
                vars.set(tempint,tempvec.toString);
              } else{
                lastgolderror = new goldException(concate(inloc,":Error[11]:Failed to parse command <operation"),"Command_error");
                Ehandler.adderror(lastgolderror);
              }
            } catch(Exception e){
              lastgolderror = new goldException(concate(inloc,":Error[11]:Failed to parse command <operation>"),"Command_error");
              Ehandler.adderror(lastgolderror);
            }
          } else if(tempstring.equals("comment")){
            try{
              System.out.print("");
            } catch(Exception e){
              lastgolderror = new goldException("Gold_interpreter:Error[1]:Failed on a comment please report this","System_error");
              Ehandler.adderror(lastgolderror);
            }
          } else{
            lastgolderror = new goldException(concate(inloc,concate(":","Error[0]:unknown command")),"Command_error");
            Ehandler.adderror(lastgolderror);
          }
          command.clear();
          b += 1;
        } catch(Exception e){
          a = 0;
        }
      }
    } catch(Exception e){
      Ehandler.adderror(new goldException("Gold_interpreter:Error[0]:Critical Failure please report","System_error"));
    }
  Ehandler.rethrow();
  return ret;
  }
}
