import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import java.net.*;

public class Client {
	public static void main(String args[]) throws Exception {
		XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
		config.setServerURL(new URL("http://127.0.0.1:2092"));
		XmlRpcClient client = new XmlRpcClient();
		client.setConfig(config);
		byte code[] = new byte[]{0x10,0x3};
		Object[] params = new Object[]{new String("campbest"),code};
		String authToken= (String) client.execute("lab.getAuthToken", params);
		System.out.println("token = " + authToken);
	}
}
