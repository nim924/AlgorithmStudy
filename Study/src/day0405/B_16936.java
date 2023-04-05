package day0405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_16936 {

	static long arr[];
	static int N;
	static long answer[];
	static boolean isCheck[];
	static boolean isFinsh;
	public static void main(String[] args) throws IOException {

		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		arr = new long[N];
		answer = new long[N];
		isCheck = new boolean[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		isFinsh = false;
		perm(0);
//		System.out.println(isFinsh);
		for (int i = 0; i < N; i++) {
			System.out.print(answer[i] + " ");
		}
		
	}
	
	public static void perm(int count) {
		if(isFinsh) return;
		if(count == N) {
			isFinsh = true;
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(isCheck[i]) continue;
			if(count == 0) {
				answer[count] = arr[i];
				isCheck[i] = true;
			}else {
				if((answer[count-1]%3 == 0 && answer[count-1]/3==arr[i] )|| answer[count-1]*2==arr[i]) {
					answer[count] = arr[i];
					isCheck[i] = true;
				}else {
					continue;
				}
			}
			
			perm(count+1);
			isCheck[i] = false;
		}
	}

}
