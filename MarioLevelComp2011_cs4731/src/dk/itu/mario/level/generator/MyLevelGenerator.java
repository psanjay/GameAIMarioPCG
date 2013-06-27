package dk.itu.mario.level.generator;

import java.util.Random;

import dk.itu.mario.MarioInterface.Constraints;
import dk.itu.mario.MarioInterface.GamePlay;
import dk.itu.mario.MarioInterface.LevelGenerator;
import dk.itu.mario.MarioInterface.LevelInterface;
import dk.itu.mario.level.CustomizedLevel;
import dk.itu.mario.level.MyLevel;

public class MyLevelGenerator extends CustomizedLevelGenerator implements LevelGenerator{

	public LevelInterface generateLevel(GamePlay playerMetrics) {
		Random random = new Random();
		//Running is about 10 blocks/second
		//Walking is about 5 blocks/second
		int Time_Total = playerMetrics.totalTime;
		int Time_Run = playerMetrics.timeSpentRunning;
		int Time_Duck = playerMetrics.timeSpentDucking;
		int Deaths = playerMetrics.timesOfDeathByArmoredTurtle+playerMetrics.timesOfDeathByCannonBall+playerMetrics.timesOfDeathByChompFlower+(int)playerMetrics.timesOfDeathByFallingIntoGap+playerMetrics.timesOfDeathByGoomba+playerMetrics.timesOfDeathByGreenTurtle+playerMetrics.timesOfDeathByJumpFlower+playerMetrics.timesOfDeathByRedTurtle;
		int Time_Taken = Time_Total - Time_Duck;
		Time_Taken += Time_Run;
		Time_Taken = Time_Taken/(Deaths+1);
		if (playerMetrics.completionTime > Time_Taken)
			Time_Taken = playerMetrics.completionTime;
		if (Time_Taken > 120)
			Time_Taken = 120;
		if (Time_Taken < 45)
			Time_Taken = 45;
		int Level_Length = Time_Taken*5;
		long Seed = random.nextLong();
		int height = 15;
		int difficulty = 1;
		System.out.println("Time To Comletion: " + playerMetrics.completionTime + " Total Time: " + Time_Total);
		System.out.println("Time Taken: " + Time_Taken + " Time Run: " + Time_Run + " Time Duck: " + Time_Duck + " Deaths: " + Deaths);
		System.out.println("Level Length: " + Level_Length + " Seed: " + Seed + " Difficulty: " + difficulty);
		LevelInterface level = new MyLevel(Level_Length,height,Seed,difficulty,LevelInterface.TYPE_OVERGROUND,playerMetrics);
		return level;
	}

	@Override
	public LevelInterface generateLevel(String detailedInfo) {
		// TODO Auto-generated method stub
		return null;
	}

}
