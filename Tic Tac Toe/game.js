const Player = require("./player")
const Board = require("./board")


class Game{
    constructor(board,players) {
        this.board = board
        this.players = players
        this.turn = 0
        this.isActive = true
    }

    static newGame(player0Name,player1Name){

        if(typeof player0Name !="string" && typeof player1Name !="string")
            throw new Error("Enter Valid Name")

        const players = [ Player.newPlayer(player0Name,"X"),
                             Player.newPlayer(player1Name,"O")]

        const board =  Board.newBoard()
        
        return new Game(board,players)

    }

    play(cellNo){
        if(!this.isActive)
            return "Game Ended"


        let currPlayer = this.players[this.turn%2]

        try {

            if(cellNo<0 || cellNo>8)
            throw new Error("Not proper cell location")

            if(this.board.cells[cellNo].isMarked())
             throw new Error("Cell Alredy marked")

           
               this.board.cells[cellNo].markCell(currPlayer.symbol); 
        
         
               this.board.printBoard()
       
               let [mark,state] = this.board.analyseResult();
        
               if(state == "win"){
                   this.isActive = false;
                   if(this.players[0].symbol == mark)
                   return `${this.players[0].name} won  `
       
                   return `${this.players[1].name} won`
                  
               }

               if(state == "draw"){
                this.isActive = false;
               
                return `No One Won The Game`

               }


               this.turn ++;
               console.log("Game in ",state ,"State");
               return `Turn : ${this.turn}  ${currPlayer.name}`;
              



               
        } catch (error) {
           
            return error.message
           
        }

        
    }
}

module.exports = Game