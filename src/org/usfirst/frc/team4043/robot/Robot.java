
package org.usfirst.frc.team4043.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team4043.robot.subsystems.DuckPlucker;
import org.usfirst.frc.team4043.robot.subsystems.FlipFlop;
import org.usfirst.frc.team4043.robot.commands.AutoL;
import org.usfirst.frc.team4043.robot.commands.AutoM;
import org.usfirst.frc.team4043.robot.commands.AutoR;
import org.usfirst.frc.team4043.robot.commands.DriveTimed;
import org.usfirst.frc.team4043.robot.commands.DriveToDistance;
import org.usfirst.frc.team4043.robot.commands.Flip;
import org.usfirst.frc.team4043.robot.commands.Flop;
import org.usfirst.frc.team4043.robot.commands.LetsBeStupid;
import org.usfirst.frc.team4043.robot.commands.PneumaticsClose;
import org.usfirst.frc.team4043.robot.subsystems.BallBox;
import org.usfirst.frc.team4043.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4043.robot.subsystems.GrabberNabber;
import org.usfirst.frc.team4043.robot.subsystems.Winch;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 * Will this work?
 */
public class Robot extends IterativeRobot {

	public static OI oi;
	public static DriveTrain drivetrain;
	public static Winch winch;
	public static GrabberNabber grabberNabber;
	public static DuckPlucker ballPickerUpper;
	public static FlipFlop flipFlop;
	public static BallBox ballbox;
	
	double gyroAngle;
	double wanted_angle;
	double AngleSpeed = -0.6d;
	public int Step;
	public float targetAngle;
	String targetAnglestr;
	public double angleMinSpeed;
	Preferences prefs;

	Command autonomousCommand;
	SendableChooser autoChooser;
	SendableChooser<Command> chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		// chooser.addObject("My Auto", new MyAutoCommand())
		SmartDashboard.putData("Auto mode", chooser);
		drivetrain = new DriveTrain();
		winch = new Winch();
		flipFlop = new FlipFlop();
		grabberNabber = new GrabberNabber();
		ballPickerUpper = new DuckPlucker();
		ballbox = new BallBox();
		oi = new OI();
		
		autoChooser = new SendableChooser <Command>();
		autoChooser.addObject("Timed Drive" , new DriveTimed(3000l));
		autoChooser.addDefault("Drop Gear", new LetsBeStupid(3000));
//		autoChooser.addObject("Left side", new AutoL());
//		autoChooser.addObject("Right side" , new AutoR());
//		autoChooser.addObject("Center spike" , new AutoM());
//		autoChooser.addObject("Nothing" , null);
//		SmartDashboard.putData("Autonomous mode chooser" , autoChooser);
		
		drivetrain.TankDrive = Preferences.getInstance().getBoolean("TankDrive", false);

		UsbCamera camera = CameraServer.getInstance().startAutomaticCapture("Front", 0);
		camera.setResolution(320, 240);
		camera.setFPS(15);
		
		Servo exampleServo= new Servo(1);
		exampleServo.set(.5);
		exampleServo.setAngle(75);
		
		
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
		new Flop();
		new PneumaticsClose();

	}

	@Override
	public void disabledPeriodic() {
		drivetrain.TankDrive = Preferences.getInstance().getBoolean("Tankdrive", false);
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		
		autonomousCommand = new LetsBeStupid(3000);//(Command) autoChooser.getSelected();
		drivetrain.gyroSPI.reset();
		
		//autonomousCommand = (Command) autoChooser.getSelected();
		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
		
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		
		SmartDashboard.putNumber("Does it work?", 1.01d);
		SmartDashboard.putNumber("right encoder value", (double) RobotMap.motorBR.getPulseWidthPosition());
		SmartDashboard.putNumber("left encoder value", (double) RobotMap.motorBL.getPulseWidthPosition());
	}
	

	
	public void auto2() {
		gyroAngle = drivetrain.gyroSPI.getAngle();
		targetAnglestr = SmartDashboard.getString("DB/String 1", "myDefaultData");
		targetAngle = Float.parseFloat(targetAnglestr);
		
		if (Step == 1) {
			if (Math.abs(gyroAngle) < Math.abs(targetAngle)) {
				if (targetAngle < 0){
				    drivetrain.drive.arcadeDrive(0, AngleSpeed);
				}
				else{
					drivetrain.drive.arcadeDrive(0, -AngleSpeed);
				}
			} else {
				drivetrain.drive.arcadeDrive(0, 0);
				Step = 2;
				System.out.println("Step2");
			}
		}
		
		if (Step == 2) {
				if (targetAngle < 0){
					if (gyroAngle < 0) {
						drivetrain.drive.arcadeDrive(0, -AngleSpeed);
					} else {
						drivetrain.drive.arcadeDrive(0, 0);
						Step = 1;
					}
				}
				else{
					if (gyroAngle > 0) {
						drivetrain.drive.arcadeDrive(0, -AngleSpeed);
					} else {
						drivetrain.drive.arcadeDrive(0, 0);
					}
				}
		
		}
	}
	
	public void auto3() {
		gyroAngle = drivetrain.gyroSPI.getAngle();
		if (gyroAngle > targetAngle + 1.5){
			drivetrain.drive.arcadeDrive(0, findAngleSpeed(gyroAngle));
		}
		if (gyroAngle < targetAngle -1.5){
			drivetrain.drive.arcadeDrive(0, findAngleSpeed(gyroAngle));
		}
	}
	
	double figuredSpeed = 0;
	
	public double findAngleSpeed(double gyroAngle) {
		if (gyroAngle < targetAngle + 10 && gyroAngle > targetAngle){
			return angleMinSpeed;
		}
		if (gyroAngle > targetAngle -10 && gyroAngle < targetAngle){
			return -angleMinSpeed;
		}
		figuredSpeed = (gyroAngle - targetAngle) * AngleSpeed;
		if (Math.abs(figuredSpeed) > Math.abs(AngleSpeed)) {
			if (figuredSpeed > 0) {
				return -AngleSpeed;
			} else {
				return AngleSpeed;
			}
		} else {
			return figuredSpeed;
		}		
	}

	
	//
	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		
		//current_ticks = drivetrain.renc.getRaw();
		//SmartDashboard.putNumber("encoder value", current_ticks);
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		
		//current_ticks = 
		SmartDashboard.putNumber("Does it work?", 1.01d);
		SmartDashboard.putNumber("right encoder value", (double) RobotMap.motorBR.getPulseWidthPosition());
		SmartDashboard.putNumber("left encoder value", (double) RobotMap.motorBL.getPulseWidthPosition());
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
