/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.AutoGrabber;
import frc.robot.commands.AutoRamp;
import frc.robot.commands.GrabberControl;
import frc.robot.commands.ManualRamp;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());
  private Joystick stick = new Joystick(RobotMap.OI_DRIVER_CONTROLLER);
 

  Button setManualRamp = new JoystickButton(stick, 12);
  Button setAutoRamp = new JoystickButton(stick, 11);
  //Button CloseGrabber = new JoystickButton(stick, 10);
  //Button OpenGrabber = new JoystickButton(stick, 9);
  public OI (){

  stick = new Joystick(RobotMap.OI_DRIVER_CONTROLLER);
  setManualRamp.whenPressed(new ManualRamp());
  setAutoRamp.whenPressed(new AutoRamp());
  //CloseGrabber.whenPressed(new AutoGrabber(true));
  //OpenGrabber.whenPressed(new AutoGrabber(false));
}

public double rightDrive() {
  return ((stick.getY() * 1) + stick.getX()) * determineThrottle();
}
public double leftDrive() {
  return ((stick.getY() * -1) + stick.getX()) * determineThrottle();
} 

public double determineThrottle() {
  return ((stick.getThrottle()) + 1) / 2;
}

public boolean brakePress() {
  return stick.getRawButtonPressed(3);
}

public boolean coastPress() {
  return stick.getRawButtonPressed(4);
}

public boolean RampForwardPress() {
  return stick.getRawButton(5);
}

public boolean RampBackwardPress() {
  return stick.getRawButton(6);
}

public boolean FirstWindButton() {
  return stick.getRawButton(10);
}
public boolean GrabberOut() {
  return stick.getTrigger();
}
public boolean GrabberIn() {
  return stick.getRawButton(2);
}
public boolean GrabberBothLeft() {
  return stick.getRawButton(8);
}
public boolean GrabberBothRight () {
  return stick.getRawButton(7);
}
}