module.exports = {

    bitnami:
    {
        name: "MongoDB Service",
        url: "mongodb://" + process.env.MONGODB_USERNAME + ":" + process.env.MONGODB_PASSWORD + "@" + process.env.MONGODB_HOST + "/" + process.env.MONGODB_DATABASE,
        port: process.env.MONGODB_PORT
    }

};
