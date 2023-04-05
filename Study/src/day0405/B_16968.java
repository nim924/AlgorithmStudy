package day0405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_16968 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		
		int ans = 1;
		int prev = 0;
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == 'd') {
				if(i-1 >= 0 && s.charAt(i) == s.charAt(i-1)) {
					ans *= 9;
				}else {
					ans *= 10;
					prev = 9;
				}
			}else {
				if(i-1 >= 0 && s.charAt(i) == s.charAt(i-1)) {
					ans *= 25;
					prev --;
				}else {
					ans *= 26;
				}
			}
		}
		
		System.out.println(ans);
	}

}
