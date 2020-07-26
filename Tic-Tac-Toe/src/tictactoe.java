import java.io.*;
import java.util.*;
import java.lang.*;
public class tictactoe
{
    boolean gameActive=true;
    String[] board={" "," "," "," "," "," "," "," "," "};
    int [][] winningPositions=new int[][]{{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    boolean xChance=true;
    int filled_slots=0;
    public static void main(String args[])throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        tictactoe obj=new tictactoe();
        Scanner sc = new Scanner(System.in);
        System.out.println("\nWelcome to 2 player Tic-Tac-Toe");
        System.out.println("___________");
        obj.printBoard();
        obj.game();
    }
    public void game()
    {
        Scanner sc = new Scanner(System.in);
        boolean ch=true;
        while(ch)
        {
            gameLogic();
            System.out.println("do you want to play again (y/n)");
            char c=sc.next().charAt(0);
            if(!(c=='y'||c=='Y'))
            {
                ch=false;
            }
            else
            {
                gameActive=true;
                for(int i=0;i<9;i++)
                {
                    board[i]=" ";
                }
                xChance=true;
                filled_slots=0;
            }
        }
    }
    public void gameLogic()
    {
        Scanner sc = new Scanner(System.in);
        int slot=0;
        System.out.print("player 'X' will play first.enter the slot number to place 'X' in :");
        while(filled_slots!=9&&gameActive)
        {
            try
            {
                slot = sc.nextInt() - 1;
                if(!(slot >= 0 && slot < 9))
                {
                    System.out.println("invalid input: Re-enter slot number");
                    continue;
                }
            }catch(Exception e)
            {
                System.out.println("invalid input: Re-enter slot number");
                continue;
            }
            if(board[slot].equals(" "))
            {
                filled_slots++;
                if(xChance)
                {
                    board[slot]="X";
                    xChance=false;
                }
                else
                {
                    board[slot]="O";
                    xChance=true;
                }
                printBoard();
                checkWinner();
            }
            else
            {
                System.out.println("slot already taken: re-enter slot number");
            }

        }

    }
    public void checkWinner()
    {
        for(int[] winningPosition:winningPositions)
        {
            if(board[winningPosition[0]].equals(board[winningPosition[1]])&&board[winningPosition[1]].equals(board[winningPosition[2]])
                    &&!board[winningPosition[0]].equals(" "))
            {
                if(xChance)
                {
                    System.out.println("----Cogratulations player 'O' you won----\nThanks for playing");
                }
                else
                {
                    System.out.println("----Cogratulations player 'X' you won----\nThanks for playing");
                }
                gameActive=false;
            }
        }
        if(filled_slots==9&&gameActive)
        {
            gameActive=false;
            System.out.println("Its a DRAW thanks for playing");
        }
        else if(gameActive)
        {
            if(xChance)
            {
                System.out.println("'X' turn: enter a slot number to place 'X' in");
            }
            else
            {
                System.out.println("'O' turn: enter a slot number to place 'O' in");
            }
        }
    }
    public void printBoard()
    {
        System.out.println("┌-----------┐");
        System.out.println("| "+board[0]+" | "+board[1]+" | "+board[2]+" | ");
        System.out.println("|-----------|");
        System.out.println("| "+board[3]+" | "+board[4]+" | "+board[5]+" | ");
        System.out.println("|-----------|");
        System.out.println("| "+board[6]+" | "+board[7]+" | "+board[8]+" | ");
        System.out.println("└-----------┘");
    }
}