package com.jianqing.interview.language;

import java.io.*;

/**
 * Created by jianqing_sun on 1/29/18.
 */
public class IODemo {
/*
    File fout = new File(this.path);
    FileOutputStream fos = new FileOutputStream(fout, true);

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

    bw.write(s);
    bw.newLine();
    bw.close();
*/
    public static void main(String[] args) {
        IODemo io = new IODemo();
        //io.ByteDemo();
        io.CharDemo();
    }

    // Read Write bytes
    public void ByteDemo(){
        // InputStream 是父类, BufferedInputStream, FileInputStream 是常用的stream
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/iodemo/data.txt");
            FileOutputStream fos = new FileOutputStream("src/main/resources/iodemo/data_output.txt");

            InputStream is = new BufferedInputStream(fis);
            OutputStream os = new BufferedOutputStream(fos);

            while(is.available() > 0){
                // InputStream 可以传入byte[]
                int b = is.read();

                os.write(b);
                System.out.println("Char: " + b);
            }

            is.close();
            os.close();

            // Object Demo
            Student s = new Student("qing", 30);
            fos = new FileOutputStream("src/main/resources/iodemo/obj_output.txt");
            fis = new FileInputStream("src/main/resources/iodemo/obj_output.txt");
            ObjectOutputStream objOutStream = new ObjectOutputStream(fos);

            objOutStream.writeObject(s);
            objOutStream.close();

            ObjectInputStream objInputStream = new ObjectInputStream(fis);
            Student sin = (Student)objInputStream.readObject();

            System.out.println(String.format("A String %s %s", sin.name, sin.age));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {

        }
    }


    // Read Write chars
    public void CharDemo(){
        try {
            Reader reader = new BufferedReader(new FileReader("src/main/resources/iodemo/data.txt"));
            Writer writer = new BufferedWriter(new FileWriter("src/main/resources/iodemo/data_output.txt"));

            // reader 读 char array
            char[] bf = new char[3];
            int c = -1;
            while((c = reader.read(bf)) != -1){
                if(c == bf.length){
                    writer.write(bf);
                }
                else{
                    // 最后一次的时候， read 的 number 小于 bf.length
                    for(int i = 0; i < c; i++){
                        writer.write(bf[i]);
                    }
                }
            }

            reader.close();
            writer.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static class Student implements Serializable{
        String name;
        int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
}

