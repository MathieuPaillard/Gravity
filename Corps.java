
public class Corps {
	double Ma;
	double vselonX;
	double vselonY;
	double reelX;
	double reelY;
	double accselonX;
	double accselonY;
	int temps;
	int tempsmoinsun;
	int X;
	int Y;
	double g;
	int positionxy;
	double rayon;
	double volume;
	double densite;
	public  Corps() {
	Ma = 1;
	vselonX = 0;
	vselonY = 0;
	reelX = 1;
	reelY=1;
	rayon = 1;
	}
	public  Corps(double pMasse, double pvselonX, double pvselonY, int pRX, int pRY) {
		 Ma=pMasse ;
		 vselonX=pvselonX ;
		 vselonY=pvselonY ;
		 X=pRX ;
		 Y=pRY ;
		 reelX=pRX ;
		 reelY=pRY ;
		 temps=0;
		 accselonX=0;
		 accselonY=0;
		 densite=5;
		 volume = Ma/densite;
		 rayon=Math.pow(((3*volume)/(4*3.14)), (1.0/3.0));
		 System.out.println("rayon : " + rayon);
	}	
	public  Corps(double pMasse, double pvselonX, double pvselonY, int ppsotionxy, int ppixels, int pgrillex) {
		
	Y = (ppsotionxy+pgrillex)/pgrillex;
		//System.out.println("y = " +y+ " : n = " +n);
	X = (ppixels+1)-(ppixels-ppsotionxy)-((Y-1)*pgrillex);

		 Ma=pMasse ;
		 vselonX=pvselonX ;
		 vselonY=pvselonY ;
		 
		 reelX=X ;
		 reelY=Y ;
		 temps=0;
		 accselonX=0;
		 accselonY=0;
		 positionxy = ppsotionxy;
		 densite=5000;
		 volume = Ma/densite;
		 rayon=Math.pow(((3*volume)/(4*3.14)), (1.0/3.0));
	}	
	
	public void collision(Corps pAstre , double pd) {
		
		//System.out.println("On est dans collision");
		double vX = this.vselonX;
		double vY= this.vselonY;
		double aX = this.accselonX;
		double aY = this.accselonY;
		
		
		
		 this.vselonX= ((vX*this.Ma) +  (pAstre.vselonX *pAstre.Ma) )/(pAstre.Ma+this.Ma) ;
		 this.vselonY= ((vY*this.Ma) +  (pAstre.vselonY *pAstre.Ma) )/(pAstre.Ma+this.Ma);
		 pAstre.vselonX =  ((vX*this.Ma) +  (pAstre.vselonX *pAstre.Ma) )/(pAstre.Ma+this.Ma) ;
		 pAstre.vselonY =  ((vY*this.Ma) +  (pAstre.vselonY *pAstre.Ma) )/(pAstre.Ma+this.Ma) ;
		
		 //this.accselonX=((aX*this.Ma)+(pAstre.accselonX*pAstre.Ma))/(pAstre.Ma+this.Ma)  ;
		 //this.accselonY=((aY*this.Ma)+(pAstre.accselonY*pAstre.Ma))/(pAstre.Ma+this.Ma) ;
		 //pAstre.accselonX = ((aX*this.Ma)+(pAstre.accselonX*pAstre.Ma))/(pAstre.Ma+this.Ma)  ;
		 //pAstre.accselonY = ((aY*this.Ma)+(pAstre.accselonY*pAstre.Ma))/(pAstre.Ma+this.Ma)  ;
		 
		 if (pd <5) {
			 if (pAstre.Ma>=this.Ma) {
			 this.reelX=pAstre.reelX ;
			 this.reelY=pAstre.reelY ; 
			 }
			 else {
				 pAstre.reelX=this.reelX;
				 pAstre.reelY=this.reelY;
			 }
		 }
		 
	}
	public void calculacceleration(double pcoordonneex ,double  pcoordonneey , double pmasse , Corps pAstre){
		double Gr = 6.6742 ;
		double a = Math.abs( pcoordonneex - this.reelX) ;
		double b = Math.abs( pcoordonneey - this.reelY) ;
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
				d = Math.sqrt((b * b) + (a * a)) ;}//poipoiupoiupoiupio
		}
		//if (d<rayon) {
		//this.reelX = pcoordonneex;
		//this.reelY = pcoordonneex;


		//}
		//System.out.println("rayon : " + rayon + " Et distance : " + d);
		//if ( rayon > d) {
		//	System.out.println("rayon > d ");
		//	collision(pAstre);
		//}
		
		if ((rayon + pAstre.rayon) > d) {
			d=d*10;
			g = ((Gr * (pmasse)) / (d * d))/10000;
			collision(pAstre, d);	
			
			if ((pcoordonneex - this.X)==0) {
				accselonX =0+accselonX;}
			else {
				accselonX =(((pcoordonneex - this.X)/d)*g)+accselonX ;
			}
			if ((pcoordonneey - this.Y)==0) {
				accselonY =0+accselonY;}
			else {
				accselonY =(((pcoordonneey - this.Y)/d)*g)+accselonY ;
			}
			
		} //g = ((Gr * (pmasse))) ;}

		else{
			d=d*10;
			g = ((Gr * (pmasse)) / (d * d));



			if ((pcoordonneex - this.X)==0) {
				accselonX =0+accselonX;}
			else {
				accselonX =(((pcoordonneex - this.X)/d)*g)+accselonX ;
			}
			if ((pcoordonneey - this.Y)==0) {
				accselonY =0+accselonY;}
			else {
				accselonY =(((pcoordonneey - this.Y)/d)*g)+accselonY ;
			}
		}


	}
	public void determinationnouvelleposition(int ptemps){
		tempsmoinsun = temps;
		temps = ptemps;
		vselonX = vselonX + (temps - tempsmoinsun)*accselonX ;
		vselonY = vselonY + (temps - tempsmoinsun)*accselonY ;
		reelX = reelX + (temps - tempsmoinsun)*vselonX ;
		reelY = reelY + (temps - tempsmoinsun)*vselonY ;
		X = (int)(Math.round(reelX));
		Y = (int)(Math.round(reelY));
		
		//System.out.println("X = " + reelX + " ; Y = " + reelY);
	}
	
}

//for (Unite U : j.Troupes) {
//	U.GestionnaireBonus(j);
//}