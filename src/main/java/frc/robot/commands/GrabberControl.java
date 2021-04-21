/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class GrabberControl extends Command {
  public GrabberControl() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.m_grabber);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    requires(Robot.m_grabber);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if (Robot.m_oi.GrabberIn()) {
    Robot.m_grabber.Grab();
    }
    else if (Robot.m_oi.GrabberOut()) {
      Robot.m_grabber.Retract();
    }
    else if (Robot.m_oi.GrabberBothLeft()) {
      Robot.m_grabber.BothGrabberLeft();
    }
    else if (Robot.m_oi.GrabberBothRight()) {
      Robot.m_grabber.BothGrabberRight();
    }
    else {
    Robot.m_grabber.stopMotion();
    }
    
    
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
