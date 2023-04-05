package day0404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B_9019 {

	public static class Que{
		String number;
		String record;
		public Que(String number, String record) {
			super();
			this.number = number;
			this.record = record;
		}
		@Override
		public String toString() {
			return "Que [number=" + number + ", record=" + record + "]";
		}
		
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			String start = st.nextToken();
			String end = st.nextToken();
			
			int size = start.length();
			for (int i = 0; i < 4-size; i++) {
				start = "0" + start;
			}
			
			boolean isVisit[] = new boolean[10000];
			Queue<Que> que = new LinkedList<>();
			que.add(new Que(start,""));
			isVisit[(Integer.parseInt(start))] = true;
			
			while(!que.isEmpty()) {
				Que cur = que.poll();
				//System.out.println("cur" + cur.number);
				if(Integer.parseInt(end) == Integer.parseInt(cur.number)) {
					System.out.println(cur.record);
					break;
				}
				
				int temp = Integer.parseInt(cur.number);
				temp *=  2;
				
				if(temp > 9999) temp %= 10000;
				String ts = Integer.toString(temp);
				size = ts.length();
				if(size < 4) {
					for (int i = 0; i < 4 - size; i++) {
						ts = "0" + ts;
					}
				}
				//System.out.println(ts);
				if(!isVisit[temp]) {
					que.add(new Que(ts, cur.record + "D"));
					isVisit[temp] = true;
				}
				/////////////////
				temp = Integer.parseInt(cur.number);
				temp -=  1;
				
				if(temp == -1) temp = 9999;
				ts = Integer.toString(temp);
				size = ts.length();
				if(size < 4) {
					for (int i = 0; i < 4 - size; i++) {
						ts = "0" + ts;
					}
				}
				//System.out.println(ts);
				if(!isVisit[temp]) {
					que.add(new Que(ts, cur.record + "S"));
					isVisit[temp] = true;
				}
				///////////////////////
				
				StringBuilder sb = new StringBuilder();
				sb.append(cur.number.charAt(1));
				sb.append(cur.number.charAt(2));
				sb.append(cur.number.charAt(3));
				sb.append(cur.number.charAt(0));
				
				String s = sb.toString();
				//System.out.println(s);
				
				if(!isVisit[Integer.parseInt(s)]) {
					que.add(new Que(s, cur.record + "L"));
					isVisit[Integer.parseInt(s)] = true;
				}
				//////////////////
				sb = new StringBuilder();
				sb.append(cur.number.charAt(3));
				sb.append(cur.number.charAt(0));
				sb.append(cur.number.charAt(1));
				sb.append(cur.number.charAt(2));
				
				s = sb.toString();
				//System.out.println(s);
				if(!isVisit[Integer.parseInt(s)]) {
					que.add(new Que(s, cur.record + "R"));
					isVisit[Integer.parseInt(s)] = true;
				}
				
			}
		}
		
	}

}
