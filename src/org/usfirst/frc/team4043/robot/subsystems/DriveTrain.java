package org.usfirst.frc.team4043.robot.subsystems;

import org.usfirst.frc.team4043.robot.RobotMap;
import org.usfirst.frc.team4043.robot.commands.TankDrive;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveTrain extends Subsystem {
	
	public RobotDrive drive;
	
	private AnalogInput rightRangeFinder;
	public AnalogInput frontRangeFinder;
	
	public ADXRS450_Gyro gyroSPI;
	public Encoder renc;
	public Encoder lenc;
	public DriveTrain() {
		super();
		//TODO: Double check this, are the motors going in the correct spots? Hover over drive base to see where they should go.
		//Changed 2-2-2017
		drive = new RobotDrive(RobotMap.motorFL, RobotMap.motorBL, RobotMap.motorFR, RobotMap.motorBR);
		gyroSPI = new ADXRS450_Gyro();
		gyroSPI.calibrate();
		renc = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
		lenc = new Encoder(2, 3, false, Encoder.EncodingType.k4X);
	}

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public void drive(double throttle, double turn) {
			drive.arcadeDrive(throttle, turn);
	}
	
	public float maxSpeed = -1;
	public float maxTurn = 0.85f;
	public float maxautoturn = 0.25f;
	public float currentSpeed;
	//public float currentTurn;
	public double inputSpeed;
	public double inputTurn;
	public boolean autoTurnEnabled;
	public boolean turnStarted = false;
	public double lastTurnRead;
	public double currentTurnRead;
	public double turnStep = 0.1d;
	public double turnSlowThreshhold = 0.25d;
	public double maxSpeedDuringManualTurn = -0.8f;
	public boolean driveDirection = true;
	
	public void drive(Joystick joy) {
		if (SmartDashboard.getBoolean("DB/Button 0", false)) {
			drive.tankDrive(joy.getRawAxis(1), joy.getRawAxis(5));
			return;
		}
		inputSpeed = -joy.getRawAxis(1);
		inputTurn = -joy.getRawAxis(4);
		
		//TODO: DOUBLE CHECK THIS SECTION, perhaps remove the limits completely for now.
		//if (inputSpeed < maxSpeed) {  
			//inputSpeed = maxSpeed;
		//}
		
		drive(inputSpeed, inputTurn);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new TankDrive());
    }
}

