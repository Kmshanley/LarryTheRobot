/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class RampControl extends Subsystem {
  static WPI_TalonSRX RampMotor = null;
  static AnalogInput photoR = null;

  public RampControl() {
    RampMotor = new WPI_TalonSRX(RobotMap.DRIVETRAIN_RAMPMOTOR);
    photoR = new AnalogInput(0);

    RampMotor.configFactoryDefault();
    RampMotor.setNeutralMode(NeutralMode.Brake);
  }

  public double autoSuck() {
    double volts = photoR.getAverageVoltage();
    if (volts > 0.5) {
       rampDrive(0.65);
    }
    else {
      rampDrive(0.1);
    }
    return volts;
  }

  public void rampDrive(double speed) {
    RampMotor.set(ControlMode.PercentOutput, speed);
  }

  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
