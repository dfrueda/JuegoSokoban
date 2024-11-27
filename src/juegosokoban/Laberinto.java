
package juegosokoban;

import java.util.Random;

/**
 *
 * @author Diego Rueda y Brahian Gonzales
 */
public class Laberinto{
    //CORESPONDENCIA DE TIPO DE ELEMENTOS EN NUMERO
    
    //NUMERO 0 = pasto
    //NUMERO 1 = personaje
    //NUMERO 2 = muro
    //NUMERO 3 = objeto
    //NUMERO 4 = destino
    //NUMERO 5 = bestia1(bestia tormentosa)
    //NUMERO 6 = bestia2(bestia asesino letal)
    
    
    private int dim=12;
    private int validar;//valida la posicion de un elemento
    
    //instancias numero maximo por elemento
    private int num0;//total pasto(no utilizada)
    private int num1=1;//total personaje
    private int num2=(dim*3);//total muros
    private int num3;//total objetos
    private int num4;//total destinos
    public int num5;//total bestias1
    public int num6;//total bestias2
    
    //instancias contador de numero de elementos
    private int cont0;//contador pasto(no utilizada)
    private int cont1;//contador personaje
    private int cont2;//contador muros
    private int cont3;//contador objetos
    private int cont4;//contador destinos
    private int cont5;//contador bestias1
    private int cont6;//contador bestias2
    
    //instancias posicion de los elementos segun el contador
    private int posicion0;//posicion pasto(no utilizada)
    private int posicion1=(int) (Math.random()*20);//posicion personaje
    private int posicion2;//contador muros(no utilizada)
    private int posicion3a;//posicion objetos num1
    private int posicion3b;//posicion objetos num2
    private int posicion3c;//posicion objetos num3
    private int posicion4a;//posicion destinos num1
    private int posicion4b;//posicion destinos num2
    private int posicion4c;//posicion destinos num3
    private int posicion5a;//posicion bestias1 num1
    private int posicion5b;//posicion bestias1 num2
    private int posicion5c;//posicion bestias1 num3
    private int posicion6a;//posicion bestias2 num1
    private int posicion6b;//posicion bestias2 num2
    private int posicion6c;//posicion bestias2 num3
    
    //instancias comprobacion de los elementos nesesarios para un laberinto solucionable(contadores de elementos)
    private int comp1;
    private int comp3;
    private int comp4;
    private int[] compbestias;//comprueva que dos bestias5 no tenga el mismo numero de posicion en el contador
    
    
    //instancias que validan la solucion del laberinto    
    private int validacion1;
    private int validacion2;
    private int validacion3;
    private int validacion4;
    private int validacion5;
    
    //instancias matrizes y vectores
    private int[][] matriz;//laberinto
    private int[][] matrizentorno;//enrtorno del laberinto    
    
    //instancias de posicion
    int x;
    int y;    
    private ValidarLaberinto valida;

    public int[][] Nivel1 (){        
        //ASIGANCION DE VALORES A ELEMENTOS QUE DEPENDEN DEL NIVEL
        do{        
    
        //Tamaño de las matrizes
        this.matriz=new int[dim][dim];
        this.matrizentorno=new int[dim][dim];
        
        //numero de elementos por tipo de elementos
        this.num3=1;
        this.num4=1;
        this.num5=1;
        this.num6=1;
        
        //posicion del elemento segun el contador
        posicion3a=(int)(Math.random()*20);
        posicion4a=(int)(Math.random()*20);         
        posicion5a=(int)(Math.random()*20);
        posicion6a=(int)(Math.random()*20);
         
        
        //iniciando contadores
        cont0=0;//contador pasto
        cont1=0;//contador personaje
        cont2=0;//contador muros
        cont3=0;//contador objetos
        cont4=0;//contador destinos
        cont5=0;//contador bestias1
        cont6=0;//contador bestias2       
        
        
        //CREACION DEL LABERINTO : RELLENANDO MATRIZES        
            for(int a=0;a<dim;a++){
                for(int b=0;b<dim;b++){                    
                    do{
                        
                        matriz[a][b]=(int) (Math.random()*9);//numero aleatorio que ocupara dicho puesto en la matriz
                        
                        //pasto
                        if(matriz[a][b]==0||(matriz[a][b]>6&&matriz[a][b]<=9)){
                            matriz[a][b]=0;
                            this.matrizentorno[a][b]=0;
                            validar=0;
                        }
                        
                        //personaje
                        else if((matriz[a][b]==1)){                        

                            if(cont1==posicion1){
                                cont1=cont1+1;
                                this.matrizentorno[a][b]=0;
                                validar=0;}
                            else{
                                cont1=cont1+1;
                                validar=1;
                            }
                        }
                        
                        //muro
                        else if((matriz[a][b]==2)&&(cont2<num2)){
                            this.matrizentorno[a][b]=2;
                            cont2=cont2+1;
                            validar=0;
                        }
                        
                        //objeto                        
                        else if((matriz[a][b]==3)){                            
                            if((cont3==posicion3a)){
                                this.matrizentorno[a][b]=0;
                                cont3=cont3+1;                                    
                                validar=0;}
                            else{
                                cont3=cont3+1;
                                validar=1;}                            
                        }
                        
                        //destino
                        else if((matriz[a][b]==4)){                            
                            if(cont4==posicion4a){
                                this.matrizentorno[a][b]=4;
                                cont4=cont4+1;                                    
                                validar=0;}
                            else{
                                cont4=cont4+1;
                                validar=1;}                            
                        }
                        
                        //bestia1
                        else if((matriz[a][b]==5)){                            
                            if((cont5==posicion5a)){
                                cont5=cont5+1;                                
                                this.matrizentorno[a][b]=0;
                                validar=0;}
                            else{
                                cont5=cont5+1;
                                validar=1;}                            
                        }
                        
                        //bestia2
                        else if((matriz[a][b]==6)){                            
                            if((cont6==posicion6a)){
                                this.matrizentorno[a][b]=0;
                                cont6=cont6+1;                                
                                validar=0;}
                            else{
                                cont6=cont6+1;
                                validar=1;}                            
                        }
                        
                        //escojer nuevo numero para la casilla
                        else {
                            validar=1;
                        }

                        }while(validar==1);

                        System.out.print(matriz[a][b]+" ");
                }
                System.out.println();
            }
            System.out.println();
            
            
            //METODOS QUE VALIDAN LA SOLUCION DEL LABERINTO
            valida= new ValidarLaberinto();
            
            //Comprobacion de los elementos nesesarios para un laberinto solucionable
            validacion1=valida.Validacion1(num3, num4, matriz);
            
            //Comprueba la no existencia de mounstros alrrededor del personaje
            validacion2=valida.Validacion2(matriz);
            
            //Comprueba que el personaje no este rodeado de paredes
            validacion3=valida.Validacion3(matriz, 1);
            
            //Comprueba que el objeto no este rodeado de paredes
            validacion4=valida.Validacion3(matriz, 3);
            
            //Comprueba que el destino no este rodeado de paredes
            validacion5=valida.Validacion3(matriz, 4);
        }while((validacion1!=1)||(validacion2!=1)||(validacion3!=1)
                ||(validacion4!=1)||(validacion5!=1));       
        
        return matriz; 
    }
    
