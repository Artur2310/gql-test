const {RESTDataSource} = require('apollo-datasource-rest');

class AuthorAPI extends RESTDataSource {
    constructor() {
        super();
        this.baseURL = 'http://localhost:8080/author/';
    }

    async getAuthor(id) {
        return this.get(`get/${id}`);
    }

    async getAuthors(args) {
        return this.get(`get`, args);
    }

}

module.exports = AuthorAPI;


