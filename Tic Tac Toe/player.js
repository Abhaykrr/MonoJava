class Player{
    constructor(name,symbol){
        this.name = name
        this.symbol = symbol
    }

    static newPlayer(name,symbol){
        return new Player(name,symbol)
    }

 
}

module.exports = Player