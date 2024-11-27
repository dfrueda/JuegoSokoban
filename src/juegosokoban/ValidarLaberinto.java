/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juegosokoban;

/**
 *
//  @author Diego Rueda y Brahian Gonzales
 */

/**CLASE QUE VALIDA LA SOLUCION DEL LABERINTO ORIGINAL*/

public class ValidarLaberinto {
    
    //contadores que comprueban la cantidad de elemenetos de un tipò de elemento
    private int comp1;
    private int comp3;
    private int comp4;
    private int dim=12;
    private int[][] matriz;//matriz laberinto
    private int validacion;
    private int elemento;
    
    
    /**Comprobacion de los elementos nesesarios para un laberinto solucionable*/
    public int Validacion1(int num3,int num4,int[][] matriz1){
        comp1=0;
        comp3=0;
        comp4=0;
        this.matriz=matriz1;
        int num1=1;
        int numero3=num3;
        int numero4=num4;
         for(int a=0;a<dim;a++){
                for(int b=0;b<dim;b++){
                    if(matriz[a][b]==1){
                        comp1=comp1+1;
                    }
                    if(matriz[a][b]==3){
                        comp3=comp3+1;
                    }
                    if(matriz[a][b]==4){
                        comp4=comp4+1;
                    }
                }                
            }
            if((comp1==num1)&&(comp3==numero3)&&(comp4==numero4)){
                validacion=1;}            
            return validacion;
    }  
    
    
    /**Valida que no hallan bestias alrededor del personaje*/
    public int Validacion2(int[][] matriz1){
        this.matriz=matriz1;
        validacion=0;
        //recorre matriz
        for(int a=0;a<dim;a++){
            for(int b=0;b<dim;b++){
                
                /**casila donde esta el personaje*/
                if(matriz[a][b]==1){                    
                    //POSICION://
                    
                    /**Esquinas:*/
                    //posicion (0,0)
                    if((a==0)&&(b==0)){
                        if(((matriz[a+1][b]!=5)&&(matriz[a+1][b]!=6))&&
                                ((matriz[a][b+1]!=5)&&(matriz[a][b+1]!=6))){
                             validacion=1;
                        }
                    }
                    
                    /**posicion (0,dim-1)*/
                    else if((a==0)&&(b==(dim-1))){
                        if(((matriz[a+1][b]!=5)&&(matriz[a+1][b]!=6))&&
                                ((matriz[a][b-1]!=5)&&(matriz[a][b-1]!=6))){
                             validacion=1;
                        }
                    }
                    
                    /**posicion (dim-1,0)*/
                    else if((a==(dim-1))&&(b==0)){
                        if(((matriz[a-1][b]!=5)&&(matriz[a-1][b]!=6))&&
                                ((matriz[a][b+1]!=5)&&(matriz[a][b+1]!=6))){
                             validacion=1;
                        }
                    }
                    
                    /**posicion (dim-1,dim-1)*/
                    else if((a==(dim-1))&&(b==(dim-1))){
                        if(((matriz[a-1][b]!=5)&&(matriz[a-1][b]!=6))&&
                                ((matriz[a][b-1]!=5)&&(matriz[a][b-1]!=6))){
                             validacion=1;
                        }
                    }
                    
                    
                    /**Lados:*/
                    /**posicion (0,y)*/
                    else if(a==0){
                        if(((matriz[a+1][b]!=5)&&(matriz[a+1][b]!=6))&&
                                ((matriz[a][b+1]!=5)&&(matriz[a][b+1]!=6))&&
                                ((matriz[a][b-1]!=5)&&(matriz[a][b-1]!=6))){
                             validacion=1;
                        }
                    }
                    
                    /**posicion (dim-1,y)*/
                    else if(a==(dim-1)){
                        if(((matriz[a-1][b]!=5)&&(matriz[a-1][b]!=6))&&
                                ((matriz[a][b+1]!=5)&&(matriz[a][b+1]!=6))&&
                                ((matriz[a][b-1]!=5)&&(matriz[a][b-1]!=6))){
                             validacion=1;
                        }
                    }
                    
                    /**posicion (x,0)*/
                    else if(b==0){
                        if(((matriz[a+1][b]!=5)&&(matriz[a+1][b]!=6))&&
                                ((matriz[a-1][b]!=5)&&(matriz[a-1][b]!=6))&&
                                ((matriz[a][b+1]!=5)&&(matriz[a][b+1]!=6))){
                             validacion=1;
                        }
                    }
                    
                    /**posicion (x,(dim-1))*/
                    else if(b==(dim-1)){
                        if(((matriz[a+1][b]!=5)&&(matriz[a+1][b]!=6))&&
                                ((matriz[a-1][b]!=5)&&(matriz[a-1][b]!=6))&&
                                ((matriz[a][b-1]!=5)&&(matriz[a][b-1]!=6))){
                             validacion=1;
                        }
                    }
                    
                    
                    /**Posicion (x,y)sincontarlos lados ni esquinas*/                    
                    else{
                        if(((matriz[a+1][b]!=5)&&(matriz[a+1][b]!=6))&&
                                ((matriz[a-1][b]!=5)&&(matriz[a-1][b]!=6))&&
                                ((matriz[a][b+1]!=5)&&(matriz[a][b+1]!=6))&&
                                ((matriz[a][b-1]!=5)&&(matriz[a][b-1]!=6))){
                             validacion=1;
                        }
                    }
                }
            }
        }
    return validacion;
    }
    
    
    /**Valida que los elementos(personaje,objeto,destino) no se encuentren 
    //encerrados por paredes*/ 
    public int Validacion3(int[][] matriz1,int tipo){
        
        this.matriz=matriz1;
        this.elemento=tipo;
        validacion=0;
        
        /**recorre matriz*/
        for(int a=0;a<dim;a++){
            for(int b=0;b<dim;b++){
                
                /**casila donde esta el elemento*/
                if(matriz[a][b]==elemento){                    
                    //POSICION://
                    
                    /**Esquinas:*/
                    /**posicion (0,0)*/
                    if((a==0)&&(b==0)){
                        if((matriz[a+1][b]!=2)||(matriz[a][b+1]!=2)){
                             validacion=1;
                        }
                    }
                    
                    /**posicion (0,dim-1)*/
                    else if((a==0)||(b==(dim-1))){
                        if((matriz[a+1][b]!=2)||(matriz[a][b-1]!=2)){
                             validacion=1;
                        }
                    }
                    
                    /**posicion (dim-1,0)*/
                    else if((a==(dim-1))||(b==0)){
                        if((matriz[a-1][b]!=2)||(matriz[a][b+1]!=2)){
                             validacion=1;
                        }
                    }
                    
                    /**posicion (dim-1,dim-1)*/
                    else if((a==(dim-1))||(b==(dim-1))){
                        if((matriz[a-1][b]!=2)&&(matriz[a][b-1]!=2)){
                             validacion=1;
                        }
                    }
                    
                    
                    /**Lados:
                    //posicion (0,y)*/
                    else if(a==0){
                        if((matriz[a+1][b]!=2)||(matriz[a][b+1]!=2)||
                                (matriz[a][b-1]!=1)){
                             validacion=1;
                        }
                    }
                    
                    /**posicion (dim-1,y)*/
                    else if(a==(dim-1)){
                        if((matriz[a-1][b]!=2)||(matriz[a][b+1]!=2)||
                                (matriz[a][b-1]!=2)){
                             validacion=1;
                        }
                    }
                    
                    /**posicion (x,0)*/
                    else if(b==0){
                        if((matriz[a+1][b]!=2)||(matriz[a-1][b]!=2)||
                                (matriz[a][b+1]!=2)){
                             validacion=1;
                        }
                    }
                    
                    /**posicion (x,(dim-1))*/
                    else if(b==(dim-1)){
                        if((matriz[a+1][b]!=2)||(matriz[a-1][b]!=2)||
                                (matriz[a][b-1]!=2)){
                             validacion=1;
                        }
                    }
                    
                    
                    /**Posicion (x,y)sin contar los lados ni esquinas*/                    
                    else{
                        if((matriz[a+1][b]!=2)||(matriz[a-1][b]!=2)||
                                (matriz[a][b+1]!=2)||(matriz[a][b-1]!=2)){
                             validacion=1;
                        }
                    }
                }
            }
        }
    return validacion;
    }
}