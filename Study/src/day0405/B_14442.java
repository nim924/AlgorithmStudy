package day0405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class B_14442 {
	
	static class Pos{
		int r,c,time,count;

		public Pos(int r, int c, int time, int count) {
			super();
			this.r = r;
			this.c = c;
			this.time = time;
			this.count = count;
		}

		@Override
		public String toString() {
			return "Pos [r=" + r + ", c=" + c + ", time=" + time + ", count=" + count + "]";
		}
		
		
	}

	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		boolean isVisit[][][] = new boolean[K+1][N][M];
		int map[][] = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0'; 
			}
		}
		
		Queue<Pos> que = new LinkedList<>();
		que.add(new Pos(0,0,1,0));
		isVisit[0][0][0] = true;
		
		while(!que.isEmpty()) {
			Pos cur = que.poll();
			if(cur.r == N-1 && cur.c == M-1) {
				System.out.println(cur.time);
				return;
			}
			
			for (int d = 0; d < 4; d++) {
				int dR = cur.r + dr[d];
				int dC = cur.c + dc[d];
				
				if(dR < 0 || dR >= N || dC < 0 || dC >= M) continue;
				if(isVisit[cur.count][dR][dC]) continue;
				if(map[dR][dC]==1) {
					if(cur.count+1 <= K) {
						que.offer(new Pos(dR,dC,cur.time+1, cur.count+1));
						isVisit[cur.count][dR][dC] = true;
					}
				}else {
					que.offer(new Pos(dR,dC,cur.time+1,cur.count));
					isVisit[cur.count][dR][dC] = true;
				}
					
			}
			
		}
		System.out.println(-1);
		
		
	}

}
