package tictactoe;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

class Board  implements WindowListener
{
    public void win()
    {
        String message = "                                    Congratulations \n"+"                                   "+GameApplet.winner+"\n"+"To exit, press 'Exit'. To start new game, press 'Clear.'";
        
        JOptionPane pane = new JOptionPane(message);
        JDialog dialog = pane.createDialog(new JFrame(), "Dilaog");
        dialog.show();
    }
    

    public static boolean CheckXHorizontal(){
        boolean flag = true;

        int counter = 0;
        while(flag){

            for(int w = 0; GameApplet.WIDTH > w; w += 1){
                for(int h = 0; GameApplet.HEIGHT > h; h += 1){
                    if(GameApplet.board[w][h] == 'X'){ 
                        counter += 1;
                    }else{
                        counter = 0; 
                    }
                    if(counter == 6){
                        System.out.println("Player 1 wins"); 
                        flag = false;
                    }
                }
            }
            break;
        }
        return flag;
    }

    public static boolean CheckXVertical(){
      
        boolean flag = true;

        int counter = 0;
        while(flag){

            for(int h = 0; GameApplet.HEIGHT > h; h += 1){
                for(int w = 0; GameApplet.WIDTH > w; w += 1){
                    if(GameApplet.board[w][h] == 'X'){ 
                        counter += 1;
                    }else{
                        counter = 0; 
                    }
                    if(counter == 6){
                        System.out.println("Player 1 wins"); 
                        flag = false;
                    }
                }
            }
            break;
        }
        return flag;
    }

    public static boolean CheckOVertical(){
       
        boolean flag = true;

        int counter = 0;
        while(flag){

            for(int h = 0; GameApplet.HEIGHT > h; h += 1){
                for(int w = 0; GameApplet.WIDTH > w; w += 1){
                    if(GameApplet.board[w][h] == 'O'){ 
                        counter += 1;
                    }else{
                        counter = 0; 
                    }
                    if(counter == 6){
                        System.out.println("Player 2 wins"); 
                        flag = false;
                    }
                }
            }
            break;
        }
        return flag;
    }

    public static boolean CheckOHorizontal(){
      
        boolean flag = true;

        int counter = 0;
        while(flag){

            for(int w = 0; GameApplet.WIDTH > w; w += 1){
                for(int h = 0; GameApplet.HEIGHT > h; h += 1){
                    if(GameApplet.board[w][h] == 'O'){ 
                        counter += 1;
                    }else{
                        counter = 0;
                    }
                    if(counter == 6){
                        System.out.println("Player 2 wins"); 
                        flag = false;
                    }
                }
            }
            break;
        }
        return flag;
    }

    public static boolean CheckXDiagonalForward(){
      
        boolean flag = true;

        int counter = 0;

        Boolean check = false;

        int checkColumn = 1;
        int checkRow = 1;

        while(flag){ 
            for(int w = 0; GameApplet.WIDTH > w; w += 1){
                for(int h = 0; GameApplet.HEIGHT > h; h += 1){
                    if(GameApplet.board[w][h] == 'X'){
                        counter += 1;
                        check = true;
                        while(check){ 
                            if(checkColumn + w <= GameApplet.WIDTH - 1&& checkRow + h <= GameApplet.HEIGHT - 1){
                                if(GameApplet.board[w + checkColumn][h + checkRow] == 'X'){ 
                                    counter += 1;
                                }
                            }

                            checkColumn += 1;
                            checkRow += 1;

                            if(checkColumn == GameApplet.WIDTH -1 || checkRow == GameApplet.HEIGHT -1){  
                            	check = false;
                                break;
                            }

                            if(counter == 6){
                                System.out.println("Player 1 wins"); 
                                check = false;
                                flag = false;
                                break;
                    
                            }
                        }
                    }
                    if(counter >= 4){
                        flag = false;
                        break;
                    }

                    counter = 0;
                    checkColumn = 1;
                    checkRow = 1;
                }
            }
            break;
        }
        return flag;
    }

