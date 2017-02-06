package org.usfirst.frc.team4043.robot.subsystems;

import org.usfirst.frc.team4043.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GrabberNabber extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
	public void OpenClaw() {
		RobotMap.GrabberClaw.set(0.5);
    }
	
	public void CloseClaw() {
		RobotMap.GrabberClaw.set(-0.5);
    }
	
	public void StopClaw() {
		RobotMap.GrabberClaw.set(0);
    }
	
	public void RaiseArm() {
		RobotMap.GrabberArm.set(0.5);
    }
	
	public void LowerArm() {
		RobotMap.GrabberArm.set(-0.5);
    }
	
	public void StopArm() {
		RobotMap.GrabberArm.set(0);
    }
}

