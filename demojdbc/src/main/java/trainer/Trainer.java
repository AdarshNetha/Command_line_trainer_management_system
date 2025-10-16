package trainer;

public class Trainer {
	private int id;
	private String name;
	private String sub;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSub() {
		return sub;
	}
	public void setSub(String sub) {
		this.sub = sub;
	}
	@Override
	public String toString() {
		return "Trainer [id=" + id + ", name=" + name + ", sub=" + sub + "]";
	}
	public Trainer(int id, String name, String sub) {
		this.id = id;
		this.name = name;
		this.sub = sub;
	}
	public Trainer() {
		super();
	}
	
	
}
