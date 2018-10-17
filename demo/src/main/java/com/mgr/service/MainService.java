/**
 * 
 */
package com.mgr.service;

import com.mgr.service.accounts.AccountServer;
import com.mgr.service.registration.RegistrationServer;
import com.mgr.service.web.WebServer;

/**
 * @author govind.raju
 *
 */
public class MainService {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String server_name = "NO_VALUES";

		System.out.println(
				" registration || reg || accounts || web || should be server instance to start and arg Length is "
						+ args.length + args[0]);

		switch (args.length) {
		case 1:
			server_name = args[0].toLowerCase();
			break;
		case 2:
			System.setProperty("server.port", args[1]);

		default:
			howToUse();
			return;
		}
		
		if(server_name.equalsIgnoreCase("registration")||server_name.equalsIgnoreCase("reg")) {
			RegistrationServer.main(args);
		} else if(server_name.equalsIgnoreCase("accounts")) {
			AccountServer.main(args);
		} else if(server_name.equalsIgnoreCase("web")) {
			WebServer.main(args);
		} else {
			System.out.println("I dont know Server type you entered "+server_name );
			howToUse();
		}

	}

	protected static void howToUse() {
		System.out.println("Usage: java -jar ... <server-name> [server-port]");
		System.out.println(
				"     where server-name is 'reg', 'registration', " + "'accounts' or 'web' and server-port > 1024");
	}

}
