package day0406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class B_9944 {

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
	
	static class D{
		int r,c,d;

		public D(int r, int c, int d) {
			super();
			this.r = r;
			this.c = c;
			this.d = d;
		}

		
		
	}
	static int N,M;
	static int map[][];
	static int total;
	static int min;
	static boolean isVisit[][][];
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		total = 0;
		min = Integer.MAX_VALUE;
		isVisit = new boolean[N][M][4];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
				if(map[i][j] == '.') total ++;
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == '.') {
					DFS(new Pos(i,j),0,1,-1, new boolean[N][M]);
				}
			}
		}
		System.out.println(min);
		
	}
	
	public static void DFS(Pos p, int count, int visitCnt, int dir, boolean check[][]) {
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(check[i]));
		}
		if(visitCnt == total) {
			min = Math.min(min, count);
			return;
		}
		for (int d = 0; d < 4; d++) {
			int dR = p.r;
			int dC = p.c;
			System.out.println(dR + " " + dC +" " + d + " " +isVisit[dR][dC][d]);
			if(isVisit[dR][dC][d]) continue;
			ArrayList<Pos> list = new ArrayList<>();
			ArrayList<D> dList = new ArrayList<>();
			boolean[][] temp = new boolean[N][M];
			
			for (int i = 0; i < N; i++) {
				temp[i] = check[i].clone();
			}
			int cnt = visitCnt;
			isVisit[dR][dC][d] = true;
			dList.add(new D(dR,dC,d));
			if(!temp[dR][dC]) {
				temp[dR][dC] = true;
				list.add(new Pos(dR,dC));
				cnt ++;
			}
			while(true) {
				dR += dr[d];
				dC += dc[d];
				
				if(dR < 0 || dR >= N || dC < 0 || dC >= M) break;
				if(map[dR][dC] == '*') break;
				if(!isVisit[dR][dC][d]) {
					dList.add(new D(dR,dC,d));
					isVisit[dR][dC][d] = true;
				}
				
				if(!temp[dR][dC]) {
					list.add(new Pos(dR,dC));
					cnt++;
					temp[dR][dC] = true;
				}
			}
			dR -= dr[d];
			dC -= dc[d];
			if(cnt - visitCnt != 0) {
				DFS(new Pos(dR,dC), count+1, cnt,d, temp);
				for (int i = 0; i < list.size(); i++) {
					temp[list.get(i).r][list.get(i).c] = false;
				}
			}
			System.out.println("delete");
			for (int i = 0; i < dList.size(); i++) {
				System.out.println(dList.get(i).r + " " + dList.get(i).c + " " + dList.get(i).d);
				isVisit[dList.get(i).r][dList.get(i).c][dList.get(i).d] = false;
			}
			System.out.println("------");
			
			
			
		}
		
		
	}

}
