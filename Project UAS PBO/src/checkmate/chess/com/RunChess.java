/*
 * Projek UAS PBO Membuat Aplikasi Berbasis OOP
 * Aplikasi			: Catur
 * Oleh				: Imam Arief Al Baihaqy
 * NIM				: 19051397006
 * Prodi/kelas 		: D4 Manajemen Informatika/2019A
 * Dosen Pembimbing : Andi Iwan Nurhidayat, S.Kom., M.T.
 * Teknik
 * Universitas Negeri Surabaya
 */

package checkmate.chess.com;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class RunChess extends JFrame implements MouseListener{
	
	public static Board board = new Board();
	public static boolean hasActive = false;//Belum meng-klik
	public static Square previousSquare = null;
	public static String pieceColor = "";
	public static Square source = null;
	public static int counter = 0;
	public static boolean oneMoved = false;
	public static boolean enableDeleteAction = false;
	public static JMenuBar menuBar = new JMenuBar();
	public static JMenu mnOptions = new JMenu("Options");
	public static JMenuItem mntmAbout = new JMenuItem("About");

//==================================== LOADING ===============================================
	public RunChess()
	{
		getContentPane().add(board);

		//Menambah bar menu
		setJMenuBar(menuBar);
		menuBar.add(mnOptions);
		mnOptions.add(mntmAbout);
		
		JMenuItem mntmSetting = new JMenuItem("Setting");
		mnOptions.add(mntmSetting);
		board.initializeChessBoard("white");
		//add the action listener of the square
		for(int i = 0; i < 8; i++)
		{
			for(int j = 0; j < 8; j++)
			{
				board.square[i][j].addMouseListener(this);
			}
		}
		//board.setColor(Color.yellow, Color.gray);
	}

//=================================== Ketika di klik proses akan dimulai ============================
	@Override
	public void mouseClicked(MouseEvent e) 
	{
		//get the reference of clicked source square 
		source = (Square) e.getSource();
		
		//if the source piece is not free then get the type and color of the piece
		if(!source.isFree())
		{
			pieceColor = source.getPiece().getColor();
		}
		
		//print to debug
		System.out.println("isActive:"+source.isActive+" isfree: "+source.isFree()+" hasActive?: "+hasActive
				+" PieceColor is: "+pieceColor);
		
		//ketika a square is clicked and is not active, not free means containing piece
		//then user can move it
		if(!source.isActive && !source.isFree())
		{
			source.isActive = true;
			hasActive = true;
			previousSquare = source;
		}
		else if(hasActive)//ketika there is an active and the clicked square is free
		{
			System.out.println("Piece type is :"+previousSquare.getPiece().getPieceType());
			String pieceType = previousSquare.getPiece().getPieceType();
			String pieceColor = previousSquare.getPiece().getColor();
			//---------------------------ketika pion di klik------------------------------------------
			//TODO Pawn does not work properly for black and white
			//if the pawn is white
			if(pieceType.equalsIgnoreCase("pawn") && pieceColor.equalsIgnoreCase("white"))
			{
				System.out.println("row number is"+previousSquare.getRow());
				//TODO whether the pawn is black or white is not clicked
				//if at initial position source's row is equal destination's row + 1 or 2 && source's column equal destination column.
				if((previousSquare.getRow() == 6 && (previousSquare.getRow() == source.getRow() + 1 || previousSquare.getRow() == source.getRow() + 2)) && previousSquare.getCol() == source.getCol())
				{
					System.out.println("move piece is called for pawn");
					movePiece();//call movePiece() method
					oneMoved = true;
				}
				//ketika is not at initial position & destination is row+1 at the same column
				else if( previousSquare.getRow() == source.getRow() + 1 && previousSquare.getCol() == source.getCol())
				{
					System.out.println("move piece is called for pawn");
					movePiece();//call movePiece() method
					oneMoved = true;
				}
				//ketika move a pawn to kill opposit's piece
				//if the row is just 1 step ahead and the piece to kill is at 1 column aside
				else if(previousSquare.getRow() == source.getRow() + 1 && Math.abs(previousSquare.getCol() - source.getCol()) == 1)
				{
					System.out.println("move piece is called for pawn");
					enableDeleteAction = true;
					movePiece();//call movePiece() method
					oneMoved = true;
				}
				else{clear();}
			}
			//else if the pawn is black
			else if(pieceType.equalsIgnoreCase("pawn") && pieceColor.equalsIgnoreCase("black"))
			{
				System.out.println("row number is"+previousSquare.getRow());
				//TODO whether the pawn is black or white is not clicked
				//if at initial position source's row is equal destination's row + 1 or 2 && source's column equal destination column.
				if((previousSquare.getRow() == 1 && (previousSquare.getRow() == source.getRow() - 1 || previousSquare.getRow() == source.getRow() - 2)) && previousSquare.getCol() == source.getCol())
				{
					System.out.println("move piece is called for pawn");
					movePiece();//call movePiece() method
					oneMoved = true;
				}
				//ketika is not at initial position & destination is row+1 at the same column
				else if( previousSquare.getRow() == source.getRow() - 1 && previousSquare.getCol() == source.getCol())
				{
					System.out.println("move piece is called for pawn");
					movePiece();//call movePiece() method
					oneMoved = true;
				}
				//ketika move a pawn to kill opposit's piece
				//if the row is just 1 step ahead and the piece to kill is at 1 column aside
				else if(previousSquare.getRow() == source.getRow() - 1 && Math.abs(previousSquare.getCol() - source.getCol()) == 1)
				{
					System.out.println("move piece is called for pawn");
					enableDeleteAction = true;
					movePiece();//call movePiece() method
					oneMoved = true;
				}
				else{clear();}
			}//End of pawn's action
			//---------------------------ketika KNIGHT di klik------------------------------------------
			else if(pieceType.equalsIgnoreCase("knight"))//ketika Knight di klik
			{
				//if source's row is equal destination's row + 1 or 2 && source's column equal destination column.
				if(		(previousSquare.getRow() == source.getRow() + 1 && previousSquare.getCol() == source.getCol() + 2)
						|| (previousSquare.getRow() == source.getRow() + 1 && previousSquare.getCol() == source.getCol() - 2)
						|| (previousSquare.getRow() == source.getRow() - 1 && previousSquare.getCol() == source.getCol() + 2)
						|| (previousSquare.getRow() == source.getRow() - 1 && previousSquare.getCol() == source.getCol() - 2)
						|| (previousSquare.getRow() == source.getRow() + 2 && previousSquare.getCol() == source.getCol() + 1)
						|| (previousSquare.getRow() == source.getRow() - 2 && previousSquare.getCol() == source.getCol() + 1)
						|| (previousSquare.getRow() == source.getRow() + 2 && previousSquare.getCol() == source.getCol() - 1)
						|| (previousSquare.getRow() == source.getRow() - 2 && previousSquare.getCol() == source.getCol() - 1)
				)
				{
					System.out.println("move piece is called for knight");
					enableDeleteAction = true;
					movePiece();//call movePiece() method
					oneMoved = true;
				}
				else{clear();}
			}//end of knight's action
			//---------------------------ketika ROOK di klik------------------------------------------
			else if(pieceType.equalsIgnoreCase("rook"))
			{
				System.out.println("prev row col "+previousSquare.getRow()+" "+previousSquare.getCol()+" \n now is "+source.getRow()+" "+source.getCol());
				//if source's row is equal destination's row + 1 or 2 && source's column equal destination column.
				if(previousSquare.getRow() == source.getRow() || previousSquare.getCol() == source.getCol())
				{
					System.out.println("move piece is called for rook");
					enableDeleteAction = true;
					movePiece();//call movePiece() method
					oneMoved = true;
				}
				else{clear();}
			}//end of rook's action
			//---------------------------ketika BISHOP di klik------------------------------------------
			else if(pieceType.equalsIgnoreCase("bishop"))
			{
				System.out.println("prev row col "+previousSquare.getRow()+" "+previousSquare.getCol()+" \n now is "+source.getRow()+" "+source.getCol());
				//if source's row is equal destination's row + 1 or 2 && source's column equal destination column.
				int rowOffset = previousSquare.getRow()- source.getRow();
				int colOffset = previousSquare.getCol() - source.getCol();
				if(Math.abs(rowOffset) == Math.abs(colOffset))
				{
					System.out.println("move piece is called for bishop");
					enableDeleteAction = true;
					movePiece();//call movePiece() method
					oneMoved = true;
				}
				else{clear();}
			}//end of bishop's action
			//---------------------------ketika QUEEN di klik------------------------------------------
			else if(pieceType.equalsIgnoreCase("queen"))
			{
				System.out.println("prev row col "+previousSquare.getRow()+" "+previousSquare.getCol()+" \n now is "+source.getRow()+" "+source.getCol());
				//if source's row is equal destination's row + 1 or 2 && source's column equal destination column.
				int rowOffset = previousSquare.getRow()- source.getRow();
				int colOffset = previousSquare.getCol() - source.getCol();
				if(	Math.abs(rowOffset) == Math.abs(colOffset) 
						|| previousSquare.getRow() == source.getRow()
						|| previousSquare.getCol() == source.getCol()
				)
				{
					System.out.println("move piece is called for queen");
					enableDeleteAction = true;
					movePiece();//call movePiece() method
					oneMoved = true;
				}
				else{clear();}
			}//end of queen's action
			//---------------------------ketika KING di klik------------------------------------------
			else if(pieceType.equalsIgnoreCase("king"))
			{
				System.out.println("prev row col "+previousSquare.getRow()+" "+previousSquare.getCol()+" \n now is "+source.getRow()+" "+source.getCol());
				//if source's row is equal destination's row + 1 or 2 && source's column equal destination column.
				int rowOffset = previousSquare.getRow()- source.getRow();
				int colOffset = previousSquare.getCol() - source.getCol();
				if(	Math.abs(rowOffset) == 1 ||  Math.abs(colOffset) == 1) 
				{
					System.out.println("move piece is called for king");
					enableDeleteAction = true;
					movePiece();//call movePiece() method
					oneMoved = true;
				}
				else{clear();}
			}//end of king's action
		}
		//source.add(board.blackPawn[0]);
		
	}

//-----------------------Move piece or replace pieces(according to condition)------------------------------------
	public void movePiece()
	{
		//System.out.println("its ok");
		if(!source.isFree() && !previousSquare.getPiece().getColor().equalsIgnoreCase(pieceColor) && enableDeleteAction)
		{
			source.remove(source.getPiece());//remove previous first the piece
			source.setPiece(null);//set the piece first as null
			enableDeleteAction = false;
		}
		source.add(previousSquare.getPiece());//add previous piece in destination square
		source.setPiece(previousSquare.getPiece());//set the piece in the destination square
		source.revalidate();
		board.repaint();//repaint the board
		hasActive = false;
		previousSquare.setStatus(true);//setting the previous as free
		previousSquare.setPiece(null);//there is no piece
		previousSquare.isActive = false;//Its no more active(di klik) now
		source.setStatus(false);//destination square is no free now
		previousSquare = null;//clear the previous square
	}
	
	public void clear()//Clear the properties for the next time
	{
		System.out.println("Piece was not moved");
		hasActive = false;
		oneMoved = false;
		enableDeleteAction = false;
		previousSquare.isActive = false;//Its no more active(di klik) now
		previousSquare = null;//clear the previous square
		source = null;
	}
//============================================== Main method ==================================================
	public static void main(String[] CHAND)
	{	
		JFrame frame = new RunChess();
		frame.setSize(700, 700);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
}

