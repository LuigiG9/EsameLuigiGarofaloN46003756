package testProggetto;



import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.Before;

import progettoEsame.control.UniversityControl;
import progettoEsame.entity.Appello;
import progettoEsame.entity.Corso;
import progettoEsame.entity.Data;
import progettoEsame.entity.Docente;
import progettoEsame.entity.Studente;
import progettoEsame.entity.TipoAula;
import progettoEsame.entity.TipoProva;

public class TestProggetto {
	UniversityControl CC= new UniversityControl();
	public ArrayList<Studente> studentiPrenotati=new ArrayList<Studente>(); 
	@Before
	public void setUp() {
		
	}
	@Test
	public void test01UnoStudenteUnCorsoUnAppelloUnaDataUnaPrenotazione() {
		Docente doc1= new Docente("ROBERTO","NATELLA");
		Corso corso1=CC.creaCorso("INFORMATICA",doc1,9);
		Data data1= new Data(LocalDate.of(2019,6,14),TipoProva.PROVA_AL_CALCOLATORE, TipoAula.LABORATORIO);
		Appello appello =CC.creaAppello(1,corso1,"CX2");
		appello.addData(data1);
		CC.aggiungiAppello(appello);
		Studente s= new Studente("Luigi","Garofalo","N46003756",21785);
		CC.effettuaPrenotazione(appello,s);
		CC.visualizzaStudentiPrenotati(appello);
		assertEquals(1,appello.studentiPrenotati.size());
		System.out.println(" SOPRA E' TEST 1");
	}
	@Test
	public void test02UnoStudenteUnCorsoUnAppelloUnaDataPiùPrenotazioni() {
		Docente doc1= new Docente("ROBERTO","NATELLA");
		Corso corso1=CC.creaCorso("INFORMATICA",doc1,9);
		Data data1= new Data(LocalDate.of(2019,6,14),TipoProva.PROVA_AL_CALCOLATORE, TipoAula.LABORATORIO);
		Appello appello =CC.creaAppello(1,corso1,"CX2");
		appello.addData(data1);
		CC.aggiungiAppello(appello);
		Studente s= new Studente("Luigi","Garofalo","N46003756",21785);
		CC.effettuaPrenotazione(appello,s);
		CC.effettuaPrenotazione(appello,s);
		CC.visualizzaStudentiPrenotati(appello);
		assertEquals(1,appello.studentiPrenotati.size());
		System.out.println(" SOPRA E' TEST 2");
	}
	@Test
	public void test03PiùStudenteUnCorsoUnAppelloZeroDatePiùPrenotazioni() {
		Docente doc1= new Docente("ROBERTO","NATELLA");
		Corso corso1=CC.creaCorso("INFORMATICA",doc1,9);
		Appello appello =CC.creaAppello(0,corso1,"CX2");
		Studente s= new Studente("Luigi","Garofalo","N46003756",21785);
		Studente k= new Studente("Mario","Rossi","N46003567",25485);
		CC.effettuaPrenotazione(appello,s);
		CC.effettuaPrenotazione(appello,k);
		CC.visualizzaStudentiPrenotati(appello);
		assertEquals(0,appello.studentiPrenotati.size());
		System.out.println(" SOPRA E' TEST 3");
	}
	@Test
	public void test04PiùStudenteUnCorsoPiùAppelliPiùDatePiùPrenotazioni() {
		Docente doc1= new Docente("ROBERTO","NATELLA");
		Corso corso1=CC.creaCorso("INFORMATICA",doc1,9);
		Appello appello =CC.creaAppello(2,corso1,"CX2");
		Data data1= new Data(LocalDate.of(2019,6,14),TipoProva.PROVA_AL_CALCOLATORE, TipoAula.LABORATORIO);
		appello.addData(data1);
		Data data2= new Data(LocalDate.of(2019,6,15),TipoProva.PROVA_SCRITTA, TipoAula.AULA);
		appello.addData(data2);
		Appello appello2= CC.creaAppello(1,corso1,"CX3");
		Data data3= new Data(LocalDate.of(2019,6,16),TipoProva.PROVA_ORALE, TipoAula.AULA);
		appello2.addData(data3);
		Studente s= new Studente("Luigi","Garofalo","N46003756",21785);
		Studente k= new Studente("Mario","Rossi","N46003567",25485);
		CC.effettuaPrenotazione(appello,s);
		CC.effettuaPrenotazione(appello,k);
		CC.effettuaPrenotazione(appello2,k);
		CC.visualizzaStudentiPrenotati(appello);
		CC.visualizzaStudentiPrenotati(appello2);
		assertEquals(2,appello.studentiPrenotati.size());
		assertEquals(1,appello2.studentiPrenotati.size());
		System.out.println(" SOPRA E' TEST 4");;
	}
	@Test
	public void test05UnoStudentePiùCorsiUnAppelloPiùDocentiPiùDateUnaPrenotazione() {
		Docente doc1= new Docente("ROBERTO","NATELLA");
		Corso corso1=CC.creaCorso("INFORMATICA",doc1,9);
		Docente doc2= new Docente("ANTONIO","PICARIELLO");
		Corso corso2=CC.creaCorso("BASI DI DATI",doc2,9);
		Appello appello =CC.creaAppello(2,corso1,"CX2");
		Data data1= new Data(LocalDate.of(2019,6,14),TipoProva.PROVA_AL_CALCOLATORE, TipoAula.LABORATORIO);
		appello.addData(data1);
		Data data2= new Data(LocalDate.of(2019,6,15),TipoProva.PROVA_SCRITTA, TipoAula.AULA);
		appello.addData(data2);
		Appello appello2= CC.creaAppello(2,corso2,"CX3");
		Data data3= new Data(LocalDate.of(2019,6,16),TipoProva.PROVA_ORALE, TipoAula.AULA);
		Data data4= new Data(LocalDate.of(2019,6,17),TipoProva.PROVA_SCRITTA, TipoAula.AULA);
		appello2.addData(data3);
		appello2.addData(data4);
		Studente s= new Studente("Luigi","Garofalo","N46003756",21785);
		
		CC.effettuaPrenotazione(appello,s);
		CC.effettuaPrenotazione(appello2,s);
		CC.visualizzaStudentiPrenotati(appello);
		CC.visualizzaStudentiPrenotati(appello2);
		assertEquals(1,appello.studentiPrenotati.size());
		assertEquals(1,appello2.studentiPrenotati.size());
		System.out.println(" SOPRA E' TEST 5");
	}
	@Test
	public void test06ZeroStudentiUnCorsoUnAppelloUnDocenteUnaDataZeroPrenotazioni() {
		Docente doc1= new Docente("ROBERTO","NATELLA");
		Corso corso1=CC.creaCorso("INFORMATICA",doc1,9);
		Data data1= new Data(LocalDate.of(2019,6,14),TipoProva.PROVA_AL_CALCOLATORE, TipoAula.LABORATORIO);
		Appello appello =CC.creaAppello(1,corso1,"CX2");
		appello.addData(data1);
		CC.visualizzaStudentiPrenotati(appello);
		CC.effettuaPrenotazione(appello, null);
		assertEquals(0,appello.studentiPrenotati.size());
		System.out.println(" SOPRA E' TEST 6");
	}
	
