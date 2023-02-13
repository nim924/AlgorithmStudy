package day0213;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class B_1138 {

	static int N;
	static int[] numbers;
	static int[] arr;
	static boolean[] isSelected;
	static boolean isFinish;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		isSelected = new boolean[N];
		numbers = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		isFinish = false;
		perm(0);
		for (int i = 0; i < N; i++) {
			System.out.print(numbers[i]+1 + " ");
		}
	}
	
	public static void perm(int count) {
		if(isFinish) return ;
		if(count == N) {
			if(Check()) isFinish = true;
			return ;
		}
		
		for (int i = 0; i < N; i++) {
			if(isSelected[i]) continue;
			isSelected[i] = true;
			numbers[count] = i;
			perm(count+1);
			if(isFinish) return ;
			isSelected[i] = false;
			
		}
	}
	
	public static boolean Check() {
		for (int i = 0; i < N; i++) {
			int count = 0;
			for(int j=0;j<i;j++) {
				if(numbers[j] > numbers[i]) {
					count ++;
				}
			}
			if(count != arr[numbers[i]]) return false;
		}
		return true;
	}

}
