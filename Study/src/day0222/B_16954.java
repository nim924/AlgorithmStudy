package day0222;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class B_16954 {

	static class Pos{
		int r,c;

		public Pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	static int dr[] = {-1,1,0,0,-1,-1,1,1,0};
	static int dc[] = {0,0,-1,1,-1,1,-1,1,0};
	public static void main(String[] args) throws IOException {
		char map[][] = new char[8][8];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Pos> wallList = new LinkedList<>();
		for (int i = 0; i < 8; i++) {
			String s = br.readLine();
			for (int j = 0; j < 8; j++) {
				map[i][j] = s.charAt(j);
				
			}
		}
		for (int i = 7; i >= 0; i--) {
			for (int j = 0; j < 8; j++) {
				if(map[i][j] == '#') {
					wallList.add(new Pos(i,j));
				}
				
			}
		}
		Queue<Pos> que = new LinkedList<>();
		que.add(new Pos(7,0));
		
		while(!que.isEmpty()) {
			int size = que.size();
			for (int i = 0; i < size; i++) {
				Pos cur = que.poll();
				if(map[cur.r][cur.c] == '#') {
					continue;
				}
				if(cur.r == 0 && cur.c == 7) {
					System.out.println("1");
					return ;
				}
				for (int d = 0; d < 9; d++) {
					int dR = cur.r + dr[d];
					int dC = cur.c + dc[d];
					
					if(dR < 0 || dR >= 8 || dC < 0 || dC>= 8) continue;
					if(map[dR][dC] == '#') continue;
					que.add(new Pos(dR,dC));
					
				}
			}
			
			int wallsize = wallList.size();
			for (int i = 0; i < wallsize; i++) {
				Pos wall = wallList.poll();
				map[wall.r][wall.c] = '.';
				if(wall.r+1 < 8) {
					wallList.add(new Pos(wall.r+1,wall.c));
					map[wall.r+1][wall.c] = '#';
				}
			}
//			for (int i = 0; i < 8; i++) {
//				for (int j = 0; j < 8; j++) {
//					System.out.print(map[i][j]);
//				}
//				System.out.println();
//			}
//			System.out.println();
			
		}
		System.out.println(0);
		
		
		
	}

}
