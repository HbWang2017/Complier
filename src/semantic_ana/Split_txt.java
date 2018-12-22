package semantic_ana;

import java.io.*;
public class Split_txt {//每次读一句话到另一个文本
    private String retainString = new String();
    private int no = 0;//标记第几行
    private String currentString;
    public void readIn(String filePath){
        File file = new File(filePath);
        Reader reader = null;
        int c;
        try {
            reader = new InputStreamReader(new FileInputStream(file));
            while ((c = reader.read()) != -1){
                retainString += (char) c;
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public void writeTo(){
        int flag = 0;
        int commentFlag = 0;
        String string = new String();
        for (int i = 0;i < retainString.length();i++){
            if (flag == no){
                string += retainString.charAt(i);//要写入文件的内容
            }
            if (retainString.charAt(i) == ';') flag++;
            if (i < retainString.length()-2 && (retainString.charAt(i) == '-'
                    && retainString.charAt(i-1) == '-') || (retainString.charAt(i) == '/' && retainString.charAt(i-1) == '/')) commentFlag++;
            if (commentFlag > 0 && retainString.charAt(i) == '\n') flag++;
        }
        if (string.indexOf("\r\n")!=-1) {
        	string = string.substring(string.indexOf("\r\n")+2);
        }
        currentString = string;
        /*File file = new File("D://test1.txt");
        if (file.exists()){
            file.delete();
            try {
                file.createNewFile();
//                System.out.println("删除后创建文件成功");
            } catch (IOException e) {
                System.out.println("创建文件错误");
                e.printStackTrace();
                System.exit(-1);
            }
        }else {
            try {
                file.createNewFile();
//                System.out.println("没有该文件，创建文件成功");
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }

        PrintStream p = null;
        try {
            p = new PrintStream(new FileOutputStream(file));
            p.println(string);
            p.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(-1);
        }*/
        no++;
    }

    public String readFile(){
        //String string = new String();
        /*File file = new File("D://test1.txt");
        Reader reader = null;
        int c;
        try {
            if (file.exists())
            {
                reader =new InputStreamReader(new FileInputStream(file));
                while ((c = reader.read()) != -1){
                    string +=(char) c;
                }
                reader.close();
            }
        }catch (IOException e){
            System.out.println("打开文件错误");
            e.printStackTrace();
            System.exit(-1);
        }
        if (string.indexOf("\r\n")!=-1) {
        	System.out.println(string.indexOf("\r\n"));
        	string = string.substring(0, string.indexOf("\r\n"));
        }*/
        
        return currentString;
    }
    public void setCurrentString(String s) {
    	currentString = s;
    }
    public String getCurrentString() {
    	return currentString;
    }
}
