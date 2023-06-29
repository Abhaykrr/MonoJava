class Player{
    constructor(name,symbol){
        this.name = name
        this.symbol = symbol
    }

    static newPlayer(name,symbol){
        return new Player(name,symbol)
    }

    markCell(cellNo){

        this.board.cells[cellNo].mark = symbol

    }

   
}

module.exports = Player