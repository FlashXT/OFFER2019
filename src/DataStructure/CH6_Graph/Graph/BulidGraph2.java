package DataStructure.CH6_Graph.Graph;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/*****************************************************************
 * @Author:FlashXT;
 * @Date: 2019/6/5 21:24
 * @Version 1.0
 * CopyRight © 2018-2020,FlashXT & turboMan . All Right Reserved.
 *****************************************************************/
public class BulidGraph2 {
    public static void main(String [] args) throws Exception{
        String filepath = "src\\DataStructure\\CH6_Graph\\Graph\\testGraph1.txt";
        bulidGraph(filepath);
    }

    public static void  bulidGraph(String filepath) throws Exception {
        FileReader fr = new FileReader(filepath);
        BufferedReader br = new BufferedReader(fr);

        String line = br.readLine();
        String [] arr = line.split(" ");
        Graph1 g = new Graph1(Integer.valueOf(arr[0]),false);
        while((line = br.readLine()) != null){
            arr = line.split(" ");
            g.addedge(Integer.valueOf(arr[0]),Integer.valueOf(arr[1]),Double.valueOf(arr[2]));
        }
        g.Print();

    }

}
