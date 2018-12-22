package parser;


import lexical_analyzer.Token;
import lexical_analyzer.Token_Table;
import lexical_analyzer.usedclass;

import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Author:fan
 * Date: 17-12-16
 * Time: 涓嬪崍7:59
 * Description:
 */
public class analySentence {//鍒嗘瀽浼犺繘鏉ョ殑鍙ュ瓙缁撴瀯锛屽苟涓旀浛鎹㈠嚱鏁板拰琛ㄨ揪寮�,鐩爣杩斿洖涓�鍙ヨ瘽
    public BlockingQueue<Token> alaly_sentence(BlockingQueue<Token> queue){
        LinkedList linkedList = new LinkedList(queue);

        //鏇挎崲PI鍜孍
        for (int i = 0;i < linkedList.size();i++){
            Token token1 =(Token) linkedList.get(i);
            if (token1.getOriinpt() == "PI") {
                Token token11 = new Token("CONST_ID",String.valueOf(token1.getValue()),token1.getValue(),"NULL");
                linkedList.remove(i);linkedList.add(i,token11);
            }else if (token1.getOriinpt() == "E"){
                Token token11 = new Token("CONST_ID",String.valueOf(token1.getValue()),token1.getValue(),"NULL");
                linkedList.remove(i);linkedList.add(i,token11);
            }
        }
        linkedList = new func_filter().filterFunc(link2queue(linkedList));//杩囨护鍑芥暟

        sentence_pattern sentencePattern = new sentence_pattern();
        Token token1 =(Token) linkedList.get(0);
        sentencePattern.setPattern(token1);
        //寮�濮嬪尮閰嶅彞瀛�,鍒ゅ畾璇硶妯″紡
        switch (sentencePattern.getPattern()){
            case "origin_pattern":
                linkedList = testOriinputPattern(linkedList);
                break;//origin妯″紡
            case "rot_pattern":
                linkedList = testRotPattern(linkedList);
                break;//rot妯″紡
            case "scale_pattern":
                linkedList = testOriinputPattern(linkedList);
                break;//scale妯″紡
            case "for_pattern":
                linkedList = testForPattern(linkedList);
                break;//for妯″紡
            //
            case "setcolor_pattern":
                linkedList = testSetColorPattern(linkedList);
                break;
            //
        }
        //娴嬭瘯
//        System.out.println("After test");//杈撳嚭杩囨护鍑芥暟缁撴灉
//        for (int i = 0;i < linkedList.size();i++){
//            Token token100 =(Token) linkedList.get(i);
//            System.out.println( token100.getToken_type() + " " + token100.getOriinpt() + " " + token100.getValue());
//        }
        //
        queue.clear();
        for (int i = 0;i < linkedList.size();i++){
            Token token =(Token) linkedList.get(i);
            queue.add(token);
        }
        return queue;
    }
    private LinkedList testOriinputPattern(LinkedList linkedList){//鍒ゅ畾ori璇硶妯″紡鍜宻cale璇硶妯″紡姝ｇ‘鎬�
        LinkedList linkedList1 = new LinkedList();
        if (linkedList.size() < 8) {
            System.out.println("璇硶閿欒 analySentence_1");
            System.exit(-1);
        }
        Token token11 = (Token) linkedList.get(1);
        if (token11.getOriinpt() != "IS"){
            System.out.println("璇硶閿欒 analySentence_2");
            System.exit(-1);
        }
        token11 = (Token) linkedList.get(2);
        if (token11.getOriinpt() != "("){
            System.out.println("璇硶閿欒 analySentence_3");
            System.exit(-1);
        }
        token11 = (Token) linkedList.get(linkedList.size()-2);
        if (token11.getOriinpt() != ")"){
            System.out.println("璇硶閿欒 analySentence_4");
            System.exit(-1);
        }
        int flag = 0;
        for (int i = 3;i < linkedList.size()-1;){//璁＄畻鎷彿涓殑琛ㄨ揪寮�                               //attention -1
            Token token1 =(Token) linkedList.get(i);
            if (in_pattern(token1.getToken_type()) ){//灞炰簬姝ｅ父鐘舵��
                linkedList1.add(token1);
                linkedList.remove(i);
            }else if (token1.getOriinpt() == ","){
                flag++;
                double result = new expression_compute().compute(linkedList1);
                Token token12 = new Token("CONST_ID",String.valueOf(result),result,"NULL");
                linkedList.add(i,token12);
                linkedList1.clear();
                i += 2;//
            }else {

                System.out.println("璇硶閿欒 analySentence_5");
                System.exit(-1);
            }
            if (flag > 1){
                System.out.println("璇硶閿欒 analySentence_6");
                System.exit(-1);
            }
        }

        double result = new expression_compute().compute(linkedList1);
        Token token = new Token("CONST_ID",String.valueOf(result),result,"NULL");
        linkedList.add(5,token);
        Token token1 = new Token("R_BRACKET",")",0.0,"NULL");
        linkedList.add(6,token1);
        return linkedList;
    }
    private LinkedList testRotPattern(LinkedList linkedList){//鍖归厤rot妯″紡
        LinkedList linkedList1 = new LinkedList();
        if (linkedList.size() < 4){
            System.out.println("璇硶閿欒 analySentence_7");
            System.exit(-1);
        }
        Token token =(Token) linkedList.get(1);
        if (token.getOriinpt() != "IS"){
            System.out.println("璇硶閿欒 analySentence_8");
            System.exit(-1);
        }
        for (int i = 2;i < linkedList.size() - 1;){
            Token token1 =(Token) linkedList.get(i);
            if (in_pattern(token1.getToken_type())){
                linkedList1.add(token1);
                linkedList.remove(i);
            }else {
                System.out.println("璇硶閿欒 analySentence_9");
                System.exit(-1);
            }
        }
        //娴嬭瘯
//        System.out.println("test");//杈撳嚭杩囨护鍑芥暟缁撴灉
//        for (int i = 0;i < linkedList1.size();i++){
//            Token token100 =(Token) linkedList1.get(i);
//            System.out.println( token100.getToken_type() + " " + token100.getOriinpt() + " " + token100.getValue());
//        }
        //

        double result = new expression_compute().compute(linkedList1);
        Token token2 = new Token("CONST_ID",String.valueOf(result),result,"NULL");
        linkedList.add(2,token2);
        return linkedList;
    }
    private LinkedList testForPattern(LinkedList linkedList){
        LinkedList linkedList1 = new LinkedList();
        if (linkedList.size() < 15){
            System.out.println("璇硶閿欒 1");
            System.exit(-1);
        }
        Token token;
        token = (Token) linkedList.get(1);
        if (token.getToken_type() != "T"){
            System.out.println("璇硶閿欒 2");
            System.exit(-1);
        }
        token = (Token) linkedList.get(2);
        if (token.getToken_type() != "FROM"){
            System.out.println("璇硶閿欒 3");
            System.exit(-1);
        }
        for (int i = 3;;){
            Token token1 =(Token) linkedList.get(i);
            if (in_pattern(token1.getToken_type())){//姝ｅ父妯″紡
                linkedList1.add(token1);
                linkedList.remove(i);
            }else if (token1.getToken_type() == "TO"){
                double result = new expression_compute().compute(linkedList1);
                linkedList1.clear();
                Token token2 = new Token("CONST_ID",String.valueOf(result),result,"NULL");
                linkedList.add(i,token2);
                break;
            }else {
                System.out.println("璇硶閿欒 4");
                System.exit(-1);
            }
        }
        for (int i = 5;;){
            Token token1 =(Token) linkedList.get(i);
            if (in_pattern(token1.getToken_type())){//姝ｅ父妯″紡
                linkedList1.add(token1);
                linkedList.remove(i);
            }else if (token1.getToken_type() == "STEP"){
                double result = new expression_compute().compute(linkedList1);
                linkedList1.clear();
                Token token2 = new Token("CONST_ID",String.valueOf(result),result,"NULL");
                linkedList.add(i,token2);
                break;
            }else {
                System.out.println("璇硶閿欒 5");
                System.exit(-1);
            }
        }
        for (int i = 7;;){
            Token token1 =(Token) linkedList.get(i);
            if (in_pattern(token1.getToken_type())){//姝ｅ父妯″紡
                linkedList1.add(token1);
                linkedList.remove(i);
            }else if (token1.getToken_type() == "DRAW"){
                double result = new expression_compute().compute(linkedList1);
                linkedList1.clear();
                Token token2 = new Token("CONST_ID",String.valueOf(result),result,"NULL");
                linkedList.add(i,token2);
                break;
            }else {
                System.out.println("璇硶閿欒 6");
                System.exit(-1);
            }
        }
        Token token10 =(Token) linkedList.get(9);
        if (token10.getOriinpt() != "("){
            System.out.println("璇硶閿欒 7");
            System.exit(-1);
        }
        for (int i = 10;;){
            Token token1 =(Token) linkedList.get(i);
            if (in_pattern(token1.getToken_type())){//姝ｅ父妯″紡
                linkedList1.add(token1);
                linkedList.remove(i);
            }else if (token1.getToken_type() == "COMMA"){
                double result = new expression_compute().compute(linkedList1);
                linkedList1.clear();
                Token token2 = new Token("CONST_ID",String.valueOf(result),result,"NULL");
                linkedList.add(i,token2);
                break;
            }else if (token1.getToken_type() == "T"){
                break;
            } else {
                System.out.println("璇硶閿欒 8");
                System.exit(-1);
            }
        }
        int flag = 1;
        LinkedList linkedList2 = new LinkedList();

        for (int i = 12;;){
            Token token1 =(Token) linkedList.get(i);
            if (in_pattern(token1.getToken_type())){//姝ｅ父妯″紡
                linkedList2.add(token1);
                linkedList.remove(i);
                if (token1.getOriinpt() == "(") flag++;
                else if (token1.getOriinpt() == ")") flag--;
            }else if (token1.getToken_type() == "T"){
                break;
            }
            if (flag == 0) {
                double result = new expression_compute().compute(linkedList2);
                Token token2= new Token("CONST_ID",String.valueOf(result),result,"NULL");
                linkedList.add(i,token2);
                Token token3 = new Token("R_BRACKET",")",0.0,"NULL");
                linkedList.add(i+1,token3);
                break;
            }
        }

        return linkedList;
    }
    private String[] patter = {//+-*/鎷彿
            "PLUS","MINUS","MUL","DIV",
            "POWER","CONST_ID","L_BRACKET",
            "R_BRACKET"
    };
    private boolean in_pattern(String a){
        for (int i = 0;i < 8;i++)if (a.equalsIgnoreCase(patter[i])) return true;
        return false;
    }
    //
    private LinkedList testSetColorPattern(LinkedList linkedList){
        Token token;
        int flag = 0;
        String[] color = {"RED","YELLOW","BLUE","GREEN","BLACK"};
        if (((Token) linkedList.get(1)).getOriinpt() != "("){
            System.out.println("璇硶閿欒-");
            System.exit(-1);
        }else if (((Token) linkedList.get(3)).getOriinpt() != ")"){
            System.out.println("璇硶閿欒--");
            System.exit(-1);
        }
        token =(Token) linkedList.get(2);
        for (;flag < 5;flag++){
            if (token.getOriinpt().equalsIgnoreCase(color[flag])) break;
        }
        if (flag == 5 && !token.getOriinpt().equalsIgnoreCase(color[4])){
            System.out.println(token.getOriinpt());
            System.out.println("璇硶閿欒---");
            System.exit(-1);
        }


        return linkedList;
    }
    private BlockingQueue<Token> link2queue(LinkedList<Token> linkedList){
        BlockingQueue<Token> queue = new LinkedBlockingQueue<>(100);
        for (int i = 0;i < linkedList.size();i++){
            queue.add(linkedList.get(i));
        }
        return queue;
    }
}
