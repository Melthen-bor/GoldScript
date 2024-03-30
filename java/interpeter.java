#include macros
#put LICENSE
-Melthen-bor*/
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
    this.inputhandler=new Scanner(System.in);
    this.errors=new ArrayList<String>();
    this.vars=new ArrayList<String>();
    this.ret="";
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
        this.errors.add(concate(this.inloc,concate("[",concate(temp,"]:Error[2]:Failed to parse command <goif>_[Command_error]"))));
      }
    } catch(Exception e){
      this.errors.add(concate(this.inloc,concate("[",concate(temp,"]:Error[2]:Failed to parse command <goif>_[Command_error]"))));
    }
  }
  public void throwcmd(String[] args){
    try{
      a=args[1];
      if((a.equals("Command_error"))||(a.equals("System_error"))){
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
      a=args[0];
      if(a].equals("String")){
        this.ret=args[1];
      } else if(a.equals("Variable")){
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
      a=args[0];
      if(a.equals("String")){
        this.vars.set(Integer.parseInt(args[1]),args[2]);
      } else if(a.equals("Prevar")){
        this.vars.set(Integer.parseInt(args[1]),this.prevars[Integer.parseInt(args[2]));
      } else{
        this.errors.add(concate(this.inloc,concate("[",concate(this.line,"]:Error[5]:Failed to parse command <assign>_[Command_error]"))));
      }
    } catch(Exception e){
      this.errors.add(concate(this.inloc,concate("[",concate(this.line,"]:Error[5]:Failed to parse command <assign>_[Command_error]"))));
    }
  }
  public void timecmd(String[] args){
    try{
      this.vars.set(Integer.parseInt(args[0]),LocalDateTime.now(DateTimeFormatter.ofPattern(this.vars.get(Integer.parseInt(args[1])))));
    } catch(Exception e){
      this.errors.add(concate(this.inloc,concate("[",concate(this.line,"]:Error[6]:Failed to parse command <time>_[Command_error]"))));
    }
  }
  public void outcmd(String[] args){
    try{
      a=args[0]
      if(a.equals("String")){
        System.out.print(args[1]);
      } else if(a.equals("Variable")){
        System.out.print(this.vars.get(Integer.parseInt(args[1])));
      } else if(a.equals("New")){
        System.out.println();
      } else if(a.equals("Return")){
        System.out.print("\r");
      } else if(a.equals("Control")){
        System.out.print(concate("\033[",concate(args[1],"m")));
      } else if(a.equals("Control Variable")){
        System.out.print(concate("\033[",concate(this.vars.get(Integer.parseInt(args[1])),"m")));
      } else{
        this.errors.add(concate(this.inloc,concate("[",concate(this.line,"]:Error[7]:Failed to parse command <out>_[Command_error]"))));
      }
    } catch(Exception e){
      this.errors.add(concate(this.inloc,concate("[",concate(this.line,"]:Error[7]:Failed to parse command <out>_[Command_error]"))));
    }
  }
  public void implementcmd(String[] args){
    try{
      this.vars.set(Integer.parseInt(args[0]),"0");
    } catch(Exception e){
      this.errors.add(concate(this.inloc,concate("[",concate(this.line,"]:Error[8]:Failed to parse command <implement>_[Command_error]"))));
    }
  }
  public void inputcmd(String[] args){
    try{
      this.vars.set(Integer.parseInt(args[0]),this.inputhandler.nextLine());
    } catch(Exception e){
      this.errors.add(concate(this.inloc,concate("[",concate(this.line,"]:Error[9]:Failed to parse command <input>_[Command_error]"))));
    }
  }
  public void operationcmd(String[] args){
    try{
      a=args[0];
      if(a.equals("+")){
        this.vars.set(Integer.parseInt(args[1]),Integer.toString(Integer.parseInt(this.vars.get(Integer.parseInt(args[2])))+Integer.parseInt(this.vars.get(Integer.parseInt(args[3])))));
      } else(a.equals("-")){
        this.vars.set(Integer.parseInt(args[1]),Integer.toString(Integer.parseInt(this.vars.get(Integer.parseInt(args[2])))-Integer.parseInt(this.vars.get(Integer.parseInt(args[3])))));
      } else(a.equals("*")){
        this.vars.set(Integer.parseInt(args[1]),Integer.toString(Integer.parseInt(this.vars.get(Integer.parseInt(args[2])))*Integer.parseInt(this.vars.get(Integer.parseInt(args[3])))));
      } else(a.equals(":")){
        this.vars.set(Integer.parseInt(args[1]),Integer.toString(Integer.parseInt(this.vars.get(Integer.parseInt(args[2])))/Integer.parseInt(this.vars.get(Integer.parseInt(args[3])))));
      } else{
        this.errors.add(concate(this.inloc,concate("[",concate(this.line,"]:Error[10]:Failed to parse command <operation>_[Command_error]"))));
      }
    } catch(Exception e){
      this.errors.add(concate(this.inloc,concate("[",concate(this.line,"]:Error[10]:Failed to parse command <operation>_[Command_error]"))));
    }
  }
  public String run(String file,String[] prevars){
    try{
      
}
