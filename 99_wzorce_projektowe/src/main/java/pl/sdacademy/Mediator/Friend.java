package pl.sdacademy.Mediator;

public class Friend {
	private Mediator mediator;
	private String id;

	public Friend(String id) {this.id = id;}
	public void registerMediator(Mediator mediator) {this.mediator = mediator;}
	public String getId() {return id;}

	public void send(String adresat, String message) {
		System.out.println("Przsyłanie wiadomośći od "+this.id+ " do " +adresat+": "+message);
		mediator.send(adresat, message);
	}

	public void recive(String message) {
		System.out.println("Wiadomość odebrana przez "+id+": "+message);
	}
}
