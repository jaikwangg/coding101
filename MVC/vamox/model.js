class QueryEngine {
    constructor() {
      this.result = null;
      this.executionTime = null;
    }
  
    
    executeSqlQuery(query) {
    const startTime = performance.now(); 
    const expressionMatch = query.match(/^SELECT\s+([0-9+\-*/()\s]+);$/);

        if (expressionMatch) {
        const expression = expressionMatch[1];
        try {
            this.result = eval(expression).toString();
        } catch (error) {
            this.result = "Wrong Syntax!";
        }
        } else {
        this.result = "Wrong Syntax!";
        }

      const endTime = performance.now();
      this.executionTime = endTime - startTime; 
    }
  
    executeMqlQuery(query) {
      const startTime = performance.now(); 

      if (query.startsWith("print(") && query.endsWith(");")) {
        const expression = query.substring(6, query.length - 2); 
        try {
          const result = new Function(`return (${expression});`)();
          this.result = result.toString();
        } catch (error) {
          this.result = "Wrong Syntax!";
        }
      } else {
        this.result = "Wrong Syntax!";
      }
      const endTime = performance.now(); 
      this.executionTime = endTime - startTime;
    }
  }
  
  module.exports = QueryEngine;
  