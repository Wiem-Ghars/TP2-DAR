package operation;

import java.io.Serializable;

// Implémentation de Serialisable pour pouvoir être converti en fichier binaire et envoyé
public class Operation  implements Serializable{
	int op1, op2, resultat;
	char operation;
	
	public Operation(int op1, int op2, char operation) {
		super();
		this.op1 = op1;
		this.op2 = op2;
		this.operation = operation;
	}
	
	public int getOp1() {
		return op1;
	}

	public void setOp1(int op1) {
		this.op1 = op1;
	}

	public int getOp2() {
		return op2;
	}

	public void setOp2(int op2) {
		this.op2 = op2;
	}

	public char getOperation() {
		return operation;
	}

	public void setOperation(char operation) {
		this.operation = operation;
	}

	public int getResultat() {
		return resultat;
	}

	public void setResultat(int resultat) {
		this.resultat = resultat;
	}

}
