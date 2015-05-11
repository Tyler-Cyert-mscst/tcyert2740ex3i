package tcyert2740ex3i;

import javax.swing.DefaultListModel;

public class DriverExam {
	private char [] answers;
	private char [] responses;
//responses = {'B','D','A','Z','C','A','B','A','C','D'};
	private final double requiredPct = .7;	 
	
	public DriverExam(char[] answers) {
		this.answers = new char[answers.length];
		
		for(int index = 0; index < answers.length; index++){
			this.answers[index] = answers[index];		
		}
	}
	
	public DriverExam(DefaultListModel answers) {
		this.answers = new char[answers.getSize()];
		
		for (int i = 0; i < answers.getSize(); i++) {
			String r = (String) answers.get(i);
			this.answers[i] = r.charAt(0);
		}
	}
	
	public void setResponses(DefaultListModel responses) {
		this.responses = new char[responses.getSize()];
		
		for (int i = 0; i < responses.getSize(); i++) {
			String r = responses.get(i).toString();
			this.responses[i] = r.charAt(0);
		}
	}
	
	public DefaultListModel getAnswers() {
		DefaultListModel answersListModel = new DefaultListModel();
		
		for (int i = 0; i < this.answers.length; i++) {
			answersListModel.addElement(this.answers[i]);
		}
		
		return answersListModel;
	}
	public int validate() {
		int index = 0;
		while(index < this.responses.length) {
			if (this.responses[index] > 'D' || this.responses[index] < 'A') {
				return index + 1;
			}
			index++;
		}
		return -1;
		
	}
	public boolean passed() {
		if (this.totalCorrect() >= requiredPct * this.answers.length) {
			return true;
		}
		else return false;
	}
	public int totalCorrect() {
		int correct = 0;
		for(int index = 0; index < this.answers.length; index++) {
			if (this.answers[index] == this.responses[index]) {
				correct++;
			}
		}
		return correct;
	}
	public int totalIncorrect() {
		int incorrect = 0;
		for(int index = 0; index < this.answers.length; index++) {
			if (this.answers[index] != this.responses[index]) {
				incorrect++;
			}
		}
		return incorrect;
	}
	public int[] questionsMissed() {
		int[] missed = {0,0,0,0,0,0,0,0,0,0};
		int m = 0;
		for (int index = 0; index < this.answers.length; index++) {
			if (this.answers[index] != this.responses[index]) {
				missed[m] = index + 1;
				m++;
			}
		}
		return missed;
	}
	
	
}
