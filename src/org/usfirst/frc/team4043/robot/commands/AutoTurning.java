package org.usfirst.frc.team4043.robot.commands;

import org.usfirst.frc.team4043.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoTurning extends Command {
	
	double gyroAngle;
	double wanted_angle;
	double AngleSpeed = -0.6d;
	public int Step;
	public float targetAngle;
	String targetAnglestr;
	public double angleMinSpeed;
	double figuredSpeed = 0;
	boolean isfinished = false;

    public AutoTurning() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivetrain.gyroSPI.reset();
    	isfinished = false;
    }
    
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

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	gyroAngle = Robot.drivetrain.gyroSPI.getAngle();
		if (gyroAngle > targetAngle + 1.5){
			Robot.drivetrain.drive.arcadeDrive(0, findAngleSpeed(gyroAngle));
		}
		else if (gyroAngle < targetAngle -1.5){
			Robot.drivetrain.drive.arcadeDrive(0, findAngleSpeed(gyroAngle));
		}
		else {
			isfinished = true;
		}
		
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isfinished;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
