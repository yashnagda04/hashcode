import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = Integer.parseInt(in.nextLine()); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			int N = Integer.parseInt(in.nextLine());
			char[] wallArray = in.nextLine().toCharArray();
			
			int[] wall=new int[N];			
			for(int j=0;j<N;j++){
				wall[j]=Integer.parseInt(wallArray[j]+"");
			}
			
			int ansLen=(N+1)/2;
			int ans=0;
			
			int j=0;
			for(;j<ansLen;j++){
				ans+=wall[j];
			}

			int tmp=ans;
			for(;j<N;j++) {
				tmp+=wall[j];
				tmp-=wall[j-ansLen];
				if(tmp>ans)
					ans=tmp;
			}
			
			System.out.println("Case #" + i + ": " + ans);
		}
		in.close();
	}

}
