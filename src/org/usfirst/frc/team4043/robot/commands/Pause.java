package org.usfirst.frc.team4043.robot.commands;

import org.usfirst.frc.team4043.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Pause extends Command {

	long startTime;
	long endTime;
	boolean isFinished = false;
	long waitTime;
	
    public Pause(long time) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    	waitTime = time;

    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	startTime = System.currentTimeMillis();
    	endTime = startTime + waitTime;
    	System.out.println("time" + waitTime);
    	System.out.println("start" + startTime);
    	System.out.println("end" + endTime);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (System.currentTimeMillis() > endTime) {
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