    public static boolean CheckODiagonalForward(){
        
        boolean flag = true;

        int counter = 0;

        Boolean check = false;

        int checkColumn = 1;
        int checkRow = 1;

        while(flag){ 
            for(int w = 0; GameApplet.WIDTH > w; w += 1){
                for(int h = 0; GameApplet.HEIGHT > h; h += 1){
                    if(GameApplet.board[w][h] == 'O'){ 
                        counter += 1;
                        check = true;
                        while(check){ 
                            if(checkColumn + w <= GameApplet.WIDTH - 1&& checkRow + h <= GameApplet.HEIGHT - 1){
                                if(GameApplet.board[w + checkColumn][h + checkRow] == 'O'){ 
                                    counter += 1;
                                }
                            }

                            checkColumn += 1;
                            checkRow += 1;

                            if(checkColumn == GameApplet.WIDTH -1 || checkRow == GameApplet.HEIGHT -1){ 
                                check = false;
                                break;
                            }

                            if(counter == 6){
                                System.out.println("Player 2 wins");
                                check = false;
                                flag = false;
                                break;
                            }
                        }
                    }
                    if(counter >= 4){
                        flag = false;
                        break;
                    }

                    counter = 0;
                    checkColumn = 1;
                    checkRow = 1;
                }
            }
            break;
        }
        return flag;
    }

    public static boolean CheckXDiagonalBack(){
     
        boolean flag = true;

        int counter = 0;

        Boolean check = false;

        int checkColumn = 1;
        int checkRow = 1;

        while(flag){ 
            for(int w = 0; GameApplet.WIDTH > w; w += 1){
                for(int h = 0; GameApplet.HEIGHT > h; h += 1){
                    if(GameApplet.board[w][h] == 'X'){
                        counter += 1;
                        check = true;
                        while(check){ 
                            if(w - checkColumn >= 0 && h - checkRow >= 0){
                                if(GameApplet.board[w - checkColumn][h - checkRow] == 'X'){
                                    counter += 1; 
                                }
                            }

                            checkColumn += 1;
                            checkRow += 1;

                            if(checkColumn == 0 || checkRow == GameApplet.HEIGHT -1){ 
                                check = false;
                                break;
                            }

                            if(counter == 6){
                                System.out.println("Player 1 wins");
                                check = false;
                                flag = false;
                                break;
                            }
                        }
                    }
                    if(counter >= 4){
                        flag = false;
                        break;
                    }

                    counter = 0;
                    checkColumn = 1;
                    checkRow = 1;
                }
            }
            break;
        }
        return flag;
    }

    public static boolean CheckODiagonalBack(){
    
        boolean flag = true;

        int counter = 0;

        Boolean check = false;

        int checkColumn = 1;
        int checkRow = 1;

        while(flag){

            for(int w = 0; GameApplet.WIDTH > w; w += 1){
                for(int h = 0; GameApplet.HEIGHT > h; h += 1){
                    if(GameApplet.board[w][h] == 'O'){
                        counter += 1;
                        check = true;
                        while(check){
                            if(w - checkColumn >= 0 && h - checkRow >= 0){
                                if(GameApplet.board[w - checkColumn][h - checkRow] == 'O'){
                                    counter += 1; 
                                }
                            }

                            checkColumn += 1;
                            checkRow += 1;

                            if(checkColumn == 0 || checkRow == GameApplet.HEIGHT -1){ 
                                check = false;
                                break;
                            }

                            if(counter == 6){
                                System.out.println("Player 2 wins");
                                check = false;
                                flag = false;
                                break;
                            }
                        }
                    }
                    if(counter >= 4){
                        flag = false;
                        break;
                    }

                    counter = 0;
                    checkColumn = 1;
                    checkRow = 1;
                }
            }
            break;
        }
        return flag;
    }

    public static boolean CheckX(){
        boolean flag = true;
        if(!CheckXVertical() || !CheckXHorizontal()|| !CheckXDiagonalBack()|| !CheckXDiagonalForward()){
            flag = false;
        }
        return flag;
    }

    public static boolean CheckO(){
        boolean flag = true;
        if(!CheckOVertical() || !CheckOHorizontal() || !CheckODiagonalBack() || !CheckODiagonalForward()){
            flag = false;
        }
        return flag;
    }

    
    
    
    public void windowClosing(WindowEvent we)
    {
        System.exit(0);
    }
    
    public void windowOpened(WindowEvent we)
    {
    }
    
    public void windowClosed(WindowEvent we)
    {
    }
    
    public void windowActivated(WindowEvent we)
    {
    }
    
    public void windowDeactivated(WindowEvent we)
    {
    }
    
    public void windowIconified(WindowEvent we)
    {
    }
    
    public void windowDeiconified(WindowEvent we)
    {
    }
}
