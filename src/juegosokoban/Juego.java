/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juegosokoban;


import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.net.URL;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Diego Rueda y Brahian Gonzales
 */
public class Juego implements KeyListener{
    
    private Container contenidos;
    private JLabel casillas[][];
    private JLabel JLjugador;
    private JLabel JLnivel;
    private JLabel JLnummov;//numero de movimientos
    private int[][] matriz;
    private int[][] matrizentorno;
    private JPanel juego;
    private JPanel control;
    private JPanel tablero;    
    private int numdestinos;//total de destinos y objetos
    private int numbestias1;
    private int numbestias2;
    private int nmovimientos;
    private int direccion;    
    private int dim;
    private int bestia1=5;//bestia tormentosa
    private int bestia2=6;//bestia asesino letal
    private int objetotomado=0;//nunmero de objetos tomados
    private int destinousado=0;//numero de destinos usados(objetos colocados)
    private int validacion;//valida acciones al encontrarse con las bestias
    private String level;
    private int nivel;//nivel del juego
    private int continua;//valida que el juego actual sigue en curso
    private String jugador;
    private JFrame ventana;
    private Laberinto laberinto;
    private Graficos grafico;
    private Movimientos movimiento;
    private Accionjuego accion;    
    
    

    public Juego(String nivel, String jugador){        
        this.level=nivel;
        this.nivel=Nivel(nivel);
        this.jugador=jugador;
        dim=12;
        matriz=new int[dim][dim];
        matrizentorno=new int[dim][dim];
        laberinto=new Laberinto();
        Levels();
        this.Tablero();
        
    }
    
    /**convierte el nivel de String en int*/
    private int Nivel(String level){
        switch (level) {
            case "Nivel 1":
                return 1;
            case "Nivel 2":
                return 2;
            case "Nivel 3":
                return 3;
            case "Nivel 4":
                return 4;
            case "Nivel 5":
                return 5;
            case "Nivel 6":
                return 6;
            case "Nivel 7":
                return 7;
            case "Nivel 8":
                return 8;
            default:
                return 9;
        }        
    }     
    
    //crea el laberinto segun el nivel
    private void Levels(){
        
        if(this.nivel==1){
            laberinto=new Laberinto();
            this.matriz=laberinto.Nivel1();
            this.matrizentorno=laberinto.Entorno();
            this.numbestias1=Numbestias(this.bestia1);
            this.numbestias2=Numbestias(this.bestia2);
            this.numdestinos=1;
            this.nmovimientos=100;
        }
        
        if(this.nivel==2){
            laberinto=new Laberinto();
            this.matriz=laberinto.Nivel2();
            this.matrizentorno=laberinto.Entorno();
            this.numbestias1=Numbestias(this.bestia1);
            this.numbestias2=Numbestias(this.bestia2);
            this.numdestinos=1;
            this.nmovimientos=75;
        }
        
        if(this.nivel==3){
            laberinto=new Laberinto();
            this.matriz=laberinto.Nivel3();
            this.matrizentorno=laberinto.Entorno();
            this.numbestias1=Numbestias(this.bestia1);
            this.numbestias2=Numbestias(this.bestia2);
            this.numdestinos=1;
            this.nmovimientos=50;
        }
        
        if(this.nivel==4){
            laberinto=new Laberinto();
            this.matriz=laberinto.Nivel4();
            this.matrizentorno=laberinto.Entorno();
            this.numbestias1=Numbestias(this.bestia1);
            this.numbestias2=Numbestias(this.bestia2);
            this.numdestinos=2;
            this.nmovimientos=200;
        }
        
        if(this.nivel==5){
            laberinto=new Laberinto();
            this.matriz=laberinto.Nivel5();
            this.matrizentorno=laberinto.Entorno();
            this.numbestias1=Numbestias(this.bestia1);
            this.numbestias2=Numbestias(this.bestia2);
            this.numdestinos=2;
            this.nmovimientos=175;
        }
        
        if(this.nivel==6){
            laberinto=new Laberinto();
            this.matriz=laberinto.Nivel6();
            this.matrizentorno=laberinto.Entorno();
            this.numbestias1=Numbestias(this.bestia1);
            this.numbestias2=Numbestias(this.bestia2);
            this.numdestinos=2;
            this.nmovimientos=150;
        }
        
        if(this.nivel==7){
            laberinto=new Laberinto();
            this.matriz=laberinto.Nivel7();
            this.matrizentorno=laberinto.Entorno();
            this.numbestias1=Numbestias(this.bestia1);
            this.numbestias2=Numbestias(this.bestia2);
            this.numdestinos=3;
            this.nmovimientos=300;
        }
        
        if(this.nivel==8){
            laberinto=new Laberinto();
            this.matriz=laberinto.Nivel8();
            this.matrizentorno=laberinto.Entorno();
            this.numbestias1=Numbestias(this.bestia1);
            this.numbestias2=Numbestias(this.bestia2);
            this.numdestinos=3;
            this.nmovimientos=275;
        }
        
        if(this.nivel==9){
            laberinto=new Laberinto();
            this.matriz=laberinto.Nivel9();
            this.matrizentorno=laberinto.Entorno();
            this.numbestias1=Numbestias(this.bestia1);
            this.numbestias2=Numbestias(this.bestia2);
            this.numdestinos=3;
            this.nmovimientos=250;
        }        
    }
    
