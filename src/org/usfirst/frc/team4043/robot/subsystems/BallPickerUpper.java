package org.usfirst.frc.team4043.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc.team4043.robot.RobotMap;

public class BallPickerUpper extends Subsystem {

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new org.usfirst.frc.team4043.robot.commands.BallPickerUpper());
	}

	public void start(float axis) {
		RobotMap.ballPickerUpper.set(axis);

	}

	public void stop() {
		RobotMap.ballPickerUpper.set(0);
	}

}
