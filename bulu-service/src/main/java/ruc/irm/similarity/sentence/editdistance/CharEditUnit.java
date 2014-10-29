package ruc.irm.similarity.sentence.editdistance;

public class CharEditUnit extends EditUnit {
	private String content = "";
	
	public CharEditUnit(Character ch){
		content = ch.toString();
	}
	
	
	public String getUnitString() {
		return content;
	}

}
