const { RESTDataSource } = require('apollo-datasource-rest');

class RecordAPI extends RESTDataSource {
  constructor() {
    super();
    this.baseURL = 'http://localhost:8080/record/';
  }

  async getRecord(id) {
    return this.get(`get/${id}`);
  }

}

module.exports = RecordAPI;


