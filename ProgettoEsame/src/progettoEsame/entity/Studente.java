package progettoEsame.entity;

import java.util.ArrayList;

public class Studente {
private String nomeS;
private String cognomeS;
private String matricola;
private int PIN;
public ArrayList<Appello> appelliPrenotati= new ArrayList<Appello>();


//CONSTRUCTOR
public Studente(String nomeS,String cognomeS,String matricola,int PIN) {
	appelliPrenotati= new ArrayList<Appello>();
	this.nomeS=nomeS;
	this.cognomeS=cognomeS;
	this.PIN=PIN;
	this.matricola=matricola;
	
	
}

public String getNomeS() {
	return nomeS;
}
public void setNomeS(String nomeS) {
	this.nomeS = nomeS;
}
public String getCognomeS() {
	return cognomeS;
}
public void setCognomeS(String cognomeS) {
	this.cognomeS = cognomeS;
}
public String getMatricola() {
	return matricola;
}
public void setMatricola(String matricola) {
	this.matricola = matricola;
}
public int getPIN() {
	return PIN;
}
public void setPIN(int pIN) {
	PIN = pIN;
}
public ArrayList<Appello> getAppelliPrenotati(){
	return appelliPrenotati;
}
public String toString() {
	
	StringBuffer buf = new StringBuffer();
	
	buf.append(nomeS+" "+cognomeS+", MATRICOLA: "+matricola+"\n");
	return buf.toString();
}
}

