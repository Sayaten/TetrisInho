import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Tetris implements KeyListener{
	public static void print_plane(Plane block) {
		for (int y = 0; y < block.dy; y++) {
			for (int x = 0; x < block.dx; x++) {
				if (block.get_ref()[y][x] > 0)
					System.out.print("■ ");
				else
					System.out.print("□ ");
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}
	
	public static char get_key() throws IOException{
			char c;
			String line;
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			line = br.readLine();
			c = line.charAt(0);
			//c = (char) System.in.read();
			//System.in.reset();
			return c;
	}
	
	public static void main(String args[]) {
		int[][] screen_array = {
				{ 1, 0, 0, 0, 0, 0, 0, 1},	
				{ 1, 0, 0, 0, 0, 0, 0, 1},	
				{ 1, 0, 0, 0, 0, 0, 0, 1},	
				{ 1, 0, 0, 0, 0, 0, 0, 1},	
				{ 1, 0, 0, 0, 0, 0, 0, 1},	
				{ 1, 0, 0, 0, 0, 0, 0, 1},	
				{ 1, 0, 0, 0, 0, 0, 0, 1},	
				{ 1, 0, 0, 0, 0, 0, 0, 1},	
				{ 1, 0, 0, 0, 0, 0, 0, 1},	
				{ 1, 0, 0, 0, 0, 0, 0, 1},	
				{ 1, 0, 0, 0, 0, 0, 0, 1},	
				{ 1, 0, 0, 0, 0, 0, 0, 1},	
				{ 1, 1, 1, 1, 1, 1, 1, 1},	
		};
		int[][] array1 = {
				{ 0, 1, 0 },
				{ 0, 1, 1 },
				{ 0, 0, 1 }
		};
		Plane board = new Plane(screen_array);
		Plane block = new Plane(array1);
		//Plane block = new Plane(4,4);
		int[][] array = block.get_ref();
				
		//print_plane(block);
		//print_plane(board);
		
		// 기존 보드를 복사
		Plane board2 = new Plane(board);
				
		// 보드에 블럭을 붙임
		//board2.paste(block, 0, 2);
		//print_plane(board2);
		
		// 보드의 이동
		//board2 = new Plane(board);
		//board2.paste(block, 1, 2);
		//print_plane(board2);
		
		boolean endGame = false;
		long start = System.currentTimeMillis();
		long end;
		int nowX = 2, nowY = 0;
		int count = 0;
		char key = 0;
		Plane backup, realboard, testboard;
		
		realboard = new Plane(board);
		testboard = new Plane(realboard);
		backup = new Plane(realboard);
		
		print_plane(realboard);
		
		while(!endGame)
		{
			if(System.currentTimeMillis() - start >= 1000)
			{
				/*
				testboard = new Plane(backup);
				nowY++;
				
				testboard.paste(block, nowY, nowX);
				count++;
				print_plane(board2);
				start = System.currentTimeMillis();
				*/
				System.out.println(System.currentTimeMillis() - start);
				start = System.currentTimeMillis();
			}
			try{
				if(System.in.available() != 0)
				{
					key = get_key();
					System.out.println(key);
					
				}
			}catch(Exception e){
				
			}

			if(count > 5)
			{
				endGame = true;
			}
		} // game
		
		//board.paste(block, 1, 2);
		//print_plane(board);
		/*
		for (int y = 0; y < block.dy; y++) {
			for (int x = 0; x < block.dx; x++) {
				System.out.print(array[y][x]);
			}
			System.out.println("");
		}
		System.out.println("array[0][0] = " + array[0][0]);
		*/
		
	}
	
	public static boolean checkDownColl(Plane board, Plane block)
	{
		
		return false;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
