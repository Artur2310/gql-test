module.exports = {
    Query: {
        record: async (root, {id}, {dataSources}) => {
            return dataSources.recordAPI.getRecord(id);
        },
        records: async (root, args, {dataSources}) => {
            return dataSources.recordAPI.getRecords(args);
        },
        author: async (root, {id}, {dataSources}) => {
            return dataSources.authorAPI.getAuthor(id);
        },
        authors: async (root, args, {dataSources}) => {
            return dataSources.authorAPI.getAuthors(args);
        },
    },
    Mutation:{
        createRecord: async (root, {record}, {dataSources}) => {
            return dataSources.recordAPI.createRecord({...record});
        },
        deleteRecord: async (root, {id}, {dataSources}) => {
            return dataSources.recordAPI.deleteRecord(id).then(function () {
                return {result: true}
            }).catch(function () {
                return {result: false}
            });
        },
        updateRecord: async (root, {record}, {dataSources}) => {
            return dataSources.recordAPI.updateRecord({...record});
        },
        createAuthor: async (root, {author}, {dataSources}) => {
            return dataSources.authorAPI.createRecord({...author});
        },
        deleteAuthor: async (root, {id}, {dataSources}) => {
            return dataSources.authorAPI.deleteRecord(id).then(function () {
                return {result: true}
            }).catch(function () {
                return {result: false}
            });
        },
    }
};
