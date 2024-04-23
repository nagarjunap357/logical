package org.example.ds.hashtable;

import java.util.ArrayList;

public class HashTable {
    private int size = 7;
    private Node[] dataMap;

    public HashTable() {
        dataMap = new Node[size];
    }

    private int hash(String key) {
        int hash = 0;

        char[] charArr = key.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            int asciVal = charArr[i];
            hash = (hash + asciVal * 23) % dataMap.length;
        }
        return hash;
    }

    public void set(String key, int value) {
        int index = hash(key);
        Node newNode = new Node(key, value);
        if (dataMap[index] == null) {
            dataMap[index] = newNode;
        } else {
            Node temp = dataMap[index];
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }

    }

    public int get(String key){
        int index = hash(key);
        Node temp = dataMap[index];

        while(temp != null){
            if(temp.key.equals(key)){
                return temp.value;
            }
            temp = temp.next;
        }
        return 0;
    }

    public ArrayList<String> keys(){
        ArrayList<String> keyList = new ArrayList<>();
        for (int i=0;i< dataMap.length;i++){
            Node temp = dataMap[i];
            while(temp != null){
                keyList.add(temp.key);
                temp = temp.next;
            }
        }

        return keyList;
    }

    public void print() {
        for (int i = 0; i < dataMap.length; i++) {
            System.out.println(i + ":");
            Node temp = dataMap[i];
            while (temp != null) {
                System.out.println(" {" + temp.key + "= " + temp.value + "}");
                temp = temp.next;
            }
        }
    }

}
