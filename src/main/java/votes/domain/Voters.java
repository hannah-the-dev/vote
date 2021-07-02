package votes.domain;

public class Voters {
	private int voteIdx;
	private int candiIdx;
	private int age;
	private int local;
	public int getVoteIdx() {
		return voteIdx;
	}
	public int getCandiIdx() {
		return candiIdx;
	}
	public void setCandiIdx(int candiIdx) {
		this.candiIdx = candiIdx;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getLocal() {
		return local;
	}
	public void setLocal(int local) {
		this.local = local;
	}
	public Voters(int voteIdx, int candiIdx, int age, int local) {
		super();
		this.voteIdx = voteIdx;
		this.candiIdx = candiIdx;
		this.age = age;
		this.local = local;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + candiIdx;
		result = prime * result + local;
		result = prime * result + voteIdx;
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
		Voters other = (Voters) obj;
		if (age != other.age)
			return false;
		if (candiIdx != other.candiIdx)
			return false;
		if (local != other.local)
			return false;
		if (voteIdx != other.voteIdx)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Voters [voteIdx=" + voteIdx + ", candiIdx=" + candiIdx + ", age=" + age + ", local=" + local + "]";
	}
	
}
