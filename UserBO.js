class UserBO
{
     userName;
     password;

    setUserName(userName){
        this.userName = userName;
    }

    getUserName()
    {
        return this.userName
    }

    setpassword(password){
        this.password = password;
    }
    getPassword()
    {
        return this.password
    }
}

module.exports = new UserBO();