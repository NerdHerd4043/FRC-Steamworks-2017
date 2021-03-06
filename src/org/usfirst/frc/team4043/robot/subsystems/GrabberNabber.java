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
	
	Solenoid grabbernabber = new Solenoid(16, 3);
	Solenoid kicker = new Solenoid(16,4);
	public boolean grabberState = true;
    public boolean kickerState = true;
	

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
	
	public void MoveClaw() {
		grabbernabber.set(grabberState);
		grabberState = !grabberState;
		System.out.println("claw move " + grabberState);
	}
	
	//public void StopClaw() {
		//grabbernabber.set(DoubleSolenoid.Value.kOff);
    //}
	
	public void RaiseArm() {
		RobotMap.GrabberArm.set(0.7);
    }
	
	public void LowerArm() {
		RobotMap.GrabberArm.set(-0.5);
    }
	
	public void StopArm() {
		RobotMap.GrabberArm.set(0);
    }
	
    public void KickerMove() {
        kicker.set(kickerState);
        kickerState = !kickerState;
    }

}

