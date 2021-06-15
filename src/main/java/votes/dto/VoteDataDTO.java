package votes.dto;


public class VoteDataDTO extends CandidateDTO{
	
	private int voteCount;
	private double voteRate;
	private CandidateDTO stats;
	public int getVoteCount() {
		return voteCount;
	}
	public void setVoteCount(int voteCount) {
		this.voteCount = voteCount;
	}
	public double getVoteRate() {
		return voteRate;
	}
	public void setVoteRate(double voteRate) {
		this.voteRate = voteRate;
	}
	public CandidateDTO getStats() {
		return stats;
	}
	public void setStats(CandidateDTO stats) {
		this.stats = stats;
	}
	public VoteDataDTO(int candiIdx, String candiName) {
		super(candiIdx, candiName);
		// TODO Auto-generated constructor stub
	}
	
	
}
