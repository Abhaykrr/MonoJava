//Driver Code


const User = require("./User");

try {
    const admin1 = User.newAdmin("Abhay", "ak123")


    const user1 = admin1.newUser("Sk", "sk123")
    const user2 = admin1.newUser("Rakesh", "r123")
    const user3 = admin1.newUser("Dk", "dk123")
    

    admin1.updateUser("sk123", "name", "AK")
    admin1.deleteUser("r123")

    
     user1.newContact("a")
     user1.newContact("b")
     user1.newContact("c")
     user1.newContact("d")
     user1.newContact("e")

     user1.updateContact("b","k")
     user1.deleteContact("c")

     user1.addContactInfo("a","Home",98989)
     user1.addContactInfo("a","Telephone",98989)
     user1.addContactInfo("a","Mobile",98989)
     
     user1.updateContactInfo("a","Mobile",909090)

     user1.deleteContactInfo("a","Telephone")
     

     console.log(user1);
     console.log(user1.contacts[0]);


} catch (error) {
    console.log(error.message)
}

