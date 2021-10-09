//Kevin Ramirez
//5.13.2021
//this class is used by the game window to hold game data on health and move damage
public class PokemonData {
	
	private int snivyHealthLV1 = 100;
	private int eeveeHealthLV2 = 100;
	
	public PokemonData(int snivyHealthLV1, int eeveeHealthLV2) {
		super();
		this.snivyHealthLV1 = snivyHealthLV1;
		this.eeveeHealthLV2 = eeveeHealthLV2;
	}

	public int getSnivyHealthLV1() {
		return snivyHealthLV1;
	}

	public void setSnivyHealthLV1(int snivyHealthLV1) {
		this.snivyHealthLV1 = snivyHealthLV1;
	}

	public int getEeveeHealthLV2() {
		return eeveeHealthLV2;
	}

	public void setEeveeHealthLV2(int eeveeHealthLV2) {
		this.eeveeHealthLV2 = eeveeHealthLV2;
	}
	
	public void takeDown(int pokemon) {
		int life = 0;
		if(pokemon == 1) {
			life = snivyHealthLV1 - 30;
			snivyHealthLV1 = life;
		}
		else {
			life = eeveeHealthLV2 - 30;
			eeveeHealthLV2 = life;
		}
	}
	
	public void swift(int pokemon) {
		int life = 0;
		if(pokemon == 1) {
			life = snivyHealthLV1 - 15;
			snivyHealthLV1 = life;
		}
		else {
			life = eeveeHealthLV2 - 15;
			eeveeHealthLV2 = life;
		}
	}

	public void quickAttack(int pokemon) {
		int life = 0;
		if(pokemon == 1) {
			life = snivyHealthLV1 - 5;
			snivyHealthLV1 = life;
		}
		else {
			life = eeveeHealthLV2 - 5;
			eeveeHealthLV2 = life;
		}
	}
	
	public void tackle(int pokemon) {
		int life = 0;
		if(pokemon == 1) {
			life = snivyHealthLV1 - 20;
			snivyHealthLV1 = life;
		}
		else {
			life = eeveeHealthLV2 - 6;
			eeveeHealthLV2 = life;
		}
	}
	
	public void megaDrain(int pokemon) {
		int life = 0;
		if(pokemon == 1) {
			life = snivyHealthLV1 - 7;
			snivyHealthLV1 = life;
			eeveeHealthLV2 += 2;
		}
		else {
			life = eeveeHealthLV2 - 7;
			eeveeHealthLV2 = life;
			snivyHealthLV1 += 5;
		}
	}
	
	public void vineWhip(int pokemon) {
		int life = 0;
		if(pokemon == 1) {
			life = snivyHealthLV1 - 4;
			snivyHealthLV1 = life;
		}
		else {
			life = eeveeHealthLV2 - 4;
			eeveeHealthLV2 = life;
		}
	}
	
	public void slam(int pokemon) {
		int life = 0;
		if(pokemon == 1) {
			life = snivyHealthLV1 - 6;
			snivyHealthLV1 = life;
		}
		else {
			life = eeveeHealthLV2 - 6;
			eeveeHealthLV2 = life;
		}
	}
}
