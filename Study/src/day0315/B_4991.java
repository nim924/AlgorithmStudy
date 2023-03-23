package day0315;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
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
	
	static class Robot implements Comparable<Robot>{
		Pos p;
		int count, move;
		ArrayList<Pos> cleanList;
		public Robot(Pos p) {
			super();
			this.p = p;
			this.count = 0;
			this.move = 0;
			this.cleanList = new ArrayList<>();
		}
		public Robot(Pos p, int count, int move, ArrayList<Pos> cleanList) {
			super();
			this.p = p;
			this.count = count;
			this.move = move;
			this.cleanList = cleanList;
		}
		
		@Override
		public int compareTo(Robot o) {
			// TODO Auto-generated method stub
			if(o.count == this.count) {
				return this.move - o.move;
			}else {
				return o.count - this.count;
			}
		}
		@Override
		public String toString() {
			return "Robot [p=" + p + ", count=" + count + ", move=" + move + ", cleanList=" + cleanList + "]";
		}
		
		
		
		
		
	}
	
//	static int dr[] = {-1,1,0,0,-1,-1,1,1};
//	static int dc[] = {0,0,-1,1,-1,1,-1,1};
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null; 
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			
			int C = Integer.parseInt(st.nextToken()); 
			int R = Integer.parseInt(st.nextToken());
			
			boolean isVisit[][][] = new boolean[R][C][10];
			if(R == 0 && C == 0) break;
			
			char map[][] = new char[R][C];
			
			Pos startP = new Pos(0,0);
			int totalCount = 0;
			for (int i = 0; i < R; i++) {
				String s = br.readLine();
				for (int j = 0; j < C; j++) {
					map[i][j] = s.charAt(j);
					if(map[i][j] == 'o') {
						startP = new Pos(i,j);
					}else if(map[i][j] == '*') {
						totalCount ++;
					}
				}
			}
			int MIN = Integer.MAX_VALUE;
			boolean isGo = false;
			PriorityQueue<Robot> que = new PriorityQueue<>();
			//Queue<Robot> que = new LinkedList<>();
			
			que.offer(new Robot(startP));
			isVisit[startP.r][startP.c][0] = true;
//			System.out.println("start");
			while(!que.isEmpty()) {
				Robot cur = que.poll();
				System.out.println("---");
				System.out.println(cur.move);
				System.out.println(cur.count);
				System.out.println(cur.p.r + " " + cur.p.c);
				System.out.println("size" + cur.cleanList.size());
				for (int i = 0; i < cur.cleanList.size(); i++) {
					System.out.println(cur.cleanList.get(i).r + " " + cur.cleanList.get(i).c);
				}
				if(cur.count == totalCount) {
					System.out.println("mmmm");
					MIN = Math.min(MIN, cur.move);
					System.out.println(cur.move);
					isGo = true;
					continue;
					//break;
				}
				for (int d = 0; d < 4; d++) {
					int dR = cur.p.r + dr[d];
					int dC = cur.p.c + dc[d];
					System.out.println("dR,dC");
					System.out.println(dR + " " + dC);
					if(dR < 0 || dR >= R || dC < 0 || dC >= C) continue;
					if(isVisit[dR][dC][cur.count]) {
						if(map[dR][dC] == '*') {
							boolean isV = false;
//							System.out.println("cloaen");
							for (int i = 0; i < cur.cleanList.size(); i++) {
//								System.out.println(cur.cleanList.get(i).r + " " + cur.cleanList.get(i).c);
								if(cur.cleanList.get(i).r == dR && cur.cleanList.get(i).c == dC ) {
									isV = true;
									break;
								}
							}
//							System.out.println("aa" + isV);
							if(isV) continue;
						}else {
							continue;
						}
					}
					if(map[dR][dC] == 'x') continue;
					if(map[dR][dC] == '*') {
						boolean isV = false;
						for (int i = 0; i < cur.cleanList.size(); i++) {
							if(cur.cleanList.get(i).r == dR && cur.cleanList.get(i).c == dC ) {
								isV = true;
								break;
							}
						}
//						System.out.println(isV);
						if(isV) {
							
							que.offer(new Robot(new Pos(dR,dC), cur.count, cur.move+1 ,cur.cleanList));
							isVisit[dR][dC][cur.count] = true;
						}else {
							ArrayList<Pos> list = (ArrayList<Pos>)cur.cleanList.clone();
//							System.out.println(dR + " " + dC);
//							System.out.println(cur.move);
							list.add(new Pos(dR,dC));
							que.offer(new Robot(new Pos(dR,dC), cur.count+1, cur.move+1 ,list));
							isVisit[dR][dC][cur.count+1] = true;
						}
						
					}else {
						que.offer(new Robot(new Pos(dR,dC), cur.count, cur.move+1 ,cur.cleanList));
						isVisit[dR][dC][cur.count] = true;
					}
				}
				
			}
			if(!isGo) {
				System.out.println(-1);
			}else {
				System.out.println(MIN);
			}
			
			
		}
	}

}