	@Test
	public void test07ZeroDocenti() {
		Corso corso1=CC.creaCorso("INFORMATICA",null,9);
		Data data1= new Data(LocalDate.of(2019,6,14),TipoProva.PROVA_AL_CALCOLATORE, TipoAula.LABORATORIO);
		Appello appello =CC.creaAppello(1,corso1,"CX2");
		appello.addData(data1);
		Studente s= new Studente("Luigi","Garofalo","N46003756",21785);
		CC.effettuaPrenotazione(appello,s);
		CC.visualizzaStudentiPrenotati(appello);
		assertEquals(0,appello.studentiPrenotati.size());
		System.out.println(" SOPRA E' TEST 7");
	}
	@Test
	public void test08PiùStudentiPiùCorsiUnDocentePiùAppelliPiùDateUnaPrenotazione() {
		Docente doc1= new Docente("ROBERTO","NATELLA");
		Corso corso1=CC.creaCorso("INFORMATICA",doc1,9);
		Corso corso2=CC.creaCorso("BASI DI DATI",doc1,9);
		Appello appello =CC.creaAppello(2,corso1,"CX2");
		Data data1= new Data(LocalDate.of(2019,6,14),TipoProva.PROVA_AL_CALCOLATORE, TipoAula.LABORATORIO);
		appello.addData(data1);
		Data data2= new Data(LocalDate.of(2019,6,15),TipoProva.PROVA_SCRITTA, TipoAula.AULA);
		appello.addData(data2);
		Appello appello2= CC.creaAppello(2,corso2,"CX3");
		Data data3= new Data(LocalDate.of(2019,6,16),TipoProva.PROVA_ORALE, TipoAula.AULA);
		Data data4= new Data(LocalDate.of(2019,6,17),TipoProva.PROVA_SCRITTA, TipoAula.AULA);
		appello2.addData(data3);
		appello2.addData(data4);
		Studente s= new Studente("Luigi","Garofalo","N46003756",21785);
		Studente k= new Studente("Mario","Rossi","N46003456",64365);
		CC.effettuaPrenotazione(appello,s);
		CC.effettuaPrenotazione(appello2,s);
		CC.effettuaPrenotazione(appello2,k);
		CC.visualizzaStudentiPrenotati(appello);
		CC.visualizzaStudentiPrenotati(appello2);
		assertEquals(1,appello.studentiPrenotati.size());
		assertEquals(2,appello2.studentiPrenotati.size());
		System.out.println(" SOPRA E' TEST 8");
	}
	@Test
	public void test09ZeroCorsi() {
		
		Data data1= new Data(LocalDate.of(2019,6,14),TipoProva.PROVA_AL_CALCOLATORE, TipoAula.LABORATORIO);
		Appello appello =CC.creaAppello(1,null,"CX2");
		appello.addData(data1);
		Studente s= new Studente("Luigi","Garofalo","N46003756",21785);
		CC.effettuaPrenotazione(appello,s);
		CC.visualizzaStudentiPrenotati(appello);
		assertEquals(0,appello.studentiPrenotati.size());
		System.out.println(" SOPRA E' TEST 9");
	}
	
	
}
