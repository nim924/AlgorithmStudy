package day0407;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class B_17070 {

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
	
	static int N;
	static int map[][];
	static int dr[] = {0,1,1};
	static int dc[] = {1,0,1};
	static int answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		
		StringTokenizer st = null;
		answer = 0;
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		DFS(new Pos(0,1),0);
		System.out.println(answer);
		
	}
	
	public static void DFS(Pos p, int dir) {
//		System.out.println(p);
		if(p.r == N-1 && p.c == N-1) {
			answer ++;
			return ;
		}
		
		for (int d = 0; d < 3; d++) {
			int dR = p.r + dr[d];
			int dC = p.c + dc[d];
			
			if(dR < 0 || dR >= N || dC < 0 ||dC >= N) continue;
			if(map[dR][dC] != 0) continue;
			switch (d) {
			case 0: {
				if(dir==1) continue;
				map[dR][dC] = 2;
				DFS(new Pos(dR,dC), d);
				map[dR][dC] = 0;
				break;
			}
			case 1: {
				if(dir==0) continue;
				map[dR][dC] = 2;
				DFS(new Pos(dR,dC), d);
				map[dR][dC] = 0;
				break;
			}
			case 2: {
				int ldR = p.r + dr[0];
				int ldC = p.c + dc[0];
				
				int ddR = p.r + dr[1];
				int ddC = p.c + dc[1];
				
				if(ldR < 0 || ldR >= N || ldC < 0 || ldC >= N || ddR < 0 || ddR >= N || ddC < 0 || ddC >= N) continue;
				if(map[ldR][ldC] != 0) continue;
				if(map[ddR][ddC] != 0) continue;
				map[dR][dC] = 2;
				DFS(new Pos(dR,dC), d);
				map[dR][dC] = 0;
				
				break;
			}
			default:
			}
		}
	}

}
