const readline = require('readline');
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

const QueryController = require('./controller');

const controller = new QueryController();

rl.question('Enter SQL or MQL command: ', (query) => {
  rl.question('Enter command type (SQL or MQL): ', (queryType) => {
    queryType = queryType.toUpperCase();
    rl.question('Display results in JSON format (t/f): ', (formatJSON) => {
      formatJSON = formatJSON.toLowerCase() === "t";
      controller.executeQuery(query, queryType, formatJSON);
      rl.close();
    });
  });
});
