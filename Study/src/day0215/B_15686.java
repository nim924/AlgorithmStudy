package day0215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B_15686 {

	static class Pos{
		int r,c;

		public Pos(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	
	static int N,M;
	static int map[][];
	static List<Pos> chickenList;
	static List<Pos> homeList;
	static int[] selectedChicken;
	static int MIN;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		chickenList = new ArrayList<>();
		homeList = new ArrayList<>();
		selectedChicken = new int[M];
		MIN = Integer.MAX_VALUE;
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == 1) {
					homeList.add(new Pos(i,j));
				}else if(map[i][j] == 2) {
					chickenList.add(new Pos(i,j));
				}
			}
		}
		
		if(chickenList.size() <= M) {
			int sum = 0;
			for(int i=0; i<homeList.size(); i++) {
				int MinD = Integer.MAX_VALUE;
				for (int j = 0; j < chickenList.size(); j++) {
					MinD = Math.min(MinD, (Math.abs(homeList.get(i).r - chickenList.get(j).r) + Math.abs(homeList.get(i).c - chickenList.get(j).c)));
				}
				sum += MinD;
			}
			System.out.println(sum);
			return ;
		}else {
			comb(0,0);
		}
		System.out.println(MIN);
		
		
	}
	
	public static void comb(int start, int count) {
		if(count == M) {
			MIN = Math.min(MIN, calcDist());
			return ;
		}
		
		for(int i=start; i<chickenList.size(); i++) {
			selectedChicken[count] = i;
			comb(i+1, count+1);
		}
	}
	
	public static int calcDist() {
		int sum = 0;
		for(int i=0; i<homeList.size(); i++) {
			int MinD = Integer.MAX_VALUE;
			for (int j = 0; j < M; j++) {
				MinD = Math.min(MinD, (Math.abs(homeList.get(i).r - chickenList.get(selectedChicken[j]).r) + Math.abs(homeList.get(i).c - chickenList.get(selectedChicken[j]).c)));
			}
			sum += MinD;
		}
		
		return sum;
	}

}
