package com.kosta.snake;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
class Snake{
public int direction=3;
int length=2;
int snakeX[]=new int[100];
int snakeY[]=new int[100];

public Snake(int x0,int y0,int x1,int y1){
snakeX[0]=x0;
snakeY[0]=y0;
snakeX[1]=x1;
snakeY[1]=y1;
}
public void move(){
for(int d=length;d>0;d--){
snakeX[d]=snakeX[d-1];
snakeY[d]=snakeY[d-1];
if(direction==0) snakeX[0]++;
if(direction==1) snakeY[0]++;
if(direction==2) snakeX[0]--;
if(direction==3) snakeY[0]--;
}

}

}

class App extends JPanel implements ActionListener{
public static final int SCALE=32;
public static final int WIDTH=20;
public static final int HEIGHT=20;
Snake s;
static final int SPEED=1;
Timer t=new Timer(1000/SPEED,this);

    public App() {
        s=new Snake(10,10,9,10);
        t.start();
        addKeyListener(new KeyBoard());
    }

//public void actionPerformed(ActionEvent arg0){
//s.move();
//repaint();
//}
    int x1;
    int y1;
//    String s="";
    public void draw(int x,int y,String string){
//     s=string;   
     x1=x;
     y1=y;
    }
    public void paint(Graphics g){
//        int x1=43;
//        int y1=129;
//        String s="*";
//        g.drawString(s, x1, y1);
	g.setColor(color(5,50,10));
	g.fillRect(0,0,WIDTH*SCALE,HEIGHT*SCALE);
        g.setColor(color(255,216,0));
for(int xx=0;xx<=WIDTH*SCALE;xx+=SCALE){
g.drawLine(xx,0,xx,WIDTH*SCALE);
}
for(int yy=0;yy<=HEIGHT*SCALE;yy+=SCALE){
g.drawLine(0,yy,WIDTH*SCALE,yy);
}
for(int d=0;d<s.length;d++){
g.setColor(color(20,30,150));
g.fillRect(s.snakeX[d]*SCALE+1,s.snakeY[d]*SCALE+1,SCALE-1,SCALE+1);
}

    }
public Color color(int red,int green,int blue){
return new Color(red,green,blue);
    
}

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
       s.move();
        repaint();
    }
private class KeyBoard extends KeyAdapter{
public void keyPressed(KeyEvent kEvt){
int key=kEvt.getKeyCode();
if(key==KeyEvent.VK_RIGHT) s.direction=0;
else if(key==KeyEvent.VK_LEFT) s.direction=2;
else if(key==KeyEvent.VK_DOWN) s.direction=1;
else if(key==KeyEvent.VK_UP) s.direction=3;
}
}

}


class Main  {
public static final int SCALE=32;
public static final int WIDTH=20;
public static final int HEIGHT=20;

public static void main(String args[]){
SwingUtilities.invokeLater(new Runnable(){
public void run(){
JFrame f=new JFrame();
f.add(new App());

//App a=new App();
//a.draw(43,129,"#");
//App b=new App();
//a.draw(43, 129, "*");
f.setVisible(true);
f.setSize(WIDTH*SCALE,HEIGHT*SCALE);
f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

});
        }
}

