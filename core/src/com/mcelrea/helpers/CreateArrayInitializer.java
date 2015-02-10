package com.mcelrea.helpers;

import javax.swing.*;
import java.util.Scanner;

/**
 * Created on 2/10/2015.
 */
public class CreateArrayInitializer {

    public static void main(String args[]) {

        Scanner input = new Scanner(System.in);

        System.out.print("How many cols: ");
        int cols = input.nextInt();
        System.out.print("How many rows: ");
        int rows = input.nextInt();

        createArr(cols, rows);
    }

    public static void createArr(int cols, int rows) {

        String output = "int arr[][] = {";

        for(int row = 0; row < rows; row++) {
            output += "{";
            for(int col = 0; col < cols; col++) {
                output += "0";
                if(col != cols-1)
                    output += ",";
            }
            output += "}";
            if(row != rows-1)
                output += ",";
            output += "\n";
        }

        output += "};\n";

        System.out.println(output);
    }
}
