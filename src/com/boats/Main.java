package com.boats;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] masses = new int[6];
        System.out.print("passengers' weights: ");
        for (int i = 0; i < 6; i++) {
            masses[i] = (int)(Math.random()*40)+10;
            System.out.print(masses[i]+" ");
        }
        System.out.println();
        int[] payloads = {70,50};
        System.out.println(max_passengers(masses,payloads));
    }
    static String max_passengers(int[] masses, int[] payloads){
        String ex_str = "";
        Arrays.sort(masses);
        Arrays.sort(payloads);
        int[] curr_payloads = payloads.clone();
        int[] rest_mass = masses.clone();
        boolean[][] layout = new boolean[payloads.length][masses.length];
        for (int i = masses.length-1;i>=0;i--){
            for (int j = 0; j < curr_payloads.length; j++) {
                if(rest_mass[i]!=0 && curr_payloads[j]>=rest_mass[i]){
                    curr_payloads[j] -= rest_mass[i];
                    layout[j][i] = true;
                    rest_mass[i] = 0;
                }
            }
        }
        for (int i = 0; i < payloads.length; i++) {
            ex_str += "payload " + payloads[i] + " passengers: ";
            for (int j = 0; j < masses.length; j++) {
                if(layout[i][j]){
                    ex_str += masses[j] + " ";
                }
            }
            ex_str += "\n";
        }
        return ex_str;
    }
}
