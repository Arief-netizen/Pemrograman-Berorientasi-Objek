package pbo_3_inherite;

public class main {

    public static void main(String[] args) {
        //Deklarasi Tim
        Tim UnesaEsport = new Tim("Unesa Esport");
        
        //Deklarasi Member
        Member orang_1 = new Member("Abil", 20);
        Member orang_2 = new Member("Wisnu", 23);
        Member orang_3 = new Member("Vazlo", 22);
        
        //Deklarasi Trainee
        Member orang_4 = new Trainee("Clay", 26, 8);
        Member orang_5 = new Trainee("Zuxxy", 21, 10);
        Member orang_6 = new Trainee("Luxxy", 30, 12);
        
        //Menambahkan data pada ArrayList
        boynyutEsport.addMember(orang_1);
        boynyutEsport.addMember(orang_2);
        boynyutEsport.addMember(orang_3);
        boynyutEsport.addMember(orang_4);
        boynyutEsport.addMember(orang_5);
        boynyutEsport.addMember(orang_6);
        
        //Output
        boynyutEsport.displayFullMember();
        boynyutEsport.displayTrainee();
    }
    
}