    //ventana con la que el jugador interactua durante el juego
    private void Tablero(){
        
        //creacion de la ventana     
        ventana = new JFrame();
        ventana.setSize(500,700);
        ventana.setLocation(200,20);
        ventana.setTitle("Laberinto"); 
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        ventana.setVisible(true);        
        ventana.setLayout(new BorderLayout());
        if((continua==1)||(continua==2)) {
            ventana.addKeyListener(null);
        }
        else {
            ventana.addKeyListener(this);
        }
        grafico = new Graficos();
        //panel que contiene los paneles tablero y control
        juego=new JPanel();
        juego.setLayout(new BorderLayout());
        
        //panel control
        control=new JPanel();        
        control.setLayout(new BorderLayout());
        JLjugador=new JLabel();//nombre del jugador
        JLjugador.setFont(new Font("Comic Sans MS", 0,14 ));
        JLjugador.setForeground(Color.BLUE);        
        JLjugador.setText("Jugador: "+this.jugador+"                    Nivel: "+this.nivel+
                "            Numero de movimientos: "+this.nmovimientos);
        control.add(JLjugador,BorderLayout.NORTH);
        JLnivel=new JLabel();//nivel
        JLnivel.setFont(new Font("Comic Sans MS", 0,14 ));
        JLnivel.setForeground(Color.BLUE);        
        JLnivel.setText("Objetos tomados: "+this.objetotomado+"/"+this.numdestinos+
                "                                        "
                + "Destinos completados: "+this.destinousado+"/"+this.numdestinos);
        control.add(JLnivel,BorderLayout.SOUTH);
        //JLnummov=new JLabel();//numero de movimientos 
        //JLnummov.setFont(new Font("Comic Sans MS", 0,14 ));
        //JLnummov.setForeground(Color.BLUE);
        //JLnummov.setText("Numero de movimientos: "+this.nmovimientos);
        //control.add(JLnummov,BorderLayout.EAST);
        
        //panel tablero grafica del juego
        tablero=new JPanel();
        tablero.setSize(500, 500);        
        casillas= new JLabel[dim][dim];        
        pintando();
        juego.add(tablero,BorderLayout.NORTH);
        juego.add(control,BorderLayout.SOUTH);
        ventana.add(juego,BorderLayout.SOUTH);
        
    }
    
    //pinta laventana(usado cada ves que se mueve el juego) 
    private void pintando(){
        for(int a=0;a<dim;a++){
            for(int b=0;b<dim;b++){                
                casillas[a][b]= new JLabel(grafico.pintar(this.matriz[a][b]));                
                tablero.add(casillas[a][b]);                
            }           
        }        
        tablero.setLayout(new GridLayout(dim,dim));
    }
    
    //identifica el numero de bestias en el laberinto
    public int Numbestias(int bestia){
        int numb=0;
        for(int a=0;a<dim;a++){
            for(int b=0;b<dim;b++){
                if(this.matriz[a][b]==bestia){
                    numb=numb+1;
                }
            }
        }
        return numb;
    }  
    
    //llama a los metodos de movimiento
    private void Movimientos(){
        movimiento.Movimiento(matriz, matrizentorno, direccion,nmovimientos);
        nmovimientos=movimiento.Nummovimientos();
        objetotomado=movimiento.Objetotomado(objetotomado);
        destinousado=movimiento.Destinousdado(destinousado);
        matriz=movimiento.Movpersonaje();
        matrizentorno=movimiento.Matrizentorno();
        matriz=movimiento.Movbestia(matriz,matrizentorno,numbestias1,5);
        matriz=movimiento.Movbestia(matriz,matrizentorno,numbestias2,6);
        
    }
    
    //llama a los metodos que generan una accion determinadad en el juego     
    //segun el caso de interaccion en el juego
    private void Acciones(){
        validacion = accion.encuentroB(matriz);
        if((objetotomado==numdestinos)&&(destinousado==numdestinos)){
            continua=2;
        }
        else if(validacion == 2){
            nmovimientos=accion.encuentroB5(nmovimientos,nivel);
            if(nmovimientos<=0) {
                continua=1;
            }
            else {
                continua=0;
            }
        }
        else if(validacion==1){
            continua=1;
        }
        else if(nmovimientos<=0) {
            continua=1;
        }
        else {
            continua=0;
        }
    }
    
    //continua o detiene el juego segun el caso
    private void Continuidad(){
        if(continua==1){
            Tablero();
            ventana.dispose();
            Perder perder=new Perder(this.jugador,this.nivel);
            perder.setVisible(true);
        }
        else if(continua==2) {
            Tablero();
            ventana.dispose();
            Ganar ganar=new Ganar(this.jugador,this.nivel);
            ganar.setVisible(true);
        }
        else {
            Tablero();
        }
    }
    
    //acciones del teclado
    @Override
    public void keyPressed(KeyEvent e){
        
        //arriva
        if(e.getKeyCode()==KeyEvent.VK_UP){
            movimiento= new Movimientos();
            accion=new Accionjuego();
            ventana.dispose();     
            direccion=1;
            Movimientos();          
            Acciones();
            Continuidad();
        }
        //abajo
        if(e.getKeyCode()==KeyEvent.VK_DOWN){
            movimiento= new Movimientos();
            accion=new Accionjuego();
            ventana.dispose();
            direccion=2;
            Movimientos();
            Acciones();
            Continuidad();
        }
        //derecha
        if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            movimiento= new Movimientos();
            accion=new Accionjuego();
            ventana.dispose();
            direccion=3;
            Movimientos();
            Acciones();
            Continuidad();
        }
        //izquierda
        if(e.getKeyCode()==KeyEvent.VK_LEFT){
            movimiento= new Movimientos();
            accion=new Accionjuego();
            ventana.dispose();
            direccion=4;
            Movimientos();
            Acciones();
            Continuidad();
        }
        
        
    }
    @Override
    public void keyTyped(KeyEvent e) {}
    
    @Override
    public void keyReleased(KeyEvent e) {} 
}