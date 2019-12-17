package progettoEsame.entity;

public class Corso {
 private String nomeCorso;
 private Docente docenteCorso;
 private int CFU;
 
 public Corso(String nomeCorso, Docente docenteCorso, int CFU) {
	 this.nomeCorso=nomeCorso;
	 this.docenteCorso=docenteCorso;
	 this.CFU=CFU;
 }
 
public String getNomeCorso() {
	return nomeCorso;
}
public void setNomeCorso(String nomeCorso) {
	this.nomeCorso = nomeCorso;
}
public Docente getDocenteCorso() {
	return docenteCorso;
}
public void setDocenteCorso(Docente docenteCorso) {
	this.docenteCorso = docenteCorso;
}
public int getCFU() {
	return CFU;
}
public void setCFU(int CFU) {
	this.CFU = CFU;
}
public String toString() {
	
	StringBuffer buf = new StringBuffer();
	
	buf.append("CORSO: "+nomeCorso+", "+docenteCorso+", CFU: "+CFU+"\n");
	return buf.toString();
}
}
