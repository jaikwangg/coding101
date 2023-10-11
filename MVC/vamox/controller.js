const QueryEngine = require('./model');
const QueryView = require('./view');

class QueryController {
  constructor() {
    this.queryEngine = new QueryEngine();
    this.view = new QueryView();
  }

  executeQuery(query, queryType, formatJSON) {
    if (queryType === "SQL") {
      this.queryEngine.executeSqlQuery(query);
    } else if (queryType === "MQL") {
      this.queryEngine.executeMqlQuery(query);
    }

    if (formatJSON) {
      this.view.showResultJSON(query, this.queryEngine.result, this.queryEngine.executionTime);
    } else {
      this.view.showResultText(query, this.queryEngine.result, this.queryEngine.executionTime);
    }
  }
}

module.exports = QueryController;
