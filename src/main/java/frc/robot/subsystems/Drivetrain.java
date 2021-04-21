package frc.robot.subsystems;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.DriveJoyStick;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;

//http://devsite.ctr-electronics.com/maven/release/com/ctre/phoenix/Phoenix-latest.json

public class Drivetrain extends Subsystem {
    
  
WPI_VictorSPX Motor1 = null;
WPI_VictorSPX Motor2 = null;
WPI_VictorSPX Motor3 = null;
WPI_VictorSPX Motor4 = null;

    public Drivetrain() {
      
        Motor1 = new WPI_VictorSPX(RobotMap.DRIVETRAIN_LEFT_BACK_VICTOR);
        Motor2 = new WPI_VictorSPX(RobotMap.DRIVETRAIN_LEFT_FRONT_VICTOR);
        Motor3 = new WPI_VictorSPX(RobotMap.DRIVETRAIN_RIGHT_FRONT_VICTOR);
        Motor4 = new WPI_VictorSPX(RobotMap.DRIVETRAIN_RIGHT_BACK_VICTOR);
        
        
        Motor1.configFactoryDefault();
        Motor2.configFactoryDefault();
        Motor3.configFactoryDefault();
        Motor4.configFactoryDefault();
    
        Motor2.follow(Motor1);
        Motor4.follow(Motor3);
    }
 
    public void arcadeDrive(double leftspeed, double rightspeed) {
       
        Motor3.set(ControlMode.PercentOutput, rightspeed);
        Motor1.set(ControlMode.PercentOutput, leftspeed);
    }

    public void setCoast() {
       Motor1.setNeutralMode(NeutralMode.Coast);
       Motor2.setNeutralMode(NeutralMode.Coast);
       Motor3.setNeutralMode(NeutralMode.Coast);
       Motor4.setNeutralMode(NeutralMode.Coast);
    }

    public void setBrake() {
        Motor1.setNeutralMode(NeutralMode.Brake);
        Motor2.setNeutralMode(NeutralMode.Brake);
        Motor3.setNeutralMode(NeutralMode.Brake);
        Motor4.setNeutralMode(NeutralMode.Brake);

    }

    public double[] getDriveMotorsPctOut() {
        double[] data = new double[]{Motor1.getMotorOutputPercent(), Motor2.getMotorOutputPercent(), Motor3.getMotorOutputPercent(), Motor4.getMotorOutputPercent()};
        return data;
    }

    public void initDefaultCommand() {
        setDefaultCommand(new DriveJoyStick());
    }
}
