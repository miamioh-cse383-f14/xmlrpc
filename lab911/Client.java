/*
   Scott Campbell

   lab 911 client

   write url's to amazondb
 */

import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import java.net.*;
import java.io.*;

public class Client {
	XmlRpcClient xmlRPCclient = null;
	String token = null;
	int port = -1;


	public static void main(String args[]) {
		int port = -1;
		try {
			port = Integer.parseInt(args[1]);
		} catch (Exception err) {
			System.out.println("specify port");
			return;
		}

		try {
			Client client = new Client(args[0],port);
			String t= client.getToken("campbest");
		}
		catch (Exception err) {
			System.err.println("error geting token " + err);
			return;
		}
	}

	/*
	   constructor
	 */
	public Client(String host,int p) throws IOException {
		port = p;
		XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
		config.setServerURL(new URL("http://" + host+":"+port));
		xmlRPCclient = new XmlRpcClient();
		xmlRPCclient.setConfig(config);
	}

	public String getToken(String uid) throws IOException,org.apache.xmlrpc.XmlRpcException {
		byte code[] = new byte[]{0x10,0x3};
		Object[] params = new Object[]{new String("campbest"),code};
		String authToken= (String) xmlRPCclient.execute("lab.getAuthToken", params);
		System.out.println("token = " + authToken);
		token = authToken;
		return authToken;
	}


}
