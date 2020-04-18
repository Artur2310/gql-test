module.exports = {
    Query: {
        record: async (_source, {id}, {dataSources}) => {
            return dataSources.recordAPI.getRecord(id);
        },
    },
    Mutation:{
        createRecord: async (_source, {record}, {dataSources}) => {
            return dataSources.recordAPI.createRecord({...record});
        },
    }
};
