$.get('https://openexchangerates.org/api/latest.json', {app_id: 'YOUR_APP_ID'}, function(data) {
    console.log("1 US Dollar equals " + data.rates.GBP + " British Pounds");
});