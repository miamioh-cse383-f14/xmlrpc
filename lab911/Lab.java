/*
*/
public class Lab {
	public String getAuthToken(String uid, byte code[]) {
		System.out.println("uid: " + uid);
		String token = uid + " 10011";
		return token;
	}

	private boolean authToken(String token) {
			return true;
	}

	public void storeURL(String token, String URL) {
		System.err.println("Store URL: " + URL);
	}
}

