import org.apache.xmlrpc.*;
import org.apache.xmlrpc.webserver.*;
import org.apache.xmlrpc.server.*;

public class Server {
	static int port = 2092;

	public Integer sum(int x, int y) {
		return new Integer(x+y);
	}

	public static void main (String [] args) {
		try {

			PropertyHandlerMapping mapping = new PropertyHandlerMapping();
			ClassLoader cl = Thread.currentThread().getContextClassLoader();
			mapping.load(cl,"server.properties");

			System.out.println("Attempting to start XML-RPC Server...");
			WebServer webServer = new WebServer(port);

			XmlRpcServerConfigImpl config = new XmlRpcServerConfigImpl();
			XmlRpcServer server = webServer.getXmlRpcServer();
			server.setConfig(config);
			server.setHandlerMapping(mapping);

			webServer.start();
			System.out.println("Started successfully.");
			System.out.println("Accepting requests. (Halt program to stop.)");

		} catch (Exception exception) {
			System.err.println("Server: " + exception);
			exception.printStackTrace();
		}
	}
}

