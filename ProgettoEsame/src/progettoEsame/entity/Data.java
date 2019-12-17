package progettoEsame.entity;

import java.time.LocalDate;

public class Data {
	

	private LocalDate dataProva;
	private TipoProva tipo;
	private TipoAula tipoa;
	
	public Data(LocalDate dataProva, TipoProva tipo, TipoAula tipoa) {
		
		this.dataProva=dataProva;
		this.tipo=tipo;
		this.setTipoa(tipoa);
		
	}


	public LocalDate getDataProva() {
		return dataProva;
	}
	public void setDataProva(LocalDate dataProva) {
		this.dataProva = dataProva;
	}

	public TipoProva getTipo() {
		return tipo;
	}

	public void setTipo(TipoProva tipo) {
		this.tipo = tipo;
	}

	public TipoAula getTipoa() {
		return tipoa;
	}

	public void setTipoa(TipoAula tipoa) {
		this.tipoa = tipoa;
	}

}
