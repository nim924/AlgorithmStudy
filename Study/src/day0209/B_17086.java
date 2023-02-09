package day0209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_17086 {
	
	static class Pos{
		int r,c;

		public Pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}

	static int dr[] = {-1,1,0,0,-1,-1,1,1};
	static int dc[] = {0,0,-1,1,-1,1,-1,1};
	static int N,M;
	static int MAX, MIN;
	static int arr[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		MAX = 0;
		
		arr = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				MIN = Integer.MAX_VALUE;
				if(arr[i][j] == 0) {
					boolean isVisited[][] = new boolean[N][M];
					isVisited[i][j] = true;
					DFS(new Pos(i,j), isVisited, 0);
					System.out.println(MIN);
					MAX = Math.max(MIN, MAX);
				}
			}
		}
		System.out.println(MAX);
		
	}
	
	public static void DFS(Pos p, boolean isVisited[][], int count) {
		if(count > MIN) return ;
		if(arr[p.r][p.c] == 1) {
			
			return ;
		}
		for(int d=0; d<8; d++) {
			int dR = p.r + dr[d];
			int dC = p.c + dc[d];
			
			if(dR < 0 || dR >= N || dC < 0 || dC >= M) continue;
			if(isVisited[dR][dC]) continue;
			isVi
			
		}
	}

}
