package day0215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B_16918 {

	static class Pos{
		int r,c;

		public Pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	static int R,C,N;
	static char map[][];
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		List<Pos> bombList = new ArrayList<>();
		map = new char[R][C];
		
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j] =='O') {
					bombList.add(new Pos(i,j));
				}
			}
		}
		
		int dr[] = {-1,1,0,0};
		int dc[] = {0,0,-1,1};
		int time = 1;
		while(true) {
			if(time == 1) {
				
			}else {
				if(time%2 == 0) {
					for (int i = 0; i < R; i++) {
						for (int j = 0; j < C; j++) { 
							if(map[i][j] =='.') {
								map[i][j] = 'O';
							}
						}
					}
				}else {
					for (int i = 0; i < bombList.size(); i++) {
						Pos cur = bombList.get(i);
						map[cur.r][cur.c] = '.';
						for (int d = 0; d < 4; d++) {
							int dR = cur.r + dr[d];
							int dC = cur.c + dc[d];
							
							if(dR < 0 || dR >= R || dC < 0 || dC >= C) continue;
							map[dR][dC] = '.';
						}
					}
					bombList = new ArrayList<>();
					for (int i = 0; i < R; i++) {
						for (int j = 0; j < C; j++) { 
							if(map[i][j] =='O') {
								bombList.add(new Pos(i,j));
							}
						}
					}
					
				}
			}
			if(time == N) break;
			/*
			 * for (int i = 0; i < R; i++) { for (int j = 0; j < C; j++) {
			 * System.out.print(map[i][j]); } }
			 */
			time ++;
		}
		
		
		
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	
	}

}
