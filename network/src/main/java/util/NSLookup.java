package util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NSLookup {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			while (true) {
				System.out.print(">");
				String line = sc.nextLine();
				if (line.equals("exit")) {
					sc.close();
					break;
				}
				InetAddress[] inetAddresses = InetAddress.getAllByName(line);
				for (InetAddress inetAddress : inetAddresses) {
					System.out.println(line + " : " + inetAddress.getHostAddress());
				}
			}

		} catch (UnknownHostException e) {
			System.out.println("error: " + e);
		}
	}

}
