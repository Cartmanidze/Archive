import javax.management.ObjectName;
import java.io.IOException;
import java.util.*;


/**
 * Created by Stanislav on 15.09.2017.
 */
public class Compresion {

    List<Map.Entry <Character, Long>> list;
    CharFreq charFreq;
    FileReader fileWriter;

    public static Map<Character, String> charCods;

    public Compresion() throws IOException {//класс будет отвечать за сжатие

        charCods = new HashMap<Character, String>();
        charFreq = new CharFreq();
        list = charFreq.list;

        Set<Map.Entry<Character, String>> entrySet = charCods.entrySet();

        fileWriter = new FileReader("outPut.txt", 2);


        List<TreeNode> treeList= new ArrayList<TreeNode>();

        for (int i = 0; i < list.size(); i++){

            TreeNode node = new TreeNode();
            node.symbol = list.get(i).getKey();
            node.weight = Math.toIntExact(list.get(i).getValue());
            treeList.add(node);
        }




        while (treeList.size() > 1) {
            Collections.sort(treeList, new Comparator<TreeNode>() {
                @Override
                public int compare(TreeNode o1, TreeNode o2) {
                    if (o1.weight == o2.weight) return 0;
                    else if (o1.weight > o2.weight) return 1;
                    else return -1;
                }
            });



            TreeNode parent = new TreeNode();
            parent.leftChild = treeList.get(0);
            parent.rightChild = treeList.get(1);
            parent.weight = parent.leftChild.weight + parent.rightChild.weight;
            treeList.remove(0);
            treeList.remove(0);
            treeList.add(parent);
        }


        print(treeList.get(0), "");
        System.out.print(charCods);
        new Uncompresion();

        textGen(entrySet, CharFreq.text);

    }


    void print(TreeNode node, String context) throws IOException { // PRINT
        if (node.leftChild == null){
           //fileWriter.writer(node.symbol + ";" + context);

            charCods.put(node.symbol, context);

            return;
        }
        if (node.leftChild!= null){
            print(node.leftChild, context + "0");
            print(node.rightChild, context + "1");
        }

    }

    void textGen(Set<Map.Entry<Character, String>> set, String s) {

        byte buffer = 0;
        /*String sTest = "0110101010101";
        char[] chTest = sTest.toCharArray();

        for (char ch: chTest){

            buffer = (byte) ((buffer << 1) + (('0' == ch) ? 0 : 1));
            i++;
            if (i == 7){
                System.out.println(buffer + "Cikl");
                System.out.println(Integer.toBinaryString(buffer));
                buffer = 0;
                i = 0;
            }

        }
        System.out.println(buffer+ "posle");

        System.out.println(Integer.toBinaryString(buffer));
        if (buffer < 0){
            System.out.println("YAAA");
        }*/

        int i = 0;

        char[] chars = s.toCharArray();
        char[] charsTemp;

        buffer = 0;

        for (char c : chars) {
            for (Map.Entry<Character, String> pair : set) {
                if (c == pair.getKey()) {
                    charsTemp = pair.getValue().toCharArray();
                    for (char chT : charsTemp) {


                        buffer = (byte) ((buffer << 1) + (('0' == chT) ? 0 : 1));
                        i++;
                        if (i == 7) {
                            //System.out.print(buffer);
                            try {
                                //fileWriter.writer(buffer);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            buffer = 0;
                            i = 0;

                        }
                        //System.out.print(buffer);
                    /*try {
                        fileWriter.writer(buffer);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }*/
                        //buffer = 0;
                    }

                }


            }

        }

    }
}




