/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class AutoGrabber extends Command {
  boolean state;
  public AutoGrabber(boolean fstate) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    state = fstate;
    requires(Robot.m_LeftAutoGrabber);
    requires(Robot.m_RightAutoGrabber);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    if (state) {
      Robot.m_RightAutoGrabber.enable();
      Robot.m_LeftAutoGrabber.enable();
      Robot.m_RightAutoGrabber.setSetpoint(5);
      Robot.m_LeftAutoGrabber.setSetpoint(5);
    }
    else if (!state) {
      Robot.m_LeftAutoGrabber.enable();
      Robot.m_RightAutoGrabber.enable();
      Robot.m_LeftAutoGrabber.setSetpoint(0);
      Robot.m_RightAutoGrabber.setSetpoint(0);
    }
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
