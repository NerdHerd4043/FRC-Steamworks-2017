package org.usfirst.frc.team4043.robot.subsystems;

import org.usfirst.frc.team4043.robot.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class FlipFlop extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	Solenoid flipflop = new Solenoid(16, 1);
	
	public void flip() {
		flipflop.set(false);
		System.out.println("FLOP!");
	}
	
	public void flop() {
		flipflop.set(true);
		System.out.println("FLIP!");
	}
	
	//public void stop() {
		//flipFlop.set(DoubleSolenoid.Value.kOff);
	//}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

