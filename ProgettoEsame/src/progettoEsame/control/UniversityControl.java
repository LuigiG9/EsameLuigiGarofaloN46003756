package progettoEsame.control;
import progettoEsame.entity.*;
public class UniversityControl {
 
	

	//CREA CORSO
	public Corso creaCorso(String nomeCorso,Docente docenteCorso, int CFU) {
		Corso nome= new Corso(nomeCorso,docenteCorso,CFU);
	
		
    	Segreteria.listacorsi.add(nome);
	
		return nome;
		}
   // CREA APPELLO
	public Appello creaAppello(int numDate,Corso corso,String idAppello) {
		Appello appello = new Appello(numDate,corso,idAppello);
		aggiungiAppello(appello);
		return appello;
		
	}
	
	//VISUALIZZA CORSI
	public void visualizzaCorsi() {
		if(Segreteria.listacorsi.size()==0) {
			System.out.println("NON CI SONO CORSI DISPONIBILI");
		}
		else {
			System.out.println("I CORSI DISPONIBILI SONO");
		
		for(Corso e : Segreteria.listacorsi) {
			System.out.println(e.getDocenteCorso()+"|"+e.getNomeCorso()+"|"+"CFU:"+e.getCFU()+"\n");
		}
		}
	}
		//VISUALIZZA TUTTI GLI APPELLI DISPONIBILI
		public void visualizzaAppelliDisponibili() {
			if(Segreteria.elencoAppelli.size()==0) {
				System.out.println("NON CI SONO APPELLI DISPONIBILI: \n");
			}
			else {
				System.out.println("GLI APPELLI DISPONIBILI SONO :\n");
				for(Appello a: Segreteria.elencoAppelli) {
					System.out.println(a);
				}
			}
	}
	//CERCA APPELLO
	public boolean cercaAppello(Appello Appello1)
	  {
	     boolean flag = false;
	if (Segreteria.elencoAppelli.size()==0)
	      return flag = false;
	    else {
	       
	     for (Appello a: Segreteria.elencoAppelli){
	
	     if (a.equals(Appello1))
	      return flag = true;
	    }
	  }
	return flag;
	} 
	//EFFETTUA PRENOTAZIONE

	public void effettuaPrenotazione(Appello appello,Studente studente)
	{ if(studente!=null) {
		if (cercaAppello(appello)==true) {
			if(appello.getCorso()!=null) {
			
		 if(appello.getCorso().getDocenteCorso()!=null) {

			if(appello.getElencoDate().size()!=0) {
				
					if(studente.appelliPrenotati.contains(appello))
          return;
			
					else {
						
						studente.appelliPrenotati.add(appello);
						appello.studentiPrenotati.add(studente);
					}
				}
					}
			}
		   else {
			   return;
		       }
			
		}		
		else {
		System.out.println(" ERRORE : IMPOSSIBILE EFFETTUARE LA PRENOTAZIONE");
		}
	}else {
		return;
	}
	}
	//VISUALIZZA APPELLI PRENOTATI
	public void visualizzaAppelliPrenotati(Studente s) {
		if(s.appelliPrenotati.size()==0) {
			System.out.println(s+" NON E' PRENOTATO A NESSUN APPELLO");
		}
		else {
			System.out.println("GLI APPELLI PRENOTATI DALLO STUDENTE \n"+s+"  SONO:");
		
		for(Appello a : s.appelliPrenotati) {
			System.out.println(a);
		}
		}
	}
	//VISUALIZZA STUDENTI PRENOTATI
	public void visualizzaStudentiPrenotati(Appello a) {
		if(a.getElencoDate().size()!=0) {
			if(a.studentiPrenotati.size()!=0) {
			
		System.out.println("GLI STUDENTI PRENOTATI PER L' APPELLO "+a.getIdAppello()+" DEL "+a.getCorso().getDocenteCorso()+" SONO :\n");
		for(Studente s : a.getStudentiPrenotati()) {
			System.out.println(s);
		}
		}else {
			System.out.println("NON CI SONO STUDENTI PRENOTATI PER L'APPELLO\n");
			
		}
		}
		
		else {
			System.out.println("NON CI SONO STUDENTI PRENOTATI PER L'APPELLO\n");
			
		}
	}
//AGGIUNGI APPELLO

	public void aggiungiAppello(Appello appello)
	{

	if (!cercaAppello(appello)) {
		if(appello!=null) {
			Segreteria.elencoAppelli.add(appello);
		}
	
	}
	}
}
