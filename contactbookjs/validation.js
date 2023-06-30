class Validation{

    static checkString(data){
        if(typeof data !="string")
            throw new Error("Format Incorrect String Required")
    }


    static checkNumber(data){
        if(typeof data !="number")
            throw new Error("Format Incorrect Number Required")
    }
}



module.exports = Validation