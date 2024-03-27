#include macros
#put LICENSE
Melthen-bor*/
#put IMPORTS
public class interpreter{
  private int line;
  private ArrayList<String> vars;
  private String ret;
  private String[] prevars;
  private Scanner inputhandler;
  private String inloc;
  private ArrayList<String> errors;
#put CONCATE_FUNC
#put LIST_PARSE
  public interpreter(String[] args){
    this.inloc=args[0];
    this.line=0;
  }
  public void gocmd(String[] args){
    int temp=this.line;
    try{
      this.line=Integer.parseInt(args[0]);
    } catch{
      this.errors.add(concate(this.inloc,concate("[",concate(temp,"]:Error[1]:Failed to parse command <go>_[Command_error]"))));
    }
  }
  public void goifcmd(String[] args){
    int temp=this.line;
    try{
      int a=Integer.parseInt(args[0]);
      String b=args[1];
      int c=Integer.parseInt(this.vars.get(Integer.parseInt(args[2])));
      int d=Integer.parseInt(this.vars.get(Integer.parseInt(args[3])));
      if(b.equals("==")){
        if(c==d){
          this.line=a;
        }
      } else if(b.equals(">")){
        if(c>d){
          this.line=a;
        }
      } else if(b.equals("<")){
        if(c<d){
          this.line=a;
        }
      } else if(b.equals("!=")){
        if(!(c==d)){
          this.line=a;
        }
      } else if(b.equals(">=")){
        if(c>=d){
          this.line=a;
        }
      } else if(b.equals("<=")){
        if(c<=d){
          this.line=a;
        }
      } else{
        this.errors.add(concate(this.inloc,concate("[",concate(temp,"]:Error[0]:Failed to parse command <goif>_[Command_error]"))));
      }
    } catch(Exception e){
      this.errors.add(concate(this.inloc,concate("[",concate(temp,"]:Error[0]:Failed to parse command <goif>_[Command_error]"))));
    }
  }
  public void throwcmd(String[] args){
    try{
      if((args[1].equals("Command_error"))||(args[1].equals("System_error"))){
        this.errors.add(concate(this.inloc,concate("[",concate(this.line,concate("]:",concate(args[0],"_[Thrown__error]"))))));
      else{
        this.errors.add(concate(this.inloc,concate("[",concate(this.line,concate("]:",concate(args[0],concate("_[",concate(args[1],"]"))))))));
      }
    } catch(Exception e){
      this.errors.add(concate(this.inloc,concate("[",concate(this.line,"]:Error[?]:Undefined error_[Thrown_error]"))));
    }
  }
  public void importcmd(String[] args){
    try{
      interpreter inter=new interpreter({args[2]});
      this.vars.set(Integer.parseInt(args[1]),inter.run(args[0],this.vars.get(Integer.parseInt(args[3])).split("#")));
    } catch(Exception e){
      this.error.add(concate(this.inloc,concate("[",concate(this.line,"]:Error[3]:Failed to parse command <import>_[Command_error]"))));
    }
  }
  public void returncmd(String[] args){
    try{
      if(args[0].equals("String")){
        this.ret=args[1];
      } else if(args[0].equals("Variable")){
        this.ret=this.vars.get(Integer.parseInt(args[1]));
      } else{
        this.errors.add(concate(this.inloc,concate("[",concate(this.line,"]:Error[4]:Failed to parse command <return>_[Command_error]"))));
      }
    } catch(Exception e){
      this.errors.add(concate(this.inloc,concate("[",concate(this.line,"]:Error[4]:Failed to parse command <return>_[Command_error]"))));
    }
  }
  public void assigncmd(String[] args){
    try{
      if(args[0].equals("String")){
        this.vars.set(Integer.parseInt(args[1]),args[2]);
      } else if(args[0].equals("Prevar")){
        this.vars.set(Integer.parseInt(args[1]),this.prevars[Integer.parseInt(args[2]));
      } else{
        this.errors.add(concate(this.inloc,concate("[",concate(this.line,"]:Error[5]:Failed to parse command <assign>_[Command_error]"))));
      }
    } catch(Exception e){
      this.errors.add(concate(this.inloc,concate("[",concate(this.line,"]:Error[5]:Failed to parse command <assign>_[Command_error]"))));
    }
  }
}
