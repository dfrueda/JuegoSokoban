/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juegosokoban;

import java.util.Random;

/**
 *
 * @author Diego Rueda y Brahian Gonzales
 */
public class Movimientos {
   
    private int[][] matriz;
    private int[][] matrizentorno;
    private int direccion;//direccion personaje
    private int gdireccion;//direccion grafica del personja
    private int tipobestia;
    private int numbestias;
    private int destinousado=0;
    private int objetotomado=0;
    private int[] mdireccion;//direccion bestias
    private int dim=12;
    private int c;//recorre medirecciones
    private int pintapersonaje;
    private int x1;
    private int y1;
    private int[] x;
    private int[] y;
    private int nmovimientos;
    
    //valida y acciona el movimiento del personaje
    public void Movimiento(int[][] matriz1, int[][] matrizentorno1, int direccion1,int movimientos1){
        
        this.matriz=matriz1;
        this.matrizentorno=matrizentorno1;
        this.direccion=direccion1;
        this.nmovimientos=movimientos1;
        
        for(int a =0;a<dim;a++){
            for(int b=0;b<dim;b++){
                if((matriz[a][b]==1)||(matriz[a][b]==7)||(matriz[a][b]==8)
                        ||(matriz[a][b]==9)){
                    
                    //arriba
                    if((direccion==1)&&(a!=0)&&(matriz[(a-1)][b]!=2)&&
                            (matriz[(a-1)][b]!=5)&&(matriz[(a-1)][b]!=6)){
                        matriz[a][b]=matrizentorno[a][b];
                        x1=a-1;
                        y1=b;
                        nmovimientos=nmovimientos-1;
                        pintapersonaje=7;
                    }
                    //abajo
                    else if((direccion==2)&&(a!=(dim-1))&&(matriz[(a+1)][b]!=2)&&
                            (matriz[(a+1)][b]!=5)&&(matriz[(a+1)][b]!=6)){
                        matriz[a][b]=matrizentorno[a][b];
                        x1=a+1;
                        y1=b;
                        nmovimientos=nmovimientos-1;
                        pintapersonaje=1;
                    }
                    //derecha
                    else if((direccion==3)&&(b!=(dim-1))&&(matriz[a][(b+1)]!=2)&&
                            (matriz[a][(b+1)]!=5)&&(matriz[a][(b+1)]!=6)){
                        matriz[a][b]=matrizentorno[a][b];
                        x1=a;
                        y1=b+1;
                        nmovimientos=nmovimientos-1;
                        pintapersonaje=8;
                    }
                    //izquierda
                    else if((direccion==4)&&(b!=0)&&(matriz[a][(b-1)]!=2)&&
                            (matriz[a][(b-1)]!=5)&&(matriz[(a)][(b-1)]!=6)){
                        matriz[a][b]=matrizentorno[a][b];
                        x1=a;
                        y1=b-1;
                        nmovimientos=nmovimientos-1;
                        pintapersonaje=9;
                    }
                    else{
                        pintapersonaje=pintadireccion(matriz[a][b],direccion);
                        x1=a;
                        y1=b;                                                         
                    }
                }                    
            }
        }      
    }
    
    public int[][] Movpersonaje(){
        matriz[x1][y1]=pintapersonaje;
        return matriz;
    }
    
    public int Nummovimientos(){
        return nmovimientos;
    }
    
    //aumenta la cuenta de objetos tomados si corresponde a una casilla objeto
    public int Objetotomado(int objetos){
        this.objetotomado=objetos;
        if(matriz[x1][y1]==3){
            objetotomado=objetotomado+1;
        }
        return objetotomado;
    }
    //aumenta la cuenta de destinos usados si corresponde a una casilla destino
    public int Destinousdado(int destinos){
        this.destinousado=destinos;
        if((matriz[x1][y1]==4)&&(objetotomado>destinousado)){
            destinousado=destinousado+1;
            matrizentorno[x1][y1]=0;
        }
        return destinousado;
    }
    
    public int[][] Matrizentorno(){
        return matrizentorno;
    }

