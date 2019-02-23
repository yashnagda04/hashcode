import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) {
		boolean somethingWentWrong = false;
		Scanner in = new Scanner(System.in);
		int t = Integer.parseInt(in.nextLine()); // Scanner has functions to read ints, longs, strings, chars, etc.
		for (int i = 1; i <= t; ++i) {
			String[] AB = in.nextLine().split(" ");
			int A = Integer.parseInt(AB[0]);
			int B = Integer.parseInt(AB[1]);
			int N = Integer.parseInt(in.nextLine());

			while (true) {
				System.out.println((int) Math.ceil((A + B) / 2.0));
				String res = in.nextLine();
				if (res.equals("TOO_SMALL")) {
					A = (int) Math.ceil((A + B) / 2.0);
					continue;
				} else if (res.equals("TOO_BIG")) {
					B = (int) Math.ceil((A + B) / 2.0);
					continue;
				} else if (res.equals("CORRECT")) {
					break;
				} else if (res.equals("WRONG_ANSWER")) {
					somethingWentWrong = true;
					in.close();
					return;
				} else {
					somethingWentWrong = true;
					in.close();
					return;
				}
			}
			if (somethingWentWrong) {
				in.close();
				return;
			}

			// System.out.println("Case #" + i + ": " + (n + m) + " " + (n * m));
		}
		in.close();
		return;
	}
}
