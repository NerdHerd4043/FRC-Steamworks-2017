package org.usfirst.frc.team4043.robot.commands;

import org.usfirst.frc.team4043.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LetsBeStupid extends Command {

	long startTime;
	long endTime;
	boolean isFinished = false;
	boolean clawOpened = false;
	long reverseTime;
	
    public LetsBeStupid(long time) {
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
    	clawOpened = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (System.currentTimeMillis() < endTime) {
    		Robot.drivetrain.drive.arcadeDrive(0.6, 0);
    	}
    	if (System.currentTimeMillis() > endTime) {
    		if (!clawOpened) {
    			Robot.grabberNabber.OpenClaw();
        		reverseTime = System.currentTimeMillis() + 1000;
    			clawOpened = true;
    		}
    		Robot.drivetrain.drive.arcadeDrive(-0.6, 0.1);
    		if (System.currentTimeMillis() > reverseTime){
        		isFinished = true;
    		}
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
