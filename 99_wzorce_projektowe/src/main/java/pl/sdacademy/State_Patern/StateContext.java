package pl.sdacademy.State_Patern;

public class StateContext {
	private StateLike myState;
	StateContext() {
		setState(new StateLowerCase());
	}

	void setState(final StateLike newState) {
		myState = newState;
	}

	public void writeName(final String name) {
		myState.writeName(this, name);
	}
}
