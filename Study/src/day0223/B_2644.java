package day0223;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_2644 {

	public static class fam{
		int dad, me;

		public fam(int dad, int me) {
			super();
			this.dad = dad;
			this.me = me;
		}
		
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		int p1 = Integer.parseInt(st.nextToken())-1;
		int p2 = Integer.parseInt(st.nextToken())-1;
		
		int M = Integer.parseInt(br.readLine());
		int matrix[][] = new int[N][N]; 
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			matrix[a][b] = 1;
			matrix[b][a] = 1;
		}
		
		boolean isViist[] = new boolean[N];
		isViist[p1] = true;
		Queue<fam> que = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			if(matrix[p1][i] == 1) {
				que.add(new fam(p1,i));
				isViist[i] = true;
			}
		}
		
		int count = 0;
		while(!que.isEmpty()) {
			int size = que.size();
//			System.out.println(size);
			count ++;
			for (int i = 0; i < size; i++) {
				fam cur = que.poll();
//				System.out.println(cur.dad + " "+ cur.me);
				if(cur.me == p2) {
					System.out.println(count);
					return;
				}
				for (int j = 0; j < N; j++) {
					if(matrix[cur.me][j]==1) {
						if(!isViist[j]) {
							que.add(new fam(cur.me,j));
							isViist[j] = true;
						}
					}
				}
				
			}
		}
		
		System.out.println(-1);
		
		
		
	}

}
