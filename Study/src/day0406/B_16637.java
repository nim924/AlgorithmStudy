package day0406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class B_16637 {

	static List<Integer> numArr;
	static List<Character> opArr;
	static boolean isCheck[];
	static int N;
	static long max;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		numArr = new ArrayList<Integer>();
		opArr = new ArrayList<Character>();
		max = Long.MIN_VALUE;
		isCheck = new boolean[N/2];
		
		String s = br.readLine();
		if(N==1) {
			System.out.println(s);
			return;
		}
		for (int i = 0; i < N; i++) {
			if(i%2==0) {
				numArr.add(s.charAt(i) - '0');
			}else {
				opArr.add(s.charAt(i));
			}
		}
		
		Subset(0);
		System.out.println(max);
		
	}
	
	public static void Subset(int index) {
		if(N/2 == index) {
//			System.out.println(Arrays.toString(isCheck));
			List<Long> nL = new ArrayList<>();
			List<Character> oL = new ArrayList<>();
			for (int i = 0; i < N/2; i++) {
				if(isCheck[i]) {
					switch (opArr.get(i)) {
					case '+': {
						nL.add((long) (numArr.get(i) + numArr.get(i+1)));
						break;
					}
					case '-': {
						nL.add((long) (numArr.get(i) - numArr.get(i+1)));
						break;
						
					}
					case '*': {
						nL.add((long) (numArr.get(i) * numArr.get(i+1)));
						break;
					}
					default:
					}
				}else {
					oL.add(opArr.get(i));
					if(i==0) {
						nL.add((long)numArr.get(i));
					}
					
						if(i==N/2-1 || (i!=N/2-1 && !isCheck[i+1])) {
							nL.add((long)numArr.get(i+1));
						}
					
				}
			
			}
			
			long sum = nL.get(0);
			for (int i = 0; i < oL.size(); i++) {
				switch (oL.get(i)) {
				case '+': {
					sum += nL.get(i+1);
					break;
				}
				case '-': {
					sum -= nL.get(i+1);
					break;
				}
				case '*': {
					sum *= nL.get(i+1);
					break;
				}
				default:
				}
//				System.out.println(sum);
			}
//			System.out.println(Arrays.toString(oL.toArray()));
//			System.out.println(Arrays.toString(nL.toArray()));
//			System.out.println(sum);
			max = Math.max(max, sum);
			return;
		}
		
		if(index == 0 || !isCheck[index-1]) {
			isCheck[index] = true;
			Subset(index+1);
		}
		isCheck[index] = false;
		Subset(index+1);
	}

}
