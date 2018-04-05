package pol;


public class Monom  {
public int coeficient;
public int putere;
public Monom(int coeficient,int putere) {
	this.coeficient=coeficient;
	this.putere=putere;
}
public int getCoeficient() {
	return coeficient;
}
public void setCoeficient(int coeficient) {
	this.coeficient = coeficient;
}
public int getPutere() {
	return putere;
}
public void setPutere(int putere) {
	this.putere = putere;
}
public String toStringM() {
	String s="";
	if(this.coeficient==0) {
		s+="";
	}
	if(this.coeficient==1 && this.putere==1) {
		s+="+x";
	}
	if(this.coeficient>0 && this.putere!=0) {
		s+="+"+this.coeficient+"x^"+this.putere;
	}
	if(this.coeficient<0 && this.putere!=0) {
		s+=+this.coeficient+"x^"+this.putere;
	}
	if(this.coeficient>0 && this.putere==0) {
		s+="+"+this.coeficient;
	}
	if(this.coeficient<0 && this.putere==0) {
		s+=this.coeficient;
	}

	return s;
}
public Monom adunareMonom(Monom m) {
	Monom m1;
	if (this.putere == m.getPutere()) {
		m1 = new Monom(this.coeficient + m.getCoeficient(),
				m.getPutere());
	} else if (this.putere < m.getPutere()) {
		m1 = new Monom(m.getCoeficient(), m.getPutere());
	} else {
		m1 = new Monom(this.coeficient, this.putere);
	}
	return m1;
}
public Monom scadereMonom(Monom m) {
	Monom rezultat;
	if (this.putere == m.getPutere()) {
		rezultat = new Monom(this.coeficient - m.getCoeficient(),
				m.getPutere());
	} else if (this.putere < m.getPutere()) {
		rezultat = new Monom(m.getCoeficient() * (-1), m.getPutere());
	} else {
		rezultat = new Monom(this.coeficient, this.putere);
	}
	return rezultat;
}

public Monom inmultireMonom(Monom m) {
	Monom rezultat;
	rezultat=new Monom(this.coeficient*m.coeficient,this.putere+m.putere);
	return rezultat;
}
public Monom derivareMonom() {
	Monom rezultat;
	rezultat=new Monom(this.coeficient*this.putere,this.putere-1);
	return rezultat;
}
public Monom integrareMonom() {
	Monom rezultat;
	rezultat=new Monom(this.coeficient*(1/(this.putere+1)),this.putere+1);
	return rezultat;
}
}
