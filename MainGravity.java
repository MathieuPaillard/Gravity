import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class MainGravity {
	public static int convertionCoordonnees(int Xc , int Yc, int gX) {
		int uC = ((Yc-1)*(gX))+Xc-1;
		return uC ;
	}
	public static void main(String[] args)  throws IOException {
		int grillex ;
		int grilley ;
		grillex = 1080;
		grilley = 720;
		int nombreAstre = 5000;
		int pixels = (grillex*grilley);
		System.out.println (pixels );
		//System.out.println ("1" );

		Espace[] Table;
		//for (double t = 1 ; t== 20 ;t++)
		Table = new Espace[pixels];
		Corps[] Astre;
		Astre = new Corps[nombreAstre];
		System.out.println ("Initialisation astres" );
		
		for(int n = 0 ; n <nombreAstre ; n++) {
		Astre[n] = new Corps((Math.random()*(20)),0,0,(int)(Math.random()*((pixels*2)-pixels)),((pixels*2)-pixels),grillex);
		//System.out.println ("2");
		}
		Astre[0] = new Corps(1000000,0,0,750-210,750-390);
		Astre[1] = new Corps(1000,7,0,750-210,600-390);
		Astre[2] = new Corps(100,4,0,750-210,400-390);
		Astre[3] = new Corps(50500,-4,0,750-210,1000-390);
		
		
		Astre[4] = new Corps(1540,5,0,750-210,990-390);
		//Astre[5] = new Corps(1400,0,0,750-210,1000-390);
	    //Astre[6] = new Corps(7510,0,0,750-210,450-390);
		
		System.out.println ("Boucle de temps" );
		for (int t = 1 ; t< 5000;t++) {
			//Table[0] = new Espace();
			//Table[0].setMasse(50);
			//System.out.println (Table[0].getMasse());
			//Table[9].initialisation(1, 2, 50, 50, 50, 1, 50);
			//System.out.println ("3" );
			System.out.println ("Boucle génération de l'espace" );
			for (int n = 0; n<= (pixels-1) ;n++) {
				//System.out.println ("Salut");
				int y = (n+grillex)/grillex;
				//System.out.println("y = " +y+ " : n = " +n);
				int x = (pixels+1)-(pixels-n)-((y-1)*grillex);
				//System.out.println("x = " +x+ " : y = " +y+ " : n = " +n);
				Table[n] = new Espace(x,y);
				//System.out.println ("4" );
				//System.out.println (Table[n].getBleu() +" "+  Table[n].getY());
			}

			//' Modèle à coller ici

			//System.out.println (Table[1][1].Bleu);
			System.out.println ("Boucle association des masses au tissu" );
			for(int n = 0 ; n <nombreAstre ; n++) {
				//System.out.println(Astre[n].X+" X " + Astre[n].Y+" Y ");
				Astre[n].accselonX =0;
				Astre[n].accselonY =0;
				//System.out.println ("5" );
				if (convertionCoordonnees(Astre[n].X,Astre[n].Y,grillex)<pixels &&convertionCoordonnees(Astre[n].X,Astre[n].Y,grillex)>0) {
				Table[convertionCoordonnees(Astre[n].X,Astre[n].Y,grillex)].Matiere = true; 
				Table[convertionCoordonnees(Astre[n].X,Astre[n].Y,grillex)].setMasse(Astre[n].Ma);
				
				//System.out.println ("6" );
			}
			}
			
			System.out.println ("Boucle distance");
			for (int n = 0; n< nombreAstre ;n++) {                       //for (int n = 0; n<= (pixels-1) ;n++) {                                       
				//if (Table[n].Ma != 0) {                                  //if (Table[n].Ma != 0) {
					for (int v = 1 ;v<= (pixels-1);v++){
						//System.out.println ("7" );
						Table[v].distance (Astre[n].reelX, Astre[n].reelY, Astre[n].Ma);   // j'ai remplacé table par astre
					}
				//}
			}
			
			System.out.println ("Boucle acceleration" );
			for(int n = 0 ; n <nombreAstre ; n++) {
				
				for(int p = 0 ; p <nombreAstre ; p++) {
					if ((Astre[n].reelX != Astre[p].reelX) &&( Astre[n].reelY!=Astre[p].reelY)) {
						//System.out.println ("8" );
						Astre[n].calculacceleration(Astre[p].reelX, Astre[p].reelY, Astre[p].Ma ,Astre[p]);}
				}
			}
			
			//Astre[0].calculacceleration(Astre[1].reelX, Astre[1].reelY, Astre[1].Ma);
			//Astre[0].calculacceleration(Astre[2].reelX, Astre[2].reelY, Astre[2].Ma);
			//Astre[0].calculacceleration(Astre[3].reelX, Astre[3].reelY, Astre[3].Ma);
			//Astre[1].calculacceleration(Astre[0].reelX, Astre[0].reelY, Astre[2].Ma);
			//Astre[1].calculacceleration(Astre[2].reelX, Astre[2].reelY, Astre[3].Ma);
			//Astre[1].calculacceleration(Astre[3].reelX, Astre[3].reelY, Astre[3].Ma);
			//Astre[2].calculacceleration(Astre[0].reelX, Astre[0].reelY, Astre[2].Ma);
			//Astre[2].calculacceleration(Astre[1].reelX, Astre[1].reelY, Astre[3].Ma);
			//Astre[2].calculacceleration(Astre[3].reelX, Astre[3].reelY, Astre[3].Ma);
			//Astre[3].calculacceleration(Astre[0].reelX, Astre[0].reelY, Astre[2].Ma);
			//Astre[3].calculacceleration(Astre[1].reelX, Astre[1].reelY, Astre[3].Ma);
			//Astre[3].calculacceleration(Astre[2].reelX, Astre[2].reelY, Astre[3].Ma);
		
			//System.out.println(Astre[0].accselonX + "ax ; " + Astre[0].accselonY + " ay.");
			//System.out.println(Astre[1].accselonX + "ax ; " + Astre[1].accselonY + " ay.");
			System.out.println ("Boucle gestion couleur" );
			for (int n = 0; n<= (pixels-1) ;n++) {
				//System.out.println ("9" );
				Table[n].gestionCouleur (1);
			}
			System.out.println ("Boucle nouvelle position" );
			for (int z = 0 ;z< nombreAstre;z++){
				//System.out.println ("10" );
				Astre[z].determinationnouvelleposition(t);
			}
			//for (int n = 0; n<= 2 ;n++) {
				//Astre[0].calculacceleration(pcoordonneex, pcoordonneey, pmasse);
			//}

			//    'Modèle au dessus
			//   for (int X = 1; X == grillex; X++)     {   
			//       for (int Y = 1 ;Y==grilley;Y++) {

			//           if (Table[X][Y].Ma != 0) {
			//               for (int v = 1 ;v== grillex;v++){
			//                    for (int w = 1 ;w== grilley;w++) {
			//                        Table[v][w].distance (X, Y, Table[X][Y].Ma);
			//                    }
			//              }
			//          }
			//      }
			//  }

			//System.out.println ("11" );
			// TODO Auto-generated method stub
			int width = grillex; //in pixels
			int height = grilley; //in pixels
			BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
			//BufferedImage.TYPE_4BYTE_ABGR - store RGB color and visibility (alpha), see javadoc for more info

			Graphics g = image.createGraphics();

			//draw whatever you like, like you would in a drawComponent(Graphics g) method in an UI application

			for (int n = 0; n<= (pixels-1) ;n++) {


				g.setColor( new Color(Table[n].Rouge ,Table[n].Vert , Table[n].Bleu));
				g.fillRect(Table[n].X, Table[n].Y, 1, 1);

			}
			g.dispose(); //dispose graphics objects when they are no longer needed
			File nomfichier = new File("E:/Excel/ImagesExcel/MyImage" + t + ".png");
			//now image has programmatically generated content, you can use it in graphics.drawImage() to draw it somewhere else
			//or just simply save it to a file
			ImageIO.write(image, "png", nomfichier);
			System.out.println ("Image générée" );
		}

	}
}
