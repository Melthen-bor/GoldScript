/*This file is licensed under the OPLL v1.4.
This file is from the GoldScript repo
owned by Melthen-bor. 
This file contains commitments by
Melthen-bor*/
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
public class goldBit{
  boolean value;
  public goldBit(){
    this.value=false;
  }
  public static boolean getvalue(){
    return this.value;
  }
  public static void not(){
    if(this.value){
      this.value=false;
    } else{
      this.value=true;
    }
  }
  public static void and(goldBit bit1){
    if(this.value){
      if(bit1.getvalue()){
        this.value=true;
      } else{
        this.value=false;
      }
    } else{
      this.value=false;
    }
  }
}
