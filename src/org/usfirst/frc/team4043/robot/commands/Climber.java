package org.usfirst.frc.team4043.robot.commands;

import org.usfirst.frc.team4043.robot.OI;
import org.usfirst.frc.team4043.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Climber extends Command {
	Command armUp;
    public Climber() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.winch);
    	armUp = new RaiseArm();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	float axis = (float)OI.getCoStick().getRawAxis(5);
    	if (axis > 0.1f){
    		Robot.winch.start(axis);
    		armUp.start();
    	}
    	else if (axis < -0.3f) {
    			Robot.winch.start(axis);
    	}
    	else {
    		Robot.winch.stop();
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
