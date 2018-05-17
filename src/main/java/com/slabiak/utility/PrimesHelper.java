package com.slabiak.utility;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrimesHelper {

    public static boolean isPrime(int number) {
        if (number < 2) return false;

        for (int i=2; i <= Math.sqrt(number); i++){
            if (number%i == 0){
                return false;
            }
        }
        return true;
    }

    public static ArrayList<Integer> filterPrimes(List<Integer> input){
        ArrayList<Integer> primes = new ArrayList<Integer>();
        for  (int number : input){
            if(isPrime(number))
            {
                primes.add(number);
            }
        }
        return primes;
    }

    public static ArrayList<Integer> removeDuplicates(List<Integer> input){
        ArrayList<Integer> uniqueList = new ArrayList<Integer>();
        for (int number : input){
            if (!uniqueList.contains(number)){
                uniqueList.add(number);
            }
        }
        return uniqueList;
    }

    public static List<Integer> sortPrimes(List<Integer> primes){
        Collections.sort(primes);
        return primes;

    }
}