    public int[][] Nivel2(){        
        //ASIGANCION DE VALORES A ELEMENTOS QUE DEPENDEN DEL NIVEL
        do{        
    
        //Tamaño de las matrizes
        this.matriz=new int[dim][dim];
        this.matrizentorno=new int[dim][dim];
        
        //numero de elementos por tipo de elementos
        this.num3=1;
        this.num4=1;
        this.num5=2;
        this.num6=2;
        
        //posicion del elemento segun el contador
        posicion3a=(int)(Math.random()*20);
        posicion4a=(int)(Math.random()*20);
        
        do{
        posicion5a=(int)(Math.random()*20);
        posicion5b=(int)(Math.random()*20);
        }while(posicion5a==posicion5b);
        
        do{
        posicion6a=(int)(Math.random()*20);
        posicion6b=(int)(Math.random()*20);
         }while(posicion6a==posicion6b);
        
        
        //iniciando contadores
        cont0=0;//contador pasto
        cont1=0;//contador personaje
        cont2=0;//contador muros
        cont3=0;//contador objetos
        cont4=0;//contador destinos
        cont5=0;//contador bestias1
        cont6=0;//contador bestias2       
        
        
        //CREACION DEL LABERINTO : RELLENANDO MATRIZES        
            for(int a=0;a<dim;a++){
                for(int b=0;b<dim;b++){                    
                    do{
                        
                        matriz[a][b]=(int) (Math.random()*9);//numero aleatorio que ocupara dicho puesto en la matriz
                        
                        //pasto
                        if(matriz[a][b]==0||(matriz[a][b]>6&&matriz[a][b]<=9)){
                            matriz[a][b]=0;
                            this.matrizentorno[a][b]=0;
                            validar=0;
                        }
                        
                        //personaje
                        else if((matriz[a][b]==1)){             

                            if(cont1==posicion1){
                                cont1=cont1+1;
                                this.matrizentorno[a][b]=0;
                                validar=0;}
                            else{
                                cont1=cont1+1;
                                validar=1;
                            }
                        }
                        
                        //muro
                        else if((matriz[a][b]==2)&&(cont2<num2)){
                            this.matrizentorno[a][b]=2;
                            cont2=cont2+1;
                            validar=0;
                        }
                        
                        //objeto                        
                        else if((matriz[a][b]==3)){                            
                            if((cont3==posicion3a)){
                                this.matrizentorno[a][b]=0;
                                cont3=cont3+1;                                    
                                validar=0;}
                            else{
                                cont3=cont3+1;
                                validar=1;}                            
                        }
                        
                        //destino
                        else if((matriz[a][b]==4)){                            
                            if(cont4==posicion4a){
                                this.matrizentorno[a][b]=4;
                                cont4=cont4+1;                                    
                                validar=0;}
                            else{
                                cont4=cont4+1;
                                validar=1;}                            
                        }
                        
                        //bestia1
                        else if((matriz[a][b]==5)){                            
                            if((cont5==posicion5a)||(cont5==posicion5b)){
                                cont5=cont5+1;                                
                                this.matrizentorno[a][b]=0;
                                validar=0;}
                            else{
                                cont5=cont5+1;
                                validar=1;}                            
                        }
                        
                        //bestia2
                        else if((matriz[a][b]==6)){                            
                            if((cont6==posicion6a)||(cont6==posicion6b)){
                                this.matrizentorno[a][b]=0;
                                cont6=cont6+1;                                
                                validar=0;}
                            else{
                                cont6=cont6+1;
                                validar=1;}                            
                        }
                        
                        //escojer nuevo numero para la casilla
                        else {
                            validar=1;
                        }

                        }while(validar==1);

                        System.out.print(matriz[a][b]+" ");
                }
                System.out.println();
            }
            System.out.println();
            
            
            //METODOS QUE VALIDAN LA SOLUCION DEL LABERINTO
            valida= new ValidarLaberinto();
            
            //Comprobacion de los elementos nesesarios para un laberinto solucionable
            validacion1=valida.Validacion1(num3, num4, matriz);
            
            //Comprueba la no existencia de mounstros alrrededor del personaje
            validacion2=valida.Validacion2(matriz);
            
            //Comprueba que el personaje no este rodeado de paredes
            validacion3=valida.Validacion3(matriz, 1);
            
            //Comprueba que el objeto no este rodeado de paredes
            validacion4=valida.Validacion3(matriz, 3);
            
            //Comprueba que el destino no este rodeado de paredes
            validacion5=valida.Validacion3(matriz, 4);
        }while((validacion1!=1)||(validacion2!=1)||(validacion3!=1)
                ||(validacion4!=1)||(validacion5!=1));       
        
        return matriz; 
    }
    
