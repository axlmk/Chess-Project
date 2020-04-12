package model.board;

import model.Army;
import model.Coordinates;
import model.character.Character;

@SuppressWarnings("serial")
public class BoardChess extends Board {
	
    private Cell cells[][] = null;
	private int sideWidthsNb;
	
	public BoardChess() {
		super(BoardShape.CHESS);
		this.boardShape = BoardShape.CHESS;
		this.sideWidthsNb = 8;
		this.cells = new Cell[sideWidthsNb][sideWidthsNb];

		for(int i = 0; i < sideWidthsNb; i++) {
			for(int j = 0; j < sideWidthsNb; j++) {
				cells[i][j] = new Cell(CellType.CLASSIC, new Coordinates(i, j));				
			}
		}
	}
	
	public Cell getACell(Coordinates coord) {
		int x = coord.getX(), y = coord.getY();
		if(x >= 0 && x < sideWidthsNb && y >= 0 && y < sideWidthsNb) {
			return cells[x][y];
		} return null;
	}
	
	public int getWidthsNb() {
		return sideWidthsNb;
	}
	
	public BoardShape getBoardShape() {
		return boardShape;
	}
	
	public void loadCharacters(Army[] armies) {
		Character chara;
		for(int i = 0; i < armies.length; i++) {
			for(int j = 0; (chara = armies[i].getCharacter(j)) != null; j++) {
				chara.getCell(this).setCharacter(chara);
			}
		}
	}
	

}