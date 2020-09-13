
public  class Espace {
	int X ;
	int Y ;
	int Rouge ;
	int Vert ;
	int Bleu ;
	boolean Matiere ;
	double d ; // distance séparant nos deux systèmes de coordonnées
	int ModeCouleur ;
	double Ma ;
	double g ;
	public void initialisation (int pCoordonneesX , int pCoordonneesY, int pRouge, int pVert , int pBleu, int pModeCouleur, double pMa) {

		this.X = pCoordonneesX ;
		this.Y = pCoordonneesY ;
		this.Rouge = pRouge ;
		this.Vert = pVert ;
		this.Bleu = pBleu ;
		this.ModeCouleur = pModeCouleur ;
		this.Ma = pMa ;
		this.g = 0;
	}
	public Espace() {
		this.X=0;
		this.Y=0;
		this.Rouge = 255;
		this.Vert = 255;
		this.Bleu = 255;
		this.Matiere = false ;
		this.Ma = 0;
		this.ModeCouleur = 0 ;
		this.g = 0;
	}
	public Espace(int pcoordonneesX ,int pcoordonneesY) {
		this.X = pcoordonneesX ;
		this.Y = pcoordonneesY ;
		this.Rouge = 255;
		this.Vert = 255;
		this.Bleu = 255;
		this.Matiere = false ;
		this.Ma = 0;
		this.ModeCouleur = 0 ;
		this.g = 0;

	}
	public void setMasse (double pMa) {
		this.Ma = pMa ;
	}
	public int getRouge() {
		return this.Rouge;

	}
	public int getVert() {
		return this.Vert;

	}
	public int getBleu() {
		return this.Bleu;

	}
	public boolean getMatiere() {
		return this.Matiere ;

	}
	public int getModeCouleur() {
		return this.ModeCouleur;

	}
	public double getMasse() {
		return this.Ma;

	}
	public int getX() {
		return this.X;

	}
	public int getY() {
		return this.Y;

	}
	//g = (G. Ma)/Ra^2   G = 6,6742.10-11 N·m2·kg-2 .
	public void distance(double pcoordonneex ,double  pcoordonneey , double pmasse ){
		double Gr = 6.6742 ;
		double a = Math.abs( pcoordonneex - this.X) ;
		double b = Math.abs( pcoordonneey - this.Y) ;
		double d ;                    
		if (a == 0){
			if (b == 0)
				d = 0 ;
			else
				d = b ;
		}
		else{
			if( b == 0) {
				d = a;}
			else{
				d = Math.sqrt((b * b) + (a * a)) ;}
		}
		if (d == 0) {
			g =g+ ((Gr * pmasse) / 0.01) ;}
		else{
			g = g+((Gr * pmasse) / (d * d));
		}
	}
	public void gestionCouleur( int ptype){
		//System.out.println ("On entre dans gestion couleur et ppoint vaut " + pPoints);
		double pPoints = Math.round(this.g);
		if (ptype == 1) { 
			//System.out.println ("On entre dans la première condition");
			if (pPoints != 0) { 
				if(pPoints > 255*3) {
					Rouge = 0 ; Vert = 0 ; Bleu = 0 ;}
				else {
					for (double n = 1d ; n <= pPoints ; n++ ) { 
						if (Bleu > Vert) { 
							if (Bleu != 0) {
								Bleu = Bleu - 1;}}
						else if (Vert > Rouge) {
							if (Vert != 0) {
								Vert = Vert - 1;}}
						else if (Rouge != 0) {
							Rouge = Rouge - 1;}


					}
				}

			}
		}

		if (ptype == 2) {
			if (pPoints != 0) { 
				if(pPoints > 255*3) {
					Rouge = 0 ; Vert = 0 ; Bleu = 0 ;}
				else {
					for (double n = 1 ; n <= pPoints; n++) {
						if (Bleu != 0) {
							Bleu = Bleu - 1;}
						else if (Vert != 0) {
							Vert = Vert - 1;}
						else if (Rouge != 0) {
							Rouge = Rouge - 1;
						}
					}
				}
			}
		}

		if (ptype == 3) {
			if (pPoints != 0) {
				if(pPoints > 255*3) {
					Rouge = 0 ; Vert = 0 ; Bleu = 0 ;}
				else {
					for (double n = 1 ;n <= pPoints;n++) {
						if (Rouge != 0) {
							Rouge = Rouge - 1;}
						else if (Vert != 0) {
							Vert = Vert - 1;}
						else if (Bleu != 0) {
							Bleu = Bleu - 1;}
					}
				}
			}
		}


		if (ptype == 4) { 

			if (pPoints != 0) { 
				for (double n = 1 ;n <= pPoints;n++){
					if(pPoints > 5800) {
						Rouge = 0 ; Vert = 0 ; Bleu = 0 ;
						break;}
					else {
						if (ModeCouleur == 0) {
							if (Bleu != 0) {
								Bleu = Bleu - 1;}
							else if (Vert != 1) {
								Vert = Vert - 1;}
							else {ModeCouleur = 1;
							Vert = Vert - 1;}
						}

						else if (ModeCouleur == 1) {
							if (Rouge == 255 && Bleu != 255) {
								Bleu = Bleu + 1;}
							else if (Rouge == 255 && Bleu == 255) {
								Rouge = Rouge - 1;}
							else if (Rouge != 255 && Rouge != 0) {
								Rouge = Rouge - 1;}
							else if (Rouge == 0 && Bleu != 0) {
								Bleu = Bleu - 1;}
							else {ModeCouleur = 2;}
						}

						else if (ModeCouleur == 2) {

							if (Rouge != 255 && Bleu != 255 && Vert != 255 ) {
								Bleu = Bleu + 1 ; Rouge = Rouge + 1 ; Vert = Vert + 1;}
							else{ ModeCouleur = 3;}
						}

						else if (ModeCouleur ==3) {
							if (Rouge != 0 && Bleu == 255) { 
								Rouge = Rouge - 1;}
							else if (Rouge == 0 && Bleu!= 1) {
								Bleu = Bleu - 1;}
							else if (Rouge == 0 && Bleu == 1) {
								ModeCouleur = 4; Bleu = Bleu - 1;}
						}

						else if (ModeCouleur == 4) {
							if (Rouge != 255) {
								Rouge = Rouge + 1;}
							else if (Bleu != 254) { 
								Bleu = Bleu + 1;}
							else if (Bleu == 254) {
								Bleu = Bleu + 1; ModeCouleur = 5;}
						}

						else if (ModeCouleur == 5) {
							if (Rouge != 0) {
								Rouge = Rouge - 1;}
							else if (Vert != 0) {
								Vert = Vert - 1;}
							else if (Bleu != 0) {
								Bleu = Bleu - 1;}
						}

					}
				}

				if (ptype == 5) {
					if (pPoints != 0) { 
						for( double n = 1 ;n == pPoints ;n++){
							if (Bleu > Vert) {
								if (Bleu != 0) { Bleu = Bleu - 1;}
								else if (Vert > Rouge) {
									if (Vert != 0) { Vert = Vert - 1;}
									else if (Rouge != 0) {Rouge = Rouge - 1;}}
							}
						}
					}
				}
			}


		}

		//System.out.println (this.Rouge + " rouge " + this.Vert  + " Vert " + this.Bleu  + " Bleu ");
	}

	public void  TracerCercle(double pcoordonnéex , double pcoordonnéey ,double pdistance, double pvariance ) {

		double a = Math.abs(pcoordonnéex - X) ;
		double b = Math.abs(pcoordonnéey - Y) ;

		if (a == 0) {
			if (b == 0) {
				d = 0;}
			else {
				d = b;}}

		else {
			if (b == 0) {
				d = a;}
			else {
				d = Math.sqrt(b * b + a * a) ;
				//' If d <> 0 Then d = d * 10 ' poipoipoiupoiu

			}}
		if (d > (pdistance - pvariance) && d < (pdistance + pvariance)) {Matiere = true;}

	}

}
