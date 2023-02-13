package day0213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_2178 {

	static class Pos{
		int r,c,cnt;

		public Pos(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

		
	}
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int [][] map = new int[N][M];
		
		for(int i=0; i< N; i++) {
			String s = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
			
		}
		boolean isVisit[][] = new boolean[N][M];
		Queue<Pos> que = new LinkedList<>();
		que.offer(new Pos(0,0,0));
		isVisit[0][0] = true;
		Pos cur = null;
		while(!que.isEmpty()) {
			int size = que.size();
			cur = que.poll();
			if(cur.r == N-1 && cur.c == M-1) break;
			for (int d = 0; d < 4; d++) {
				int dR = cur.r + dr[d];
				int dC = cur.c + dc[d];
					
				if(dR < 0 || dR >= N || dC < 0 || dC >= M) continue;
				if(map[dR][dC] == 0) continue;
				
				if(isVisit[dR][dC]) continue;
				
				isVisit[dR][dC] = true;
				que.offer(new Pos(dR,dC,cur.cnt+1));
			}
		}
		System.out.println(cur.cnt+1);
	}

}
