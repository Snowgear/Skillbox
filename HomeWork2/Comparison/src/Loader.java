public class Loader {
    public static void main(String[] args) {
        Integer dimaAge = 35;
        Integer mishaAge = 55;
        Integer vasyaAge = 18;

        Integer oldest = 5;
        Integer youngest = 8;
        Integer middle = 9;

        //Определение младшего возраста
        if (dimaAge <= mishaAge && dimaAge <=vasyaAge) {
            youngest = dimaAge;
            System.out.println("Most young " + youngest);
        }
        else if (mishaAge <= dimaAge && mishaAge <= vasyaAge) {
            youngest = mishaAge;
            System.out.println("Most young " + youngest);
        }
        else {
            youngest = vasyaAge;
            System.out.println("Most young " + youngest);
        }

        //Определение среднего возраста
        if ((dimaAge >= mishaAge && dimaAge <= vasyaAge) || (dimaAge <= mishaAge && dimaAge >= vasyaAge)){
            middle = dimaAge;
            System.out.println("Middle " + middle);
        }
        else if ((mishaAge >= dimaAge && mishaAge <= vasyaAge) || (mishaAge <= dimaAge && mishaAge >= vasyaAge)) {
            middle = mishaAge;
            System.out.println("Middle " + middle);
        }
        else {
            middle = vasyaAge;
            System.out.println("Middle " + middle);
        }

        //Определение старшего возраста
        if (dimaAge >= mishaAge && dimaAge >= vasyaAge) {
            oldest = dimaAge;
            System.out.println("Most old " + oldest);
        }
        else if (mishaAge >= dimaAge && mishaAge >= vasyaAge) {
            oldest = mishaAge;
            System.out.println("Most old " + oldest);
        }
        else {
            oldest = vasyaAge;
            System.out.println("Most old " + oldest);
        }
    }
}
