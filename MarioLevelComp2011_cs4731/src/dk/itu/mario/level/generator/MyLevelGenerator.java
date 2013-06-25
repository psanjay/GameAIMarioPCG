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
		//Running is about 10 blocks/second
		//Walking is about 5 blocks/second
		int Completion_Time = playerMetrics.completionTime;
		int Time_Run = playerMetrics.timeSpentRunning;
		int equive_walk_time = Completion_Time+Time_Run;
		int Level_Length = equive_walk_time*4;
		System.out.println("Time to Complete: " + Completion_Time + " Time Running: " + Time_Run + "New Length: " + Level_Length);
		LevelInterface level = new MyLevel(Level_Length,15,new Random().nextLong(),2,LevelInterface.TYPE_OVERGROUND,playerMetrics);
		return level;
	}

	@Override
	public LevelInterface generateLevel(String detailedInfo) {
		// TODO Auto-generated method stub
		return null;
	}

}
