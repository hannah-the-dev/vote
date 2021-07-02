package votes.domain;

public class Candidate {
	private int candiIdx;
	private String candiName;
	private boolean valid;
	private String title;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
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
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	
	@Override
	public String toString() {
		return "Candidates [candiIdx=" + candiIdx + ", candiName=" + candiName + ", valid=" + valid + ", title=" + title
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + candiIdx;
		result = prime * result + ((candiName == null) ? 0 : candiName.hashCode());
		result = prime * result + (valid ? 1231 : 1237);
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
		Candidate other = (Candidate) obj;
		if (candiIdx != other.candiIdx)
			return false;
		if (candiName == null) {
			if (other.candiName != null)
				return false;
		} else if (!candiName.equals(other.candiName))
			return false;
		if (valid != other.valid)
			return false;
		return true;
	}
	
	// when creates, always valid
	public Candidate(int candiIdx, String candiName, Boolean valid) {
		super();
		this.candiIdx = candiIdx;
		this.candiName = candiName;
		this.valid = valid;
		this.title = "후보 등록";
	}
	public Candidate(int candiIdx, String candiName) {
		this(candiIdx, candiName, true);
		this.title = "후보 조회";
	}
		
}
