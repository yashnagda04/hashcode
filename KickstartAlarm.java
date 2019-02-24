import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		int mod = 1000000007;		
		Scanner in = new Scanner(System.in);
		int t = Integer.parseInt(in.nextLine()); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int iii = 1; iii <= t; ++iii) {
			String[] AB = in.nextLine().split(" ");// N, K, x1, y1, C, D, E1, E2, F
			int N = Integer.parseInt(AB[0]);
			int K = Integer.parseInt(AB[1]);
			long x1 = Long.parseLong(AB[2]);
			long y1 = Long.parseLong(AB[3]);
			long C = Long.parseLong(AB[4]);
			long D = Long.parseLong(AB[5]);
			long E1 = Long.parseLong(AB[6]);
			long E2 = Long.parseLong(AB[7]);
			int F = Integer.parseInt(AB[8]);

			long[] x = new long[N];
			long[] y = new long[N];
			long[] A = new long[N];

			x[0] = x1;
			y[0] = y1;
			A[0] = (x[0] + y[0]) % F;

			for (int i = 1; i < N; i++) {
				x[i] = ((C * x[i - 1]) + (D * y[i - 1]) + E1) % F;
				y[i] = ((D * x[i - 1]) + (C * y[i - 1]) + E2) % F;
				A[i] = (x[i] + y[i]) % F;
			}

			int POWER = 0;

			for (int i = 1; i <= K; i++) {
				// Contiguous Sub Arrays
				for (int left = 0; left < N; left++) {
					for (int right = 0; right < N; right++) {
						int tmp = 1;
						for (int gg = left; gg <= right; gg++) {
							long tmp2 = A[gg];
							for (int hh = 0; hh < i; hh++)
								tmp2 = (tmp2 * tmp) % mod;
							POWER = (int) ((POWER + tmp2) % mod);
							tmp++;
						}
					}
				}
			}

			System.out.println("Case #" + iii + ": " + POWER);
		}
		in.close();
	}

}
