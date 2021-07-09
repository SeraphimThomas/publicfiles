package fixtures;

public abstract class Fixture {
	String name;
	String shortDescription;
	String longDescription;

	public Fixture(String name, String shortDesc, String longDesc) {
		super();
		this.name=name;
		this.shortDescription=shortDesc;
		this.longDescription=longDesc;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getShortDesc() {
		return shortDescription;
	}
	public void setShortDesc(String shortDesc) {
		this.shortDescription=shortDesc;
	}
	public String getLongDesc() {
		return longDescription;
	}
	public void setLongDesc(String longDesc) {
		this.longDescription=longDesc;
	}
}