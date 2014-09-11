import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import java.net.*;

public class Client {
	public static void main(String args[]) throws Exception {
		XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
		config.setServerURL(new URL("http://127.0.0.1:2092"));
		XmlRpcClient client = new XmlRpcClient();
		client.setConfig(config);
		Object[] params = new Object[]{new String("Hello"), new String(" World")};
		String result = (String) client.execute("adder.append", params);
		System.out.println("Result = " + result);
	}
}
