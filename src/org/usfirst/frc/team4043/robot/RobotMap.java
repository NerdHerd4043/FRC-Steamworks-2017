package org.usfirst.frc.team4043.robot;

import org.usfirst.frc.team4043.robot.commands.Flip;
import org.usfirst.frc.team4043.robot.commands.Flop;
import org.usfirst.frc.team4043.robot.commands.PneumaticsClose;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	public static CANTalon motorFR = new CANTalon(4);
	public static CANTalon motorFL = new CANTalon(2);
	public static CANTalon motorBR = new CANTalon(3);
	public static CANTalon motorBL = new CANTalon(1);
	
	public static CANTalon winch1 = new CANTalon(5);
	public static CANTalon winch2 = new CANTalon(6);
	
	public static CANTalon GrabberArm = new CANTalon(7);
	public static CANTalon GrabberClaw = new CANTalon(8);
	
	public static CANTalon ballPickerUpper = new CANTalon(9);
	
	public static Compressor compressor = new Compressor(16);
	
	public static Servo servo = new Servo(5);
	
	public static void init() {
		GrabberArm.reverseSensor(true);
		compressor.setClosedLoopControl(true);
		new Flip();
		new PneumaticsClose();
		
		LiveWindow.addActuator("DriveTrain", "CAN Talon 4", motorFR);
		
		LiveWindow.addActuator("DriveTrain", "CAN Talon 2", motorFL);
		
		LiveWindow.addActuator("DriveTrain", "CAN Talon 3", motorBR);
		
		LiveWindow.addActuator("DriveTrain", "CAN Talon 1", motorBL);
		
		LiveWindow.addActuator("Winch", "CAN Talon 5", winch1);
		
		LiveWindow.addActuator("Winch", "CAN Talon 6", winch2);
		
		LiveWindow.addActuator("Arm", "CAN Talon 7", GrabberArm);
	
		LiveWindow.addActuator("Claw", "CAN Talon 8", GrabberClaw);
		
		LiveWindow.addActuator("BallPickerUpper", "CAN Talon 9", ballPickerUpper);

	}
}