    public int[][] Nivel3(){        
        //ASIGANCION DE VALORES A ELEMENTOS QUE DEPENDEN DEL NIVEL
        do{        
    
        //Tamaño de las matrizes
        this.matriz=new int[dim][dim];
        this.matrizentorno=new int[dim][dim];
        
        //numero de elementos por tipo de elementos
        this.num3=1;
        this.num4=1;
        this.num5=3;
        this.num6=3;
        
        //posicion del elemento segun el contador
        posicion3a=(int)(Math.random()*20);
        posicion4a=(int)(Math.random()*20);
        
        do{
        posicion5a=(int)(Math.random()*20);
        posicion5b=(int)(Math.random()*20);
        posicion5c=(int)(Math.random()*20);
        }while((posicion5a==posicion5b)||(posicion5a==posicion5c)
                ||(posicion5b==posicion5c));
        
        do{
        posicion6a=(int)(Math.random()*20);
        posicion6b=(int)(Math.random()*20);
        posicion6c=(int)(Math.random()*20);
         }while((posicion6a==posicion6b)||(posicion6a==posicion6c)
                ||(posicion6b==posicion6c));
        
        
        //iniciando contadores
        cont0=0;//contador pasto
        cont1=0;//contador personaje
        cont2=0;//contador muros
        cont3=0;//contador objetos
        cont4=0;//contador destinos
        cont5=0;//contador bestias1
        cont6=0;//contador bestias2       
        
        
        //CREACION DEL LABERINTO : RELLENANDO MATRIZES        
            for(int a=0;a<dim;a++){
                for(int b=0;b<dim;b++){                    
                    do{
                        
                        matriz[a][b]=(int) (Math.random()*9);//numero aleatorio que ocupara dicho puesto en la matriz
                        
                        //pasto
                        if(matriz[a][b]==0||(matriz[a][b]>6&&matriz[a][b]<=9)){
                            matriz[a][b]=0;
                            this.matrizentorno[a][b]=0;
                            validar=0;
                        }
                        
                        //personaje
                        else if((matriz[a][b]==1)){             

                            if(cont1==posicion1){
                                cont1=cont1+1;
                                this.matrizentorno[a][b]=0;
                                validar=0;}
                            else{
                                cont1=cont1+1;
                                validar=1;
                            }
                        }
                        
                        //muro
                        else if((matriz[a][b]==2)&&(cont2<num2)){
                            this.matrizentorno[a][b]=2;
                            cont2=cont2+1;
                            validar=0;
                        }
                        
                        //objeto                        
                        else if((matriz[a][b]==3)){                            
                            if((cont3==posicion3a)){
                                this.matrizentorno[a][b]=0;
                                cont3=cont3+1;                                    
                                validar=0;}
                            else{
                                cont3=cont3+1;
                                validar=1;}                            
                        }
                        
                        //destino
                        else if((matriz[a][b]==4)){                            
                            if(cont4==posicion4a){
                                this.matrizentorno[a][b]=4;
                                cont4=cont4+1;                                    
                                validar=0;}
                            else{
                                cont4=cont4+1;
                                validar=1;}                            
                        }
                        
                        //bestia1
                        else if((matriz[a][b]==5)){                            
                            if((cont5==posicion5a)||(cont5==posicion5b)||
                                    (cont5==posicion5c)){
                                cont5=cont5+1;                                
                                this.matrizentorno[a][b]=0;
                                validar=0;}
                            else{
                                cont5=cont5+1;
                                validar=1;}                            
                        }
                        
                        //bestia2
                        else if((matriz[a][b]==6)){                            
                            if((cont6==posicion6a)||(cont6==posicion6b)||
                                    (cont6==posicion6c)){
                                this.matrizentorno[a][b]=0;
                                cont6=cont6+1;                                
                                validar=0;}
                            else{
                                cont6=cont6+1;
                                validar=1;}                            
                        }
                        
                        //escojer nuevo numero para la casilla
                        else {
                            validar=1;
                        }

                        }while(validar==1);

                        System.out.print(matriz[a][b]+" ");
                }
                System.out.println();
            }
            System.out.println();
            
            
            //METODOS QUE VALIDAN LA SOLUCION DEL LABERINTO
            valida= new ValidarLaberinto();
            
            //Comprobacion de los elementos nesesarios para un laberinto solucionable
            validacion1=valida.Validacion1(num3, num4, matriz);
            
            //Comprueba la no existencia de mounstros alrrededor del personaje
            validacion2=valida.Validacion2(matriz);
            
            //Comprueba que el personaje no este rodeado de paredes
            validacion3=valida.Validacion3(matriz, 1);
            
            //Comprueba que el objeto no este rodeado de paredes
            validacion4=valida.Validacion3(matriz, 3);
            
            //Comprueba que el destino no este rodeado de paredes
            validacion5=valida.Validacion3(matriz, 4);
        }while((validacion1!=1)||(validacion2!=1)||(validacion3!=1)
                ||(validacion4!=1)||(validacion5!=1));       
        
        return matriz; 
    }
    
