package day0320;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class B_4991 {

	static class Pos{
		int r,c;

		public Pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static int R,C;
	static char map[][];
	static int MIN;
	static boolean isCheck[];
	static ArrayList<Pos> list;
	static int number[];
	static int dis[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null; 
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			
			C = Integer.parseInt(st.nextToken()); 
			R = Integer.parseInt(st.nextToken());
			
			if(R == 0 && C == 0) break;
			
			MIN = Integer.MAX_VALUE;
			
			map = new char[R][C];
			
			int oIndex = 0;
			list = new ArrayList<>();
			for (int i = 0; i < R; i++) {
				String s = br.readLine();
				for (int j = 0; j < C; j++) {
					map[i][j] = s.charAt(j);
					if(map[i][j] == 'o') {
						oIndex = list.size();
						list.add(new Pos(i,j));
					}else if(map[i][j] == '*') {
						list.add(new Pos(i,j));
					}
				}
			}
			isCheck = new boolean[list.size()];
			number = new int[list.size()];
			dis = new int[list.size()][list.size()];
			
			for (int i = 0; i < list.size()-1; i++) {
				for (int j = i+1; j < list.size(); j++) {
					int dist = BFS(list.get(i), list.get(j));
					dis[i][j] = dis[j][i] = dist;
//					System.out.println(list.get(i).r + " " + list.get(i).c );
//					System.out.println(list.get(j).r + " " + list.get(j).c );
//					System.out.println(dist);
				}
			}
			
			number[0] = oIndex;
			isCheck[oIndex] = true;
			perm(1);
			if(MIN == Integer.MAX_VALUE) {
				System.out.println(-1);
			}else {
				System.out.println(MIN);
			}
			
			
		}
	}
	
	public static void perm(int cnt) {
		if(cnt == list.size()) {
			int sum = 0;
			for (int i = 0; i < list.size()-1; i++) {
				if(dis[number[i]][number[i+1]] == -1) {
					return ;
				}
				sum += dis[number[i]][number[i+1]];
			}
//			if(dis[number[list.size()-1]][number[0]] == -1) {
//				return ;
//			}
//			sum += dis[number[list.size()-1]][number[0]];
//			for (int i = 0; i < list.size(); i++) {
//				System.out.print(number[i]+" ");
//			}
//			System.out.println(sum);
			MIN = Math.min(MIN, sum);
		}
		
		for (int i = 0; i < list.size(); i++) {
			if(isCheck[i]) continue;
			number[cnt] = i;
			isCheck[i] = true;
			perm(cnt+1);
			isCheck[i] = false;
		}
	}
	
	public static int BFS(Pos a, Pos b) {
		boolean isVisit[][] = new boolean[R][C];
		Queue<Pos> que = new LinkedList<>();
		que.offer(new Pos(a.r, a.c));
		isVisit[a.r][a.c] = true;
		
		int count = -1;
		while(!que.isEmpty()) {
			int size = que.size();
			count ++;
			for (int i = 0; i < size; i++) {
				Pos cur = que.poll();
				if(cur.r == b.r && cur.c == b.c) return count;
				
				for (int d = 0; d < 4; d++) {
					int dR = cur.r + dr[d];
					int dC = cur.c + dc[d];
					
					if(dR < 0 || dR >= R || dC < 0 || dC >= C) continue;
					if(isVisit[dR][dC]) continue;
					if(map[dR][dC] == 'x') continue;
					que.offer(new Pos(dR,dC));
					isVisit[dR][dC] = true;
				}
			}
		}
		
		
		
		return -1;
	}

}
