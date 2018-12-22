package lexical_analyzer;

import java.util.Vector;
public class Token_Table {//记录符号表
	public Vector<Token> tokens;
	Token_Table(){
		tokens = new Vector<Token>();
		tokens.add(new Token("CONST_ID","PI",3.1415926,"NULL"));
		tokens.add(new Token("CONST_ID","E",2.71828,"NULL"));
        tokens.add(new Token("T","T",0.0,"NULL"));
        tokens.add(new Token("FUNC","SIN",0.0,"sin"));
        tokens.add(new Token("FUNC","COS",0.0,"cos"));
        tokens.add(new Token("FUNC","TAN",0.0,"tan"));
        tokens.add(new Token("FUNC","LN",0.0,"log"));
        tokens.add(new Token("FUNC","EXP",0.0,"exp"));
        tokens.add(new Token("FUNC","SQRT",0.0,"sqrt"));
        tokens.add(new Token("ORIGIN","ORIGIN",0.0,"NULL"));
        tokens.add(new Token("SCALE","SCALE",0.0,"NULL"));
        tokens.add(new Token("ROT","ROT",0.0,"NULL"));
        tokens.add(new Token("IS","IS",0.0,"NULL"));
        tokens.add(new Token("FOR","FOR",0.0,"NULL"));
        tokens.add(new Token("FROM","FROM",0.0,"NULL"));
        tokens.add(new Token("TO","TO",0.0,"NULL"));
        tokens.add(new Token("STEP","STEP",0.0,"NULL"));
        tokens.add(new Token("DRAW","DRAW",0.0,"NULL"));
        tokens.add(new Token("ERRORTOKEN","ERRORTOKEN",0.0,"NULL"));
        tokens.add(new Token("COMMENT","//",0.0,"NULL"));
        tokens.add(new Token("COMMENT","--",0.0,"NULL"));
        tokens.add(new Token("SEMICO",";",0.0,"NULL"));
        tokens.add(new Token("L_BRACKET","(",0.0,"NULL"));
        tokens.add(new Token("R_BRACKET",")",0.0,"NULL"));
        tokens.add(new Token("COMMA",",",0.0,"NULL"));
        tokens.add(new Token("PLUS","+",0.0,"NULL"));
        tokens.add(new Token("MINUS","-",0.0,"NULL"));
        tokens.add(new Token("MUL","*",0.0,"NULL"));
        tokens.add(new Token("DIV","/",0.0,"NULL"));
        tokens.add(new Token("POWER","**",0.0,"NULL"));
        tokens.add(new Token("SETCOLOR","SETCOLOR",0.0,"SETCOLOR"));
        tokens.add(new Token("COLOR","RED",0.0,"NULL"));
        tokens.add(new Token("COLOR","YELLOW",0.0,"NULL"));
        tokens.add(new Token("COLOR","BLUE",0.0,"NULL"));
        tokens.add(new Token("COLOR","GREEN",0.0,"NULL"));
        tokens.add(new Token("COLOR","BLACK",0.0,"NULL"));
		
	}
    
    public Token test(String a){
        if (a.equalsIgnoreCase("PI")) return tokens.elementAt(0);
        else if (a.equalsIgnoreCase("E")) return tokens.elementAt(1);
        else if (a.equalsIgnoreCase("T")) return tokens.elementAt(2);
        else if (a.equalsIgnoreCase("SIN")) return tokens.elementAt(3);
        else if (a.equalsIgnoreCase("cos")) return tokens.elementAt(4);
        else if (a.equalsIgnoreCase("tan")) return tokens.elementAt(5);
        else if (a.equalsIgnoreCase("ln")) return tokens.elementAt(6);
        else if (a.equalsIgnoreCase("exp")) return tokens.elementAt(7);
        else if (a.equalsIgnoreCase("sqrt")) return tokens.elementAt(8);
        else if (a.equalsIgnoreCase("origin")) return tokens.elementAt(9);
        else if (a.equalsIgnoreCase("scale")) return tokens.elementAt(10);
        else if (a.equalsIgnoreCase("rot")) return tokens.elementAt(11);
        else if (a.equalsIgnoreCase("is")) return tokens.elementAt(12);
        else if (a.equalsIgnoreCase("for")) return tokens.elementAt(13);
        else if (a.equalsIgnoreCase("from")) return tokens.elementAt(14);
        else if (a.equalsIgnoreCase("to")) return tokens.elementAt(15);
        else if (a.equalsIgnoreCase("step")) return tokens.elementAt(16);
        else if (a.equalsIgnoreCase("draw")) return tokens.elementAt(17);
        else if (a.equalsIgnoreCase("//")) return tokens.elementAt(19);
        else if (a.equalsIgnoreCase("--")) return tokens.elementAt(20);
        else if (a.equalsIgnoreCase(";")) return tokens.elementAt(21);
        else if (a.equalsIgnoreCase("(")) return tokens.elementAt(22);
        else if (a.equalsIgnoreCase(")")) return tokens.elementAt(23);
        else if (a.equalsIgnoreCase(",")) return tokens.elementAt(24);
        else if (a.equalsIgnoreCase("+")) return tokens.elementAt(25);
        else if (a.equalsIgnoreCase("-")) return tokens.elementAt(26);
        else if (a.equalsIgnoreCase("*")) return tokens.elementAt(27);
        else if (a.equalsIgnoreCase("/")) return tokens.elementAt(28);
        else if (a.equalsIgnoreCase("**")) return tokens.elementAt(29);
        else if (a.equalsIgnoreCase("setcolor")) return tokens.elementAt(30);
        else if (a.equalsIgnoreCase("red")) return tokens.elementAt(31);
        else if (a.equalsIgnoreCase("yellow")) return tokens.elementAt(32);
        else if (a.equalsIgnoreCase("blue")) return tokens.elementAt(33);
        else if (a.equalsIgnoreCase("green")) return tokens.elementAt(34);
        else if (a.equalsIgnoreCase("black")) return tokens.elementAt(35);
        else if (Character.isDigit(a.charAt(0))) return new Token("CONST_ID",a,Double.parseDouble(a),"NULL");
        return tokens.elementAt(18);
    }
}