    public int[][] Nivel4(){        
        //ASIGANCION DE VALORES A ELEMENTOS QUE DEPENDEN DEL NIVEL
        do{        
    
        //Tamaño de las matrizes
        this.matriz=new int[dim][dim];
        this.matrizentorno=new int[dim][dim];
        
        //numero de elementos por tipo de elementos
        this.num3=2;
        this.num4=2;
        this.num5=1;
        this.num6=1;
        
        //posicion del elemento segun el contador
        //posicion objetivos
        do{
        posicion3a=(int)(Math.random()*20);
        posicion3b=(int)(Math.random()*20);
        }while(posicion3a==posicion3b);
        
        //posicion destinos
        do{
        posicion4a=(int)(Math.random()*20);
        posicion4b=(int)(Math.random()*20);
        }while(posicion4a==posicion4b);
        
        posicion5a=(int)(Math.random()*20);
        posicion6a=(int)(Math.random()*20);
         
        
        //iniciando contadores
        cont0=0;//contador pasto
        cont1=0;//contador personaje
        cont2=0;//contador muros
        cont3=0;//contador objetos
        cont4=0;//contador destinos
        cont5=0;//contador bestias1
        cont6=0;//contador bestias2       
        
        
        //CREACION DEL LABERINTO : RELLENANDO MATRIZES        
            for(int a=0;a<dim;a++){
                for(int b=0;b<dim;b++){                    
                    do{
                        
                        matriz[a][b]=(int) (Math.random()*9);//numero aleatorio que ocupara dicho puesto en la matriz
                        
                        //pasto
                        if(matriz[a][b]==0||(matriz[a][b]>6&&matriz[a][b]<=9)){
                            matriz[a][b]=0;
                            this.matrizentorno[a][b]=0;
                            validar=0;
                        }
                        
                        //personaje
                        else if((matriz[a][b]==1)){                        

                            if(cont1==posicion1){
                                cont1=cont1+1;
                                this.matrizentorno[a][b]=0;
                                validar=0;}
                            else{
                                cont1=cont1+1;
                                validar=1;
                            }
                        }
                        
                        //muro
                        else if((matriz[a][b]==2)&&(cont2<num2)){
                            this.matrizentorno[a][b]=2;
                            cont2=cont2+1;
                            validar=0;
                        }
                        
                        //objeto                        
                        else if((matriz[a][b]==3)){                            
                            if((cont3==posicion3a)||(cont3==posicion3b)){
                                this.matrizentorno[a][b]=0;
                                cont3=cont3+1;                                    
                                validar=0;}
                            else{
                                cont3=cont3+1;
                                validar=1;}                            
                        }
                        
                        //destino
                        else if((matriz[a][b]==4)){                            
                            if((cont4==posicion4a)||(cont4==posicion4b)){
                                this.matrizentorno[a][b]=4;
                                cont4=cont4+1;                                    
                                validar=0;}
                            else{
                                cont4=cont4+1;
                                validar=1;}                            
                        }
                        
                        //bestia1
                        else if((matriz[a][b]==5)){                            
                            if((cont5==posicion5a)){
                                cont5=cont5+1;                                
                                this.matrizentorno[a][b]=0;
                                validar=0;}
                            else{
                                cont5=cont5+1;
                                validar=1;}                            
                        }
                        
                        //bestia2
                        else if((matriz[a][b]==6)){                            
                            if((cont6==posicion6a)){
                                this.matrizentorno[a][b]=0;
                                cont6=cont6+1;                                
                                validar=0;}
                            else{
                                cont6=cont6+1;
                                validar=1;}                            
                        }
                        
                        //escojer nuevo numero para la casilla
                        else {
                            validar=1;
                        }

                        }while(validar==1);

                        System.out.print(matriz[a][b]+" ");
                }
                System.out.println();
            }
            System.out.println();
            
            
            //METODOS QUE VALIDAN LA SOLUCION DEL LABERINTO
            valida= new ValidarLaberinto();
            
            //Comprobacion de los elementos nesesarios para un laberinto solucionable
            validacion1=valida.Validacion1(num3, num4, matriz);
            
            //Comprueba la no existencia de mounstros alrrededor del personaje
            validacion2=valida.Validacion2(matriz);
            
            //Comprueba que el personaje no este rodeado de paredes
            validacion3=valida.Validacion3(matriz, 1);
            
            //Comprueba que el objeto no este rodeado de paredes
            validacion4=valida.Validacion3(matriz, 3);
            
            //Comprueba que el destino no este rodeado de paredes
            validacion5=valida.Validacion3(matriz, 4);
        }while((validacion1!=1)||(validacion2!=1)||(validacion3!=1)
                ||(validacion4!=1)||(validacion5!=1));       
        
        return matriz; 
    }
    
