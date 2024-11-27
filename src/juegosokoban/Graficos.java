
package juegosokoban;

import javax.swing.ImageIcon;

/**
 *
 * @author Diego Rueda y Brahian Gonzales
 */
public class Graficos {
    private ImageIcon personajeP1;
    private ImageIcon personajeP2;
    private ImageIcon personajeP3;
    private ImageIcon personajeP4;
    private ImageIcon pasto;
    private ImageIcon muros;
    private ImageIcon bestia1;
    private ImageIcon bestia2;
    private ImageIcon destinos;
    private ImageIcon objetos;
    private ImageIcon pinta;
    
    public Graficos(){
        personajeP1= new ImageIcon("graficos/personajeP1.png");
        personajeP2= new ImageIcon("graficos/personajeP2.png");
        personajeP3= new ImageIcon("graficos/personajeP3.png");
        personajeP4= new ImageIcon("graficos/personajeP4.png");
        muros= new ImageIcon("graficos/muros.png");
        pasto= new ImageIcon("graficos/pasto.png");
        bestia1= new ImageIcon("graficos/bestia1.png");
        bestia2= new ImageIcon("graficos/bestia2.png");
        objetos= new ImageIcon("graficos/objetos.png");
        destinos= new ImageIcon("graficos/destinos.png");
    }
    
    public ImageIcon pintar(int x){
        switch(x){
            //CASOS INICIALES DE LOS ELEMENTOS
            case 0:
                pinta= pasto;
                break;
                
            case 1:
                pinta= personajeP2;//posicion abajo
                break;
                
            case 2:
                pinta= muros;
                break;
                
            case 3:
                pinta = objetos;
                break;
                
            case 4:
                pinta = destinos;
                break;
                
            case 5:
                pinta = bestia1;
                break;
                
            case 6:
                pinta = bestia2;
                break;
            
             //MOVIMENTO DEL PERSONAJE
            case 7:
                pinta = personajeP1;//posicion arriva
                break;
                
            case 8:
                pinta = personajeP3;//posicion derecha
                break;
                
            case 9:
                pinta = personajeP4;//posicion izquierda
                break;
        }
        return pinta;
    }
}
