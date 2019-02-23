import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		boolean somethingWentWrong = false;
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = Integer.parseInt(in.nextLine()); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			String[] AB=in.nextLine().split(" ");
			int A = Integer.parseInt(AB[0]);
			int B = Integer.parseInt(AB[1]);
			int N = Integer.parseInt(in.nextLine());

			while (true) {
				System.out.println((A + B) / 2);
				String res = in.nextLine();
				if (res.equals("TOO_SMALL")) {
					A = (A + B) / 2;
					continue;
				} else if (res.equals("TOO_BIG")) {
					B = (A + B) / 2;
					continue;
				} else if (res.equals("CORRECT"))
					break;
				else if (res.equals("WRONG_ANSWER")) {
					somethingWentWrong = true;
					break;
				}
				else{
					somethingWentWrong = true;
					break;
				}
			}
			if (somethingWentWrong)
				break;

			// System.out.println("Case #" + i + ": " + (n + m) + " " + (n * m));
		}
		in.close();
	}
}
