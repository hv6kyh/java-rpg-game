package attribute;

public class Stat {				// ĳ����, ����, �����۵��� ����
	
	private int atk;			// ���ݷ�
	private int def;			// ����
	private int hp;				// ü��
	private int money;
	
	public Stat(int atk, int def, int hp, int money) {
		super();
		this.atk = atk;
		this.def = def;
		this.hp = hp;
		this.money = money;
	}
	
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getAtk() {
		return atk;
	}
	public void setAtk(int atk) {
		this.atk = atk;
	}
	public int getDef() {
		return def;
	}
	public void setDef(int def) {
		this.def = def;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}

}
