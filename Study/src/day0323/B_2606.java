package day0323;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_2606 {

	static int N,M;
	static boolean [][] arr;
	static int count;
	static boolean isVisit[];
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		M = Integer.parseInt(br.readLine());
		
		arr = new boolean[N][N];
		
		isVisit = new boolean[N];
		
		StringTokenizer st = null;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[a-1][b-1] = arr[b-1][a-1] = true;
		}
		
//		System.out.println(Arrays.deepToString(arr));
		isVisit[0] = true;
		count = 0;
		DFS(0);
		
		System.out.println(count);
	}
	
	public static void DFS(int num) {
		for (int i = 0; i < N; i++) {
			if(arr[num][i] == true && !isVisit[i]) {
				isVisit[i] = true;
				count++;
				DFS(i);
			}
		}
	}

}
