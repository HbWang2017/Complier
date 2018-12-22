package parser;

import lexical_analyzer.Token;
import lexical_analyzer.usedclass;
import semantic_ana.Split_txt;

import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;

public class parAna_used {
    public LinkedList paraAna(Split_txt t){
        BlockingQueue<Token> queue = new usedclass().lexi_ana(t);
        //
        if (queue.isEmpty()) return new LinkedList(queue);
        //
        queue = new analySentence().alaly_sentence(queue);

        LinkedList linkedList = new LinkedList(queue);
        return linkedList;
    }
}
