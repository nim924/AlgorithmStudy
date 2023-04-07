package day0406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_16943 {

	static int A,B;
	static int [] arr;
	static int number[];
	static boolean isCheck[];
	static int size;
	static int max;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		
		String s = Integer.toString(A);
		size = s.length();
		arr = new int[size];
		max = -1;
		isCheck = new boolean[size];
		number = new int[size];
		
		for (int i = 0; i < size; i++) {
			arr[i] = s.charAt(i) - '0';
		}
		
		B = Integer.parseInt(st.nextToken());
		perm(0);
		System.out.println(max);
		
		
	}
	
	public static void perm(int cnt) {
		if(cnt == size) {
//			System.out.println(Arrays.toString(number));
			int value = 0;
			for (int i = 0; i < size; i++) {
				value += ((number[i] * Math.pow(10, size-i-1)));
			}
//			System.out.println(value);
			if(value <B) {
				max = Math.max(max, value);
			}
			return ;
		}
		
		
		for (int i = 0; i < size; i++) {
			if(isCheck[i]) continue;
			if(cnt == 0) {
				if(arr[i] == 0) continue;
			}
			number[cnt] = arr[i];
			isCheck[i] = true;
			perm(cnt+1);
			isCheck[i] = false;
		}
		
	}

}
