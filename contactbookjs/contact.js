
const ContactInfo = require("./contactInfo");
const Valiadtion = require("./validation");

class Contact {
    constructor(cName) {
        this.cName = cName
        this.contactInfos = []
    }
    static newContact(cName) {
        if(typeof cName != "string")
         throw new Error("Enter type of String Only");
         
        return new Contact(cName)
    }


    getContactInfo(type){

        let line = this.contactInfos

            for (let index = 0; index < line.length; index++) {
                if (line[index].type == type) {
                    return [true, index]
                }
            }
            return [false, -1]
    
    }

    addContactInfo(type, value ){

        
        Valiadtion.checkString(type);
        Valiadtion.checkNumber(value);

        let [isContactTypeExist, indexOfContactType] = this.getContactInfo(type)
        if (isContactTypeExist) {
            throw new Error(`${type} ContactType Alread Exist`)
        }

        const newInfo = ContactInfo.newContactInfo(type,value);
        this.contactInfos.push(newInfo);
    }

    deleteContactInfo(type){
        Valiadtion.checkString(type);


        let [isContactTypeExist, indexOfContactType] = this.getContactInfo(type)
        if (!isContactTypeExist) {
            throw new Error(`${type} ContactType Does Not Exist`)
        }

        this.contactInfos.splice(indexOfContactType,1);
    }


    updateContactInfo(type, value ){

        Valiadtion.checkNumber(value);
        Valiadtion.checkString(type);


        let [isContactTypeExist, indexOfContactType] = this.getContactInfo(type )
        if (!isContactTypeExist) {
            throw new Error(`${type} ContactType Doesnt Exist `)
        }

        this.contactInfos[indexOfContactType].value = value;
    }

    getAllContactInfos(){
        return this.contactInfos;
    }

    deleteAllConatctInfo(){
        this.contactInfos = [];
    }


}
module.exports = Contact 