package day0407;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B_16638 {

	static int N;
	static int nA[];
	static char oA[];
	static boolean isCheck[];
	static long answer;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		nA = new int[N/2+1];
		oA = new char[N/2];
		isCheck = new boolean[N/2];
		
		String s=br.readLine();
		answer = Long.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			if(i%2==0) {
				nA[i/2] = s.charAt(i)-'0';
			}else {
				oA[i/2] = s.charAt(i);
			}
		}
		perm(0);
		System.out.println(answer);
		
		
	}
	
	public static void perm(int index) {
		if(index == N/2) {
			Calc();
			return ;
		}
		
		if(index == 0 || (index != 0 && !isCheck[index-1])) {
			isCheck[index] = true;
			perm(index+1);
		}
		isCheck[index] = false;
		perm(index+1);
	}
	
	public static void Calc() {
//		System.out.println(Arrays.toString(isCheck));
		String value = "";
		
		for (int i = 0; i < N/2; i++) {
			if(isCheck[i]) {
				switch (oA[i]) {
				case '+': {
					value += (nA[i] + nA[i+1]);
					break;
				}
				case '-': {
					value += (nA[i] - nA[i+1]);
					break;
				}
				case '*': {
					value += (nA[i] * nA[i+1]);
					break;
				}
				default:
				}
			}else {
				if(i == 0) {
					value += nA[i]; 
				}
				value += oA[i];
				
				if(i == N/2-1 || (i != N/2-1 && !isCheck[i+1])) {
					value += nA[i+1];
				}
			}
		}
		
//		System.out.println(value);
		String num = "";
		List<Long> nList = new ArrayList<>();
		List<Character> oList = new ArrayList<>();
		int cnt = 0;
		
		for (int i = 0; i < value.length(); i++) {
			if(value.charAt(i) == '+') {
				nList.add(Long.parseLong(num));
				oList.add(value.charAt(i));
				num = "";
			}else if(value.charAt(i) == '*') {
				nList.add(Long.parseLong(num));
				oList.add(value.charAt(i));
				num = "";
			}else if(value.charAt(i) == '-') {
				if( i== 0|| value.charAt(i-1) == '+' || value.charAt(i-1) == '*' || value.charAt(i-1) == '-') {
					num += value.charAt(i);
				}else {
					nList.add(Long.parseLong(num));
					oList.add(value.charAt(i));
					num = "";
				}
			}else {
				num += value.charAt(i);
			}
		}
		
		nList.add(Long.parseLong(num));
		
//		System.out.println(Arrays.toString(nList.toArray()));
//		System.out.println(Arrays.toString(oList.toArray()));
		
		List<Long> nuList = new ArrayList<>();
		List<Character> opList = new ArrayList<>();
		
		for (int i = 0; i < nList.size() + oList.size(); i++) {
			if(i%2==0) {
				nuList.add(nList.get(i/2));
			}else {
				if(oList.get(i/2) == '+'|| oList.get(i/2) == '-') {
					opList.add(oList.get(i/2));
				}else {
					long temp = nuList.get(nuList.size()-1);
					nuList.remove(nuList.size()-1);
					nuList.add(temp * nList.get(i/2 + 1));
					i++;
				}
			}
		}
		
//		System.out.println(Arrays.toString(nuList.toArray()));
//		System.out.println(Arrays.toString(opList.toArray()));
		long key = 0;
		if(opList.size() == 0) {
			key = nuList.get(0);
		}else {
			switch (opList.get(0)) {
			case '+': {
				key = nuList.get(0) + nuList.get(1);
				break;
			}
			case '-': {
				key = nuList.get(0) - nuList.get(1);
				break;
			}
			default:
			}
		}
		for (int i = 1; i < opList.size(); i++) {
			switch (opList.get(i)) {
			case '+': {
				key += nuList.get(i+1);
				break;
			}
			case '-': {
				key -= nuList.get(i+1);
				break;
			}
			default:
			}
		}
		
		answer = Math.max(answer, key);
//		System.out.println(key);
		
		
	}
	
	

}
