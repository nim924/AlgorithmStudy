package day0223;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class B_20923 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Deque<Integer> doC = new ArrayDeque<>();
		Deque<Integer> suC = new ArrayDeque<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			doC.add(Integer.parseInt(st.nextToken()));
			suC.add(Integer.parseInt(st.nextToken()));
		}
		Deque<Integer> doG = new ArrayDeque<>();
		Deque<Integer> suG = new ArrayDeque<>();
		
		int turn = 0;
		while(true) {
			doG.add(doC.pollLast());
			if(doC.size() == 0) {
				System.out.println("su");
				return ;
			}
			if(!doG.isEmpty() && !suG.isEmpty() && doG.getLast() + suG.getLast() == 5) {
				
				while(!doG.isEmpty()) {
					suC.addFirst(doG.poll());
				}
				while(!suG.isEmpty()) {
					suC.addFirst(suG.poll());
				}
			}
			else if(!doG.isEmpty() && doG.getLast() == 5) {
				while(!suG.isEmpty()) {
					doC.addFirst(suG.poll());
				}
				while(!doG.isEmpty()) {
					doC.addFirst(doG.poll());
				}
			}
			turn ++;
			if(M==turn) break;
			
			suG.add(suC.pollLast());
			if(suC.size() == 0) {
				System.out.println("do");
				return ;
			}
			if(!doG.isEmpty() && !suG.isEmpty() && doG.getLast() + suG.getLast() == 5) {
				
				while(!doG.isEmpty()) {
					suC.addFirst(doG.poll());
				}
				while(!suG.isEmpty()) {
					suC.addFirst(suG.poll());
				}
			}
			else if(!suG.isEmpty() && suG.getLast() == 5) {
				while(!suG.isEmpty()) {
					doC.addFirst(suG.poll());
				}
				while(!doG.isEmpty()) {
					doC.addFirst(doG.poll());
				}
			}
			turn ++;
			if(M==turn) break;
		}

		if (suC.size() == doC.size()) {
			System.out.println("dosu");
		} else if (suC.size() > doC.size()) {
			System.out.println("su");
		} else {
			System.out.println("do");
		}
	}
}
