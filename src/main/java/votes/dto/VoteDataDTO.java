package votes.dto;

import votes.domain.Candidate;

public class VoteDataDTO extends Candidate{
	
	private int voteCount;
	private double voteRate;
	private Candidate candidate;
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
	
	public Candidate getCandidate() {
		return candidate;
	}
	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}
	public VoteDataDTO(int candiIdx, String candiName) {
		super(candiIdx, candiName);
		// TODO Auto-generated constructor stub
	}
	
	
}
