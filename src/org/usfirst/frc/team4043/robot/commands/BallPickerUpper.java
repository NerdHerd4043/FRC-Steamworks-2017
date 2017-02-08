package org.usfirst.frc.team4043.robot.commands;

import org.usfirst.frc.team4043.robot.OI;
import org.usfirst.frc.team4043.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class BallPickerUpper extends Command {

    public BallPickerUpper() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	float axis = (float)OI.getCoStick().getRawAxis(1);
    	if (axis > 0.02f){
    		Robot.ballPickerUpper.start(axis);
    	}
    	else{
    		Robot.ballPickerUpper.stop();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
