module.exports = {
    Query: {
        record: async (root, {id}, {dataSources}) => {
            return dataSources.recordAPI.getRecord(id);
        },
        records: async (root, args, {dataSources}) => {
            return dataSources.recordAPI.getRecords(args).then(function (output) {
                return output;
            });
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
    }
};
