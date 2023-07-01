class Cell{
    constructor(symbol){
        this.mark = symbol
    }

    static newCell(){
        return new Cell("z")
    }

    isMarked(){
        if(this.mark =="z")
         return false;

         return true;
    }

    markCell(symbol){
        this.mark = symbol
    }
}
module.exports = Cell