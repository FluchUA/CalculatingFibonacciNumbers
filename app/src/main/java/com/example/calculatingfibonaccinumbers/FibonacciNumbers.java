package com.example.calculatingfibonaccinumbers;

import java.util.ArrayList;

public class FibonacciNumbers {

    private ArrayList<Long> finalValues;
    private int lengthCalcule;

    FibonacciNumbers()
    {
        finalValues = new ArrayList<Long>();
    }

    public void setLengthCalcule(int lengthCalcule) {
        this.lengthCalcule = lengthCalcule;
    }

    public ArrayList<Long> getFinalValues()
    {
        return finalValues;
    }

    public void CalculeCycle()
    {
        finalValues.clear();

        if (lengthCalcule > 0)
        {
            //Если один или два элемента просто добавить их не запуская просчеты
            if (lengthCalcule == 1)
            {
                finalValues.add(1L);
            }
            else  if (lengthCalcule == 2)
            {
                finalValues.add(1L);
                finalValues.add(1L);
            }
            else
            {
                finalValues.add(1L);
                finalValues.add(1L);

                for (int i = 2; i < lengthCalcule; i++)
                {
                    finalValues.add(finalValues.get(i - 1) + finalValues.get(i - 2));
                }
            }
        }
    }

    private long Recurse(int lengthC) {
        if (lengthC == 0)
        {
            finalValues.add(1L);
            finalValues.add(1L);
            return 2;
        }
        long tempV = Recurse(lengthC - 1);
        finalValues.add(tempV);
        return tempV + finalValues.get(finalValues.size() - 2);
    }

    public void CalculeRecurse()
    {
        finalValues.clear();

        //Если один или два элемента просто добавить их не запуская просчеты
        if (lengthCalcule > 0)
        {
            if (lengthCalcule == 1)
            {
                finalValues.add(1L);
            }
            else  if (lengthCalcule == 2)
            {
                finalValues.add(1L);
                finalValues.add(1L);
            }
            else {
                Recurse(lengthCalcule - 2);
            }
        }
    }
}
