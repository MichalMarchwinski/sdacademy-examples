package pl.sdacademy.Mediator;

import java.util.HashMap;
import java.util.Map;

public class RealMediator implements Mediator {
	private Map<String, Friend> friends = new HashMap<String, Friend>();

	public void registerFriend(Friend k) {
		k.registerMediator(this);
		friends.put(k.getId(), k);
	}
	public void send(String adresat, String message) {
		friends.get(adresat).recive(message);
	}
}
