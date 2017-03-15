package org.usfirst.frc.team4043.robot;

//import edu.wpi.first.wpilibj.ADXL345_I2C.Axes;
import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.JoystickBase;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

//import org.usfirst.frc.team4043.robot.commands.CloseClaw;
import org.usfirst.frc.team4043.robot.commands.LowerArm;
//import org.usfirst.frc.team4043.robot.commands.OpenClaw;
//import org.usfirst.frc.team4043.robot.commands.PneumaticsClose;
//import org.usfirst.frc.team4043.robot.commands.PnuematicsOpen;
import org.usfirst.frc.team4043.robot.commands.RaiseArm;
import org.usfirst.frc.team4043.robot.commands.StopArm;
import org.usfirst.frc.team4043.robot.commands.sP;
import org.usfirst.frc.team4043.robot.commands.CameraFlip;
//import org.usfirst.frc.team4043.robot.commands.BallPickerUpper;
import org.usfirst.frc.team4043.robot.commands.ClawMove;
import org.usfirst.frc.team4043.robot.commands.DoorToggle;
import org.usfirst.frc.team4043.robot.commands.FloorDown;
import org.usfirst.frc.team4043.robot.commands.FloorUp;
//import org.usfirst.frc.team4043.robot.commands.Flip;
//import org.usfirst.frc.team4043.robot.commands.FlipFlopStop;
//import org.usfirst.frc.team4043.robot.commands.Flop;

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
	static Joystick coStick = new Joystick(1);
	
	//Button winchButton = new JoystickButton(coStick, 6);
	//Button reverseWinch = new JoystickButton(coStick, 5);
	//Button winchStop = new JoystickButton(coStick, 7);
	
	Button clawButton = new JoystickButton(driveStick, 1);
	Button raiseArm = new JoystickButton(driveStick, 5);
	Button lowerArm = new JoystickButton(driveStick, 6);
	//Button Servo = new JoystickButton(driveStick, 5);
	Button cameraFlip = new JoystickButton(driveStick, 7);
	
	//Button flopButton = new JoystickButton(coStick, 1);
	//Button flipButton = new JoystickButton(coStick, 2);
	Button sp = new JoystickButton(coStick, 6);
	Button doortoggle = new JoystickButton(coStick, 1);
	Button floorUp = new JoystickButton(coStick, 3);
	Button floorDown = new JoystickButton(coStick, 4);
	
	//Button openClaw = new JoystickButton(driveStick, 3);
	//Button closeClaw = new JoystickButton(driveStick, 2);
	
//	Button reverseDrive = new JoystickButton(driveStick, 7);
	
	
	public OI() {
		//float winchVal = (float) driveStick.getRawAxis(3);
		//winchButton.whenPressed(new WinchStart(winchVal));
		//reverseWinch.whenPressed(new WinchReverse());
		//winchButton.whenReleased(new WinchStop());
		
		float BallPickerUpper = (float) coStick.getRawAxis(1);
		float Winch = (float) coStick.getRawAxis(5);
		
		raiseArm.whenPressed(new RaiseArm());
		raiseArm.whenReleased(new StopArm());
		lowerArm.whenPressed(new LowerArm());
		lowerArm.whenReleased(new StopArm());
		
		floorUp.whenPressed(new FloorUp());
		floorDown.whenPressed(new FloorDown());
		clawButton.whenPressed(new ClawMove());
		sp.whileHeld(new sP());
		doortoggle.whenPressed(new DoorToggle());
		cameraFlip.whenPressed(new CameraFlip());
		
		
		//openClaw.whenPressed(new PnuematicsOpen());
		//openClaw.whenReleased(new PneumaticsStop());
		//closeClaw.whenPressed(new PneumaticsClose());
		//closeClaw.whenReleased(new PneumaticsStop());
		//flopButton.whenPressed(new Flop());
		//flipButton.whenPressed(new Flip());
		//reverseDrive.whenPressed(new direction_reverse());
		//flopButton.whenReleased(new FlipFlopStop());
		//flipButton.whenReleased(new FlipFlopStop());
		
	}
	
	public Joystick getDriveStick() {
        return driveStick;
    }
	public static Joystick getCoStick() {
		return coStick;
	}
}
