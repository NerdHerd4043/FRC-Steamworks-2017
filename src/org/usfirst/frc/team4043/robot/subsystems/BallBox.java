package org.usfirst.frc.team4043.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class BallBox extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	Solenoid ballBoxFloor = new Solenoid(16, 2);

    public void floorUp() {
    	ballBoxFloor.set(true);
    }
    
    public void floorDown() {
    	ballBoxFloor.set(false);
    }
    
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

