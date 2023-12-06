package gold;
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
public class interpreter{
  ArrayList<String> custom = new ArrayList<>();
  public String concate(Object o0,Object o1){
    return o0+""+o1;
  }
  public interpreter(String[] args){
    custom.addAll(Arrays.asList(args));
  }
  public String run(String file_name){
    String ret = "";
    errorHandler Ehandler = new errorHandler();
    try{
      String fileName = concate(file_name,".gold");
      file_reader fileHandler = new file_reader(fileName);
      ArrayList<String> contents = new ArrayList<String>();
      contents.addAll(fileHandler.read());
      LocalDateTime time;
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
      Integer tempint;
      Integer tempintii;
      Integer tempintiii;
      String temptype;
      Object result;
      String[] templist = {"a"};
      goldException lastgolderror;
      interpreter tempinter;
      ArrayList<String> vars = new ArrayList<String>();
      while(a==1){
        try{
          //This is where the included functions are defined and parsed
          unparse = contents.get(b);
          command.addAll(Arrays.asList(unparse.split(" ")));
          tempstring = command.get(0);
          //included::goif
          if(tempstring.equals("goif")){
            try{
              tempstring = command.get(1);
              tempint = Integer.valueOf(tempstring);
              tempstring = command.get(2);
              tempintii = Integer.valueOf(command.get(3));
              tempintiii = Integer.valueOf(command.get(4));
              tempintii = Integer.valueOf(vars.get(tempintii));
              tempintiii = Integer.valueOf(vars.get(tempintiii));
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
          //included::go
          } else if(tempstring.equals("go")){
            try{
              tempstring = command.get(1);
              tempint = Integer.valueOf(tempstring);
              b = tempint;
            } catch(Exception e){
              lastgolderror = new goldException(concate(inloc,concate(":","Error[1]:Failed to parse command <go>")),"Command_error");
              Ehandler.adderror(lastgolderror);
            }
          //included::throw
          } else if(tempstring.equals("throw")){
            try{
              tempstring = command.get(1);
              try{
                temptype = command.get(2);
                if(temptype.equals("Command_error")){
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
          //included::import
          } else if(tempstring.equals("import")){
            try{
              tempstring = command.get(1);
              tempint = Integer.valueOf(command.get(2));
              templist[0] = command.get(3);
              tempinter = new interpreter(templist);
              vars.set(tempint,tempinter.run(tempstring));
            } catch(Exception e){
              lastgolderror = new goldException(concate(inloc,":Error[3]:Failed to parse command <import>"),"Command_error");
              Ehandler.adderror(lastgolderror);
            }
          //included::return
          } else if(tempstring.equals("return")){
            try{
              tempstring = command.get(1);
              if(tempstring.equals("custom")){
                tempstring = command.get(2);
                ret = tempstring;
              } else if(tempstring.equals("variable")){
                tempint = Integer.valueOf(command.get(2));
                tempstring = vars.get(tempint);
                ret = tempstring;
              } else{
                lastgolderror = new goldException(concate(inloc,":Error[4]:Failed to parse command <return>"),"Command_error");
                Ehandler.adderror(lastgolderror);
              }
            } catch(Exception e){
              lastgolderror = new goldException(concate(inloc,":Error[4]:Failed to parse command <return>"),"Command_error");
              Ehandler.adderror(lastgolderror);
            }
          //included::assign
          } else if(tempstring.equals("assign")){
            try{
              tempint = Integer.valueOf(command.get(1));
              tempstring = command.get(2);
              vars.set(tempint,tempstring);
            } catch(Exception e){
              lastgolderror = new goldException(concate(inloc,":Error[5]:Failed to parse command <assign>"),"Command_error");
              Ehandler.adderror(lastgolderror);
            }
          //included::time
          } else if(tempstring.equals("time")){
            try{
              tempint = Integer.valueOf(command.get(1));
              time = LocalDatetime.now();
              tempstring = time.toString();
              vars.set(tempint,tempstring);
            } catch(Exception e){
              lastgolderror = new goldException(concate(inloc,":Error[6]:Failed to parse command <time>"),"Command_error");
              Ehandler.adderror(lastgolderror);
            }
          //included::format
          } else if(tempstring.equals("format")){
            try{
              tempstring = command.get(1);
              tempint = Integer.valueOf(command.get(2));
              if(tempstring.equals("time")){
                tempstring = command.get(3);
                timeformat = DateTimeFormatter.ofPattern(tempstring);
                tempstring = time.format(timeformat);
                vars.set(tempint,tempstring);
              } else{
                lastgolderror = new goldException(concate(inloc,":Error[7]:Failed to parse command <format>"),"Command_error");
                Ehandler.adderror(lastgolderror);
              }
            } catch(Exception e){
              lastgolderror = new goldException(concate(inloc,":Error[7]:Failed to parse command <format>"),"Command_error");
              Ehandler.adderror(lastgolderror);
            }
          //included::out
          } else if(tempstring.equals("out")){
            try{
              tempstring = command.get(1);
              if(tempstring.equals("variable")){
                tempint = Integer.valueOf(command.get(2));
                tempstring = vars.get(tempint);
                System.out.print(tempstring);
              } else if(tempstring.equals("string")){
                tempstring = command.get(2);
                System.out.print(tempstring);
              } else{
                lastgolderror = new goldException(concate(inloc,":Error[8]:Failed to parse command <out>"),"Command_error");
                Ehandler.adderror(lastgolderror);
              }
            } catch(Exception e){
              lastgolderror = new goldException(concate(inloc,":Error[8]:Failed to parse command <out>"),"Command_error");
              Ehandler.adderror(lastgolderror);
            }
          //included::implement
          } else if(tempstring.equals("implement")){
            try{
              tempint=Integer.valueOf(command.get(1));
              vars.set(tempint,"0");
            } catch(Exception e){
              lastgolderror = new goldException(concate(inloc,":Error[9]:Failed to parse command <implement>"),"Command_error");
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
      System.out.println("Gold_interpreter:\033[31mError[0]:Critical failure\033[0m\nor program ended");
    }
  Ehandler.rethrow();
  return ret;
  }
}
