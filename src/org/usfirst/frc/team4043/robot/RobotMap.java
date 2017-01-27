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
	public static CANTalon driveTrainCANTalonFR;
	public static CANTalon driveTrainCANTalonFL;
	public static CANTalon driveTrainCANTalonBR;
	public static CANTalon driveTrainCANTalonBL;
	
	public static void init() {
		driveTrainCANTalonFR = new CANTalon(1);
		LiveWindow.addActuator("DriveTrain", "CAN Talon 1", driveTrainCANTalonFR);
		
		driveTrainCANTalonFL = new CANTalon(2);
		LiveWindow.addActuator("DriveTrain", "CAN Talon 2", driveTrainCANTalonFL);
		
		driveTrainCANTalonBR = new CANTalon(3);
		LiveWindow.addActuator("DriveTrain", "CAN Talon 3", driveTrainCANTalonBR);
		
		driveTrainCANTalonBL = new CANTalon(4);
		LiveWindow.addActuator("DriveTrain", "CAN Talon 4", driveTrainCANTalonBL);
	}
}
