/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.GrabberControl;

/**
 * Add your docs here.
 */
public class Grabber extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  WPI_VictorSPX GrabMotor1 = null;
  WPI_VictorSPX GrabMotor2 = null; 
 
  public Grabber () {
    GrabMotor1 = new WPI_VictorSPX(RobotMap.GRABBER_MOTOR_LEFT);
    GrabMotor2 = new WPI_VictorSPX(RobotMap.GRABBER_MOTOR_RIGHT);


  }

  public void Grab () {
    GrabMotor1.set(ControlMode.PercentOutput, 0.50);
    GrabMotor2.set(ControlMode.PercentOutput, 0.50);

  }
  public void Retract () {
    GrabMotor1.set(ControlMode.PercentOutput, -0.50);
    GrabMotor2.set(ControlMode.PercentOutput, -0.5);
  }

  public void BothGrabberLeft() {
    GrabMotor1.set(ControlMode.PercentOutput, 0.25);
    GrabMotor2.set(ControlMode.PercentOutput, -0.25);
  }

  public void BothGrabberRight() {
    GrabMotor1.set(ControlMode.PercentOutput, -0.25);
    GrabMotor2.set(ControlMode.PercentOutput, 0.25);
  }

  public void stopMotion() {
    GrabMotor1.set(ControlMode.PercentOutput, 0);
    GrabMotor2.set(ControlMode.PercentOutput, 0);
  }

  public void setLeftSpeed(double speed) {
    GrabMotor1.set(ControlMode.PercentOutput, speed);
  }
  public void setRightSpeed(double speed) {
    GrabMotor2.set(ControlMode.PercentOutput, speed);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new GrabberControl());
  }
}
