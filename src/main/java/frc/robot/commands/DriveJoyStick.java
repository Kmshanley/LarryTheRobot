/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;


public class DriveJoyStick extends Command {
  public DriveJoyStick() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.m_drivetrain);
  }

  // Called just before this Command runs the first time
  
  protected void initialize() {
  }
  
  protected void execute() {
    double rightspeed = Robot.m_oi.rightDrive();
    double leftspeed = Robot.m_oi.leftDrive();
    
    Robot.m_drivetrain.arcadeDrive(leftspeed, rightspeed);

    if (Robot.m_oi.brakePress())
    Robot.m_drivetrain.setBrake();
    if (Robot.m_oi.coastPress())
    Robot.m_drivetrain.setCoast();
    
  }
  // Called repeatedly when this Command is scheduled to run

  // Make this return true when this Command no longer needs to run execute()
 
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
 
  protected void end() {
    Robot.m_drivetrain.arcadeDrive(0, 0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  
  protected void interrupted() {
    end();
  }
}
