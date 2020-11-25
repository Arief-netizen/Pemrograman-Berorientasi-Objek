package pbo_3_inherite;

import java.util.ArrayList;

public class Tim {
    private String nama;
    private ArrayList<Member> member;
    
    //Constructor 1 parameter
    public Tim(String nama) {
        this.nama = nama;
        member = new ArrayList<>();
    }
    
    //Method tambah data
    public void addMember(Member m) {
        member.add(m);
    }
        
    //Method list data
    public void displayFullMember() {
        System.out.println("\n\n=========== MEMBER TIM : " + nama +" ===========");
        for(Member m : member) {
            m.display();
            System.out.println();
        }
    }
    public void displayTrainee() {
        System.out.println("\n\n=========== TRAINEE TIM : " + nama +" ===========");
        for(Member m : member) {
            if(m instanceof Trainee) {
                Trainee trainee = (Trainee) m;
                trainee.display();
                System.out.println();
            }
        }
    }
}