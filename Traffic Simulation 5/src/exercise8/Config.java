package exercise8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Config {
	static Scanner scan = new Scanner(System.in);
	private String simTime;
	private String genRate;
	private String redRate;
	private String blueRate;
	private String purpleRate;
	private String yellowRate;

	public int getSimTime() {
		return Integer.parseInt(simTime);
	}

	public void setSimTime(String simTime) {
		this.simTime = simTime;
	}

	public int getGenRate() {
		return Integer.parseInt(genRate);
	}

	public void setGenRate(String genRate) {
		this.genRate = genRate;
	}
	
	public int getRedRate() {
		return Integer.parseInt(redRate);
	}

	public void setRedRate(String redRate) {
		this.redRate = redRate;
	}

	public int getBlueRate() {
		return Integer.parseInt(blueRate);
	}

	public void setBlueRate(String blueRate) {
		this.blueRate = blueRate;
	}

	public int getPurpleRate() {
		return Integer.parseInt(purpleRate);
	}

	public void setPurpleRate(String purpleRate) {
		this.purpleRate = purpleRate;
	}

	public int getYellowRate() {
		return Integer.parseInt(yellowRate);
	}

	public void setYellowRate(String yellowRate) {
		this.yellowRate = yellowRate;
	}

	public void read() {
		try {
			FileReader fReader = new FileReader("Config.txt");
			BufferedReader bReader = new BufferedReader(fReader);
			String s;
			
			s = bReader.readLine();
			setSimTime(s);
			s = bReader.readLine();
			setGenRate(s);
			s = bReader.readLine();
			setRedRate(s);
			s = bReader.readLine();
			setBlueRate(s);
			s = bReader.readLine();
			setYellowRate(s);
			s = bReader.readLine();
			setPurpleRate(s);
			
			bReader.close();
			fReader.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void write(String simTime, String genRate, String redRate, String blueRate, String yellowRate, String purpleRate) {
		try {
			FileWriter writer = new FileWriter("Config.txt", false);
			BufferedWriter bWriter = new BufferedWriter(writer);
			
			bWriter.write(simTime);
			bWriter.newLine();
			bWriter.write(genRate);
			bWriter.newLine();
			bWriter.write(redRate);
			bWriter.newLine();
			bWriter.write(blueRate);
			bWriter.newLine();
			bWriter.write(yellowRate);
			bWriter.newLine();
			bWriter.write(purpleRate);
			bWriter.newLine();
			
			bWriter.close();
			writer.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
