package progettoEsame.entity;



public class Docente {
private String nomeD;
private String cognomeD;
public Docente(String nomeD, String cognomeD) {
	
	this.cognomeD=cognomeD;
	this.nomeD=nomeD;
}

public String getNomeD() {
	return nomeD;
}

public void setNomeD(String nomeD) {
	this.nomeD = nomeD;
}

public String getCognomeD() {
	return cognomeD;
}

public void setCognomeD(String cognomeD) {
	this.cognomeD = cognomeD;
}
public String toString() {
	
	StringBuffer buf = new StringBuffer();
	
	buf.append("DOCENTE "+nomeD+" "+cognomeD);
	return buf.toString();
}

}
