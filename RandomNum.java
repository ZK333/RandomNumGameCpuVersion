import java.util.*;
public class RandomNum { // The new version of a game I made
// Zarik Khan

    
    public static int Game(int a, int b, ArrayList<Integer> c){

       if(a==b){
           return 1;
       }
       if(a<b){
           System.out.println("Your guess is too low");
       }
       if(a>b){
           System.out.println("Your guess is too high");
       }
       return 0;
       }




    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        ArrayList<Integer> PossibleRange = new ArrayList<>();
        String Intro = "A user will pick a range of numbers, and a random number will be selected from that range ";
        Intro =Intro+ System.lineSeparator() + "Then if the user can guess the number, before the cpu guesses the number they win!";
        System.out.println(Intro);
        int odds=0;
        int win =0;
        int i =0;
        int compnum =0;
        int attempts= 0;
        int guess=0;
        int cpuguess=0;
        TreeSet<Integer> MaxPos = new TreeSet<Integer>();
        TreeSet<Integer> MinPos = new TreeSet<Integer>();

        System.out.println("Please input the minimum number, from which the random number can be selected");
        int min = sc.nextInt();
        System.out.println("Please input the maximum number, from which the random number can be selected");
        int max = sc.nextInt();
        // inputs the numbers

        System.out.println("What number do you want all possible numbers that may be chosen, have as a common divisor");
        System.out.println("To only have even numbers within your range, input 2, to only have odds input 0");
        int multiple = sc.nextInt();
        if(multiple ==0){
            odds=1;
        }
        // inputs a multiple

        if(odds==0) {
            while ((min % multiple != 0 || max % multiple != 0)) {
                System.out.println("Your min and or max are not multiples of the multiple number you inputed");
                System.out.println("Please input different numbers");
                System.out.println("Please input your min");
                min = sc.nextInt();
                System.out.println("Please input your max");
                max = sc.nextInt();
            }
        }
        else {
            while ((min % 2 == 0 || max % 2 == 0)) {
                System.out.println("Your min and or max are not odd numbers");
                System.out.println("Please input different numbers");
                System.out.println("Please input your min");
                min = sc.nextInt();
                System.out.println("Please input your max");
                max = sc.nextInt();
            }
        }

        if(max<min){
            System.out.println("You must have mistaken your numbers becuase the max was less than the min");
            int storage = min;
            min = max;
            max=storage;
            System.out.println("So we switched them, the new min is "+min+" and the new max is "+max);
        }
        // double checks the numbers, to see if they fit the criteria

       while(min<max && odds==0){
             PossibleRange.add(min);
             min = min+multiple;
       }

       while(min<max && odds==1){
           PossibleRange.add(min);
           min = min+2;
       }
       PossibleRange.add(max);
       // sets up all possible numbers that can be selected

       int possmin =0;
       int possmax= PossibleRange.size()-1;
       compnum= (int)(Math.random()*(possmax-possmin+1))+0; // selects a random index for the number to be selected from the ranges

       compnum = PossibleRange.get(compnum); //the random number has been selected

        MaxPos.add(PossibleRange.get(PossibleRange.size()-1));
        MinPos.add(PossibleRange.get(0));

        while(win==0){
            System.out.println("Please input a guess, then after your guess the cpu will input a guess");
            guess=sc.nextInt();
            win=Game(guess, compnum, PossibleRange);
            if(win==1){
                break;
            }
            attempts++;
            if(guess>compnum){
                MaxPos.add(guess);
            }
            if(guess<compnum){
                MinPos.add(guess);
            }
            cpuguess = MaxPos.first()+MinPos.last();
            cpuguess = (int)cpuguess/2;
            while(cpuguess%multiple!=0){
                cpuguess++;
            }
            if(cpuguess>compnum){
                System.out.println("The cpu guessed "+cpuguess+" and their guess was too high");
                MaxPos.add(cpuguess);
            }
            else if(cpuguess<compnum){
                System.out.println("The cpu guessed "+cpuguess+" and their guess was too low");
                MinPos.add(cpuguess); 
            }
            else if(cpuguess==compnum){
                win=2;
            }
            if(win==2){
                break;
            }
        }

        if(win==1) {
            System.out.println("GOOD JOB YOU WON, YOU TOOK " + attempts + " ATTEMPTS TO GET THE RIGHT ANSWER");
        }
        if(win==2){
            System.out.println("YOU LOST, THE CPU WON, "+"THE NUMBER WAS "+compnum+" YOU HAD "+attempts+" ATTEMPTS");
        }

        }
}
