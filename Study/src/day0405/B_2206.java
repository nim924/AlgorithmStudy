package day0405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_2206 {

	static class Pos{
		int r,c, count;
		boolean isBreak;
		public Pos(int r, int c, int count, boolean isBreak) {
			super();
			this.r = r;
			this.c = c;
			this.count = count;
			this.isBreak = isBreak;
		}
		@Override
		public String toString() {
			return "Pos [r=" + r + ", c=" + c + ", count=" + count + ", isBreak=" + isBreak + "]";
		}
		
		
	}
	
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static int N,M;
	static int map[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j)-'0';
			}
		}
		
		System.out.println(BFS());
		
		
		
		
	}
	
	public static int BFS() {
		Queue<Pos> que = new LinkedList<>();
		boolean isVisit[][][] = new boolean[N][M][2];
		
		que.offer(new Pos(0,0,1,false));
		isVisit[0][0][0] = true;
		while(!que.isEmpty()) {
			Pos cur = que.poll();
//			System.out.println(cur);
			if(cur.r == N-1 && cur.c == M-1) return cur.count;
			for (int d = 0; d < 4; d++) {
				int dR = cur.r + dr[d];
				int dC = cur.c + dc[d];
				
				if(dR < 0 || dR >= N || dC < 0 || dC >=M) continue;
				if(isVisit[dR][dC][cur.isBreak == true?1:0]) continue;
				if(map[dR][dC] == 1) {
					if(!cur.isBreak) {
						que.offer(new Pos(dR,dC, cur.count+1, true));
						isVisit[dR][dC][cur.isBreak == true?1:0] = true;
					}
				}else {
					que.offer(new Pos(dR,dC, cur.count+1, cur.isBreak));
					isVisit[dR][dC][cur.isBreak == true?1:0] = true;
				}
			}
			
		}
		
		return -1;
	}
	
	

}
