package org.usfirst.frc.team4043.robot.subsystems;

import org.usfirst.frc.team4043.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GrabberNabber extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	Solenoid grabbernabber = new Solenoid(3); // Actually single solenoid in port 1

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
	public void OpenClaw() {
		grabbernabber.set(true);
    }
	
	public void CloseClaw() {
		grabbernabber.set(false);
    }
	
	//public void StopClaw() {
		//grabbernabber.set(DoubleSolenoid.Value.kOff);
    //}
	
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

