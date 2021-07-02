package votes.domain;

public class AgeInfo {
	private int age;
	private String ageDesc;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAgeDesc() {
		return ageDesc;
	}
	public void setAgeDesc(String ageDesc) {
		this.ageDesc = ageDesc;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((ageDesc == null) ? 0 : ageDesc.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AgeInfo other = (AgeInfo) obj;
		if (age != other.age)
			return false;
		if (ageDesc == null) {
			if (other.ageDesc != null)
				return false;
		} else if (!ageDesc.equals(other.ageDesc))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "AgeInfo [age=" + age + ", ageDesc=" + ageDesc + "]";
	}
	public AgeInfo(int age, String ageDesc) {
		super();
		this.age = age;
		this.ageDesc = ageDesc;
		
	}
}
