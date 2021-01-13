package com.examples.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;

public class SingletonTest {

    public static void main(String[] args) {
        cloneBreak();
    }

    static private void cloneBreak(){
        try {
            Singleton instance1 = Singleton.instance;
            Singleton instance2 = (Singleton) instance1.clone();
            System.out.println("instance1 hashCode:- " + instance1.hashCode());
            System.out.println("instance2 hashCode:- " + instance2.hashCode());
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    static private void serializableBreak(){
        try{
            Singleton instance1 = Singleton.instance;
            String filePath  = "/Users/asahdev/Work/Test/DesignPatterns/src/main/java/com/examples/singleton/file.txt";
            ObjectOutput out = new ObjectOutputStream(new FileOutputStream(filePath));
            out.writeObject(instance1);
            out.close();
            ObjectInput in = new ObjectInputStream(new FileInputStream(filePath));
            Singleton instance2 = (Singleton) in.readObject();
            in.close();
            System.out.println("instance1 hashCode:- " + instance1.hashCode());
            System.out.println("instance2 hashCode:- " + instance2.hashCode());

            SingletonEnum singletonEnum1 = SingletonEnum.INSTANCE;
            ObjectOutput out2 = new ObjectOutputStream(new FileOutputStream(filePath));
            out2.writeObject(singletonEnum1);
            out2.close();
            ObjectInput in2 = new ObjectInputStream(new FileInputStream(filePath));
            SingletonEnum singletonEnum2 = (SingletonEnum) in2.readObject();
            in2.close();
            System.out.println("singletonEnum1 hashCode:- " + singletonEnum1.hashCode());
            System.out.println("singletonEnum2 hashCode:- " + singletonEnum2.hashCode());
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    static private void reflectionBreak(){
        Singleton instance1 = Singleton.instance;
        Singleton instance2 = null;
        try{
            Constructor[] constructors = Singleton.class.getDeclaredConstructors();
            for (Constructor constructor : constructors){
                constructor.setAccessible(true);
                instance2 = (Singleton) constructor.newInstance();
                break;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("instance1.hashCode():- " + instance1.hashCode());
        System.out.println("instance2.hashCode():- " + instance2.hashCode());

        SingletonEnum singletonEnum = SingletonEnum.INSTANCE;
        SingletonEnum singletonEnum2 = null;
        try{
            Constructor[] constructors = SingletonEnum.class.getDeclaredConstructors();
            for (Constructor constructor : constructors){
                constructor.setAccessible(true);
                singletonEnum2 = (SingletonEnum) constructor.newInstance();
                break;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("singletonEnum.hashCode():- " + singletonEnum.hashCode());
        System.out.println("singletonEnum2.hashCode():- " + singletonEnum2.hashCode());
    }

    static private enum SingletonEnum
    {
        INSTANCE;
        private int field = 4;
        private void test(){
            System.out.println("executing test method");
        }
    }

    static private class Singleton implements Serializable, Cloneable
    {
        public static Singleton instance = new Singleton();
        private Singleton()
        {
        }
        @Override
        protected Object clone() throws CloneNotSupportedException
        {
//            return super.clone();
            throw new CloneNotSupportedException();
        }
    }


}