    public int[][] Nivel5(){        
        //ASIGANCION DE VALORES A ELEMENTOS QUE DEPENDEN DEL NIVEL
        do{        
    
        //Tamaño de las matrizes
        this.matriz=new int[dim][dim];
        this.matrizentorno=new int[dim][dim];
        
        //numero de elementos por tipo de elementos
        this.num3=2;
        this.num4=2;
        this.num5=2;
        this.num6=2;
        
        //posicion del elemento segun el contador
        //posicion objetivos
        do{
        posicion3a=(int)(Math.random()*20);
        posicion3b=(int)(Math.random()*20);
        }while(posicion3a==posicion3b);
        
        //posicion destinos
        do{
        posicion4a=(int)(Math.random()*20);
        posicion4b=(int)(Math.random()*20);
        }while(posicion4a==posicion4b);
        
        do{
        posicion5a=(int)(Math.random()*20);
        posicion5b=(int)(Math.random()*20);
        }while(posicion5a==posicion5b);
        
        do{
        posicion6a=(int)(Math.random()*20);
        posicion6b=(int)(Math.random()*20);
         }while(posicion6a==posicion6b);
         
        
        //iniciando contadores
        cont0=0;//contador pasto
        cont1=0;//contador personaje
        cont2=0;//contador muros
        cont3=0;//contador objetos
        cont4=0;//contador destinos
        cont5=0;//contador bestias1
        cont6=0;//contador bestias2       
        
        
        //CREACION DEL LABERINTO : RELLENANDO MATRIZES        
            for(int a=0;a<dim;a++){
                for(int b=0;b<dim;b++){                    
                    do{
                        
                        matriz[a][b]=(int) (Math.random()*9);//numero aleatorio que ocupara dicho puesto en la matriz
                        
                        //pasto
                        if(matriz[a][b]==0||(matriz[a][b]>6&&matriz[a][b]<=9)){
                            matriz[a][b]=0;
                            this.matrizentorno[a][b]=0;
                            validar=0;
                        }
                        
                        //personaje
                        else if((matriz[a][b]==1)){                        

                            if(cont1==posicion1){
                                cont1=cont1+1;
                                this.matrizentorno[a][b]=0;
                                validar=0;}
                            else{
                                cont1=cont1+1;
                                validar=1;
                            }
                        }
                        
                        //muro
                        else if((matriz[a][b]==2)&&(cont2<num2)){
                            this.matrizentorno[a][b]=2;
                            cont2=cont2+1;
                            validar=0;
                        }
                        
                        //objeto                        
                        else if((matriz[a][b]==3)){                            
                            if((cont3==posicion3a)||(cont3==posicion3b)){
                                this.matrizentorno[a][b]=0;
                                cont3=cont3+1;                                    
                                validar=0;}
                            else{
                                cont3=cont3+1;
                                validar=1;}                            
                        }
                        
                        //destino
                        else if((matriz[a][b]==4)){                            
                            if((cont4==posicion4a)||(cont4==posicion4b)){
                                this.matrizentorno[a][b]=4;
                                cont4=cont4+1;                                    
                                validar=0;}
                            else{
                                cont4=cont4+1;
                                validar=1;}                            
                        }
                        
                        //bestia1
                        else if((matriz[a][b]==5)){                            
                            if((cont5==posicion5a)||(cont5==posicion5b)){
                                cont5=cont5+1;                                
                                this.matrizentorno[a][b]=0;
                                validar=0;}
                            else{
                                cont5=cont5+1;
                                validar=1;}                            
                        }
                        
                        //bestia2
                        else if((matriz[a][b]==6)){                            
                            if((cont6==posicion6a)||(cont6==posicion6b)){
                                this.matrizentorno[a][b]=0;
                                cont6=cont6+1;                                
                                validar=0;}
                            else{
                                cont6=cont6+1;
                                validar=1;}                            
                        }
                        
                        //escojer nuevo numero para la casilla
                        else {
                            validar=1;
                        }

                        }while(validar==1);

                        System.out.print(matriz[a][b]+" ");
                }
                System.out.println();
            }
            System.out.println();
            
            
            //METODOS QUE VALIDAN LA SOLUCION DEL LABERINTO
            valida= new ValidarLaberinto();
            
            //Comprobacion de los elementos nesesarios para un laberinto solucionable
            validacion1=valida.Validacion1(num3, num4, matriz);
            
            //Comprueba la no existencia de mounstros alrrededor del personaje
            validacion2=valida.Validacion2(matriz);
            
            //Comprueba que el personaje no este rodeado de paredes
            validacion3=valida.Validacion3(matriz, 1);
            
            //Comprueba que el objeto no este rodeado de paredes
            validacion4=valida.Validacion3(matriz, 3);
            
            //Comprueba que el destino no este rodeado de paredes
            validacion5=valida.Validacion3(matriz, 4);
        }while((validacion1!=1)||(validacion2!=1)||(validacion3!=1)
                ||(validacion4!=1)||(validacion5!=1));       
        
        return matriz; 
    }
    
    public int[][] Nivel6(){        
        //ASIGANCION DE VALORES A ELEMENTOS QUE DEPENDEN DEL NIVEL
        do{        
    
        //Tamaño de las matrizes
        this.matriz=new int[dim][dim];
        this.matrizentorno=new int[dim][dim];
        
        //numero de elementos por tipo de elementos
        this.num3=2;
        this.num4=2;
        this.num5=3;
        this.num6=3;
        
        //posicion del elemento segun el contador
        //posicion objetivos
        do{
        posicion3a=(int)(Math.random()*20);
        posicion3b=(int)(Math.random()*20);
        }while(posicion3a==posicion3b);
        
        //posicion destinos
        do{
        posicion4a=(int)(Math.random()*20);
        posicion4b=(int)(Math.random()*20);
        }while(posicion4a==posicion4b);
        
        do{
        posicion5a=(int)(Math.random()*20);
        posicion5b=(int)(Math.random()*20);
        posicion5c=(int)(Math.random()*20);
        }while((posicion5a==posicion5b)||(posicion5a==posicion5c)
                ||(posicion5b==posicion5c));
        
        do{
        posicion6a=(int)(Math.random()*20);
        posicion6b=(int)(Math.random()*20);
        posicion6c=(int)(Math.random()*20);
         }while((posicion6a==posicion6b)||(posicion6a==posicion6c)
                ||(posicion6b==posicion6c));
         
        
        //iniciando contadores
        cont0=0;//contador pasto
        cont1=0;//contador personaje
        cont2=0;//contador muros
        cont3=0;//contador objetos
        cont4=0;//contador destinos
        cont5=0;//contador bestias1
        cont6=0;//contador bestias2       
        
        
        //CREACION DEL LABERINTO : RELLENANDO MATRIZES        
            for(int a=0;a<dim;a++){
                for(int b=0;b<dim;b++){                    
                    do{
                        
                        matriz[a][b]=(int) (Math.random()*9);//numero aleatorio que ocupara dicho puesto en la matriz
                        
                        //pasto
                        if(matriz[a][b]==0||(matriz[a][b]>6&&matriz[a][b]<=9)){
                            matriz[a][b]=0;
                            this.matrizentorno[a][b]=0;
                            validar=0;
                        }
                        
                        //personaje
                        else if((matriz[a][b]==1)){                        

                            if(cont1==posicion1){
                                cont1=cont1+1;
                                this.matrizentorno[a][b]=0;
                                validar=0;}
                            else{
                                cont1=cont1+1;
                                validar=1;
                            }
                        }
                        
                        //muro
                        else if((matriz[a][b]==2)&&(cont2<num2)){
                            this.matrizentorno[a][b]=2;
                            cont2=cont2+1;
                            validar=0;
                        }
                        
                        //objeto                        
                        else if((matriz[a][b]==3)){                            
                            if((cont3==posicion3a)||(cont3==posicion3b)){
                                this.matrizentorno[a][b]=0;
                                cont3=cont3+1;                                    
                                validar=0;}
                            else{
                                cont3=cont3+1;
                                validar=1;}                            
                        }
                        
                        //destino
                        else if((matriz[a][b]==4)){                            
                            if((cont4==posicion4a)||(cont4==posicion4b)){
                                this.matrizentorno[a][b]=4;
                                cont4=cont4+1;                                    
                                validar=0;}
                            else{
                                cont4=cont4+1;
                                validar=1;}                            
                        }
                        
                        //bestia1
                        else if((matriz[a][b]==5)){                            
                            if((cont5==posicion5a)||(cont5==posicion5b)||
                                    (cont5==posicion5c)){
                                cont5=cont5+1;                                
                                this.matrizentorno[a][b]=0;
                                validar=0;}
                            else{
                                cont5=cont5+1;
                                validar=1;}                            
                        }
                        
                        //bestia2
                        else if((matriz[a][b]==6)){                            
                            if((cont6==posicion6a)||(cont6==posicion6b)||
                                    (cont6==posicion6c)){
                                this.matrizentorno[a][b]=0;
                                cont6=cont6+1;                                
                                validar=0;}
                            else{
                                cont6=cont6+1;
                                validar=1;}                            
                        }
                        
                        //escojer nuevo numero para la casilla
                        else {
                            validar=1;
                        }

                        }while(validar==1);

                        System.out.print(matriz[a][b]+" ");
                }
                System.out.println();
            }
            System.out.println();
            
            
            //METODOS QUE VALIDAN LA SOLUCION DEL LABERINTO
            valida= new ValidarLaberinto();
            
            //Comprobacion de los elementos nesesarios para un laberinto solucionable
            validacion1=valida.Validacion1(num3, num4, matriz);
            
            //Comprueba la no existencia de mounstros alrrededor del personaje
            validacion2=valida.Validacion2(matriz);
            
            //Comprueba que el personaje no este rodeado de paredes
            validacion3=valida.Validacion3(matriz, 1);
            
            //Comprueba que el objeto no este rodeado de paredes
            validacion4=valida.Validacion3(matriz, 3);
            
            //Comprueba que el destino no este rodeado de paredes
            validacion5=valida.Validacion3(matriz, 4);
        }while((validacion1!=1)||(validacion2!=1)||(validacion3!=1)
                ||(validacion4!=1)||(validacion5!=1));       
        
        return matriz; 
    }
    
