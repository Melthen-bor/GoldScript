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
public class goldNibble{
  goldBit bit0;
  goldBit bit1;
  goldBit bit2;
  goldBit bit3;
  public goldNibble(){
    bit0.setvalue(false);
    bit1.setvalue(false);
    bit2.setvalue(false);
    bit3.setvalue(false);
  }
  public boolean getval0(){
    return bit0.getvalue();
  }
  public boolean getval1(){
    return bit1.getvalue();
  }
  public boolean getval2(){
    return bit2.getvalue();
  }
  public boolean getval3(){
    return bit3.getvalue();
  }
  public void not(){
    bit0.not();
    bit1.not();
    bit2.not();
    bit3.not();
  }
  public void and(){
    
  }
}
