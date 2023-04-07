package day0406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class B_9944_정답 {
	static class Pos{
		int r,c;

		public Pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Pos [r=" + r + ", c=" + c + "]";
		}
		
		
		
	}
	
	static int N,M;
	static int min;
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int count = 1;
		String input = "";
		while((input = br.readLine()) !=  null ) {
			
			st = new StringTokenizer(input);
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			min = Integer.MAX_VALUE;
			char[][] map = new char[N][M];
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < M; j++) {
					map[i][j] = s.charAt(j);
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j] == '.') {
						map[i][j] = 'o';
						DFS(new Pos(i,j), map, 0);
						map[i][j] = '.';
					}
				}
			}
			
			if(min == Integer.MAX_VALUE) {
				System.out.println("Case " + count + ": " + -1);
				
			}else {
				
				System.out.println("Case " + count + ": " + min);
			}
			count ++;
		}
		
	}
	
	public static void DFS(Pos p, char[][] temp, int count) {
		if(Check(temp)) {
			min = Math.min(count, min);
			return ;
		}
		
		for (int d = 0; d < 4; d++) {
			List<Pos> list = new ArrayList<>();
			int dR = p.r;
			int dC = p.c;
			while(true) {
				dR += dr[d];
				dC += dc[d];
				
				if(dR < 0 || dR >= N || dC < 0 || dC >= M) break;
				if(temp[dR][dC] == '*') break;
				if(temp[dR][dC] == 'o') {
					break;
				}else {
					temp[dR][dC] = 'o';
					list.add(new Pos(dR,dC));
				}
			
			}
			
			dR -= dr[d];
			dC -= dc[d];
			if(dR == p.r && dC ==p.c) continue;
			DFS(new Pos(dR,dC), temp, count+1);
			for (int i = 0; i < list.size(); i++) {
				temp[list.get(i).r][list.get(i).c] = '.';
			}
			
		}
	}
	
	public static boolean Check(char[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == '.') return false;
			}
		}
		return true;
	}

}
