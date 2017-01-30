package org.usfirst.frc.team4043.robot;

import com.ctre.CANTalon;

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
	public static CANTalon motorFR;
	public static CANTalon motorFL;
	public static CANTalon motorBR;
	public static CANTalon motorBL;
	
	public static CANTalon winch1;
	public static CANTalon winch2;
	
	public static void init() {
		motorFR = new CANTalon(1);
		LiveWindow.addActuator("DriveTrain", "CAN Talon 1", motorFR);
		
		motorFL = new CANTalon(2);
		LiveWindow.addActuator("DriveTrain", "CAN Talon 2", motorFL);
		
		motorBR = new CANTalon(3);
		LiveWindow.addActuator("DriveTrain", "CAN Talon 3", motorBR);
		
		motorBL = new CANTalon(4);
		LiveWindow.addActuator("DriveTrain", "CAN Talon 4", motorBL);
		
		winch1 = new CANTalon(5);
		LiveWindow.addActuator("Winch", "CAN Talon 5", winch1);
		
		winch2 = new CANTalon(6);
		LiveWindow.addActuator("Winch", "CAN Talon 6", winch2);
		
	}
}
