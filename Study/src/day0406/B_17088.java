package day0406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_17088 {

	static int N;
	static int min;
	static int arr[];
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		min = Integer.MAX_VALUE;
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Subset(0,0,0,0);
		if(min == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			
			System.out.println(min);
		}
	}
	
	public static void Subset(int idx, int value, int count, int diff) {
		if(idx == N) {
			min = Math.min(count, min);
			return ;
			
		}
		
		
		
		if(idx == 0) {
			Subset(idx+1, arr[idx], count, 0);
		}else if(idx == 1){
			Subset(idx+1, arr[idx], count, arr[idx] - value);
		}else {
			if(arr[idx]-value == diff) {
				Subset(idx+1, arr[idx], count, arr[idx] - value);
			}
		}
		
		if(idx == 0) {
			Subset(idx+1, arr[idx]+1, count+1, 0);
		}else if(idx == 1){
			Subset(idx+1, arr[idx]+1, count+1, arr[idx]+1 - value);
		}else {
			if(arr[idx]+1-value == diff) {
				Subset(idx+1, arr[idx]+1, count+1, arr[idx]+1 - value);
			}
		}
		if(idx == 0) {
			Subset(idx+1, arr[idx]-1, count+1, 0);
		}else if(idx == 1){
			Subset(idx+1, arr[idx]-1, count+1, arr[idx]-1 - value);
		}else {
			if(arr[idx]-1-value == diff) {
				Subset(idx+1, arr[idx]-1, count+1, arr[idx]-1 - value);
			}
		}
		
	}

}
