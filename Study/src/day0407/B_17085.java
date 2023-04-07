package day0407;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_17085 {

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
	
	static char map[][];
	static int N,M;
	static int max;
	
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		max = 0;
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == '#') {
					map[i][j] = 'o';
					DFS1(new Pos(i,j), 0, new int[]{1,1});
					map[i][j] = '#';
				}
			}
		}
		
		System.out.println(max==0?1:max);
	}
	
	public static void DFS1(Pos p, int count, int[] size) {
		if(count == 2) {
			max = Math.max(((4 * size[0]-3) * (4*size[1]-3)), max);
			return ;
		}
		
		
	}
	

}
