import java.io.*;   //import input and output package
import java.util.*;  // import util package for Scanner,HashSet
class TicTacToe //create a class with class name
//class name is same as java file name
{

static HashSet<Integer> ur_set = new HashSet<Integer>(); //store the unique elements of ur_set in collection 
static HashSet<Integer> comp_set = new HashSet<Integer>(); //store the unique elements of comp_set in collection 

	public static void main(String args[])//Main program
	{
		//creating a game board with 2D Array
		char [][]g_board={

			{' ','|',' ','|',' '},
		        {'-','|','-','|','-'},	
			{' ','|',' ','|',' '},
			{'-','|','-','|','-'},
			{' ','|',' ','|',' '}
	
		};

		print_board(g_board); //calling the print_board()method
		Scanner s =new Scanner(System.in); //Scanner for getting the input from the user
		while(true) //repeat until the condition becomes false
		{
			System.out.print("Enter any number from 1 to 9");//System.out.println() function is used for printing the user input
		    int user_pos=s.nextInt(); 
		    while(ur_set.contains(user_pos)||comp_set.contains(user_pos)) 
		    {
			    System.out.println("Position is already taken!,Try again");
			    System.out.print("Enter any number from 1 to 9");
			    user_pos=s.nextInt();
		    }
		    p_holder(g_board,user_pos,"You");

		    String res=check_winner();
		    if(res.length()>0)
		    {
		        System.out.println(res);
		        break;
		    }
		
                    int comp_pos=gen_random();
		    while(ur_set.contains(comp_pos)||comp_set.contains(comp_pos))
		    {
			     comp_pos=gen_random(); //computer can accessed by randomly
		    }
		    p_holder(g_board,comp_pos,"Comp");

		    res=check_winner();
		    if(res.length()>0)
		    {
		         System.out.println(res);
		         break;
		   
		    }
		}
    }
    //check the winner condition
    static String check_winner()
    {
    	
    	HashSet<Integer> r1=new HashSet<Integer>(); //for row
    	r1.add(1);r1.add(2);r1.add(3);
    	HashSet<Integer> r2=new HashSet<Integer>();
    	r2.add(4);r2.add(5);r2.add(6);
    	HashSet<Integer> r3=new HashSet<Integer>();
    	r3.add(7);r3.add(8);r3.add(9);
    	HashSet<Integer> c1=new HashSet<Integer>(); //for column
    	c1.add(1);c1.add(4);c1.add(7);
    	HashSet<Integer> c2=new HashSet<Integer>();
    	c2.add(2);c2.add(5);c2.add(8);
    	HashSet<Integer> c3=new HashSet<Integer>();
    	c3.add(3);c3.add(6);c3.add(9);
    	HashSet<Integer> d1=new HashSet<Integer>(); //for diagonal
    	d1.add(1);d1.add(5);d1.add(9);
    	HashSet<Integer> d2=new HashSet<Integer>();
    	d2.add(3);d2.add(5);d2.add(7);
        HashSet<HashSet> check=new HashSet<HashSet>(); 
        check.add(r1);check.add(r2);check.add(r3);
        check.add(c1);check.add(c2);check.add(c3);
        check.add(d1);check.add(d2);
        for(HashSet c : check)
        {
        	if(ur_set.containsAll(c)) //contaiinsAll() check whether the ur_set items already exist in HashSet
        		return "YOU WIN";
        	else if(comp_set.containsAll(c))  //contaiinsAll() check whether the comp_set items already exist in HashSet
        		return "YOU LOSE";
        }
        if(ur_set.size()+comp_set.size()==9) //size() check how many items in ur_set and comp_set in HashSet
        	return "ITS A DRAW";

        return"";
    }

    static int gen_random()
    {
	int max=9;
	int min=1;
	int range=max-min+1; //the range must be within 9

	int res = (int)(Math.random() * range)+ min; //Math.random() can be double so change tpecasting to integer
        return res;
    }
    static void print_board(char [][]g_board)
    {
       for(int r=0;r<g_board.length;r++)
       {
	  for(int c=0;c<g_board[0].length;c++)
	  {
		System.out.print(g_board[r][c]);
	  }
	  System.out.println();
	}
    }
    // filling O(zeros)and X(cross)
    static void p_holder(char [][]g_board,int pos,String user) 
    {
    	char syb='X';
    	if(user.equals("You")) //user argument check whether "You" or "Comp" can access
    	{
    		syb='X';
    		ur_set.add(pos); //add the position of user
    	}
    	else if(user.equals("Comp"))
    	{
    		syb='O';
            comp_set.add(pos); //add the position of computer

    	}
    	switch(pos)
    	{
    		case 1:
    		g_board[0][0]=syb; //place the position via an index of an array
    		break;
    		case 2:
    		g_board[0][2]=syb;
    		break;
    		case 3:
    		g_board[0][4]=syb;
    		break;
    		case 4:
    		g_board[2][0]=syb;
    		break;
    		case 5:
    		g_board[2][2]=syb;
    		break;
    		case 6:
    		g_board[2][4]=syb;
    		break;
    		case 7:
    		g_board[4][0]=syb;
    		break;
    		case 8:
    		g_board[4][2]=syb;
    		break;
    		case 9:
    		g_board[4][4]=syb;
    		break;
    		default:
    		System.out.println("Invalid Input");
    	}

    	print_board(g_board);

    }

}