    public int[][] Nivel7(){        
        //ASIGANCION DE VALORES A ELEMENTOS QUE DEPENDEN DEL NIVEL
        do{        
    
        //Tamaño de las matrizes
        this.matriz=new int[dim][dim];
        this.matrizentorno=new int[dim][dim];
        
        //numero de elementos por tipo de elementos
        this.num3=3;
        this.num4=3;
        this.num5=1;
        this.num6=1;
        
        //posicion del elemento segun el contador
        //posicion objetivos
        do{
        posicion3a=(int)(Math.random()*20);
        posicion3b=(int)(Math.random()*20);
        posicion3c=(int)(Math.random()*20);
        }while((posicion3a==posicion3b)||(posicion3a==posicion3c)
                ||(posicion3b==posicion3c));
        
        //posicion destinos
        do{
        posicion4a=(int)(Math.random()*20);
        posicion4b=(int)(Math.random()*20);
        posicion4c=(int)(Math.random()*20);
        }while((posicion4a==posicion4b)||(posicion4a==posicion4c)
                ||(posicion4b==posicion4c));
        
        posicion5a=(int)(Math.random()*20);
        posicion6a=(int)(Math.random()*20);
         
        
        //iniciando contadores
        cont0=0;//contador pasto
        cont1=0;//contador personaje
        cont2=0;//contador muros
        cont3=0;//contador objetos
        cont4=0;//contador destinos
        cont5=0;//contador bestias1
        cont6=0;//contador bestias2       
        
        
        //CREACION DEL LABERINTO : RELLENANDO MATRIZES        
            for(int a=0;a<dim;a++){
                for(int b=0;b<dim;b++){                    
                    do{
                        
                        matriz[a][b]=(int) (Math.random()*9);//numero aleatorio que ocupara dicho puesto en la matriz
                        
                        //pasto
                        if(matriz[a][b]==0||(matriz[a][b]>6&&matriz[a][b]<=9)){
                            matriz[a][b]=0;
                            this.matrizentorno[a][b]=0;
                            validar=0;
                        }
                        
                        //personaje
                        else if((matriz[a][b]==1)){                        

                            if(cont1==posicion1){
                                cont1=cont1+1;
                                this.matrizentorno[a][b]=0;
                                validar=0;}
                            else{
                                cont1=cont1+1;
                                validar=1;
                            }
                        }
                        
                        //muro
                        else if((matriz[a][b]==2)&&(cont2<num2)){
                            this.matrizentorno[a][b]=2;
                            cont2=cont2+1;
                            validar=0;
                        }
                        
                        //objeto                        
                        else if((matriz[a][b]==3)){                            
                            if((cont3==posicion3a)||(cont3==posicion3b)||
                                    (cont3==posicion3c)){
                                this.matrizentorno[a][b]=0;
                                cont3=cont3+1;                                    
                                validar=0;}
                            else{
                                cont3=cont3+1;
                                validar=1;}                            
                        }
                        
                        //destino
                        else if((matriz[a][b]==4)){                            
                            if((cont4==posicion4a)||(cont4==posicion4b)||
                                    (cont4==posicion4c)){
                                this.matrizentorno[a][b]=4;
                                cont4=cont4+1;                                    
                                validar=0;}
                            else{
                                cont4=cont4+1;
                                validar=1;}                            
                        }
                        
                        //bestia1
                        else if((matriz[a][b]==5)){                            
                            if((cont5==posicion5a)){
                                cont5=cont5+1;                                
                                this.matrizentorno[a][b]=0;
                                validar=0;}
                            else{
                                cont5=cont5+1;
                                validar=1;}                            
                        }
                        
                        //bestia2
                        else if((matriz[a][b]==6)){                            
                            if((cont6==posicion6a)){
                                this.matrizentorno[a][b]=0;
                                cont6=cont6+1;                                
                                validar=0;}
                            else{
                                cont6=cont6+1;
                                validar=1;}                            
                        }
                        
                        //escojer nuevo numero para la casilla
                        else {
                            validar=1;
                        }

                        }while(validar==1);

                        System.out.print(matriz[a][b]+" ");
                }
                System.out.println();
            }
            System.out.println();
            
            
            //METODOS QUE VALIDAN LA SOLUCION DEL LABERINTO
            valida= new ValidarLaberinto();
            
            //Comprobacion de los elementos nesesarios para un laberinto solucionable
            validacion1=valida.Validacion1(num3, num4, matriz);
            
            //Comprueba la no existencia de mounstros alrrededor del personaje
            validacion2=valida.Validacion2(matriz);
            
            //Comprueba que el personaje no este rodeado de paredes
            validacion3=valida.Validacion3(matriz, 1);
            
            //Comprueba que el objeto no este rodeado de paredes
            validacion4=valida.Validacion3(matriz, 3);
            
            //Comprueba que el destino no este rodeado de paredes
            validacion5=valida.Validacion3(matriz, 4);
        }while((validacion1!=1)||(validacion2!=1)||(validacion3!=1)
                ||(validacion4!=1)||(validacion5!=1));       
        
        return matriz; 
    }
    
