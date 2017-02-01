package org.usfirst.frc.team4043.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team4043.robot.commands.CloseClaw;
import org.usfirst.frc.team4043.robot.commands.ExampleCommand;
import org.usfirst.frc.team4043.robot.commands.LowerArm;
import org.usfirst.frc.team4043.robot.commands.OpenClaw;
import org.usfirst.frc.team4043.robot.commands.RaiseArm;
import org.usfirst.frc.team4043.robot.commands.WinchReverse;
import org.usfirst.frc.team4043.robot.commands.WinchStart;
import org.usfirst.frc.team4043.robot.commands.WinchStop;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 * Hi there
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
	Joystick driveStick = new Joystick(0);
	Joystick coStick = new Joystick(1);
	Button winchButton = new JoystickButton(driveStick, 5);
	Button reverseWinch = new JoystickButton(driveStick, 6);
	//Button winchStop = new JoystickButton(driveStick, 4);
	
	Button raiseArm = new JoystickButton(driveStick, 4);
	Button lowerArm = new JoystickButton(driveStick, 2);
	Button openClaw = new JoystickButton(driveStick, 3);
	Button closeClaw = new JoystickButton(driveStick, 1);
	
	
	public OI() {
		winchButton.whenPressed(new WinchStart());
		reverseWinch.whenPressed(new WinchReverse());
		//winchStop.whenPressed(new WinchStop());
		
		raiseArm.whileHeld(new RaiseArm());
		lowerArm.whileHeld(new LowerArm());
		openClaw.whileHeld(new OpenClaw());
		closeClaw.whileHeld(new CloseClaw());
	}
	
	public Joystick getDriveStick() {
        return driveStick;
    }
}
