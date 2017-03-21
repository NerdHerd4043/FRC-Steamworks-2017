package org.usfirst.frc.team4043.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class AutoM extends CommandGroup {

    public AutoM() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	
    	//according to all known laws of aviation a bee should not be able to fly
    	
    	addSequential(new DriveTimed(3000),3);
    	addSequential(new WaitCommand(.5));
    	//addSequential(new Pause(500));
    	addSequential(new ClawMove());
    	addSequential(new WaitCommand(.5));
    	//addSequential(new Pause(500));
    	addSequential(new ReverseDriveTimed(1000), 1);
    }
}
