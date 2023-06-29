//Driver Code


const User = require("./user");

try {
    const admin1 = User.newAdmin("Abhay", "ak123")

    
    // Admin CRUD Operations

    const user1 = admin1.newUser("Sk", "sk123")
    const user2 = admin1.newUser("Rakesh", "r123")
    const user3 = admin1.newUser("Dk", "dk123")
    


    admin1.updateUser("sk123", "name", "Sumit Kumar")
    admin1.deleteUser("r123")

    // Crud on Conatct 
    
     user1.newContact("a")
     user1.newContact("b")
     user1.newContact("c")
     user1.newContact("d")
     user1.newContact("e")

     user1.updateContact("b","k")
     user1.deleteContact("c")

     // CRUD ON CONTACT INFO

     user1.addContactInfo("a","Home",98989)       // Add Users Conatct Info
     user1.addContactInfo("a","Telephone",98989)
     user1.addContactInfo("a","Mobile",98989)
     
     user1.updateContactInfo("a","Mobile",909090) // Update User Conatct Info
     user1.deleteContactInfo("a","Telephone")     // Delete User Contact Info
     

     console.log("All Users",admin1.getAllUser());            // Display All User
     border();
     console.log("User 1 Details",user1);  
     border();

     console.log("User 1 All ContactInfos");              // Display Users ConatctInfo

     for (let index = 0; index < user1.contacts.length; index++) {
        console.log(user1.contacts[index]);
     }
     border();                         


// -----------------------------------------------------------------------------------------------
    user2.newContact("abhay")
    user2.newContact("bhola")
    user2.newContact("cat")
    user2.newContact("sam")
    user2.newContact("nik")

    user2.updateContact("bhola","kola")
    user2.deleteContact("cat")

     // CRUD ON CONTACT INFO

     user2.addContactInfo("abhay","Home",98989)       // Add Users Conatct Info
     user2.addContactInfo("abhay","Telephone",98989)
     user2.addContactInfo("kola","Mobile",98989)
     
     user2.updateContactInfo("abhay","Home",101010) // Update User Conatct Info
     user2.deleteContactInfo("abhay","Telephone")     // Delete User Contact Info
     

     console.log("ALl Users",admin1.getAllUser());            // Display All User
     border();                         

     console.log("User 2 All Details",user2);   border();                         
     console.log("User 2 All ContactInfos");              // Display Users ConatctInfo

     for (let index = 0; index < user2.contacts.length; index++) {
        console.log(user2.contacts[index]);
     }





} catch (error) {
    console.log(error.message)
}

function border(){

    console.log(`/\/\//\/\//\/\//\/\//\/\//\/\//\/\//\/\//\/\/`);
}

