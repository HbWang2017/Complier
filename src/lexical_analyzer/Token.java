package lexical_analyzer;


public class Token {//记录输入字符串可有的属性
    private Token_Type token_type;//类别
    private String originInput = new String();//原始字符串
    private double value;//常数的值
    private String Func = new String();//函数类别

    public Token(String m_Token_type,String m_originInput,double m_value,String m_func){
    	token_type = new Token_Type();
        token_type.setType(m_Token_type);
        originInput = m_originInput;
        value = m_value;
        Func = m_func;
    }
    public String getToken_type() {
        return token_type.getType();
    }
    public String getOriinpt() {
        return originInput;
    }
    public double getValue() {
        return value;
    }
    public String getFunc() {
        return Func;
    }

}
