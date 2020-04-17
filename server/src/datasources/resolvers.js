module.exports = {
  Query: {
   record: async (_source, { id }, { dataSources }) => {
      return dataSources.recordAPI.getRecord(id);
  }
}
};
