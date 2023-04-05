package day0404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B_16236 {

	
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
	
	static class Fish{
		Pos pos;
		int dist;
		public Fish(Pos pos, int dist) {
			super();
			this.pos = pos;
			this.dist = dist;
		}
		
		
	}
	
	
	static int dr[] = {-1,0,0,1};
	static int dc[] = {0,-1,1,0};
	static int N;
	static int map[][];
	
	static boolean isCheck[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in); 
		N = sc.nextInt();
		
		Pos sharkP = null;
		int sharkSize = 2;
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 9) sharkP = new Pos(i,j);
			}
		}
		int time = 0;
		int count = 0;
		while(true) {
			Fish f = findMin(sharkP, sharkSize);
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					System.out.print(map[i][j]+ " ");
//				}
//				System.out.println();
//			}
			if(f==null) break;
			time += f.dist;
//			System.out.println("time" + time);
//			System.out.println(f.pos);
			map[sharkP.r][sharkP.c] = 0;
			map[f.pos.r][f.pos.c] = 9;
			sharkP = new Pos(f.pos.r, f.pos.c);
			count ++;
//			System.out.println(sharkSize);
			if(count == sharkSize) {
				sharkSize ++;
				count = 0;
			}
		}
		System.out.println(time);
		
		
		
	}
	
	public static Fish findMin(Pos p, int sSize) {
		boolean isVisit[][] = new boolean[N][N];
		Queue<Pos>que = new LinkedList<>();
		que.offer(new Pos(p.r,p.c));
		isVisit[p.r][p.c] = true;
		int count = -1;
		Fish ans = null;
		boolean isConti = true;
		while(!que.isEmpty()) {
			if(!isConti) break;
			isConti = true;
			int size = que.size();
			count ++;
			
			for (int i = 0; i < size; i++) {
				Pos cur = que.poll();
				if(map[cur.r][cur.c] != 9 &&map[cur.r][cur.c] != 0 && map[cur.r][cur.c] < sSize) {
					isConti = false;
					if(ans == null) {
						ans = new Fish(new Pos(cur.r,cur.c),count); 
					}else {
						if(cur.r <= ans.pos.r) {
							if(cur.r == ans.pos.r) {
								if(cur.c < ans.pos.c) {
									ans = new Fish(new Pos(cur.r,cur.c),count);
								}
							}else {
								ans = new Fish(new Pos(cur.r,cur.c),count);
							}
						}
					}
				}
				if(!isConti) continue;
				for (int d = 0; d < 4; d++) {
					int dR = cur.r + dr[d];
					int dC = cur.c + dc[d];
					if(dR < 0 || dR >= N || dC < 0 || dC >= N) continue;
					if(isVisit[dR][dC]) continue;
					if(map[dR][dC] == 0 && map[dR][dC] == 9) continue;
					if(map[dR][dC] > sSize) continue;
					que.offer(new Pos(dR,dC));
					isVisit[dR][dC] = true;
				}
			}
			
		}
		return ans;
	}
	
	
	
}
