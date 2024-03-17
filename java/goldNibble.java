/*This file is licensed under the OPLL v1.5
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
public class goldNibble extends goldObject{
  goldBit bit0;
  goldBit bit1;
  goldBit bit2;
  goldBit bit3;
  public goldNibble(){
    this.bit0.setvalue(false);
    this.bit1.setvalue(false);
    this.bit2.setvalue(false);
    this.bit3.setvalue(false);
  }
  public boolean getval0(){
    return this.bit0.getvalue();
  }
  public boolean getval1(){
    return this.bit1.getvalue();
  }
  public boolean getval2(){
    return this.bit2.getvalue();
  }
  public boolean getval3(){
    return this.bit3.getvalue();
  }
  public void not(){
    this.bit0.not();
    this.bit1.not();
    this.bit2.not();
    this.bit3.not();
  }
  public void and(goldNibble nib1){
    this.bit0.and(nib1.bit0);
    this.bit1.and(nib1.bit1);
    this.bit2.and(nib1.bit2);
    this.bit3.and(nib1.bit3);
  }
}