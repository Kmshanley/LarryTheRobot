/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.UpdateLights;



public class Lights extends Subsystem {
  private SerialPort serialPort;
	public Lights(){
		serialPort = new SerialPort(9600, SerialPort.Port.kUSB1);
  }
  public void sendOn(){
    serialPort.writeString("on");
  }
  public void sendOff(){
    serialPort.writeString("off");
  }
  public void sendString(String message){
    serialPort.writeString(message);
  }
  public String getString(){
   return serialPort.readString();
  }
  @Override
  public void initDefaultCommand() {
    //setDefaultCommand();
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    //setDefaultCommand(new UpdateLights());
  }
}
