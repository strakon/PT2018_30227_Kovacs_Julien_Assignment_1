package pol;

import java.util.ArrayList;



public class Polinom {
	public ArrayList<Monom> polinom;
	public Polinom() {
		polinom = new ArrayList<Monom>();
	}
	public Polinom(ArrayList<Monom> polinom) {
		this.polinom = polinom;
	}
	public ArrayList<Monom> getPolinom() {
		return polinom;
	}
	public void setPolinom(ArrayList<Monom> polinom) {
		this.polinom = polinom;
	}
	public String toStringP() {
		String s="";
		for(int i=0;i<this.polinom.size();i++) {
			s=s+this.polinom.get(i).toStringM();
		}
		return s;
	}
	public boolean isInteger( String input )
	{
	   try
	   {
	      Integer.parseInt( input );
	      return true;
	   }
	   catch( Exception e )
	   {
	      return false;
	   }
	}
	public void parse(String s) {
		Monom m;
		String[] terms = s.replace("^", "").split("(?=\\+|\\-)");
		for(int i=0;i<terms.length;i++) {
			if(terms[i].equals("+x")) {
				m=new Monom(1,1);
				this.polinom.add(m);
			}else if(terms[i].equals("-x")) {
				m=new Monom(-1,1);
			}
			else if(isInteger(terms[i])) {
				m=new Monom(Integer.parseInt(terms[i]),0);
				this.polinom.add(m);
			}else {
				String[] terms2=terms[i].split("x");
				if(terms2[0]==null && terms2[1]!=null) {
					m=new Monom(1,Integer.parseInt(terms2[1]));
					this.polinom.add(m);
				}else if (terms2[0]!=null&&terms2[1]==null) {
					m=new Monom(Integer.parseInt(terms2[0]),1);
					this.polinom.add(m);
				}else if(terms2[0]!=null&&terms2[1]!=null) {
					m=new Monom(Integer.parseInt(terms2[0]),Integer.parseInt(terms2[1]));
					this.polinom.add(m);
				}
			}
		}
		}
	public Polinom adunarePolinom(Polinom polinom2) {
		Polinom rezultatPolinom = new Polinom();
		int i = 0, j = 0, r = 0;
		int n = polinom.size();
		int m = polinom2.polinom.size();
		while ((i < n) && (j < m)) {
			if (polinom.get(i).getPutere() == polinom2.polinom.get(j).getPutere()) {
				rezultatPolinom.polinom.add(r,
						polinom.get(i).adunareMonom(polinom2.polinom.get(j)));
				r++;
				i++;
				j++;
			} else if (polinom.get(i).getPutere() > polinom2.polinom.get(j)
					.getPutere()) {
				rezultatPolinom.polinom.add(r, polinom.get(i));
				i++;
				r++;
			} else if (polinom.get(i).getPutere() < polinom2.polinom.get(j)
					.getPutere()) {
				rezultatPolinom.polinom.add(r, polinom2.polinom.get(j));
				j++;
				r++;
			}
		}
		if (i < n) {
			while (i < n) {
				rezultatPolinom.polinom.add(r, polinom.get(i));
				i++;
				r++;
			}
		} else if (j < m) {
			while (j < m) {
				rezultatPolinom.polinom.add(r, polinom2.polinom.get(j));
				j++;
				r++;
			}
		}
		return rezultatPolinom;
	}	
	public Polinom scaderePolinom(Polinom polinom2) {
		Polinom rezultatPolinom = new Polinom();
		Monom nul = new Monom(0, 0);
		int i = 0, j = 0, r = 0;
		int n = polinom.size();
		int m = polinom2.polinom.size();
		while (i < n && j < m) {
			if (polinom.get(i).getCoeficient() == polinom2.polinom.get(j).getCoeficient()) {
				rezultatPolinom.polinom.add(r,
						polinom.get(i).scadereMonom(polinom2.polinom.get(j)));
				i++;
				j++;
				r++;
			} else if (polinom.get(i).getCoeficient() > polinom2.polinom.get(j)
					.getCoeficient()) {
				rezultatPolinom.polinom.add(r, polinom.get(i));
				i++;
				r++;
			} else if (polinom.get(i).getCoeficient() < polinom2.polinom.get(j)
					.getCoeficient()) {
				rezultatPolinom.polinom.add(r,
						nul.scadereMonom(polinom2.polinom.get(j)));
				j++;
				r++;
			}
		}
		if (i < n) {
			while (i < n) {
				rezultatPolinom.polinom.add(r, polinom.get(i));
				i++;
				r++;
			}
		} else if (j < m) {
			while (j < m) {
				rezultatPolinom.polinom.add(r,
						nul.scadereMonom(polinom2.polinom.get(j)));
				j++;
				r++;

			}
		}
		return rezultatPolinom;
	}

	public Polinom derivarePolinom() {
		Polinom rezultat=new Polinom();
		for(int i=0;i<this.polinom.size();i++) {
			rezultat.polinom.add(this.polinom.get(i).derivareMonom());
		}
		return rezultat;
	}
	public Polinom inmultirePolinom(Polinom polinom2) {
		Polinom rezultatPolinom = new Polinom();
		int i, j;
		for (i = 0; i < polinom.size(); i++)
			for (j = 0; j < polinom2.polinom.size(); j++) {
				rezultatPolinom.polinom.add(polinom.get(i).inmultireMonom(
						polinom2.polinom.get(j)));
			}
		return rezultatPolinom;
	}
	public Polinom integrarePolinom() {
		Polinom rezultat=new Polinom();
		for(int i=0;i<this.polinom.size();i++) {
			rezultat.polinom.add(this.polinom.get(i).integrareMonom());
		}
		return rezultat;
	}
}
