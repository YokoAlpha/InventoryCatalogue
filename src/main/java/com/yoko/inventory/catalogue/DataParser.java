package com.yoko.inventory.catalogue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by yokoAlpha on 04/02/2017.
 */
public class DataParser
{
    private static Scanner csvScanner(String csvPath)
    {
        Scanner kb = new Scanner(System.in);
        Scanner infile = null;
        try
        {
            infile = new Scanner(new File(csvPath));
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        return infile;
    }

    public static ArrayList<Product> parseProducts(String csvPath)
    {
        Scanner infile = csvScanner(csvPath);

        ArrayList<Product> personList = new ArrayList<Product>();

        while(infile.hasNextLine())
        {
            String line = infile.nextLine();
            String[] threeparts = line.split(",");
            if(threeparts.length == 3)
            {
                Product entity = new Product(threeparts[0], threeparts[1], Integer.parseInt(threeparts[2]));
                personList.add(entity);
            }
        }
        return personList;
    }

    public static ArrayList<Relationship> parseRelationship(String csvPath)
    {
        Scanner infile = csvScanner(csvPath);

        ArrayList<Relationship> relationshipList = new ArrayList<Relationship>();

        while (infile.hasNextLine())
        {
            String line = infile.nextLine();
            String[] threeparts = line.split(",");
            if(threeparts.length == 3)
            {
                Relationship association = new Relationship(threeparts[0], threeparts[1], threeparts[2]);
                relationshipList.add(association);
            }
        }
        return relationshipList;
    }

}
