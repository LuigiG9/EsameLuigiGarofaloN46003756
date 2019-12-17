package progettoEsame.entity;
import java.util.ArrayList;

public class Appello {
private String idAppello;
private int numDate;
private Corso corso;
private ArrayList<Data> elencodate = new ArrayList<Data>();
private ArrayList<Appello> elencoAppelli=new ArrayList<Appello>(); 
public ArrayList<Studente> studentiPrenotati=new ArrayList<Studente>(); 


 public Appello(int numDate,Corso corso,String idAppello) {
	 this.idAppello=idAppello;
	 elencoAppelli=new ArrayList<Appello>();
	 elencodate=new ArrayList<Data>();
	 this.numDate=numDate;
	 this.corso=corso;
	 
 }
public Corso getCorso() {
	return corso;
}
public void setCorso(Corso corso) {
	this.corso=corso;
}

public int getNumDate() {
	return numDate;
}
public void setNumDate(int numDate) {
	this.numDate = numDate;
}
//ADD
public void addData(Data d) {
	elencodate.add(d);
}

public ArrayList<Appello> getElencoAppelli(){
	return elencoAppelli;
}
public ArrayList<Data> getElencoDate() {
	return elencodate;	
}
public ArrayList <Studente> getStudentiPrenotati(){
	return studentiPrenotati;
}
public String getIdAppello() {
	return idAppello;
}
public void setIdAppello(String idAppello) {
	this.idAppello = idAppello;
} 

public String toString() {
	
	StringBuffer buf = new StringBuffer();
	if(elencodate.size()==0) {
		
		buf.append("ERRORE : L'APPELLO NON ESISTE");
	}
	else {
		
	
	buf.append("APPELLO DEL "+corso+" COD:"+idAppello+" NUMERO DATE "+numDate+ "\n");
	
	for(Data d : elencodate) {
	
		buf.append("  DATA: "+d.getDataProva()+"\n  TIPO PROVA: "+d.getTipo()+"\n AULA:"+d.getTipoa()+"\n");
	}
	}
	return buf.toString();
	

}
@Override
public boolean equals(Object obj) {
	Appello a= (Appello)obj; // casting sto forzando a e poiche e figlia di obj posso farlo 
	if(this.idAppello==(a.getIdAppello())) {
		return true;
	}
 return false;
}


}
