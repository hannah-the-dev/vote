package votes.dto;

public class CandidateDTO {
	private int candiIdx;
	private String candiName;
	
	public int getCandiIdx() {
		return candiIdx;
	}
	public void setCandiIdx(int candiIdx) {
		this.candiIdx = candiIdx;
	}
	public String getCandiName() {
		return candiName;
	}
	public void setCandiName(String candiName) {
		this.candiName = candiName;
	}
	public CandidateDTO(int candiIdx, String candiName) {
		super();
		this.candiIdx = candiIdx;
		this.candiName = candiName;
	}
	
}
