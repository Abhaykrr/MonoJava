const Contact = require("./contact")
const ContactInfo = require("./contactInfo")

class User {
    static allUser = []
    constructor(name, username, isAdmin) {
        this.name = name
        this.username = username
        this.isAdmin = isAdmin
        this.contacts = []
    }

    static properStringFormat(data){
        if(typeof data != "string")
         throw new Error("Enter type of String Only");
    }

    static findUser(username) {
        //type validation
        this.properStringFormat(username);

        for (let index = 0; index < User.allUser.length; index++) {
            if (User.allUser[index].username == username) {
                return [true, index]
            }
        }
        return [false, -1]
    }
   

    static newAdmin(name, username) {
        //type validation - name -username
       
        this.properStringFormat(name);
        this.properStringFormat(username);

        let [isUserExist, indexOfUserFound] = User.findUser(username)
        if (isUserExist) {
            throw new Error("Username Already Exist")
        }
        const admin = new User(name, username, true)
        User.allUser.push(admin)
        return admin
    }
    newUser(name, username) {
        //type validation - name -username
        User.properStringFormat(name);
        User.properStringFormat(username);
        

        //check
        if (!this.isAdmin) {
            throw new Error("Unauthorized")
        }
        let [isUserExist, indexOfUserFound] = User.findUser(username)
        if (isUserExist) {
            throw new Error("Username Already Exist")
        }
        const user = new User(name, username, false)
        User.allUser.push(user)
        return user
    }

    getAllUser() {
        if (!this.isAdmin) {
            throw new Error("Unauthorized")
        }
        return User.allUser
    }

    updateUser(username, parameter, newValue) {
        //type validation - name -username
        //check

        User.properStringFormat(username);
        User.properStringFormat(newValue);

        if (!this.isAdmin) {
            throw new Error("Unauthorized")
        }
        let [isUserExist, indexOfUserFound] = User.findUser(username)
        if (!isUserExist) {
            throw new Error("Username Does not Exist")
        }
        switch (parameter) {
            case "name": User.allUser[indexOfUserFound].updateName(newValue)
                break;
            case "username": User.allUser[indexOfUserFound].updateUsername(newValue)
                break;
            default:
                throw new Error("Invalid Parameter")

        }
    }
    updateName(newName) {
        User.properStringFormat(newName);

        this.name = newName
    }
    updateUsername(newUsername) {
        User.properStringFormat(newUsername)

        let [isUserExist, indexOfUserFound] = User.findUser(newUsername)
        if (isUserExist) {
            throw new Error("Username Already Exists")
        }
        this.username = newUsername
    }
    deleteUser(username) {

        User.properStringFormat(username)

        if (!this.isAdmin) {
            throw new Error("Unauthorized")
        }
        let [isUserExist, indexOfUserFound] = User.findUser(username)
        if (!isUserExist) {
            throw new Error("Username Does not Exist")
        }


        User.allUser.splice(indexOfUserFound,1); 
    }
// --------------------------------------------------------------------------------------
//                                   Contacts
// ______________________________________________________________________________________
    findContact(cName) {
        for (let index = 0; index < this.contacts.length; index++) {
            if (this.contacts[index].cName == cName) {
                return [true, index]
            }
        }
        return [false, -1]

    }
    newContact(cName) {
        //check cname is string
        User.properStringFormat(cName);

        //check not admin
        if (this.isAdmin){
            throw new Error("Admin Cannot Create Contacts")
        }
        let [isContactExist, indexOfContact] = this.findContact(cName)
        if (isContactExist) {
            throw new Error("Contact Already Exist")
        }

        const newContact = Contact.newContact(cName)
        this.contacts.push(newContact)
        return newContact
    }

    updateContact(cName, newContactName){

        User.properStringFormat(cName);
        User.properStringFormat(newContactName);

        if (this.isAdmin){
            throw new Error("Admin Cannot Update Contacts")
        }

        let [isContactExist, indexOfContact] = this.findContact(cName)
        if (!isContactExist) {
            throw new Error("Contact Does Not Exist")
        }

        this.contacts[indexOfContact].cName = newContactName
    }

    deleteContact(cName){

        User.properStringFormat(cName)
        if (this.isAdmin){
            throw new Error("Admin Cannot Delete Contacts")
        }

        let [isContactExist, indexOfContact] = this.findContact(cName)
        if (!isContactExist) {
            throw new Error("Contact Does Not Exist")
        }

        this.contacts.splice(indexOfContact,1)
    }
    
// --------------------------------------------------------------------------------------
//                                   Contacts Info
// ______________________________________________________________________________________

    getContactInfo(type , indexOfContact){

        let line = this.contacts[indexOfContact].contactInfos

            for (let index = 0; index < line.length; index++) {
                if (line[index].type == type) {
                    return [true, index]
                }
            }
            return [false, -1]
    
    }

    addContactInfo(cName, type, value ){

        User.properStringFormat(cName)
        User.properStringFormat(type)

        if (this.isAdmin){
            throw new Error("Admin Cannot Add Contact Info")
        }

        let [isContactExist, indexOfContact] = this.findContact(cName)
        if (!isContactExist) {
            throw new Error("Contact Does Not Exist")
        }

        let [isContactTypeExist, indexOfContactType] = this.getContactInfo(type, indexOfContact )
        if (isContactTypeExist) {
            throw new Error("ContactType Alread Exist")
        }

        const newInfo = ContactInfo.newContactInfo(type,value);
        this.contacts[indexOfContact].contactInfos.push(newInfo);
    }

    deleteContactInfo(cName, type){

        User.properStringFormat(cName)
        User.properStringFormat(type)

        if (this.isAdmin){
            throw new Error("Admin Cannot Add Contact Info")
        }

        let [isContactExist, indexOfContact] = this.findContact(cName)
        if (!isContactExist) {
            throw new Error("Contact Does Not Exist")
        }

        let [isContactTypeExist, indexOfContactType] = this.getContactInfo(type, indexOfContact )
        if (!isContactTypeExist) {
            throw new Error("ContactType Does Not Exist")
        }

        this.contacts[indexOfContact].contactInfos.splice(indexOfContactType,1)
    }


}

module.exports = User