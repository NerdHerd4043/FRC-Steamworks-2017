package org.usfirst.frc.team4043.robot.commands;

import org.usfirst.frc.team4043.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveTimed extends Command {

	long startTime;
	long endTime;
	boolean isFinished = false;
	
    public DriveTimed(long time) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    	startTime = System.currentTimeMillis();
    	endTime = startTime + 3000;
    	System.out.println("time" + time);
    	System.out.println("start" + startTime);
    	System.out.println("end" + endTime);

    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.drive.arcadeDrive(0.6, 0);
    	if (System.currentTimeMillis() > endTime) {
        	Robot.grabberNabber.OpenClaw();
    		isFinished = true;
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isFinished;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
