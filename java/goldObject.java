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
public class goldObject{
  Object value;
  public goldObject(Object val){
    this.value=val;
  }
  public goldObject(){
    this.val="";
  }
  public Object getValue(){
    return this.value;
  }
  public Object setValue(Object val){
    this.value=val;
  }
}
