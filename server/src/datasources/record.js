const {RESTDataSource} = require('apollo-datasource-rest');

class RecordAPI extends RESTDataSource {
    constructor() {
        super();
        this.baseURL = 'http://localhost:8080/record/';
    }

    async getRecord(id) {
        return this.get(`get/${id}`);
    }

    async createRecord(record) {
        return this.post(`/create`, record);
    }

    async deleteRecord(id) {
        return this.post(`/delete/${id}`);
    }

}

module.exports = RecordAPI;


