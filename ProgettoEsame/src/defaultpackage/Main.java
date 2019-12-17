package defaultpackage;

import java.time.LocalDate;

import progettoEsame.control.UniversityControl;
import progettoEsame.entity.Appello;
import progettoEsame.entity.Corso;
import progettoEsame.entity.Data;
import progettoEsame.entity.Studente;
import progettoEsame.entity.TipoAula;
import progettoEsame.entity.TipoProva;
import progettoEsame.entity.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

UniversityControl CC= new UniversityControl();
Docente doc1= new Docente("ROBERTO","NATELLA");
Corso corso1=CC.creaCorso("INFORMATICA",doc1,9);
Data data1= new Data(LocalDate.of(2019,6,14),TipoProva.PROVA_AL_CALCOLATORE, TipoAula.LABORATORIO);
Data data2= new Data(LocalDate.of(2019,6,15),TipoProva.PROVA_SCRITTA,TipoAula.AULA);
Data data3= new Data(LocalDate.of(2019,6,16),TipoProva.PROVA_ORALE,TipoAula.AULA);
Appello appello =CC.creaAppello(3,corso1,"CX2");
appello.addData(data1);
appello.addData(data2);
appello.addData(data3);

Studente s= new Studente("Luigi","Garofalo","N46003756",21785);
Studente g= new Studente("Michele","Borrelli","N44503456",32455);
CC.effettuaPrenotazione(appello,s);
CC.effettuaPrenotazione(appello,g);
CC.visualizzaStudentiPrenotati(appello);
CC.visualizzaCorsi();
CC.visualizzaAppelliDisponibili();

}

}
