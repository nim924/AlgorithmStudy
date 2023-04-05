package day0405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B_16924 {
	
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
	
	static class Ten{
		Pos center;
		int size;
		public Ten(Pos center, int size) {
			super();
			this.center = center;
			this.size = size;
		}
		@Override
		public String toString() {
			return "Ten [center=" + center + ", size=" + size + "]";
		}
		
	}
	
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static int N,M;
	static char map[][];
	static boolean isCheck[][];
	static ArrayList<Ten> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		
		
		isCheck = new boolean[N][M];
		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == '*') {
					find(new Pos(i,j));
				}
			}
		}
		
		if(list.size() == 0) {
			System.out.println(-1);
		}else {
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j] == '*' && !isCheck[i][j]) {
						System.out.println(-1);
						return;
					}
				}
			}
			System.out.println(list.size());
			for (int i = 0; i < list.size(); i++) {
				System.out.println((list.get(i).center.r+1) + " " + (list.get(i).center.c+1) + " " + list.get(i).size);
			}
		}
		
		
	}
	
	public static void find(Pos p) {
		Pos up = new Pos(p.r,p.c),down = new Pos(p.r,p.c),left = new Pos(p.r,p.c),right = new Pos(p.r,p.c);
		int size = 1;
		while(true) {
			boolean isSuccess = true;
			for (int d = 0; d < 4; d++) {
				Pos cur = null;
				switch (d) {
				case 0: {
					cur = up;
					break;
				}
				case 1: {
					cur = down;
					break;
				}
				case 2: {
					cur = left;
					break;
				}
				case 3: {
					cur = right;
					break;
				}
				default:
				}
				
				int dR = cur.r + dr[d];
				int dC = cur.c + dc[d];
				
				if(dR < 0 || dR >= N && dC < 0 || dC >= M) {
					isSuccess = false;
					break;
				}
				if(map[dR][dC] == '.') {
					isSuccess = false;
					break;
				}
				switch (d) {
				case 0: {
					up = new Pos(dR, dC);
					break;
				}
				case 1: {
					down = new Pos(dR, dC);
					break;
				}
				case 2: {
					left = new Pos(dR, dC);
					break;
				}
				case 3: {
					right = new Pos(dR, dC);
					break;
				}
				default:
				}
				
			}
			if(isSuccess) {
				isCheck[p.r][p.c] = true;
				isCheck[up.r][up.c] = true;
				isCheck[down.r][down.c] = true;
				isCheck[left.r][left.c] = true;
				isCheck[right.r][right.c] = true;
				list.add(new Ten(p, size));
				size ++;
			}else {
				break;
			}
		}
	}

}
