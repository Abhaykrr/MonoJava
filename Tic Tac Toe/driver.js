const Game = require("./game")


try {
    const g1 = Game.newGame("Nik","Sam")

    console.log(g1.play(0));
    console.log(g1.play(12));
    console.log(g1.play(1));
    console.log(g1.play(2));
    console.log(g1.play(3));
    console.log(g1.play(4));
    console.log(g1.play(5));
    console.log(g1.play(6));
    console.log(g1.play(7));
    
   

    


   
    
} catch (error) {
    console.log(error);
}