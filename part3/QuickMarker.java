import java.util.LinkedList;
import java.util.Queue;

public class QuickMarker{
    private Queue<Applicant> applicantQueue;
    private Applicant[] applicants;
    private int numberApplicants;
    private int skip;

    public static void main(String[] args){
        int a = 1100;
        int n = 259;
        QuickMarker quickMarker = new QuickMarker(a, n);
        Applicant[] applicants = quickMarker.getMarking();
        System.out.println("\nFor a = " + a + " applicants and n = "+ n + ", these are the applicants marks: \n");
        for(Applicant applicant: applicants){
            System.out.println(applicant);
        }
    }

    public QuickMarker(int numberApplicants, int skip){
        this.numberApplicants = numberApplicants;
        this.applicants = new Applicant[numberApplicants];
        this.skip = skip;
        this.applicantQueue = new LinkedList<>();
        initApplicants();
    }

    private void initApplicants(){
        for(int i = 0; i < numberApplicants; i++){
            applicants[i] = new Applicant(i, 0);
        }
    }

    /**
     * Using a queue, we go load the "Applicants[]" into it.
     * Next we need iterate through the Applicants queue, with each iteration going to applicant skip-1 (since in a queue, we are removing the person at the front, if we want to remove applicant "skip" we end right before that applicant, and move them to the front)
     * Removing that applicant, we countinue until we land on the last applicant, which will recieve 100%
     * All other applicants recieve eliminationCount/a * 100f.
     * 
     */
    private void runMarking(){
        for(int i = 0; i < numberApplicants; i++){
            applicantQueue.add(applicants[i]);
        }

        int eliminationCount = 1;

        while(!applicantQueue.isEmpty()){
            for(int i = 0; i < skip -1; i++){
                Applicant front = applicantQueue.remove();
                applicantQueue.add(front);
            }

            Applicant eliminated = applicantQueue.remove();

            float mark = ((float) eliminationCount / numberApplicants) * 100f;
            eliminated.setMark(mark);

            eliminationCount++;
        }
    }

    public Applicant[] getMarking(){
        runMarking();
        return applicants;
    }
}

