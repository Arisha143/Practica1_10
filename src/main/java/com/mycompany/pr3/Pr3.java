/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.pr3;

/**
 *
 * @author arrri
 */

import java.io.File;
import java.util.Arrays;
public class Pr3 {

    public static void main(String[] args) {
    
        System.out.println("Селянкина  Арина Николаевна РИБО-01-22 Вариант 5\n");
        
        String path = args.length > 0 ? args[0] : "."; 

        File directory = new File(path);

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Указанный путь не существует");
            return;
        }

        System.out.println("Scanning " + directory.getAbsolutePath() + "\n");

        File[] files = directory.listFiles();

        Arrays.sort(files, (f1, f2) -> {
            if (f1.isDirectory() && !f2.isDirectory()) {
                return -1; 
            } else if (!f1.isDirectory() && f2.isDirectory()) {
                return 1; 
            } else {
                return f1.getName().compareTo(f2.getName());
            }
        });

        for (File file : files) {
            if (file.isDirectory()) {
                System.out.println(file.getAbsolutePath() + " folder");
            } else {
                System.out.println(file.getAbsolutePath() + " " + file.length());
            }
        }
    }
}