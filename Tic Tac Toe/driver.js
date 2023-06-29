const Game = require("./game")


try {

    // WON State GamePlay

    const game1 = Game.newGame("Nik","Sam")

    console.log(game1.play(0));
    console.log(game1.play(12));
    console.log(game1.play(1));
    console.log(game1.play(2));
    console.log(game1.play(3));
    console.log(game1.play(4));
    console.log(game1.play(5));
    console.log(game1.play(6));
    console.log(game1.play(7));

    const game2 = Game.newGame("Ak","Sk")

    console.log(game2.play(100));
    console.log(game2.play(9));
    console.log(game2.play(0));
    console.log(game2.play(0));
    console.log(game2.play(2));
    console.log(game2.play(3));
    console.log(game2.play(4));
    console.log(game2.play(5));
    console.log(game2.play(6));
    console.log(game2.play(7));
    
   // Draw State Game Play

   const game3 = Game.newGame("riya","somya")

   console.log(game3.play(6));
   console.log(game3.play(0));
   console.log(game3.play(11));
   console.log(game3.play(1));
   console.log(game3.play(7));
   console.log(game3.play(4));
   console.log(game3.play(2));
   console.log(game3.play(3));
   console.log(game3.play(5));
   console.log(game3.play(8));
   console.log(game3.play(1));
   


   
    
} catch (error) {
    console.log(error);
}