    //valiuda y acciona el movimiento de las vestias
    public int[][] Movbestia(int[][] matriz1,int[][] matrizentorno1,int numbestias1,int tipobestia){
        
        this.numbestias=numbestias1;
        this.mdireccion=new int[numbestias];
        this.x=new int[numbestias];
        this.y=new int[numbestias];
        this.matriz=matriz1;
        this.matrizentorno=matrizentorno1;
        this.tipobestia=tipobestia;
        
        //rellenando vector direccion de bestia que toma valor aleatorio
        
        for(c=0;c<numbestias;c++){            
            this.mdireccion[c]=(int)(Math.random()*4)+1;            
        }        
        c=0;
        //validando posicion a cada bestia
        for(int a =0;a<dim;a++){
            for(int b=0;b<dim;b++){
                if(this.matriz[a][b]==this.tipobestia){
                    
                    //arriba
                    if(((mdireccion[c]==1))&&(a!=0)){
                        if((matriz[(a-1)][b]!=2)&&(matriz[(a-1)][b]!=1)&&(matriz[(a-1)][b]!=7)
                                &&(matriz[(a-1)][b]!=8)&&(matriz[(a-1)][b]!=9)
                                &&(matriz[(a-1)][b]!=6)&&(matriz[(a-1)][b]!=5)&&(matriz[(a-1)][b]!=3)){
                            matriz[a][b]=matrizentorno[a][b];
                            x[c]=a-1;
                            y[c]=b;
                            c=c+1;}
                        else{
                            matriz[a][b]=matrizentorno[a][b];
                            x[c]=a;
                            y[c]=b;
                            c=c+1;
                        }
                    }
                    
                    //abajo
                    else if(((mdireccion[c]==2))&&(a!=(dim-1))){
                        if((matriz[(a+1)][b]!=2)&&(matriz[(a+1)][b]!=1)&&(matriz[(a+1)][b]!=7)
                                &&(matriz[(a+1)][b]!=8)&&(matriz[(a+1)][b]!=9)&&(matriz[(a+1)][b]!=6)
                                &&(matriz[(a+1)][b]!=5)&&(matriz[(a+1)][b]!=3)){
                            matriz[a][b]=matrizentorno[a][b];
                            x[c]=a+1;
                            y[c]=b;
                            c=c+1;
                        }
                        else{
                            matriz[a][b]=matrizentorno[a][b];
                            x[c]=a;
                            y[c]=b;
                            c=c+1;
                        }
                    }
                    
                    //derecha
                    else if(((mdireccion[c]==3))&&(b!=(dim-1))){
                        if((matriz[a][(b+1)]!=2)&&(matriz[a][(b+1)]!=1)&&(matriz[a][(b+1)]!=7)
                                &&(matriz[a][(b+1)]!=8)&&(matriz[a][(b+1)]!=9)&&(matriz[a][(b+1)]!=6)
                                &&(matriz[a][(b+1)]!=5)&&(matriz[a][(b+1)]!=3)){
                            matriz[a][b]=matrizentorno[a][b];
                            x[c]=a;
                            y[c]=b+1;
                            c=c+1;
                        }
                        else{
                            matriz[a][b]=matrizentorno[a][b];
                            x[c]=a;
                            y[c]=b;
                            c=c+1;
                        }
                    }
                    
                    //izquierda
                    else if(((mdireccion[c]==4))&&(b!=0)){
                        if((matriz[a][(b-1)]!=2)&&(matriz[a][(b-1)]!=1)&&(matriz[a][(b-1)]!=7)
                                &&(matriz[a][(b-1)]!=8)&&(matriz[a][(b-1)]!=9)
                                &&(matriz[(a)][(b-1)]!=6)&&(matriz[(a)][(b-1)]!=5)
                            &&(matriz[(a)][(b-1)]!=3)){
                            matriz[a][b]=matrizentorno[a][b];
                            x[c]=a;
                            y[c]=b-1;
                            c=c+1;
                        }
                        else{
                            matriz[a][b]=matrizentorno[a][b];
                            x[c]=a;
                            y[c]=b;
                            c=c+1;
                        }
                    }
                    else{
                        x[c]=a;
                        y[c]=b;
                        c=c+1;                                
                    }
                }                    
            }
        }
        //rellanando matriz con la nueva posicion de cada bestia
        for(c=0;c<numbestias;c++){
            matriz[x[c]][y[c]]=this.tipobestia;           
        }        
        return matriz;
    }

    
    public int pintadireccion(int personaje1,int direccion1){
        int personaje=personaje1;
        
    if((personaje==1)||(personaje==7)||(personaje==8)
        ||(personaje==9)){
        switch(direccion1){
            case 1:
                this.gdireccion=7;
                break;
            case 2:
                this.gdireccion=1;
                break;
            case 3:
                this.gdireccion=8;
                break;
            case 4:
                this.gdireccion=9;
                break;
        }
    }
    return gdireccion;
}
}    