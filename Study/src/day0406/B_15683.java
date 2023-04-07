package day0406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class B_15683 {

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
	
	static List<Pos> cctv = new ArrayList<>();
	static int N,M,min;
	static int arr[][];
	static int number[];
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	public static void main(String[] args) throws IOException {

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		min = Integer.MAX_VALUE;
		arr = new int[N][M];
		
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] != 0 && arr[i][j] != 6) {
					cctv.add(new Pos(i,j));
				}
			}
		}
		
		number = new int[cctv.size()];
		
		DFS(0,arr);
		System.out.println(min);
	}
	
	public static void DFS(int cnt, int[][] map) {
//		for (int i = 0; i < map.length; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
//		System.out.println();
		
		if(cnt == cctv.size()) {
			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j]==0) {
						count++;
					}
				}
			}
			min = Math.min(min, count);
			return ;
			
			
		}
		switch (map[cctv.get(cnt).r][cctv.get(cnt).c]) {
		case 1: {
			for (int d = 0; d < 4; d++) {
				int temp[][] = new int[N][M];
//				System.out.println("-----");
//				for (int i = 0; i < map.length; i++) {
//					System.out.println(Arrays.toString(map[i]));
//				}
//				System.out.println("-----");
				for (int i = 0; i < N; i++) {
					temp[i] = map[i].clone();
				}
				int dR = cctv.get(cnt).r;
				int dC = cctv.get(cnt).c;
				while(true) {
					dR += dr[d];
					dC += dc[d];
					
					if(dR < 0 || dR >= N || dC < 0 || dC >= M) break;
					if(map[dR][dC] == 6) break;
					if(map[dR][dC] == 0) {
						temp[dR][dC] = 10;
					}
				}
				DFS(cnt+1,temp);
			}
			break;
		}
		case 2: {
			for (int d = 0; d < 3; d=d+2) {
				int temp[][] = new int[N][M];
				for (int i = 0; i < N; i++) {
					temp[i] = map[i].clone();
				}
				int dR = cctv.get(cnt).r;
				int dC = cctv.get(cnt).c;
				while(true) {
					dR += dr[d];
					dC += dc[d];
					
					if(dR < 0 || dR >= N || dC < 0 || dC >= M) break;
					if(map[dR][dC] == 6) break;
					if(map[dR][dC] == 0) {
						temp[dR][dC] = 10;
					}
				}
				dR = cctv.get(cnt).r;
				dC = cctv.get(cnt).c;
				while(true) {
					dR += dr[d+1];
					dC += dc[d+1];
					
					if(dR < 0 || dR >= N || dC < 0 || dC >= M) break;
					if(map[dR][dC] == 6) break;
					if(map[dR][dC] == 0) {
						temp[dR][dC] = 10;
					}
				}
				DFS(cnt+1,temp);
			}
			break;
		}
		case 3: {
			for (int d = 0; d < 4; d++) {
				int temp[][] = new int[N][M];
				for (int i = 0; i < N; i++) {
					temp[i] = map[i].clone();
				}
				int dR = cctv.get(cnt).r;
				int dC = cctv.get(cnt).c;
				while(true) {
					if(d==0) {
						dR += dr[0];
						dC += dc[0];
						
					}else if(d==1) {
						dR += dr[0];
						dC += dc[0];
						
					}else if(d==2) {
						dR += dr[1];
						dC += dc[1];
						
					}else if(d==3) {
						dR += dr[1];
						dC += dc[1];
					}

					if(dR < 0 || dR >= N || dC < 0 || dC >= M) break;
					if(map[dR][dC] == 6) break;
					if(map[dR][dC] == 0) {
						temp[dR][dC] = 10;
					}
				}
				dR = cctv.get(cnt).r;
				dC = cctv.get(cnt).c;
				while(true) {
					if(d==0) {
						dR += dr[2];
						dC += dc[2];
						
					}else if(d==1) {
						dR += dr[3];
						dC += dc[3];
						
					}else if(d==2) {
						dR += dr[2];
						dC += dc[2];
						
					}else if(d==3) {
						dR += dr[3];
						dC += dc[3];
					}

					if(dR < 0 || dR >= N || dC < 0 || dC >= M) break;
					if(map[dR][dC] == 6) break;
					if(map[dR][dC] == 0) {
						temp[dR][dC] = 10;
					}
				}
				DFS(cnt+1,temp);
			}
			break;
		}
		case 4: {
			for (int d = 0; d < 4; d++) {
				int temp[][] = new int[N][M];
				for (int i = 0; i < N; i++) {
					temp[i] = map[i].clone();
				}
				int dR = cctv.get(cnt).r;
				int dC = cctv.get(cnt).c;
				while(true) {
					if(d==0) {
						dR += dr[0];
						dC += dc[0];
						
					}else if(d==1) {
						dR += dr[0];
						dC += dc[0];
						
					}else if(d==2) {
						dR += dr[1];
						dC += dc[1];
						
					}else if(d==3) {
						dR += dr[1];
						dC += dc[1];
					}

					if(dR < 0 || dR >= N || dC < 0 || dC >= M) break;
					if(map[dR][dC] == 6) break;
					if(map[dR][dC] == 0) {
						temp[dR][dC] = 10;
					}
				}
				dR = cctv.get(cnt).r;
				dC = cctv.get(cnt).c;
				while(true) {
					if(d==0) {
						dR += dr[2];
						dC += dc[2];
						
					}else if(d==1) {
						dR += dr[3];
						dC += dc[3];
						
					}else if(d==2) {
						dR += dr[2];
						dC += dc[2];
						
					}else if(d==3) {
						dR += dr[0];
						dC += dc[0];
					}

					if(dR < 0 || dR >= N || dC < 0 || dC >= M) break;
					if(map[dR][dC] == 6) break;
					if(map[dR][dC] == 0) {
						temp[dR][dC] = 10;
					}
				}
				dR = cctv.get(cnt).r;
				dC = cctv.get(cnt).c;
				while(true) {
					if(d==0) {
						dR += dr[3];
						dC += dc[3];
						
					}else if(d==1) {
						dR += dr[1];
						dC += dc[1];
						
					}else if(d==2) {
						dR += dr[3];
						dC += dc[3];
						
					}else if(d==3) {
						dR += dr[2];
						dC += dc[2];
					}

					if(dR < 0 || dR >= N || dC < 0 || dC >= M) break;
					if(map[dR][dC] == 6) break;
					if(map[dR][dC] == 0) {
						temp[dR][dC] = 10;
					}
				}

				DFS(cnt+1,temp);
			}
			break;
		}
		case 5: {
			int temp[][] = new int[N][M];
			for (int i = 0; i < N; i++) {
				temp[i] = map[i].clone();
			}
			int dR = cctv.get(cnt).r;
			int dC = cctv.get(cnt).c;
			while(true) {
				dR += dr[0];
				dC += dc[0];
				
				if(dR < 0 || dR >= N || dC < 0 || dC >= M) break;
				if(map[dR][dC] == 6) break;
				if(map[dR][dC] == 0) {
					temp[dR][dC] = 10;
				}
			}
			dR = cctv.get(cnt).r;
			dC = cctv.get(cnt).c;
			while(true) {
				dR += dr[1];
				dC += dc[1];
				
				if(dR < 0 || dR >= N || dC < 0 || dC >= M) break;
				if(map[dR][dC] == 6) break;
				if(map[dR][dC] == 0) {
					temp[dR][dC] = 10;
				}
			}
			dR = cctv.get(cnt).r;
			dC = cctv.get(cnt).c;
			while(true) {
				dR += dr[2];
				dC += dc[2];
				
				if(dR < 0 || dR >= N || dC < 0 || dC >= M) break;
				if(map[dR][dC] == 6) break;
				if(map[dR][dC] == 0) {
					temp[dR][dC] = 10;
				}
			}
			dR = cctv.get(cnt).r;
			dC = cctv.get(cnt).c;
			while(true) {
				dR += dr[3];
				dC += dc[3];
				
				if(dR < 0 || dR >= N || dC < 0 || dC >= M) break;
				if(map[dR][dC] == 6) break;
				if(map[dR][dC] == 0) {
					temp[dR][dC] = 10;
				}
			}
			DFS(cnt+1,temp);
			break;
		}
		default:
		}
		
		
		
	}

}

