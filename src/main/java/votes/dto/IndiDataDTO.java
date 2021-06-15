package votes.dto;

public class IndiDataDTO {

	private int voteCount;
	private double voteRate;
	private int ageGroup;
	public int getVoteCount() {
		return voteCount;
	}
	public void setVoteCount(int i) {
		this.voteCount = i;
	}
	public double getVoteRate() {
		return voteRate;
	}
	public void setVoteRate(double voteRate) {
		this.voteRate = voteRate;
	}
	public int getAgeGroup() {
		return ageGroup;
	}
	public void setAgeGroup(int ageGroup) {
		this.ageGroup = ageGroup;
	}
	public IndiDataDTO(int ageGroup, int voteCount, double voteRate) {
		super();
		this.ageGroup = ageGroup;
		this.voteCount = voteCount;
		this.voteRate = voteRate;
	}
	
}
