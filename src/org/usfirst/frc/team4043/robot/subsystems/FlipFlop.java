package org.usfirst.frc.team4043.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class FlipFlop extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	DoubleSolenoid flipFlop = new DoubleSolenoid(1, 2);
	
	public void flip() {
		flipFlop.set(DoubleSolenoid.Value.kReverse);
	}
	
	public void flop() {
		flipFlop.set(DoubleSolenoid.Value.kForward);
	}
	
	public void stop() {
		flipFlop.set(DoubleSolenoid.Value.kOff);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

