package jstratego.logic.game;

import java.util.ArrayList;
import java.util.List;
import jstratego.logic.pieces.*;

/**
 * Field is representing a Field on the Playboard. Pieces are referenced here.
 *
 * @author sebastiangrosse
 */
public class Field {

	Piece piece;
	boolean blocked;

	public Field(Piece piece, boolean blocked) {
		this.piece = piece;
		this.blocked = blocked;
	}

	/**
	 * set a Piece-Reference to the Field, if the Field already has a Piece
	 * fightAgainst is used.
	 *
	 * @param piece
	 */
	public void setPiece(Piece piece) {
		if (this != null) {
			piece.fightAgainst(this.piece);
		}else{
			this.piece = piece;
		}
		if (piece.alive) {
			this.piece = piece;
		}
		if (!this.piece.alive && !piece.alive) {
			this.piece = null;
		}
	}
	List<Field> reachableFields(){
		List<Field> fields;
		fields = new ArrayList<Field>();
		if(this.piece.motion == Motion.MOVABLE){
			//TODO
		}
		if(this.piece.motion == Motion.SUPERMOVABLE){
			//TODO
		}
		if(this.piece.motion == Motion.UNMOVABLE){
			fields.clear();
		}
		return fields;
	}
}