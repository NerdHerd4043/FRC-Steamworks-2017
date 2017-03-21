package org.usfirst.frc.team4043.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class AutoL extends CommandGroup {

    public AutoL() {
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
    	
//    	addSequential(new DriveToDistance(114));     \
//    	addSequential(new AutoTurning(30));           - This is all distance and turning that doesn't work
//    	addSequential(new DriveToDistance(28.579));  /
    	
    	addSequential(new DriveTimed(2500));
    	addSequential(new WaitCommand(.25));
    	addSequential(new DriveTimed(0));
    }
}
