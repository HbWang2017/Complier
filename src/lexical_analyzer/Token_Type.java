package lexical_analyzer;

import java.util.Vector;

public class Token_Type {//记录所有记号
	private String type;
	private Vector<String> mark;
	
	Token_Type(){
		type = new String("ERRORTOKEN");
		mark = new Vector<String>();
		mark.add("ORIGIN");//保留字
		mark.add("SCALE");
		mark.add("ROT");
		mark.add("IS");
		mark.add("TO");
		mark.add("STEP");
		mark.add("DRAW");
		mark.add("FOR");
		mark.add("FROM");
		mark.add("T");//参数
		mark.add("SEMICO");//分隔符
		mark.add("L_BRACKET");
		mark.add("R_BRACKET");
		mark.add("COMMA");
		mark.add("PLUS");//运算符
		mark.add("MINUS");
		mark.add("MUL");
		mark.add("DIV");
		mark.add("POWER");
		mark.add("FUNC");//函数
		mark.add("CONST_ID");//常数
		mark.add("NONTOKEN");//空记号
		mark.add("COMMENT");//注释
		mark.add("SETCOLOR");
		mark.add("RED");
		mark.add("BLUE");
		mark.add("YELLOW");
		mark.add("BLACK");
		mark.add("GREEN");
		mark.add("ERRORTOKEN");//出错记号
	}


    
//	Function
    public void setType(String s) {
        if (mark.contains(s)) {
        	type=s;
        }
    }
    public String getType() {
        return type;
    }
}
