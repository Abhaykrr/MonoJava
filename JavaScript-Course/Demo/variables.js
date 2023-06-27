


let customSort  = (arr)=>{
   // check if  arr is an array or not;

  //  console.log("In the custom sort",arr.length);

   if(!arr.length) {
    console.log("Not an array");
    return;
   }else{
    console.log("Array has a length");
   }

      let temp =  arr.sort();
      console.log("Assending Order",temp);

     temp = arr.reverse()
     console.log("Desending Order",temp);


     temp = arr.sort((a, b) => {
      if (typeof a === "boolean" && typeof b === "boolean") {
        return b - a; 
      } else if (typeof a === "boolean") {
        return -1;
      } else if (typeof b === "boolean") {
        return 1; 
      } else if (typeof a === "string" && typeof b === "string") {
        return a.localeCompare(b);
      } else if (typeof a === "string") {
        return -1;
      } else if (typeof b === "string") {
        return 1; 
      } else {
        return a - b;
      }
    });

    

      console.log("Custom Sort",temp);
}
let arr = [5, 2, 8,"kk","pk", 1, 9,false,true, 3,"Ak","Bk","Zk","CSK",true];

customSort(arr);
customSort(2);




((number1) =>{

  // if(number1.length || typeof number1 === "string" || typeof number1 === Object || typeof number1 === "boolean"){
  //   console.log("Not an Number");
  //   return;
  // }

  if(typeof number1 != Number){
    console.log("Not an Number");
    return;
  }
  
    let curr = Math.floor(number1) 

    let sequence = [0, 1]; 

    for (let i = 2; i <= curr; i++) {
      let nextNum = sequence[i - 1] + sequence[i - 2];
      sequence.push(nextNum);
    }
    console.log(` Fibonaci  Series of ${curr} `,sequence);

    return ;
})(10.25)


let fib = (number1) => {

  if(typeof number1 != Number){
    console.log("Not an Number");
    return;
  }

    if (number1 <= 1) return number1;
    return fib(number1 - 1) + fib(number1 - 2);
  }
  
  console.log("Nth fibonacci no",fib(10));






// let a =10;
// const b = 20;
// var c = 30;

// console.log(c);
// console.log('Hello World');
// console.log(a);
// console.log(b);
// console.log(c);


// let arr = [2, 3, 4,5];  

// arr.push(5);
// console.log("After pushing 5 at last",arr);

// arr.unshift(1);
// arr.unshift(0);

// console.log("After pushing 0,1 at First",arr);



// arr.splice(2, 1);
// console.log("Removing 2nd index ",arr);

// let temp = "yash"
// let arr1 = temp.split("")
// console.log(temp.toUpperCase());
// console.log(temp.indexOf("sh"));
// console.log("After Spliting each character",arr1);