    public int[][] Nivel8(){        
        //ASIGANCION DE VALORES A ELEMENTOS QUE DEPENDEN DEL NIVEL
        do{        
    
        //Tamaño de las matrizes
        this.matriz=new int[dim][dim];
        this.matrizentorno=new int[dim][dim];
        
        //numero de elementos por tipo de elementos
        this.num3=3;
        this.num4=3;
        this.num5=2;
        this.num6=2;
        
        //posicion del elemento segun el contador
        //posicion objetivos
        do{
        posicion3a=(int)(Math.random()*20);
        posicion3b=(int)(Math.random()*20);
        posicion3c=(int)(Math.random()*20);
        }while((posicion3a==posicion3b)||(posicion3a==posicion3c)
                ||(posicion3b==posicion3c));
        
        //posicion destinos
        do{
        posicion4a=(int)(Math.random()*20);
        posicion4b=(int)(Math.random()*20);
        posicion4c=(int)(Math.random()*20);
        }while((posicion4a==posicion4b)||(posicion4a==posicion4c)
                ||(posicion4b==posicion4c));
        
        do{
        posicion5a=(int)(Math.random()*20);
        posicion5b=(int)(Math.random()*20);
        }while(posicion5a==posicion5b);
        
        do{
        posicion6a=(int)(Math.random()*20);
        posicion6b=(int)(Math.random()*20);
         }while(posicion6a==posicion6b);
         
        
        //iniciando contadores
        cont0=0;//contador pasto
        cont1=0;//contador personaje
        cont2=0;//contador muros
        cont3=0;//contador objetos
        cont4=0;//contador destinos
        cont5=0;//contador bestias1
        cont6=0;//contador bestias2       
        
        
        //CREACION DEL LABERINTO : RELLENANDO MATRIZES        
            for(int a=0;a<dim;a++){
                for(int b=0;b<dim;b++){                    
                    do{
                        
                        matriz[a][b]=(int) (Math.random()*9);//numero aleatorio que ocupara dicho puesto en la matriz
                        
                        //pasto
                        if(matriz[a][b]==0||(matriz[a][b]>6&&matriz[a][b]<=9)){
                            matriz[a][b]=0;
                            this.matrizentorno[a][b]=0;
                            validar=0;
                        }
                        
                        //personaje
                        else if((matriz[a][b]==1)){                        

                            if(cont1==posicion1){
                                cont1=cont1+1;
                                this.matrizentorno[a][b]=0;
                                validar=0;}
                            else{
                                cont1=cont1+1;
                                validar=1;
                            }
                        }
                        
                        //muro
                        else if((matriz[a][b]==2)&&(cont2<num2)){
                            this.matrizentorno[a][b]=2;
                            cont2=cont2+1;
                            validar=0;
                        }
                        
                        //objeto                        
                        else if((matriz[a][b]==3)){                            
                            if((cont3==posicion3a)||(cont3==posicion3b)||
                                    (cont3==posicion3c)){
                                this.matrizentorno[a][b]=0;
                                cont3=cont3+1;                                    
                                validar=0;}
                            else{
                                cont3=cont3+1;
                                validar=1;}                            
                        }
                        
                        //destino
                        else if((matriz[a][b]==4)){                            
                            if((cont4==posicion4a)||(cont4==posicion4b)||
                                    (cont4==posicion4c)){
                                this.matrizentorno[a][b]=4;
                                cont4=cont4+1;                                    
                                validar=0;}
                            else{
                                cont4=cont4+1;
                                validar=1;}                            
                        }
                        
                        //bestia1
                        else if((matriz[a][b]==5)){                            
                            if((cont5==posicion5a)||(cont5==posicion5b)){
                                cont5=cont5+1;                                
                                this.matrizentorno[a][b]=0;
                                validar=0;}
                            else{
                                cont5=cont5+1;
                                validar=1;}                            
                        }
                        
                        //bestia2
                        else if((matriz[a][b]==6)){                            
                            if((cont6==posicion6a)||(cont6==posicion6b)){
                                this.matrizentorno[a][b]=0;
                                cont6=cont6+1;                                
                                validar=0;}
                            else{
                                cont6=cont6+1;
                                validar=1;}                            
                        }
                        
                        //escojer nuevo numero para la casilla
                        else {
                            validar=1;
                        }

                        }while(validar==1);

                        System.out.print(matriz[a][b]+" ");
                }
                System.out.println();
            }
            System.out.println();
            
            
            //METODOS QUE VALIDAN LA SOLUCION DEL LABERINTO
            valida= new ValidarLaberinto();
            
            //Comprobacion de los elementos nesesarios para un laberinto solucionable
            validacion1=valida.Validacion1(num3, num4, matriz);
            
            //Comprueba la no existencia de mounstros alrrededor del personaje
            validacion2=valida.Validacion2(matriz);
            
            //Comprueba que el personaje no este rodeado de paredes
            validacion3=valida.Validacion3(matriz, 1);
            
            //Comprueba que el objeto no este rodeado de paredes
            validacion4=valida.Validacion3(matriz, 3);
            
            //Comprueba que el destino no este rodeado de paredes
            validacion5=valida.Validacion3(matriz, 4);
        }while((validacion1!=1)||(validacion2!=1)||(validacion3!=1)
                ||(validacion4!=1)||(validacion5!=1));       
        
        return matriz; 
    }
    
