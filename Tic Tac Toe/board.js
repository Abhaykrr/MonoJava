
const Cell = require("./cell")
const State = require("./state").Color;

class Board{
    constructor(cells){
        this.cells = cells
    }

    static newBoard(){
        const cells =[];

        for (let index = 0; index < 9; index++) {
           cells[index] = Cell.newCell();  
        }

        return new Board(cells)
    }

    analyseResult(board){

       

        const winningConditions = [
            [0, 1, 2], [3, 4, 5], [6, 7, 8], // Rows
            [0, 3, 6], [1, 4, 7], [2, 5, 8], // Columns
            [0, 4, 8], [2, 4, 6]             // Diagonals
        ];

        for (let conditions of winningConditions) {
            let a = conditions[0];
            let b = conditions[1];
            let c = conditions[2];
    
            if (board.cells[a].mark == board.cells[b].mark && board.cells[a].mark == board.cells[c].mark  && board.cells[a].mark!="z") {
                return [board.cells[a].mark,"win"];
            }
        }

        for (let index = 0; index < 9; index++) {
            if(board.cells[index].mark == "z")
            return [-1,"progress"]
        }

        return[-1,"draw"]

    }

     printBoard(board) {
        for (let i = 0; i < 9; i += 3) {
            if (i % 3 === 0)
                console.log("\t");
            let row = "| ";
            for (let j = i; j < i + 3; j++) {
                let mark = board.cells[j].mark;
                if (mark != "z")
                    row += mark + " | ";
                else
                    row += (j) + " | ";
            }
            console.log(row);
        }
    }
}

module.exports = Board