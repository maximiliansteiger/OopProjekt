package spaceinvaders;

import processing.core.*;
//import processing.sound.*;
public class Processing extends PApplet {

// spaceship
    PImage spaceship;
    int y;
    int x;
// enemy 
    PImage enemy;
    int z;
    int w;

PImage laser;


//score
    int scoreX = 100;
    int scoreY = 100;
    int scoreX1 = 100;
    int scoreY1 = 100;
    int xSpeed;


// is shot
boolean isShot = false;

//score
boolean cntup = false;
int cnt = 0;


    @Override
    public void settings() {
        size(1900, 900);
    }

    @Override
    public void setup() {
        background(0);
        spaceship = loadImage("images/space2.png");
        x = 800;
        y = 700;
        xSpeed = 3;
        
        enemy = loadImage("images/space3.png");
        z = 800;
        w = 200;

      laser = loadImage("images/laser.png");
      
    }

/**
displays the score
*/
    public void Score() {
        textSize(50);
        text("Score: "+cnt, scoreX, scoreY);
         
    }

    @Override
    public void draw() {

    System.out.println("X"+x+"Y"+y);



//move left
        if (keyPressed && keyCode == LEFT) {
            x -= 5;
            background(0);
        }

//move right
        if (keyPressed && keyCode == RIGHT) {
            x += 5;
            background(0);
        }

//  move to the other side 
        if (x >= 1600) {
            x = 1;
        }
        if (x <= 0) {
            x = 1500;
        }

// shoot
        if (keyPressed && key == 32) {
            int bulletX1 = x;
            int bulletX2 = 100;
            int bulletY1 = y;
            int bulletY2 = 200;
            
           for(int i = y; i>0; i--){
                  //bullet
                delay(1);
                //rect(x+70,i,10,100); 
                image(laser,x+70,i,10,100);
                System.out.println(i);
               // background(0);
            }
            if(x+70 > z && x+70 < z+140){
                isShot = true;
                cntup = true;
            }
           
           
        }

        if(isShot){
            image(enemy, z-1000, w-1000, 0, 0);
           // background(0);
          
            if(cntup){
                cnt++;
                cntup = false;
            }
            
            
        }else{
            image(enemy, z, w, 140, 100);
        }
        Score(); 
        image(spaceship, x, y, 150, 150);
        

    }

    public void bullet(){
        //int bulletX1 = x;
        //int bulletX2 = 100;

        //int bulletY1 = y;
        //int bulletY2 = 200;
   
    }




}
