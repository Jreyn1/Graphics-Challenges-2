import java.awt.*;
import javax.swing.*;
import java.util.Scanner;

public class MyCanvas extends Canvas
	{

		static int size;
		static int color;
		static int counter = 1;
		static Graphics graphics;
		static Scanner userIntInput = new Scanner(System.in);
		private static final long serialVersionUID = 1L;

		public static void main(String[] args)
			{
				System.out.println("Test 3");
				// challengeOneSysos();

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

				// Challenge 1 (Completed)

				// Set Blue Color
				if (color == 1)
					{
						graphics.setColor(Color.blue);
						graphics.drawRect(110, 100, size, size);
					}
				// Set Red Color
				else if (color == 2)
					{
						graphics.setColor(Color.red);
						graphics.drawRect(110, 100, size, size);
					}

				// Challenge 2 (Completed)

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

				// Challenge 3

				boolean cubeMoving = true;

				for (int i = 0; i <= 950; i = i + 10)
					{
						graphics.setColor(Color.yellow);
						graphics.fillRect(i, i, 20, 20);

						delay();

						graphics.setColor(Color.gray);
						graphics.fillRect(i, i, 20, 20);
					}

				for (int i = 950; i >= 0; i = i - 10)
					{
						graphics.setColor(Color.yellow);
						graphics.fillRect(i, i, 20, 20);

						delay();

						graphics.setColor(Color.gray);
						graphics.fillRect(i, i, 20, 20);
					}
				// Challenge 4
				for (int i = 0; i <= 965; i = i + 10)
					{
						graphics.setColor(Color.yellow);
						graphics.fillRect(i, 480, 20, 20);

						delay();

						graphics.setColor(Color.gray);
						graphics.fillRect(i, 480, 20, 20);
					}

				for (int i = 965; i >= 0; i = i - 10)
					{
						graphics.setColor(Color.yellow);
						graphics.fillRect(i, 480, 20, 20);

						delay();

						graphics.setColor(Color.gray);
						graphics.fillRect(i, 480, 20, 20);
					}

				// Challenge 5

				// Black Outer
				for (int i = 50; i <= 400; i = i + 100)
					{
						for (int i1 = 50; i1 <= 400; i1 = i1 + 100)
							{
								graphics.setColor(Color.black);
								graphics.fillRect(i, i1, 50, 50);
							}
					}

				// Black Inner
				for (int i = 100; i <= 400; i = i + 100)
					{
						for (int i1 = 100; i1 <= 400; i1 = i1 + 100)
							{
								graphics.setColor(Color.black);
								graphics.fillRect(i, i1, 50, 50);
							}
					}

				// White Outer
				for (int i = 100; i <= 400; i = i + 100)
					{
						for (int i1 = 50; i1 <= 400; i1 = i1 + 100)
							{
								graphics.setColor(Color.white);
								graphics.fillRect(i, i1, 50, 50);
							}
					}

				// White Inner
				for (int i = 50; i <= 400; i = i + 100)
					{
						for (int i1 = 100; i1 <= 400; i1 = i1 + 100)
							{
								graphics.setColor(Color.white);
								graphics.fillRect(i, i1, 50, 50);
							}
					}

				delay2();

				// White Outer
				for (int i = 50; i <= 400; i = i + 100)
					{
						for (int i1 = 50; i1 <= 400; i1 = i1 + 100)
							{
								graphics.setColor(Color.white);
								graphics.fillRect(i, i1, 50, 50);
							}
					}

				// White Inner
				for (int i = 100; i <= 400; i = i + 100)
					{
						for (int i1 = 100; i1 <= 400; i1 = i1 + 100)
							{
								graphics.setColor(Color.white);
								graphics.fillRect(i, i1, 50, 50);
							}
					}

				// Black Outer
				for (int i = 100; i <= 400; i = i + 100)
					{
						for (int i1 = 50; i1 <= 400; i1 = i1 + 100)
							{
								graphics.setColor(Color.black);
								graphics.fillRect(i, i1, 50, 50);
							}
					}

				// Black Inner
				for (int i = 50; i <= 400; i = i + 100)
					{
						for (int i1 = 100; i1 <= 400; i1 = i1 + 100)
							{
								graphics.setColor(Color.black);
								graphics.fillRect(i, i1, 50, 50);
							}
					}
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
						Thread.sleep(20);
					} catch (InterruptedException e)
					{
						e.printStackTrace();
					}
			}

		public void delay2()
			{
				try
					{
						Thread.sleep(5000);
					} catch (InterruptedException e)
					{
						e.printStackTrace();
					}
			}
	}
