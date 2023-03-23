package day0321;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_16946 {
	
	static class Pos {
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

	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	
	static int R,C;
	static int map[][];
	static Map<Integer,  Integer> pair;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		pair = new HashMap<>();
		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		int ans[][] = new int[R][C];
		FloodFill();
		
//		for (int i = 0; i < R; i++) {
//			for (int j = 0; j < C; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
		
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] == 1) {
					int sum = 1;
					ArrayList<Integer> list = new ArrayList<>();
				
					for (int d = 0; d < 4; d++) {
						int dR = i + dr[d];
						int dC = j +dc[d];
						if(dR < 0 || dR >= R || dC < 0 || dC >= C) continue;
						if(map[dR][dC] != 1) {
							if(!list.contains(map[dR][dC])) {
								sum += pair.get(map[dR][dC]);
								list.add(map[dR][dC]);	
							}
						}
					}
					ans[i][j] = sum%10;
				}
			}
		}
//		for (int i = 0; i < R; i++) {
//			for (int j = 0; j < C; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				sb.append(ans[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());

	}
	
	public static void FloodFill() {
		int number = 2;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] == 0) {
					int count = fBFS(new Pos(i,j), number);
					pair.put(number, count);
					number ++;
				}
			}
		}
	}
	
	public static int fBFS(Pos p, int number) {
		Queue<Pos> que = new LinkedList<>();
		
		que.offer(new Pos(p.r,p.c));
		map[p.r][p.c] = number;
		int count=1;
		while(!que.isEmpty()) {
			Pos cur = que.poll();
			
			for (int d = 0; d < 4; d++) {
				int dR = cur.r + dr[d];
				int dC = cur.c + dc[d];
				
				if(dR < 0 || dR >= R || dC < 0 || dC >= C) continue;
				
				
				if(map[dR][dC] != 0) continue;
				
				que.offer(new Pos(dR,dC));
				map[dR][dC] = number;
				count++;
			}
		}
		
		return count;
	}
	
//시간 초과 안나게 주의 
//함수안에서 new boolean[N][M] 으로 인해 매번 new 해서 시간초과가 나더라...ㄷ
//println 을 써도 날수도 있다 stringbuilder로 쓰기

}
