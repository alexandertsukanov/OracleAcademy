package oracleacademy.tsukanov.homework.task3.genericstorage;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Created by tsukanov on 11/14/16.
 */
public class GenericStorage<T>{

    private T[] type;
    private int last;

    GenericStorage(){
        type = (T[]) new Object[10];
        last = 0;
    }

    GenericStorage(int size){
        type = (T[]) new Object[size];
        last = 0;
    }

    void add(T value){
        type[last] = value;
        last++;
    }

    T get(int index){
        if(index > last - 1 || index < 0){
            throw new IllegalArgumentException("Index must be from 0 to " + (last - 1) + "." );
        }
        return type[index];
    }

    T[] getAll(){
        return type;
    }

    void update(int index, T obj){
        if(index > last - 1 || index < 0){
            throw new IllegalArgumentException("Index must be from 0 to " + (last - 1) + "." );
        }
        else if(type[index] != null){
            type[index] = obj;
        }
        else{
            throw new IllegalArgumentException("You need to update an element which exists.");
        }
    }

    void delete(int index) {
        if (index > last - 1 || index < 0) {
            throw new IllegalArgumentException("Index must be from 0 to " + (last - 1) + ".");
        } else {
            type[index] = null;
            if (type[index + 1] != null) {
                for (int i = index; i < last; i++) {
                    if (type[i + 1] == null) {
                        break;
                    }
                    type[i] = type[i + 1];
                    type[i + 1] = null;
                }
            }
            last--;
        }
    }

    void delete(T obj){
        boolean isFound = false;
        for (int i = 0; i < last; i++) {
            if(obj.equals(type[i])){
                isFound = true;
                type[i] = null;
                if(type[i + 1] != null){
                    for (int j = i; j < last; j++) {
                        if(type[j + 1] == null){
                            break;
                        }
                        type[j] = type[j + 1];
                        type[j + 1] = null;
                    }
                }
                last--;
            }
        }
        if(!isFound){
            throw new NoSuchElementException();
        }
    }

    int length(){
        return last;
    }

    public static void main(String[] args) {
        //Initialize generic array
        GenericStorage genericStorage = new GenericStorage(20);

        //Adding an elements to array
        genericStorage.add(2);
        genericStorage.add(3);
        genericStorage.add(6);
        genericStorage.add(6);

        //Deleting by index
        genericStorage.delete(0);

        //Deleting by Object
        genericStorage.delete(Integer.valueOf(3));

        //Show array(return an array)
        System.out.println(Arrays.toString(genericStorage.getAll()));

        //Getting an element by the index
        System.out.println(genericStorage.get(0));

        //Return a length of array
        System.out.println(genericStorage.length());

        //Updating an element
        genericStorage.update(0, 3);

        //EXCEPTION HERE! WE DON'T HAVE ANY ELEMENTS BY INDEX 2!
        //genericStorage.update(2, 3);

        //Show array again(return an array)
        System.out.println(Arrays.toString(genericStorage.getAll()));
    }
}
