package tictactoe;
import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.geom.Line2D;
import java.io.PrintStream;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GameApplet extends Applet
implements MouseListener, ActionListener, WindowListener
{
    JFrame f;
    int flag = 2;
    int n;
    int m;
    int i = 0;
    static int bug = 0;
    char[] ch = new char[9];
    JButton first;
    JButton second;
    String s1 = "";
    final static int WIDTH = 6;
    final static int HEIGHT = 6;
    final static int BOTTOM_ROW = WIDTH - 1;
    static char[][] board = new char[WIDTH][HEIGHT];
    static String winner="";
    
    public GameApplet()
    {
        this.f = new JFrame("Tic Tac Toe");
        this.first = new JButton("CLEAR");
        this.second = new JButton("EXIT");
        this.f.add(this.first);
        this.f.add(this.second);
        this.f.addWindowListener(this);
        this.f.getContentPane().setBackground(Color.gray);
        this.f.setLayout(null);
        this.f.setVisible(true);
        this.f.setSize(1190,700);
        this.f.setLocationRelativeTo(null);
        this.first.setBounds(1060, 50, 90, 60);
        this.second.setBounds(1060, 250, 90, 60);
        this.first.addActionListener(new First());
        this.second.addActionListener(new Second());
        
        this.f.addMouseListener(this);
        CreateBoard();
        
        String message = "                 Please click on the frame \n                        to start the game \n";
        
        JOptionPane pane = new JOptionPane(message);
        JDialog dialog = pane.createDialog(new JFrame(), "Dilaog");
        dialog.show();
        
       Graphics g = this.f.getGraphics();
        Graphics2D g2D =  (Graphics2D)g;
        g2D.setStroke(new BasicStroke(7));
        g2D.setColor(Color.DARK_GRAY);
        
        g2D.draw(new Line2D.Double(30,63,30,635));	
		   g2D.draw(new Line2D.Double(200,63,200,635));
		   g2D.draw(new Line2D.Double(370,63,370,635));
		   g2D.draw(new Line2D.Double(540,63,540,635));
		   g2D.draw(new Line2D.Double(710,63,710,635));
		   g2D.draw(new Line2D.Double(880,63,880,635));
		   g2D.draw(new Line2D.Double(1050,63,1050,635));
		   
		   g2D.draw(new Line2D.Double(30,60,1050,60));
		   g2D.draw(new Line2D.Double(30,140,1050,140));
		   g2D.draw(new Line2D.Double(30,240,1050,240));
		   g2D.draw(new Line2D.Double(30,340,1050,340));
		   g2D.draw(new Line2D.Double(30,440,1050,440));
		   g2D.draw(new Line2D.Double(30,540,1050,540));
		   g2D.draw(new Line2D.Double(30,640,1050,640));
	   
    }
    
    public static void CreateBoard() {
       
        for (int w = 0; WIDTH > w; w += 1) {
            for (int h = 0; HEIGHT > h; h += 1) {
                board[w][h] = '.';
            }
        }
    }
    
    public void keyPressed(KeyEvent k)
    {
        System.out.print("");
    }
    
    public void keyTyped(KeyEvent k) {
        this.s1 += k.getKeyChar();
    }
    
    public void keyReleased(KeyEvent k) {
        System.out.print("");
    }
   
    private class First implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			new GameApplet();
		}
    	
    }
    
    private class Second implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
		}
    	
    }
    
    public void actionPerformed(ActionEvent ae)
    {
   
    }
    
    public void windowClosing(WindowEvent de)
    {
    System.exit(0); }
    
    public void windowOpened(WindowEvent de) { }
    
    public void windowClosed(WindowEvent de) { }
    
    public void windowActivated(WindowEvent de) { }
    
    public void windowDeactivated(WindowEvent de) { }
    
    public void windowIconified(WindowEvent de) { }
    
    public void windowDeiconified(WindowEvent de) {  }
    
    public void mouseClicked(MouseEvent e) { Graphics2D g2;
        Graphics g = this.f.getGraphics();
        this.flag -= 1;
        int x = e.getX();
        int y = e.getY();
        
        if (this.flag == 1)
        { 
            if ((x > 30)&&(x < 200) &&(y > 57) &&(y < 139)) { this.m = 65; this.n = 65; DropO(0,0); }
            if ((x > 30)&&(x < 200)  && (y < 239)&&(y > 139)) { this.m = 65; this.n = 155; DropO(1,0); }
            if ((x > 30)&&(x < 200) && (y >239)&&(y < 339)) { this.m = 65; this.n = 250; DropO(2,0); }
            if ((x > 30)&&(x < 200) && (y < 439)&&(y > 339 )) { this.m = 65; this.n = 350; DropO(3,0); }
            if ((x > 30)&&(x < 200) && (y > 439) && (y < 539)) { this.m = 65; this.n = 450; DropO(4,0); }
            if ((x > 30)&&(x < 200) && (y > 539) && (y < 639)) { this.m = 65; this.n = 550; DropO(5,0); }
       
            if ((x > 200)&&(x < 369) &&(y > 57) &&(y < 139)) { this.m = 245; this.n = 65; DropO(0,1); }
            if ((x > 200)&&(x < 369)  && (y < 239)&&(y > 139)) { this.m = 245; this.n = 155; DropO(1,1); }
            if ((x > 200)&&(x < 369) && (y >239)&&(y < 339)) { this.m = 245; this.n = 250; DropO(2,1); }
            if ((x > 200)&&(x < 369) && (y < 439)&&(y > 339 )) { this.m = 245; this.n = 350; DropO(3,1); }
            if ((x > 200)&&(x < 369) && (y > 439) && (y < 539)) { this.m = 245; this.n = 450; DropO(4,1); }
            if ((x > 200)&&(x < 369) && (y > 539) && (y < 639)) { this.m = 245; this.n = 550; DropO(5,1); }
       
            if ((x > 369)&&(x < 539) &&(y > 57) &&(y < 139)) { this.m = 415; this.n = 65; DropO(0,2); }
            if ((x > 369)&&(x < 539)  && (y < 239)&&(y > 139)) { this.m = 415; this.n = 155; DropO(1,2); }
            if ((x > 369)&&(x < 539) && (y >239)&&(y < 339)) { this.m = 415; this.n = 250; DropO(2,2); }
            if ((x > 369)&&(x < 539) && (y < 439)&&(y > 339 )) { this.m = 415; this.n = 350; DropO(3,2); }
            if ((x > 369)&&(x < 539) && (y > 439) && (y < 539)) { this.m = 415; this.n = 450; DropO(4,2); }
            if ((x > 369)&&(x < 539) && (y > 539) && (y < 639)) { this.m = 415; this.n = 550; DropO(5,2); }
       
            if ((x > 539)&&(x < 711) &&(y > 57) &&(y < 139)) { this.m = 590; this.n = 65; DropO(0,3); }
            if ((x > 539)&&(x < 711)  && (y < 239)&&(y > 139)) { this.m = 590; this.n = 155; DropO(1,3); }
            if ((x > 539)&&(x < 711) && (y >239)&&(y < 339)) { this.m = 590; this.n = 250; DropO(2,3); }
            if ((x > 539)&&(x < 711) && (y < 439)&&(y > 339 )) { this.m = 590; this.n = 350; DropO(3,3); }
            if ((x > 539)&&(x < 711) && (y > 439) && (y < 539)) { this.m = 590; this.n = 450; DropO(4,3); }
            if ((x > 539)&&(x < 711) && (y > 539) && (y < 639)) { this.m = 590; this.n = 550;DropO(5,3); }
            
            if ((x > 711)&&(x < 881) &&(y > 57) &&(y < 139)) { this.m = 755; this.n = 65; DropO(0,4); }
            if ((x > 711)&&(x < 881)  && (y < 239)&&(y > 139)) { this.m = 755; this.n = 155; DropO(1,4); }
            if ((x > 711)&&(x < 881) && (y >239)&&(y < 339)) { this.m = 755; this.n = 250; DropO(2,4); }
            if ((x > 711)&&(x < 881) && (y < 439)&&(y > 339 )) { this.m = 755; this.n = 350; DropO(3,4); }
            if ((x > 711)&&(x < 881) && (y > 439) && (y < 539)) { this.m = 755; this.n = 450; DropO(4,4); }
            if ((x > 711)&&(x < 881) && (y > 539) && (y < 639)) { this.m = 755; this.n = 550; DropO(5,4); }
            
            if ((x > 881)&&(x < 1050) &&(y > 57) &&(y < 139)) { this.m = 930; this.n = 65; DropO(0,5); }
            if ((x > 881)&&(x < 1050)  && (y < 239)&&(y > 139)) { this.m = 930; this.n = 155; DropO(1,5); }
            if ((x > 881)&&(x < 1050)&& (y >239)&&(y < 339)) { this.m = 930; this.n = 250; DropO(2,5); }
            if ((x > 881)&&(x < 1050) && (y < 439)&&(y > 339 )) { this.m = 930; this.n = 350; DropO(3,5); }
            if ((x > 881)&&(x < 1050)&& (y > 439) && (y < 539)) { this.m = 930; this.n = 450; DropO(4,5); }
            if ((x > 881)&&(x < 1050) && (y > 539) && (y < 639)) { this.m = 930; this.n = 550; DropO(5,5); }
            
            g.setColor(new Color(77, 176, 230));
            g2 = (Graphics2D)g;
            g2.setStroke(new BasicStroke(10.0F));
            g.drawOval(this.m + 10, this.n + 10, 50,50);
        }
        
        if (this.flag == 0)
        {
            if ((x > 30)&&(x < 200) &&(y > 57) &&(y < 139)) { this.m = 65; this.n = 65; DropX(0,0); }
            if ((x > 30)&&(x < 200)  && (y < 239)&&(y > 139)) { this.m = 65; this.n = 155; DropX(1,0); }
            if ((x > 30)&&(x < 200) && (y >239)&&(y < 339)) { this.m = 65; this.n = 250; DropX(2,0); }
            if ((x > 30)&&(x < 200) && (y < 439)&&(y > 339 )) { this.m = 65; this.n = 350; DropX(3,0); }
            if ((x > 30)&&(x < 200) && (y > 439) && (y < 539)) { this.m = 65; this.n = 450; DropX(4,0); }
            if ((x > 30)&&(x < 200) && (y > 539) && (y < 639)) { this.m = 65; this.n = 550; DropX(5,0); }
       
            if ((x > 200)&&(x < 369) &&(y > 57) &&(y < 139)) { this.m = 245; this.n = 65; DropX(0,1); }
            if ((x > 200)&&(x < 369)  && (y < 239)&&(y > 139)) { this.m = 245; this.n = 155; DropX(1,1); }
            if ((x > 200)&&(x < 369) && (y >239)&&(y < 339)) { this.m = 245; this.n = 250; DropX(2,1); }
            if ((x > 200)&&(x < 369) && (y < 439)&&(y > 339 )) { this.m = 245; this.n = 350; DropX(3,1); }
            if ((x > 200)&&(x < 369) && (y > 439) && (y < 539)) { this.m = 245; this.n = 450; DropX(4,1); }
            if ((x > 200)&&(x < 369) && (y > 539) && (y < 639)) { this.m = 245; this.n = 550; DropX(5,1); }
       
            if ((x > 369)&&(x < 539) &&(y > 57) &&(y < 139)) { this.m = 415; this.n = 65; DropX(0,2); }
            if ((x > 369)&&(x < 539)  && (y < 239)&&(y > 139)) { this.m = 415; this.n = 155; DropX(1,2); }
            if ((x > 369)&&(x < 539) && (y >239)&&(y < 339)) { this.m = 415; this.n = 250; DropX(2,2); }
            if ((x > 369)&&(x < 539) && (y < 439)&&(y > 339 )) { this.m = 415; this.n = 350; DropX(3,2); }
            if ((x > 369)&&(x < 539) && (y > 439) && (y < 539)) { this.m = 415; this.n = 450; DropX(4,2); }
            if ((x > 369)&&(x < 539) && (y > 539) && (y < 639)) { this.m = 415; this.n = 550; DropX(5,2); }
       
            if ((x > 539)&&(x < 711) &&(y > 57) &&(y < 139)) { this.m = 590; this.n = 65; DropX(0,3); }
            if ((x > 539)&&(x < 711)  && (y < 239)&&(y > 139)) { this.m = 590; this.n = 155; DropX(1,3); }
            if ((x > 539)&&(x < 711) && (y >239)&&(y < 339)) { this.m = 590; this.n = 250; DropX(2,3); }
            if ((x > 539)&&(x < 711) && (y < 439)&&(y > 339 )) { this.m = 590; this.n = 350; DropX(3,3); }
            if ((x > 539)&&(x < 711) && (y > 439) && (y < 539)) { this.m = 590; this.n = 450; DropX(4,3); }
            if ((x > 539)&&(x < 711) && (y > 539) && (y < 639)) { this.m = 590; this.n = 550;DropX(5,3); }
            
            if ((x > 711)&&(x < 881) &&(y > 57) &&(y < 139)) { this.m = 755; this.n = 65; DropX(0,4); }
            if ((x > 711)&&(x < 881)  && (y < 239)&&(y > 139)) { this.m = 755; this.n = 155; DropX(1,4); }
            if ((x > 711)&&(x < 881) && (y >239)&&(y < 339)) { this.m = 755; this.n = 250; DropX(2,4); }
            if ((x > 711)&&(x < 881) && (y < 439)&&(y > 339 )) { this.m = 755; this.n = 350; DropX(3,4); }
            if ((x > 711)&&(x < 881) && (y > 439) && (y < 539)) { this.m = 755; this.n = 450; DropX(4,4); }
            if ((x > 711)&&(x < 881) && (y > 539) && (y < 639)) { this.m = 755; this.n = 550; DropX(5,4); }
            
            if ((x > 881)&&(x < 1050) &&(y > 57) &&(y < 139)) { this.m = 930; this.n = 65; DropX(0,5); }
            if ((x > 881)&&(x < 1050)  && (y < 239)&&(y > 139)) { this.m = 930; this.n = 155; DropX(1,5); }
            if ((x > 881)&&(x < 1050)&& (y >239)&&(y < 339)) { this.m = 930; this.n = 250; DropX(2,5); }
            if ((x > 881)&&(x < 1050) && (y < 439)&&(y > 339 )) { this.m = 930; this.n = 350; DropX(3,5); }
            if ((x > 881)&&(x < 1050)&& (y > 439) && (y < 539)) { this.m = 930; this.n = 450; DropX(4,5); }
            if ((x > 881)&&(x < 1050) && (y > 539) && (y < 639)) { this.m = 930; this.n = 550; DropX(5,5); }
            
            g2 = (Graphics2D)g;
            g2.setStroke(new BasicStroke(10.0F));
            g.setColor(Color.red);
            g.drawLine(this.m + 10, this.n + 13, this.m + 50, this.n + 50);
            g.drawLine(this.m + 50, this.n + 10, this.m + 10, this.n + 50);
            this.flag += 2;
        }  
    
        if(!Board.CheckO()){
            winner ="Player 1, 'O' won \n";
        	new Board().win();  	 
        }
        
        if(!Board.CheckX()){
        	winner = "Player 2, 'X' won \n";
        	new Board().win();    	  
          }

    }

    public static void DropX(int column, int column2){
        int counter = 1;
        
   if(board[column][column2] == 'X' || board[column][column2] == 'O'){
    System.out.println("This space is alraedy filled,play in another place");
   }else{
	   board[column][column2] = 'X';
          }   
   
 }    
  
    public static void DropO(int column, int column2){
         int counter = 1;

        if(board[column][column2] == 'X' || board[column][column2] == 'O'){
            System.out.println("This space is alraedy filled,play in another place");
           }else{
        	   board[column][column2] = 'O';
           }
             
    }
    
    
    public void mouseReleased(MouseEvent e)
    {
        System.out.print("");
    }
    
    public void mouseEntered(MouseEvent e)
    {
        System.out.print("");
    }
    
    public void mouseExited(MouseEvent e) {
        System.out.print("");
    }
    
    public void mousePressed(MouseEvent e) {
        System.out.print("");
    }
    
    public static void main(String[] args)
    {
        new GameApplet();
    }
}