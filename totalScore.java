class totalScore{


    scoreRowLeft  score_Row_L = new scoreRowLeft();
    scoreRowRight score_Row_R = new scoreRowRight();
    scoreColUp   score_Col_U = new scoreColUp();
    scoreColDown score_Col_D = new scoreColDown();

    int [] total = new int[361];


    totalScore(){

        for(int i = 0 ; i <361 ; i++) total[i] = 0;

    }

    void setTotal(Location choice){

        score_Row_L.sum(choice);
        score_Row_R.sum(choice);
        score_Col_U.sum(choice);
        score_Col_D.sum(choice);

        for(int i = 0; i < 361 ; i++)
        {
            total[i] = score_Row_L.blackScore[i]
                     + score_Row_L.whiteScore[i]
                     + score_Row_R.blackScore[i]
                     + score_Row_R.whiteScore[i]
                     + score_Col_U.blackScore[i]
                     + score_Col_U.whiteScore[i]
                     + score_Col_D.blackScore[i]
                     + score_Col_D.whiteScore[i];
         }




    }

    void display(){

        System.out.print("\nScore Board");
        for(int i = 0; i<361; i++)
        {
            if(i%19 == 0) System.out.println();
            System.out.printf("%5d ", total[i]);
        }

        System.out.println();

    }

}