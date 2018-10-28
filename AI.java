class AI{  // 컴퓨터가 계산해서 최적의 위치를 반환하는 class를 구현
    

    int stoneColor ;
    // Location [] board = new Location[361];




    AI(int color){

        this.stoneColor = color ;



    }


    Location where(){

        return Gomoku.board[1];
    }

    void setBoard(){

        for(int i=0;i<361;i++){

            // board[i] = new Location();
            // board[i] = Gomoku.board[i];
            if(Gomoku.board[i].is != false){



            }


        }

    }





}