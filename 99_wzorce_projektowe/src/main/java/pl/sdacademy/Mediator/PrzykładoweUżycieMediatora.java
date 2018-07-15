package pl.sdacademy.Mediator;

public class PrzykładoweUżycieMediatora {
	public static void main(String[] args) {
		Friend rene = new Friend("Rene");
		Friend toni = new Friend("Toni");
		Friend kim = new Friend("Kim");

		RealMediator m = new RealMediator();
		m.registerFriend(rene);
		m.registerFriend(toni);
		m.registerFriend(kim);

		kim.send("Toni", "Hello world.");
		rene.send("Kim", "Witaj!");
	}
}
