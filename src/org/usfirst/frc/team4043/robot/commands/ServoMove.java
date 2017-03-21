package org.usfirst.frc.team4043.robot.commands;

import org.usfirst.frc.team4043.robot.Robot;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ServoMove extends Command {
	
	Servo lidarServo = new Servo(1);
	double startTime;
	double currentTime;
	double Angle;
	

    public ServoMove(double angle) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    	//startTime = System.currentTimeMillis();
    	Angle = angle;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	currentTime = System.currentTimeMillis();
    	lidarServo.set(Angle);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
