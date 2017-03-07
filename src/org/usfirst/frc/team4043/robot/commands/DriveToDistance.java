package org.usfirst.frc.team4043.robot.commands;

import org.usfirst.frc.team4043.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveToDistance extends Command {
	
	public double target_ticks;
	public double current_ticks;
	public double error;
	public double deriv_error;
	public double prev_error = 0;
	public double p_out;
	public double d_out;
	public double output;
	boolean isfinished = false;
	

    public DriveToDistance(double inches) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    	target_ticks = inches / 28.26 * 3600;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivetrain.renc.reset();
    	Robot.drivetrain.lenc.reset();
    	isfinished = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	current_ticks = Robot.drivetrain.renc.getRaw();
    	error = target_ticks - current_ticks;
    	deriv_error = prev_error - error;
    	
    	p_out = error / 1500;
    	d_out = deriv_error / 3600;
    	
    	output = p_out + d_out;
		
		if (output > 1) {
			output = 1;
		}
		if (output < -1) {
			output = -1;
		}
		
		prev_error = error;
		
		Robot.drivetrain.drive.arcadeDrive(output, 0);
		
		if (error < 50) {
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
