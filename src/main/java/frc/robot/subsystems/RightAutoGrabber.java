/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class RightAutoGrabber extends PIDSubsystem {
  /**
   * Add your docs here.
   */
  Encoder En2 = null; 

  public RightAutoGrabber() {
    // Intert a subsystem name and PID values here
    super("RightAutoGrabber", 0.10, 0.0, 0.0);
    // Use these to get going:
    // setSetpoint() - Sets where the PID controller should move the system
    // to
    // enable() - Enables the PID controller.
    getPIDController().setContinuous(false);
    En2 = new Encoder(3, 4, false, Encoder.EncodingType.k4X);

    ConfigEn(En2);
  }

  public void ConfigEn(Encoder toConfig) {
    toConfig.setMaxPeriod(.1);
    toConfig.setMinRate(10);
    toConfig.setDistancePerPulse(5);
    toConfig.setReverseDirection(false);
    toConfig.setSamplesToAverage(6);
  }


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  @Override
  protected double returnPIDInput() {
    // Return your input value for the PID loop
    // e.g. a sensor, like a potentiometer:
    // yourPot.getAverageVoltage() / kYourMaxVoltage;
    return En2.getDistance();
  }

  @Override
  protected void usePIDOutput(double output) {
    Robot.m_grabber.setRightSpeed(output);
  }
}
