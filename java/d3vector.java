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
  int a;
  int b;
  int c;
  public static String concate(object s0,object s1){
    return s0+""+s1;
  }
  public static d3vector(String[] vec){
    this.a=Integer.parseInt(vec[0]);
    this.b=Integer.parseInt(vec[1]);
    this.c=Integer.parseInt(vec[2]);
  }
  public static int[] to_list(){
    vec=[]={"","",""};
    vec[0]=this.a;
    vec[1]=this.b;
    vec[2]=this.c;
  }
  public static void cross(int[] a,int[] b){
    this.a=a[1]*b[2]-a[2]*b[1];
    this.b=a[2]*b[0]-a[0]*b[2];
    this.c=a[0]*b[1]-a[1]*b[0];
  }
  public static void cross(int[] a){
    d=this.a;
    e=this.b;
    f=this.c;
    this.a=e*a[2]-f*a[1];
    this.b=f*a[0]-d*a[2];
    this.c=d*a[1]-e*a[0];
  }
  public static int dot(int[] a){
    d=a[0]*this.a;
    d+=a[1]*this.b;
    d+=a[2]*this.c;
    return d
  }
  public static int perpdot(int[] a){
    d=a[0]*this.b-a[1]*this.a;
    return d
  }
  public static void hadamard(int[] a,int[] b){
    this.a=a[0]*b[0];
    this.b=a[1]*b[1];
    this.c=a[2]*b[2]:
  }
  public static void hadamard(int[] a){
    this.a=this.a*a[0];
    this.b=this.b*a[1];
    this.c=this.c*a[2];
  }
}
