import java.util.*;

abstract class Permainan
{
    Scanner inputUser = new Scanner(System.in);
    String namaPemain;
    int levelPemain;

    void setNamaPemain(String namaPemain)
    {
        System.out.print("Masukkan nama anda : ");
        namaPemain = inputUser.nextLine();
    }

    void setLevelPemain(int levelPemain)
    {
        System.out.print("Pilih level anda : ");
        levelPemain = inputUser.nextInt();
        if (levelPemain >= 1 && levelPemain <=20 )
        {
            System.out.println("Level mudah");
        }
        else if (levelPemain >= 21 && levelPemain <= 80)
        {
            System.out.println("Level sedang");
        }
        else if (levelPemain >= 81 && levelPemain <= 100)
        {
            System.out.println("Level sulit");
        }
        else
        {
            System.out.println("Level tidak tersedia!");
            System.out.println("Level terendah : 1");
            System.out.println("Level tertinggi : 100");
        }
    }

    String getNamaPemain()
    {
        return namaPemain;
    }
    int getLevelPemain()
    {
        return levelPemain;
    }

    void jalankan()
    {
        setNamaPemain(namaPemain);
        setLevelPemain(levelPemain);
    }

    abstract int hitungSkor(int hit, int miss);
}

class PermainanArcade extends Permainan
{
    @Override
    int hitungSkor(int hit, int miss)
    {
        int total = (hit*3) - (miss*1);
        System.out.println("Maka, skor perolehan : " + total);
        System.out.println("\n");
        return total;
    }
}

class PermainanStrategy extends Permainan
{
    @Override
    int hitungSkor(int hit, int miss)
    {
        int total = hit*5;
        System.out.println("Maka, skor perolehan : " + total);
        System.out.print("\n");
        return total;
    }
}

public class Main_Permainan {
    public static void main(String[] args) {
     Scanner inputUser = new Scanner(System.in);
     Permainan Arcade = new PermainanArcade();
     Permainan Strategy = new PermainanStrategy();

     System.out.println("--MODE PERMAINAN--");
     System.out.println("1. Permainan Arcade");
     System.out.println("2. Permainan Strategy");
     System.out.print("Masukkan pilihan anda : ");
     int pilmode = inputUser.nextInt();
     if (pilmode == 1) {
         Arcade.jalankan();
         System.out.println("\n--PERMAINAN ARCADE--");
         Arcade.hitungSkor(5, 3);
     }
     else if (pilmode == 2)
     {
         Strategy.jalankan();
         System.out.println("\n--PERMAINAN STRATEGY--");
         Strategy.hitungSkor(10, 5);
     }
     else
     {
         System.out.println("\nMode tidak tersedia!");
     }
    }
}