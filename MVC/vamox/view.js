class QueryView {
    showResultText(query, result, executionTime) {
      console.log("Query:", query);
      console.log("Result:", result);
      console.log("Query Execution Time:", executionTime, "ms");
    }
  
    showResultJSON(query, result, executionTime) {
      console.log(JSON.stringify({
        "status": "true",
        "query": query,
        "result": result,
        "execution_time": executionTime
      }));
    }
  
    showError(formatJSON) {
      if (formatJSON) {
        console.log(JSON.stringify({
          "status": "false"
        }));
      } else {
        console.log("Wrong Syntax!");
      }
    }
  }
  
  module.exports = QueryView;
  