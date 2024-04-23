package org.example.ds.hashtable;

public class HashTableTest {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable();

        hashTable.set("nails",100);
        hashTable.set("tile",50);
        hashTable.set("lumber",50);
        hashTable.set("bolts",30);
        hashTable.set("screws",70);

//        hashTable.print();

//        System.out.println("bolts: "+hashTable.get("bolts"));
        System.out.println(hashTable.keys());
    }
}
