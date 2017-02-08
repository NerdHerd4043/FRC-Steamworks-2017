package org.usfirst.frc.team4043.robot.subsystems;

import org.usfirst.frc.team4043.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Winch extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public void start(float axis) {
		RobotMap.winch1.set(axis);
		RobotMap.winch2.set(axis);
		
		//RobotMap.winch1.set(-0.5f);
		//RobotMap.winch2.set(-0.5f);
	}
	
	public void reverse() {
		RobotMap.winch1.set(-0.5f);
		RobotMap.winch2.set(-0.5f);
		
		//RobotMap.winch1.set(0.5f);
		//RobotMap.winch2.set(0.5f);
	}
	
	public void stop() {
		RobotMap.winch1.set(0);
		RobotMap.winch2.set(0);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

