package day0406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_16938 {

	static int N,L,R,X;
	static int arr[];
	static int count;
	static boolean isCheck[];
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		isCheck = new boolean[N];
		count = 0;
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		recur(0,0);
		System.out.println(count);
		
		
	}
	
	public static void recur(int cnt, int sum) {
		if(sum > R) return ;
		if(cnt == N) {
			int min = Integer.MAX_VALUE;
			int max = 0;
			int s = 0;
			for (int i = 0; i < N; i++) {
				if(isCheck[i]) {
					s += arr[i];
					min = Math.min(arr[i],min);
					max = Math.max(arr[i], max);
				}
			}
			if(max - min >= X && s >= L) count ++;
			return;
		}
		
		
		isCheck[cnt] = true;
		recur(cnt+1, sum+arr[cnt]);
		isCheck[cnt] = false;
		recur(cnt+1, sum);
	}

}
