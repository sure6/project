package com.uow.jena;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFileTool {
    private static String filePath="C:\\idea-workspaces\\project\\learn-jena\\src\\main\\java\\com\\uow\\jena\\";
    private static String fileName="vc-db-1.rdf";

    public static void writeFile(String output){
        FileWriter writer =null;
        BufferedWriter bw=null;
        try {
            writer = new FileWriter(filePath + fileName);
            bw = new BufferedWriter(writer);
            bw.write(output);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(writer!=null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bw!=null){
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public static void main(String[] args) {
        String a="asdadasfagf";
        writeFile(a);
    }
}
