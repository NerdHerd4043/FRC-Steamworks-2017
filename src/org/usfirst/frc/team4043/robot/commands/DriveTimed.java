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
	long driveTime;
	
    public DriveTimed(long time) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    	driveTime = time;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	startTime = System.currentTimeMillis();
    	endTime = startTime + driveTime;
    	System.out.println("time" + driveTime);
    	System.out.println("start" + startTime);
    	System.out.println("end" + endTime);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double angle = Robot.drivetrain.gyroSPI.getAngle();
    	//TODO: robot turned the wrong direction, I removed the - before angle so it should be 
    	//correct now, just needs re-testing.
    	//Robot.drivetrain.drive.arcadeDrive(0.6, angle*.03d); //.03 is a conversion factor
    	Robot.drivetrain.drive.arcadeDrive(0.6, 0);
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
