import java.awt.*;
import javax.swing.*;
import java.util.Scanner;

public class MyCanvas extends Canvas
	{
		
		static int size;
		static int color;
		static Graphics graphics;
		static Scanner userIntInput = new Scanner(System.in);
		private static final long serialVersionUID = 1L;

		public static void main(String[] args)
			{
				System.out.println("Test 3");
		//		challengeOneSysos();
				
				MyCanvas canvas = new MyCanvas();
				JFrame frame = new JFrame();
				frame.setSize(1000, 1000);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.getContentPane().add(canvas).setBackground(Color.gray);
				frame.setLocationRelativeTo(null); // Sets JPanel to center of screen
				frame.setResizable(false);
				frame.setVisible(true);
				
			}

		public void paint(Graphics graphics)
			{

			//Challenge 1 (Completed)	
				
				//Set Blue Color
		//		if (color == 1)
		//			{
		//				graphics.setColor(Color.blue);
		//				graphics.drawRect(110, 100, size, size);
		//			}
				//Set Red Color
		//		else if (color == 2)
		//			{
		//				graphics.setColor(Color.red);
		//				graphics.drawRect(110, 100, size, size);
		//			}
				
			//Challenge 2 (Completed)
				
				for (int r = 0; r <= 255; r++)
					{
						for (int g = 0; g <= 255; g++)
							{
								for (int b = 0; b <= 255; b++)
									{
										graphics.setColor(new Color(r, g, b));
										graphics.fillRect(100, 100, 200, 200);
									}
							}
					}
				
			//Challenge 2

			}

		public static void challengeOneSysos()
			{
				System.out.println("How big of a square would you like to make? (from 100-800 pixels)");
				size = userIntInput.nextInt();
				System.out.println("What color would you like the square?");
				System.out.println("1) Blue");
				System.out.println("2) Red");
				color = userIntInput.nextInt();
			}

		public void delay()
			{
				try
					{
						Thread.sleep(500);
					} catch (InterruptedException e)
					{
						e.printStackTrace();
					}
			}
	}

