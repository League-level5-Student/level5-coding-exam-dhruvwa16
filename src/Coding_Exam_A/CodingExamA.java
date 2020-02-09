package Coding_Exam_A;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.jointheleague.graphical.robot.Robot;

public class CodingExamA {
	public static void main(String[] args) {
		/*
		 * Write a program that asks the user for three pieces of information.
		 * 1. How many robots
		 * 2. The color of the shapes
		 * 3. How many sides each shape will have
		 * 
		 * Once the information has been collected, the program will then make the requested number of robots
		 * each draw the requested shape in the requested color. The robots should execute at the same time so 
		 * Threads will need to be used. Arrange the robots so that the shapes do not overlap.
		 * For full credit, define the Thread functions using lambdas.
		 * 
		 * See the Coding_Exam_A_Demo.jar for an example of what the finished product should look like.
		 */

		String a = JOptionPane.showInputDialog("How many robots?");
		int robots = Integer.parseInt(a);
		Robot [] robot = new Robot[robots];
		String color = JOptionPane.showInputDialog("Which color? (Red, Green, Blue)");
		String b = JOptionPane.showInputDialog("How many sides in the shape(>0)?");
		int sides = Integer.parseInt(b);
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setSize(2000,2000);
		for (int i = 0; i < robots; i++) {
			robot[i] = new Robot();
			if(color == "red") {
				robot[i].setPenColor(Color.RED);
			}
			else if(color == "green") {
				robot[i].setPenColor(Color.GREEN);
			}
			else {
				robot[i].setPenColor(Color.BLUE);
			}
			robot[i].penDown();
			robot[i].setSpeed(100);
			robot[i].setX(i * 200 + 100);
			robot[i].setY(i * 100 + 100);
		}
		Thread t = new Thread(()-> {
			 for (int i = 0; i < sides; i++) {
				robot[0].move(40);
				robot[0].turn(360/sides);
			}
		});
		Thread t2 = new Thread(()-> {
			 for (int i = 0; i < sides; i++) {
				robot[1].move(40);
				robot[1].turn(360/sides);
			}
		});
		Thread t3 = new Thread(()-> {
			 for (int i = 0; i < sides; i++) {
				robot[2].move(40);
				robot[2].turn(360/sides);
			}
		});
		Thread t4 = new Thread(()-> {
			 for (int i = 0; i < sides; i++) {
				robot[3].move(40);
				robot[3].turn(360/sides);
			}
		});
		
		t.start();
		t2.start();
		t3.start();
		t4.start();
		
	}

}
