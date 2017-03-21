package org.usfirst.frc.team4043.robot.commands;

import org.usfirst.frc.team4043.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class TurnToAngle extends Command {
	
	private static final int TIMEOUT = 3000;
	
	private static final int MIN_ALIGNED_COUNT = 5;
	private static final double KP = 0.009; 
	private static final double KD = 0.0105;
	private static final double KI = 0.0;
	private static final double MINIMUM_POWER = 0.05;
	
	public boolean isFinished = false;
	
	private double degrees, targetYaw;
	private double error, lastError, totalError;
	private double alignedCount;
	private final double allowableError;
	
	private long startTime;
	
	double leftPower, rightPower, output = 0;
	
	public TurnToAngle(double degrees, double allowableError)
	{
		this.degrees = degrees;
		this.alignedCount = 0;
		this.allowableError = allowableError;
	}
	
	public void initialize()
	{
		this.targetYaw = degrees;  //Calculate the target heading off of # of degrees to turn
		this.lastError = this.error = getError(); //Calculate the initial error value
		this.totalError += this.error;
		startTime = System.currentTimeMillis();
		isFinished = false;
	}
	
	public void execute()
	{
		error = getError(); //Update error value
		System.out.println(error);
		this.totalError += this.error; //Update running error total
		
		if((Math.abs(error) < allowableError)) alignedCount++;
		if(alignedCount >= MIN_ALIGNED_COUNT) {
			isFinished = true;
			return;
		}
		if(System.currentTimeMillis() - startTime > TIMEOUT){
			isFinished = true;
			return;
		}
		
		output = ((KP * error) + (KI * totalError) + (KD * (error - lastError)));
		if(Math.abs(output) < MINIMUM_POWER){
			double scalar = output>0?1:-1;
			output = MINIMUM_POWER * scalar;
		}
		leftPower = output; 
		rightPower = -output;
		
		Robot.drivetrain.drive.arcadeDrive(0, output);
		
		lastError = error;
	}
	
	public double getError(){
		//return navx.getAngleDistance(navx.getAngleOffStart(), targetYaw);
		return Robot.drivetrain.gyroSPI.getAngle();
	}

	@Override
	protected boolean isFinished() {
		return isFinished;
	}
	
}