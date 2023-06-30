//Driver Code


const User = require("./user");

try {
    const admin1 = User.newAdmin("Abhay", "ak123")

    
    // Admin CRUD Operations

    const user1 = admin1.newUser("Sk", "sk123")
    const user2 = admin1.newUser("Rakesh", "r123")
    const user3 = admin1.newUser("Dk", "dk123")
    


    admin1.updateUser("sk123", "name", "Sumit Kumar")
    admin1.deleteUser("dk123")
//---------------------Contact And Contact Info Crud ------------------------------------------------------

      user1.newContact("Abhay");
      user1.newContact("nik");
      user1.newContact("sam");

      user1.updateContact("nik","bruno");
      user1.deleteContact("sam");

      

      user1.getContact("Abhay").addContactInfo("Home",9090);
      user1.getContact("Abhay").addContactInfo("Mobile",9090);
      user1.getContact("Abhay").addContactInfo("Work",9090);

      
      user1.getContact("Abhay").updateContactInfo("Work",1010);
      user1.getContact("Abhay").deleteContactInfo("Work");


      console.log(user1);
      console.log(user1.getContact("Abhay").getAllContactInfos());
      user1.getContact("Abhay").deleteAllConatctInfo();
   




} catch (error) {
    console.log(error.message)
}


