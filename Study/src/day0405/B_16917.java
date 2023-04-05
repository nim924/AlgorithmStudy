package day0405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_16917 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		
		int MAX = X<Y?Y:X;
		int answer = Integer.MAX_VALUE;
		for (int i = 0; i <= MAX; i++) {
			int value = (i * C * 2) + ((A * (X-i))<0?0:(A * (X-i))) + ((B * (Y-i))<0?0:(B * (Y-i)));
			answer = Math.min(answer, value);
//			System.out.println(value);
		}
		System.out.println(answer);
		
	}

}