    public int[][] Nivel9(){        
        //ASIGANCION DE VALORES A ELEMENTOS QUE DEPENDEN DEL NIVEL
        do{        
    
        //Tamaño de las matrizes
        this.matriz=new int[dim][dim];
        this.matrizentorno=new int[dim][dim];
        
        //numero de elementos por tipo de elementos
        this.num3=3;
        this.num4=3;
        this.num5=3;
        this.num6=3;
        
        //posicion del elemento segun el contador
        //posicion objetivos
        do{
        posicion3a=(int)(Math.random()*20);
        posicion3b=(int)(Math.random()*20);
        posicion3c=(int)(Math.random()*20);
        }while((posicion3a==posicion3b)||(posicion3a==posicion3c)
                ||(posicion3b==posicion3c));
        
        //posicion destinos
        do{
        posicion4a=(int)(Math.random()*20);
        posicion4b=(int)(Math.random()*20);
        posicion4c=(int)(Math.random()*20);
        }while((posicion4a==posicion4b)||(posicion4a==posicion4c)
                ||(posicion4b==posicion4c));
        
        do{
        posicion5a=(int)(Math.random()*20);
        posicion5b=(int)(Math.random()*20);
        posicion5c=(int)(Math.random()*20);
        }while((posicion5a==posicion5b)||(posicion5a==posicion5c)
                ||(posicion5b==posicion5c));
        
        do{
        posicion6a=(int)(Math.random()*20);
        posicion6b=(int)(Math.random()*20);
        posicion6c=(int)(Math.random()*20);
         }while((posicion6a==posicion6b)||(posicion6a==posicion6c)
                ||(posicion6b==posicion6c));
         
        
        //iniciando contadores
        cont0=0;//contador pasto
        cont1=0;//contador personaje
        cont2=0;//contador muros
        cont3=0;//contador objetos
        cont4=0;//contador destinos
        cont5=0;//contador bestias1
        cont6=0;//contador bestias2       
        
        
        //CREACION DEL LABERINTO : RELLENANDO MATRIZES        
            for(int a=0;a<dim;a++){
                for(int b=0;b<dim;b++){                    
                    do{
                        
                        matriz[a][b]=(int) (Math.random()*9);//numero aleatorio que ocupara dicho puesto en la matriz
                        
                        //pasto
                        if(matriz[a][b]==0||(matriz[a][b]>6&&matriz[a][b]<=9)){
                            matriz[a][b]=0;
                            this.matrizentorno[a][b]=0;
                            validar=0;
                        }
                        
                        //personaje
                        else if((matriz[a][b]==1)){                        

                            if(cont1==posicion1){
                                cont1=cont1+1;
                                this.matrizentorno[a][b]=0;
                                validar=0;}
                            else{
                                cont1=cont1+1;
                                validar=1;
                            }
                        }
                        
                        //muro
                        else if((matriz[a][b]==2)&&(cont2<num2)){
                            this.matrizentorno[a][b]=2;
                            cont2=cont2+1;
                            validar=0;
                        }
                        
                        //objeto                        
                        else if((matriz[a][b]==3)){                            
                            if((cont3==posicion3a)||(cont3==posicion3b)||
                                    (cont3==posicion3c)){
                                this.matrizentorno[a][b]=0;
                                cont3=cont3+1;                                    
                                validar=0;}
                            else{
                                cont3=cont3+1;
                                validar=1;}                            
                        }
                        
                        //destino
                        else if((matriz[a][b]==4)){                            
                            if((cont4==posicion4a)||(cont4==posicion4b)||
                                    (cont4==posicion4c)){
                                this.matrizentorno[a][b]=4;
                                cont4=cont4+1;                                    
                                validar=0;}
                            else{
                                cont4=cont4+1;
                                validar=1;}                            
                        }
                        
                        //bestia1
                        else if((matriz[a][b]==5)){                            
                            if((cont5==posicion5a)||(cont5==posicion5b)||
                                    (cont5==posicion5c)){
                                cont5=cont5+1;                                
                                this.matrizentorno[a][b]=0;
                                validar=0;}
                            else{
                                cont5=cont5+1;
                                validar=1;}                            
                        }
                        
                        //bestia2
                        else if((matriz[a][b]==6)){                            
                            if((cont6==posicion5a)||(cont6==posicion6b)||
                                    (cont6==posicion6c)){
                                this.matrizentorno[a][b]=0;
                                cont6=cont6+1;                                
                                validar=0;}
                            else{
                                cont6=cont6+1;
                                validar=1;}                            
                        }
                        
                        //escojer nuevo numero para la casilla
                        else {
                            validar=1;
                        }

                        }while(validar==1);

                        System.out.print(matriz[a][b]+" ");
                }
                System.out.println();
            }
            System.out.println();
            
            
            //METODOS QUE VALIDAN LA SOLUCION DEL LABERINTO
            valida= new ValidarLaberinto();
            
            //Comprobacion de los elementos nesesarios para un laberinto solucionable
            validacion1=valida.Validacion1(num3, num4, matriz);
            
            //Comprueba la no existencia de mounstros alrrededor del personaje
            validacion2=valida.Validacion2(matriz);
            
            //Comprueba que el personaje no este rodeado de paredes
            validacion3=valida.Validacion3(matriz, 1);
            
            //Comprueba que el objeto no este rodeado de paredes
            validacion4=valida.Validacion3(matriz, 3);
            
            //Comprueba que el destino no este rodeado de paredes
            validacion5=valida.Validacion3(matriz, 4);
        }while((validacion1!=1)||(validacion2!=1)||(validacion3!=1)
                ||(validacion4!=1)||(validacion5!=1));       
        
        return matriz; 
    }
       
    //metodo que devuelve entorno del laberinto : matrizentorno
    public int[][] Entorno(){
        return matrizentorno;
    }
}
