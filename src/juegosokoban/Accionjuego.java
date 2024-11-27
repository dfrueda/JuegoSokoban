/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juegosokoban;

/**
 *
 * @author Diego Rueda y Brahian Gonzales
 */
public class Accionjuego {
    private int[][] matriz;
    private int dim=12;
    private int validacion;
    private int nmovimientos;
    private int nivel;
    
    //ACCIONES EN EL JUEGO
    
    //Encuentro con bestias
    public int encuentroB(int[][] matriz1){
        this.matriz=matriz1;
        
        for(int a=0;a<dim;a++){
            for(int b=0;b<dim;b++){
                if((matriz[a][b]==1)||((matriz[a][b]>=7)&&(matriz[a][b]<=9))){
                    //POSICION
                    //validacion=0;no hay ningun tipo de bestia alrrededor
                    //validacion=1;hay una bestia tipo asesino letal, produce perdida del juego
                    //validacion=2;hay una bestia tipo tormentosa, reduce el numero de casillas 
                    
                    //Esquinas:
                    //posicion (0,0)
                    if((a==0)&&(b==0)){
                        if((matriz[a+1][b]==6)||(matriz[a][b+1]==6)){
                             validacion=1;
                        }
                        else if((matriz[a+1][b]==5)||(matriz[a][b+1]==5)){
                             validacion=2;
                        }
                    }                    
                    //posicion (0,dim-1)
                    else if((a==0)&&(b==(dim-1))){
                        if((matriz[a+1][b]==6)||(matriz[a][b-1]==6)){
                             validacion=1;
                        }
                        else if((matriz[a+1][b]==5)||(matriz[a][b-1]==5)){
                             validacion=2;
                        }
                    }
                    
                    //posicion (dim-1,0)
                    else if((a==(dim-1))&&(b==0)){
                        if((matriz[a-1][b]==6)||(matriz[a][b+1]==6)){
                             validacion=1;
                        }
                        else if((matriz[a-1][b]==5)||(matriz[a][b+1]==5)){
                             validacion=2;
                        }
                    }
                    
                    //posicion (dim-1,dim-1)
                    else if((a==(dim-1))&&(b==(dim-1))){
                        if((matriz[a-1][b]==6)||(matriz[a][b-1]==6)){
                             validacion=1;
                        }
                        else if((matriz[a-1][b]==5)||(matriz[a][b-1]==5)){
                             validacion=2;
                        }
                    }
                    
                    
                    //Lados:
                    //posicion (0,y)
                    else if(a==0){
                        if((matriz[a+1][b]==6)||(matriz[a][b+1]==6)||(matriz[a][b-1]==6)){
                             validacion=1;
                        }
                        else if((matriz[a+1][b]==5)||(matriz[a][b+1]==5)||(matriz[a][b-1]==5)){
                             validacion=2;
                        }
                    }
                    
                    //posicion (dim-1,y)
                    else if(a==(dim-1)){
                        if((matriz[a-1][b]==6)||(matriz[a][b+1]==6)||(matriz[a][b-1]==6)){
                             validacion=1;
                        }
                        else if((matriz[a-1][b]==5)||(matriz[a][b+1]==5)||(matriz[a][b-1]==5)){
                             validacion=2;
                        }
                    }
                    
                    //posicion (x,0)
                    else if(b==0){
                        if((matriz[a+1][b]==6)||(matriz[a-1][b]==6)||(matriz[a][b+1]==6)){                                
                             validacion=1;                        
                        }
                        else if((matriz[a+1][b]==5)||(matriz[a-1][b]==5)||(matriz[a][b+1]==5)){                                
                             validacion=2;                        
                        }
                    }
                    
                    //posicion (x,(dim-1))
                    else if(b==(dim-1)){
                        if((matriz[a+1][b]==6)||(matriz[a-1][b]==6)||(matriz[a][b-1]==6)){                                
                             validacion=1;
                        }
                        else if((matriz[a+1][b]==5)||(matriz[a-1][b]==5)||(matriz[a][b-1]==5)){                                
                             validacion=2;
                        }
                    }                    
                    
                    
                    //Posicion (x,y)sincontarlos lados ni esquinas                    
                    else{
                        if((matriz[a+1][b]==6)||(matriz[a-1][b]==6)||(matriz[a][b+1]==6)||(matriz[a][b-1]==6)){
                             validacion=1;
                        }
                        else if((matriz[a+1][b]==5)||(matriz[a-1][b]==5)||(matriz[a][b+1]==5)||(matriz[a][b-1]==5)){
                             validacion=2;
                        }
                    }            
                }
            }
        }
        return validacion;
    }
    
    //Encuentro con las bestias de tipo tormentosas = bestias5
    public int encuentroB5(int nmov,int level){
        this.nmovimientos=nmov;
        this.nivel=level;
        for(int a=1;a<=9;a++){
            if(this.nivel==a){
                this.nmovimientos=this.nmovimientos-this.nivel;
            }
        }
        return this.nmovimientos;
    }
}
