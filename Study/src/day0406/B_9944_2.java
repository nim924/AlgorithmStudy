package day0406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_9944_2 {
	
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
	
	static class V{
		int d,r,c;

		public V(int d, int r, int c) {
			super();
			this.d = d;
			this.r = r;
			this.c = c;
		}
		
		
	}

	static int N,M;
	static int min;
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static boolean isVisit[][][];
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = 1;
		while(true) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			if(st==null) break;
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			min = Integer.MAX_VALUE;
			char[][] map = new char[N][M];
			isVisit = new boolean[4][N][M];
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < M; j++) {
					map[i][j] = s.charAt(j);
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j] == '.') {
						DFS(new Pos(i,j), map, 0);
					}
				}
			}
			
			System.out.println("Case " + count + ": " + min);
			count ++;
		}
		
	}
	
	public static void DFS(Pos p, char[][]map, int count) {
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
//		System.out.println(p);
		if(Check(map)) {
//			System.out.println("here");
			min = Math.min(count, min);
			return ;
		}
		
		for (int d = 0; d < 4; d++) {
//			System.out.println(isVisit[d][p.r][p.c]);
			if(isVisit[d][p.r][p.c]) continue;
			isVisit[d][p.r][p.c] = true;
			ArrayList<V> list = new ArrayList<>();
			list.add(new V(d,p.r,p.c));
			char[][] temp = new char[N][M];
			
			for (int i = 0; i < N; i++) {
				temp[i] = map[i].clone();
			}
			
			int dR = p.r;
			int dC = p.c;
			temp[dR][dC] = 'o';
			boolean isFill = false;
			boolean isMove = false;
			while(true) {
				dR += dr[d];
				dC += dc[d];
				
				if(dR < 0 || dR >= N || dC < 0 || dC >= M) break;
				if(temp[dR][dC] == '*') break;
				if(temp[dR][dC] == 'o') break;
				isMove = true;
				if(!isVisit[d][dR][dC]) {
					isVisit[d][dR][dC] = true;
					list.add(new V(d,dR,dC));
				}
				if(temp[dR][dC] != 'o') {
					temp[dR][dC] = 'o';
					isFill = true;
				}
				
			}
			dR -= dr[d];
			dC -= dc[d];
//			System.out.println(dR + " " + dC);
			
			
			if(isMove && isFill) {
				DFS(new Pos(dR,dC), temp, count + 1);
			}
			for (int i = 0; i < list.size(); i++) {
				isVisit[d][list.get(i).r][list.get(i).c] = false;
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
