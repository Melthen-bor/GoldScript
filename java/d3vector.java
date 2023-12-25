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
public class d3vector{
  public String concate(object s0,object s1){
    return s0+""+s1;
  }
  public d3vector(int[] vec){
    this.a=vec[0];
    this.b=vec[1];
    this.c=vec[2];
  }
  public int[] to_list(){
    vec=[]={"","",""};
    vec[0]=this.a;
    vec[1]=this.b;
    vec[2]=this.c;
  }
  public void cross(int[] a,int[] b){
    this.a=a[1]*b[2]-a[2]*b[1];
    this.b=a[2]*b[0]-a[0]*b[2];
    this.c=a[0]*b[1]-a[1]*b[0];
  }
}
